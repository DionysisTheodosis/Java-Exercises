//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package server2;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shared.FlightBooking;
import shared.FlightSearchCrit;

//KLASH H OPOIA YLOIEI THN SYNDESH GIA KATHE CLIENT STON SERVER
public class ClientHandler implements Runnable {//XRHSIMOPOIEI THN RUNNABLE GIA THN YLOPOIHSH POLLWN NYMATWN
    //DILWSH PARAMETRWN KLASHS
    private final Socket socket;                                                //GIA TO SOCKET POU EINAI SYNDEDEMENO
    private DatabaseManager database;                                           //GIA THN KLASH THS VASHS POU KANEI TIS KATALLHLH DIAXEIRHSH
    private ObjectOutputStream output;                                          //GIA THN APOSTOLH TOU OBJECT  
    private ObjectInputStream input;                                            //GIA THN LIPSH TOU OBJECT
    private static final List<ClientHandler> activeThreads = new ArrayList<>(); //MIA LISTA GIA NA VLEPOUME TA ANEIXTA THREADS
    private boolean terminated;                                                 //GIA NA MAS VOITHISEI NA STAMATHSOUME THN SYNDESH GIA TO THREAD
    
    //CONSTRUCTOR THS KLASH POU DEXETAI WS ORISMA TO SOCKET THS SYNDESH
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    //METHODOS GIA THN ARXIKOPOIHSH TWN STREAMS POU EINAI SYNDEDEMENA
    private void getStreams(){
        try{
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
         } catch (IOException ex) {
            sendData(ex);
            terminated = true; // Terminate the thread if there is an exception while setting up streams
        }
    }
    //H METHODOS POU TREXEI THN SYNDESH KAI KANEI OVERRIDE THN RUN WSTE NA AFHNEI TA POLLAPLA NYMATA
    @Override
    public void run() {
        getStreams();   //KALESMA THS METHODOU GIA THN ARXIKOPOIHSH TWN STREAMS
        if (!terminated) {  //ELEGXEI AN TO THREAD EINAI ENERGO
            try {
                database = new DatabaseManager("jdbc:sqlite:./FlightsDatabase.db"); //FTIAXNEI NEO ANTIKEIMENO GIA THNN KLASH THS DIAXEIRHSH THS VASHS
                database.connect(); //SYNDEETE STHN VASH
 
                while (!terminated) {//LOOPA GIA OSO EINAI ENERGO TO THREAD
                    try {
                        Object receivedObject = input.readObject(); //DIAVAZEI TO OBJECT POU STELNEI O PELATHS
                        //ELEGXEI GIA NA DEI TON TYPO TOU OBJECT KAI NA KANEI THN KATALLHLH DIAXEIRHSH
                        if (receivedObject instanceof String receivedString) {                      //AN EINAI TUPOU STRING KAI ME TO SWSTO ERWTHMA
                            if(receivedString.equals("Send the flight locations")){
                                displayMessage("Server  retrieving airport locations");
                                sendData(database.searchData());//STELNEI TO ERWTHMA STHN VASH GIA NA VREI TIS POLEIS KAI META TIS STELNEI STON PELATH                                            
                            }
                        } else if (receivedObject instanceof FlightSearchCrit flightSearch) {   //AN EINAI TUPOU FlightSearchCrit  KAI ME TO SWSTO ERWTHMA
                            try {
                                displayMessage("Server searching for available flights");
                                sendData(database.searchData(flightSearch));    //STELNEI STHN VASH NA PSAXEI VASH AUTOU TOU ANTIKEIMENOU KAI TWN PARAMETRWN TOU GIA TIS PTHSEIS POU YPARXOUN KAI META TIS STELNEI STON PELATH
                            } catch (SQLException ex) { //AN PIASEI TO EXCEPTION TO STELNEI STON CLIENT
                                sendData(ex);
                            }
                        } else if (receivedObject instanceof FlightBooking flightBooked) {      //AN EINAI TUPOU GIA TO BOOKING TOTE STELNEI STHN VASH GIA THN KRATHSH
                            try {
                                displayMessage("Server booking flight");
                                sendData(database.insertData(flightBooked));
                            } catch (SQLException ex) {
                                sendData(ex);
                            }
                        }
                    } catch (EOFException e) {  
                        break; // VGAINEI APO THN LOOPA AN PIASEI TO ENDOFFLINE
                    }
                }
            } catch (IOException | ClassNotFoundException | SQLException ex) {  //PIANEI OTI ERROR EXEI NA KANEI ME THN SYNDESH H ME TO CLASSPATH TWN SHARED KLASEWN H ME THN VASH
                displayMessage(ex.getMessage());
            } finally {
                displayMessage("terminates client connection\n");
                activeThreads.remove(this); // Remove the thread from the active threads list
                closeConnection();
            }
        }
    }
    
    //METHODOS POU PERNEI WS ORISMA TO OBJECT POU EINAI NA STEILEI KAI TO STELNEI
    private void sendData(Object data) {
        try {
            output.writeObject(data);       //STELNEI TO ANTIKEIMENO
            output.flush();
        } catch (IOException ioException) {
            displayMessage(ioException.getMessage());
            terminated = true;                  //STAMATAEI THN SYNDESH EFOSWN PIASTEI KAPOIO EXCEPTION KATA THN APOSTOLH TOU ANTIKEIMENOU
        }
        displayMessage("Server responded to client successfuly");
        terminated = true;                      //THETEI TO FLAG WS TRUE GIA NA TERMATHSEI THN SYNDESH META AFOTOU STEILEI TO ANTIKEIMENO
    }
    
    //METHODOS GIA TO KLEISIMO THS SYNDESHS
    private void closeConnection() {
        try {
            if (output != null) {       //ELEGXEI AN DEN EINAI NULL
                output.close();         //KLEINEI TO ANTIKEIMENO POU GRAFEI TO STREAM POU STELNEI
            }
            if (input != null) {        //ELEGXEI AN DEN EINAI NULL
                input.close();          //KLEIENEI TO ANTIKEIMENO POU DIAVAZEI TO STREAM POU LANEI
            }
            if (socket != null) {       //ELEGXEI AN DEN EINAI NULL
                socket.close();         //KLEINEI THN YPODOXH THS SYNDESHS
            }
            if (database != null) {     //ELEGXEI AN DEN EINAI NULL
                database.disconnect();  //KLEINEI THN SYNDESH ME THN VASH
            }
        } catch (IOException | SQLException ex) {  //ELEGXEI AN PIASTEI KAPOIO EXCEPTION SYNDESHS TOU SERVER H THS VASHS
            sendData(ex);
            displayMessage(ex.getMessage());
        }
    }
    
    //METHODOS GIA THN EKTYPWSH TOY MHNYMATOS
    private void displayMessage(String messageToDisplay){
        System.out.println("\n"+messageToDisplay);   
    }

}