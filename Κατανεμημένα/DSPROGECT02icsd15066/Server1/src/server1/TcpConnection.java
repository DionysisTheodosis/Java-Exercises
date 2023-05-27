//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package server1;

import shared.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

//KLASH H OPOIA YLOPOIH THN SYNDESH ME TON SERVER2
public class TcpConnection{
    private Socket connection;                      //SOCKET TOU CLIENT
    private ObjectOutputStream output;              //TO OUTPUTSTREAM WS DATAOUTPUT
    private ObjectInputStream input;                //TO INPUTSTREAM WS DATA INPUT
    private FlightSearchCrit flightsearch;          //METAVLITI GIA TO ANTIKEIMENO THS KLASHS ME TIS EPILOGES ANAZITISIS PTHSHS
    private FlightBooking flightBooking;            //METAVLITI GIA TO ANTIKEIMENO THS KLASHS GIA TIS KRATHSEIS PTHSEWN
    private Object objectToSend;                    //METAVLITI GIA TO OBJECT POU STELNEI
    private Object receivedObject;                  //METAVLITI GIA TO OBJECT POU LAMVANEI
    
    //O CONSTRUCTOR THS KLASHS POU DEXETAI SAN ORISMA TO OBJECT POU EINAI GIA NA STALTHEI STON SERVER2
    public TcpConnection(Object object)throws ConnectException, IOException{
        this.objectToSend=object;       //ARXIKOPOIEI TO OBJECT ME AUTO POU PEIRE WS ORISMA
        this.receivedObject=null;       //ARXIKOPOIEI TO OBJECT WS NULL
        try{
            connectToServer();//METHODOS GIA NA PERIMENEI MEXRI NA GINEI H SYNDESH ME TON CLIENT
            getStreams();//METHODOS GIA NA ARXIKOPOIEI TA DATASTREAMS
            processConnection();//METHODOS GIA THN EKTELESH TWN ENTOLWN TOU XRHSTH
        }
        catch(EOFException eofException){//EXAIRESH GIA TO AN YPARXEI TELOS ARXEIOU
            displayMessage("\nClient Terminated Connection\n");
        }
        catch(IOException  | ClassNotFoundException ex){    //EXERESEI GIA TO AN TYXON PHGE KATI STRAVA ME THN SYNDESH KATHWS KAI AN DEN EXEI GINEI SWSTH TO ORISMA STO CLASSPATH GIA TIS KLASEIS POU DIAMHRAZONTAI
            throw new ConnectException("Error connected to server database"); 
           
        }
        finally{//TELOS KLEINEI THN SYNDESH
            closeConnection();
                    
        }
                           
    }
      
    
     //SYNARTISH GIA THN DIMIOURGIA SYNDESHS
    private void connectToServer() throws IOException {
        displayMessage("Attemping Connection\n");//EMFANISHS MINIMATOS 
        connection = new Socket("localhost",9999);//DIMIOURGIA TOU SOCKET STO TOPICO SERVER KAI PORTA 9999
        displayMessage("Connected to: "+connection.getInetAddress().getHostName());//EMFANIZEI TO HOSTNAME TOU SERVER
    }
    //METHODOS GIA THN ARXIKOPOIHSH TWN STREAMS POU EINAI SYNDEDEMENA
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }
    //METHODOS GIA THN EPEXERGASIA THS SYNDESHS
    private void processConnection() throws IOException,ClassNotFoundException {
        sendData(objectToSend);     //STELNEI TO OBJECT STON SERVER
        
        while(true){ //EPANALIPSI EWS OTOU LAVEI KAPOIO EGKURO OBJECT APOTON SERVER
            
            receivedObject =  input.readObject();    //LAMVANEI TO OBJECT APO TON SERVER
           
        }
    }
    //METHODOS GIA THN EKTYPWSH TOY MHNYMATOS
    private void displayMessage(String messageToDisplay){
        System.out.println("\n"+messageToDisplay);   
    }
    //METHODOS GIA TON TERMATISMO THS SYNDESHS
    private void closeConnection() throws IOException{
        displayMessage("\nTerminating connection\n");
        try{
            output.close();     //KLEINEI TO OUTPUT STREAM
            input.close();      //KLEINEI TO INPUTSTREAM
            connection.close(); //KLEINEI TO CONNECTION
        }
        catch(IOException ioException){
               throw new IOException("Exception during closing connection");
        }
    }
    //METHODOS GIA THN APOSTOLH TOU OBJECT
    private void sendData(Object data) throws IOException{
        try{
            output.writeObject(data); 
            output.flush();
        }
        catch(IOException ioException){
             throw new IOException("Exception during sending object");
        }
    }
    //METHODOS GIA THN EPISTROFH TOU OBJECT-APANTHSHS APO TON SERVER2
   public Object getObject(){
       return receivedObject;
   }
    
}