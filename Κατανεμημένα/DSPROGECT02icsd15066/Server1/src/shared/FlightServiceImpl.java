//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package shared;

import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import server1.TcpConnection;


//KLASH H OPOIA YLOPOIH TWN RMI SERVER
public class FlightServiceImpl extends UnicastRemoteObject implements FlightService {
    //DILWSH METAVLITWN KLASHS
    private String[] airportNames;              //PINAKAS GIA TA ONOMATA TWN POLEWN
    private final ExecutorService bookingExecutor;    //Executor GIA TIS KRATHSEIS TWN PTHSEWN WSTE NA EXALIPSOUME TA RACE CONDITIONS
    
    //CONSTRUCTOR THS KLASHS
    public FlightServiceImpl() throws RemoteException {
        super();
        bookingExecutor = Executors.newSingleThreadExecutor();  //DHMIOURGIA TOU EXECUTOR GIA ENA NHMA KATHE FORA
    }
    
    //METHODOS GIA NA PAIRNEI TIS POLEIS POU YPARXOUN AERODROMIA KAI POU YLOPOIEI TO INTERFACE POU MOIRAZETAI STO RMI
    @Override
    public String[] getAirportNames() throws RemoteException {
        try{
        initializeAirportNames(); //KALH THN METHODO POU KANEI TO CONNECTION ME TON SERVER2 GIA THN APOKTHSH TWN POLEWN
        }
        catch(RemoteException e){//AN PIASEI KAPIO EXCEPTION TOTE PETAEI NEO WSTE NA ENHMERWSEI TON CLIENT
            throw new RemoteException(e.getMessage());
        }
        return airportNames;    //EPISTREFEI TIS POLEIS WS PINAKA SYMVOLOSEIRWN
    }
    
    //METHODOS GIA NA EPISTREFEI STON CLIENT TIS DIATHESIMES PTISEIS KAI H OPOIA LEITOURGEI ME POLLA NHMATA
    @SuppressWarnings("unchecked")//TO XRHSIMOPOIW DIOTI TO List<?> PETAEI UNCHECKED ERROR KATA THN DIADIKASIA TOU COMPILE
    @Override
    public List<FlightBooking> searchFlights(FlightSearchCrit searchFlight) throws RemoteException {
        TcpConnection conect=null;                          //DILWSH METAVLITIS GIA THN KLASH POU YLOPOIH TO CONNECTION GIA TON SERVER2
        List<FlightBooking> receivedList=null;              //DILWSH METAVLITHS GIA THN LISTA TWN DIATHESIMWN PTHSEWN
        try {   
            conect = new TcpConnection(searchFlight);       //DHMIOURGEI TO ANTIKEIMENO  GIA TO CONNECTION ME TON SERVER2 KAI PERNAEI TO ANTIKEIMENO TWN PROTIMISEWN THS ANAZHTHSHS
        } catch (IOException ex) {
            throw new RemoteException(ex.getMessage());//PETAEI NEO EXCEPTION AN TYXON KLHSH TO CONNECTION ME TON SERVER2  WSTE NA ENHMERWSH TON CLIENT
        }
        Object recievedObject = conect.getObject();  
        if (recievedObject instanceof List<?> ) {
            receivedList = (List<FlightBooking>) recievedObject;
        }
        return receivedList;
    }
    //METHODOS POU DEN KANEI KATA KAI APLA ELEGXEI GIA TO CONNECTION
    @Override
    public void dummyMethod() throws RemoteException {
      
    }
    //METHODOS POU KANEI THN SYNDESH ME TON SERVER2 KAI PERNEI TIS POLEIS
    private void initializeAirportNames() throws  RemoteException {
       TcpConnection conect=null;           //DILWSH METAVLITIS GIA THN KLASH POU YLOPOIH TO CONNECTION GIA TON SERVER2
            if (airportNames == null) {     //ELENGXEI AN O PINAKAS TWN STRING EINAI KENOS
                try {
                    conect = new TcpConnection("Send the flight locations");        //KANEI THN KLHSH MESW THS KLASHS POU EXOUME YLOPOIHSEI
                } catch (IOException ex) {
                    throw new RemoteException(ex.getLocalizedMessage());    //AN PIASEI KAPOIO ERROR ANAFORIKA ME THN SYNMDESH TOTE TO PROWTHEI STHN EPOMENH METHODO
                }
                Object receivedObject = conect.getObject();             //DILWSH METAVLITHS KAI KATAXWRHSH THS APANTHSHS APO TON SERVER2
                if (receivedObject instanceof String[] strings) {       //ELEGXEI AN TO OBJECT EINAI TYPOU STRING PINAKA
                    airportNames = strings;                             //EISAGEI THN APANTHSH STHN METAVLITH            
                } else {
                    airportNames = null;
                }
            }     
        
    }
    //METHODOS H OPOIA YLOPOIEI TO INTERFACE KAI EINAI GIA THN KRATHSH THS PTHSHS 
    @Override
    public String bookFlight(FlightBooking flight) throws RemoteException {
        
        String result;              //METAVLITI GIA THN APANTHSH APO TON SERVER2
        try {
            result = bookingExecutor.submit(() -> performBooking(flight)).get();        //EISAGEI TON KWDIKA WSTE NA TON PROSPELNAEI KATA 1 NHMA
        } catch (InterruptedException | ExecutionException  e) {        //PIANEI OPOIO EXCEPTION VRETHEI ANAFORIKA ME THN SYNDESH
            throw new RemoteException("Η κράτηση απέτυχε", e);
        }

        return result;  //EP[ISTREFEI TO APOTELESMA
    }
   
   //METHODOS POU YLOPOIEI THN KLHSH STON SERVER2 KAI THN KRATHSH
   private String performBooking(FlightBooking flight) throws RemoteException{
    try {
        //FTIAXNEI ENA ANTIKEIMENO THS KLASHS POU YLOPOIEI THN SYNDESH ME TON SERVER2 KAI PERNAEI SAN ORISMA THN KRATHSH
        TcpConnection connection = new TcpConnection(flight);
        
        //DHMIOURGIA OBJECT KAI ARXIKOPOIHSH TOU ME THN EPISTREFOMENH TIMH APO TON SERVER2
        Object response = connection.getObject();
       

        //ELEGXEI AN TO OBJECT POU EPISTRAFIKE EINAI STRING
        if (response instanceof String string) {
            return string;  //EPISTREFEI TO STRING ME TIS PLHROFORIES GIA THN KRATHSHS
        }
        throw new RemoteException("Η κράτηση απέτυχε\n");
    } catch (IOException e) {
        return "Η κράτηση απέτυχε " + e.getMessage();  
    }
   }

}
