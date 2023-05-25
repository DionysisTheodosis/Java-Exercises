//DIONYSIOS THEODOSIS AM:321/2015066 1H OMADIKH ERGASIA
package serverApp;

//EISAGWGH TWN APARAITHTWN VIVLIOTHIKWN
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

//KLASH H OPOIA YLOPOIH TON SERVER KAI THN SOCKET GIA THN EPIKOINWNIA SERVER CLIENT
public class Server {
    //METAVLITES KLASHS
    private ServerSocket server;//SOCKET TOU SERVER 
    private Socket connection;//SOCKET TOU CLIENT
    private DataOutputStream output;//TO OUTPUTSTREAM WS DATAOUTPUT
    private DataInputStream input;//TO INPUTSTREAM WS DATA INPUT
    private static  File dir; // METAVLITI FILE GIA TON FAKELO SERVERDIRECTORY
    
   
    //CONSTRUCTOR THS KLASHS
    public Server() {  
        dir = new File("server_directory");//DHMIOURGEIA TOU FAKELOU POU THA APOTHUKEUONTAI TA ARXEIA
        try{
            server = new ServerSocket(9999);//DHMIOURGIA TOU SERVER SOCKET KAI DINOUME THN PULH 9999
            while(true){
              try{
                    waitForConnection();//METHODOS GIA NA PERIMENEI MEXRI NA GINEI H SYNDESH ME TON CLIENT
                    getStreams();//METHODOS GIA NA ARXIKOPOIEI TA DATASTREAMS
                    processConnection();//METHODOS GIA THN EKTELESH TWN ENTOLWN TOU XRHSTH
                }
                catch(EOFException eofException){//EXAIRESH GIA TO AN YPARXEI TELOS ARXEIOU
                    displayMessage("\nServer terminated connection");
                }
                finally{//TELOS KLEINEI THN SYNDESH
                    closeConnection();
              }
                           
          }
        
         }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    //METHODOS GIA THN APODOXH THS SYNDESHS
    private void waitForConnection() throws IOException{
        displayMessage("Waiting for Connection\n");
        connection = server.accept();
        displayMessage("Connection "+"received from: " + connection.getInetAddress().getHostName());//EMFANISH TOU SYNDEDEMENOU HOSTNAME
    }
    //METHODOS GIA THN ARXIKOPOIHSH KAI DHMIOURGIA TWN DATASTREAMS
    private void getStreams() throws IOException{
      
        output = new DataOutputStream(connection.getOutputStream());
        output.flush();
        input = new DataInputStream(connection.getInputStream());
    }
    //METHODOS GIA THN DIERGASIA THS SYNDESHS
    private void processConnection() throws IOException{
        String  message = (String) input.readUTF();//DIAVAZEI KAI APOTHYKEYH STO ALFARITHMITIKO AYTO POU ESTEILE O CLIENT
        displayMessage(message); //EMFANIZEI OTI ESTEILE O CLIENT
        //ELEGXOS KAI EPILOGH SYMFWNA ME TO PERIEXOMENO POU ESTEILE
        switch(message.split(" ")[0]){//PERNEI TO PRWTO MERSOS TOU STRING POU EINAI H ENTOLH
            case "DELETE" -> deleteFile(message);
            case "DOWNLOAD_FILE" -> downloadFile(message);
            case "NEW_FILE" -> saveFile(message);
            case "INSERT_CONTENT" -> insertContent(message);
            case "APPEND_CONTENT" -> appendContent(message);
        }
        
        
    }
    //METHODOS GIA THN EKTYPWSH ENOS STRING
    private void displayMessage(String messageToDisplay){
        System.out.print("\n"+messageToDisplay);
    }
    //METHODOS GIA TON TERMATISMO THS SYNDESHS ME TON CLIENT
    private void closeConnection(){
        displayMessage("\nTerminating connection\n");
        try{
            output.close();//KLEINEI TO OUPUTSTREAM
            input.close();//KLEINEI TO INPUTSTREAM 
            connection.close();//KLEINEI THN SYNDESH ME TON CLIENT
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    //METHODOS GIA THN APOSTOLH STON CLIENT ENWS STRING 
    private void sendData(String message){ 
        try{
            output.writeUTF(message);
            output.flush();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    //METHODOS GIA THN DIAGRAFH TOU ARXEIOU STON SERVER
    private void deleteFile(String message){
        String fileName = message.split(" ")[1];//APOTHYKEYH TO ONOMA TOU ARXEIOY POU EXEI STLATHEI WS ALFARITHMITIKO STHN 2H THESH META TO KENO
        File file = new File(dir, fileName+".txt");//DHMIOURGEI METAVLITI FILE GIA TO ONOMA TOU ARXEIOU STON FAKELO 
        if (file.exists()) {//AN UPARXEI TO ARXEIO
            if (file.delete()) {  //TOTE TO DIAGRAFEI KAI AN GINEI TOTE
                addServerLog(connection.getInetAddress().getHostAddress(),"DELETE_FILE",file);//EISAGEI ENA LOG STO ARXEIO SERVER.LOG
                sendData("FILE_DELETED");//STELNEI STON CLIENT TO MINIMA
            } else {
                sendData("FAILED_TO_DELETE");    //STELNEI STON CLIENT TO MINIMA      
            }
        }else {
            sendData("FILE_NOT_FOUND");//STELNEI STON CLIENT TO MINIMA
        }
    }
    //METHODOS GIA THN LIPSI TOU ARXEIOU
    private void downloadFile(String message) throws IOException{
        String fileName = message.split(" ")[1];
        File file = new File(dir, fileName+".txt");
        FileInputStream fileInputStream = null;//DHMIOURGEI FILEINPUTSTREAM ANTIKEIMENO GIA THN EISAGWGH APO ARXIEO
        if(file.exists()){ //AN TO ARXEIO YPARXEI
            sendData("FILE_DOWNLOADED");//STELNEI STON CLIENT KATALHO MINIMA WSTE NA SYNEXISEI GIA THN LIPSI
            try {
                fileInputStream = new FileInputStream(file);//ARXIKOPOIHSH WSTE NA DIAVASEI APO TO ARXEIO
                byte[] buffer = new byte[1024];//DHMIOURGIA PINAKA BYTE POU THA APOTHYKEYOUME TO ARXEIO WS MERH DIAFORWN BYTE KOMMENA 1024 KOMMATIA
                fileInputStream.read(buffer,0,buffer.length);//DIAVAZEI TO ARXEIO
                OutputStream os = connection.getOutputStream();//DHMIOURGIA OUTPUTSTREAM ANTIKEIMENOU
                os.write(buffer,0,buffer.length);//GRAFEI TO ARXEIO GIA NA TO APOSTEILEI STON CLIENT
                fileInputStream.close();//KLEINEI TO FILEINPUTSTREAM
                addServerLog(connection.getInetAddress().getHostAddress(),"DOWNLOAD_FILE",file);//EISAGEI TON LOG STON SERVER
              
            } catch (IOException ex) {//AN UPARXEI KAPOIO ERROR KATA TO DIAVASMA H THN EGGRAFH
                sendData(  "FAILED_TO_DOWNLOAD");//STELNEI KATALLHLO MINIMA
            }
       }
       else{//AN TO ARXEIO DEN UPARXEI
           sendData("FILE_NOT_FOUND");//STELNEI KATALHLO MINIMA
       }
       
       
    }
    //METHODOS GIA THN DHMIOURGIA NEOU ARXEIOU
    private void saveFile(String message){//DEXETAI TO ALFARITHMITIKO POU PERIEXEI THN ENTOLH KENO KAI TO ONOMA TOU ARXEIOU   
        try {
            String fileName = message.split(" ")[1];
            File file = new File(dir,fileName+".txt"); 
            int length = input.readInt();//DIAVAZEI APO TON CLIENT TO MEGETHOS TOU PINAKA TWN BYTE 
            byte[] utf8Bytes = new byte[length];//DHMIOURGIA PINAKA BYTE
            input.readFully(utf8Bytes);//DIAVAZEI OLO TON PINAKA TWN BYTE APO TON CIENT
            if (file.exists()) {//AN TO ARXEIO YPARXEI TOTE STELNEI STON CLIENT KATALHLO MINIMA
                sendData("FILE_EXISTS");
            }
            
            else{//ALLIWS SYNEXIZEI STHN DIMIOURGIA TOU
                String str = new String(utf8Bytes, StandardCharsets.UTF_8);//METATREPEI TON PINAKA TWN TWN BYTE SE STRING
                FileWriter writer = new FileWriter(file);//DIMIOURGIA ANTIKEIMENOU FILEWRITER GIA TO ARXEIO
                writer.write(str);//EGGRAFEI TO ARXEIO ME TO PERIEXOMENO TOU STRING
                writer.close();//KLEINEI TO FILEWRITER
                sendData("FILE_SAVED");
                addServerLog(connection.getInetAddress().getHostAddress(),"NEW_FILE",file);//EISAGEI STON SERVER TO LOG
            }   
          
        } catch (IOException ex) {
            sendData("UPLOAD_FILE_FAILED");
        }             
   }
    //METHODOS GIA THN PROSTHIKI PERIEXOMENOU
    private void insertContent(String message){//DEXETAI THN SYMVOLOSEIRA POU EXEI THN ENTOLH KAI TO ONOMA TOU ARXEIO
        try {
            String fileName = message.split(" ")[1];//EISAGEI TO ONOMA TOU ARXEIO STHN METAVLITI
            File file = new File(dir,fileName+".txt"); //FTIAXNEI ANTIKEIMENO FILE STON FAKELO KAI ME ONOMA THS PARAMETROU
            int length = input.readInt();//DIAVAZEI TO MEGETHOS TOU PINAKA TWN BYTES APO TON CLIENT
            byte[] utf8Bytes = new byte[length];//DHMIOURGEI PINAKA BYTES ME MEGETHOS TO DOSMENO APO TON CLIENT
            input.readFully(utf8Bytes);//DIAVAZEI OLA TA BYTES APO TON CLIENT
            if (!file.exists()){//ELEGXEI AN DEN YPARXEI TO ARXEIO
                sendData("FILE_NOT_FOUND");//STELNEI STON CLIENT TO KATALHLO MINIMA
            }
            else{//ALLIWS AN YPARXEI
                String str = new String(utf8Bytes, StandardCharsets.UTF_8);//FTIAXNEI MIA SYMVOLOSEIRA POY METATREPEI TON PINAKA TWN BYTES SE XARAKTHRES KAI TA APOTHYKEYEI
                FileWriter writer = new FileWriter(file,false);//FTIAXNEI ENA ANTIKEIMENO GIA EGGRAFH SE ARXEIO KAI ME ANTIKATASTASH TWN DEDOMENWN TOU ARXEIOU
                writer.write(str);//GRAFEI STO ARXEIO
                writer.close();//KLEISIMO TOU GRAPSIMOU
                sendData("INSERTION_SUCCESFUL");//STELNEI STON CLIENT TO KATALHLO MINIMA
                addServerLog(connection.getInetAddress().getHostAddress(),"FILE_CONTENT_INSERTION",file);//PROSTHETEI STO SERVER.LOG TO LOG
            }   
          
        } catch (IOException ex) {//AN PIASEI OPOIADHPOTE IO EXERESH TOTE STELNEI KATALHLO MINIMA STON CLIENT
           sendData("INSERTION_UNSUCCESFUL");
        }            
    
    }
    //METHODOS GIA THN PROSARTISI TOU KEIMENOU SE ARXEIO
    private void appendContent(String message){//DEXETAI THN SYMVOLOSEIRA POU EXEI THN ENTOLH KAI TO ONOMA TOU ARXEIO
        try {
            String fileName = message.split(" ")[1];//EISAGEI TO ONOMA TOU ARXEIO STHN METAVLITI
            File file = new File(dir,fileName+".txt");  //FTIAXNEI ANTIKEIMENO FILE STON FAKELO KAI ME ONOMA THS PARAMETROU
            int length = input.readInt();//DIAVAZEI TO MEGETHOS TOU PINAKA TWN BYTES APO TON CLIENT
            byte[] utf8Bytes = new byte[length];//DHMIOURGEI PINAKA BYTES ME MEGETHOS TO DOSMENO APO TON CLIENT
            input.readFully(utf8Bytes);//DIAVAZEI OLA TA BYTES APO TON CLIENT
            if (!file.exists()){//ELEGXEI AN DEN YPARXEI TO ARXEIO
                sendData("FILE_NOT_FOUND");//STELNEI STON CLIENT TO KATALHLO MINIMA
            }
            else{//ALLIWS AN YPARXEI
                String str = new String(utf8Bytes, StandardCharsets.UTF_8);//FTIAXNEI MIA SYMVOLOSEIRA POY METATREPEI TON PINAKA TWN BYTES SE XARAKTHRES KAI TA APOTHYKEYEI
                FileWriter writer = new FileWriter(file,true);//FTIAXNEI ENA ANTIKEIMENO GIA EGGRAFH SE ARXEIO KAI PROSTHETEI TO KEIMENO STO TELOS  TWN DEDOMENWN TOU ARXEIOU
                writer.write("\n"+str);//EGGRAFEI THN SYMVOLOSEIRA STO ARXEIO 
                writer.close();//KLEISIMO TOU GRAPSIMOU
                sendData("APPEND_SUCCESFUL");//STELNEI STON CLIENT TO KATALHLO MINIMA
                addServerLog(connection.getInetAddress().getHostAddress(),"FILE_CONTENT_ANAXATION",file);//PROSTHETEI STO SERVER.LOG TO LOG
            }   
          
        } catch (IOException ex) {//AN PIASEI OPOIADHPOTE IO EXERESH TOTE STELNEI KATALHLO MINIMA STON CLIENT
           sendData("APPEND_UNSUCCESFUL");
        }            
    
    
}
    //METHODOS GIA THN DIAMORFOSH THS SUMVOLOSEIRAS GIA THN EGGRAFH STO ARXEIO TOU SERVER
    private String stringFormat(String clientAddress,String command,File file){//DEXETAI THN DIEUTHYNSH TOU CLIENT,THN ENTOLH POU EGINE KAI TO ARXEIO STO OPOIO EGINE
        LocalDateTime now;//DILWSH METAVLITIS GIA THN HMEROMHNIA
        DateTimeFormatter formatter;//DILWSH ANTIKEIMENOU GIA THN DIAMORFWSH THS HMERAS
        now = LocalDateTime.now();//ARXIKOPOIHSH THS METAVLITHS ME THN SHMERINI HMERA KAI THN WRA AUTH THN STIGMH
        formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");//DHMIOURGEI TO FORMAT 
        String formattedDateTime = now.format(formatter);//DHMIOURGEI THN SYMVOLOSEIRA POU THA KRATHSEI THN HMEROMHNIA ME TO PARAPANW FORMAT
        String serverLog = "(TimeStamp): "+formattedDateTime+">>>"+"(Client's_IP):"+clientAddress+">>>"+"(Command): "+command+">>>"+"(FileName): "+file.getName()+"\n";//FTIAXNEI THN FORMARISMENH SYMVOLOSEIRA GIA TO PATERN
        return serverLog;//EPISTREFEI THN FORMARISMENH SYMVOLOSEIRA
    }
    //METHODOS GIA THN PROSTHIKI THS EGGRAFHS TOU SERVER STO SERVER.LOG ARXEIO
    private void addServerLog(String clientAddress,String command,File file) {//DEXETAI THN DIEUTHYNSH TOU CLIENT,THN ENTOLH POU EGINE KAI TO ARXEIO STO OPOIO EGINE
        String serverLog = stringFormat(clientAddress,command,file);//KALH THN METHODO GIA THN DHMIOURGIA FORMARISMENOU STRING GIA THN EGGRAFH
        File server_Log = new File("server.log");//DHMIOURGIA ANTIKEIMENO ARXEIOU GIA TIS EGGRAFES TOU SERVER
        if(!server_Log.exists()){//AN TO ARXEIO DEN YPARXEI
            try {
                server_Log.createNewFile();//DHMIOURGEI TO ARXEIO 
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Files.write(Paths.get("server.log"), serverLog.getBytes(), StandardOpenOption.APPEND);//GRAFEI THN EGGTRAFH STO ARXEIO TOU SERVER STO TELOS TOU ARXEIOU
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}