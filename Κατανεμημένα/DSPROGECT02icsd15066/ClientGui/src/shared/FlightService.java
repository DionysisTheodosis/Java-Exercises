//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package shared;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
//TO INTERFACE POU THA EINAI KOINO GIA THN EPIKOINWNIA MESW TOU RMI
public interface FlightService extends Remote {
    //METHODOS GIA THN EPISTROFH TWN ONOMATWN TWN POLEWN 
    String[] getAirportNames() throws RemoteException;
    
    //METHODOS GIA NA PAIRNEI SAN ORISMA THN KLASH POU EXEI THS EPILOGES THS ANAZHTHSHS KAI EPISTREFEI OLES TIS PTHSEIS
    List<FlightBooking> searchFlights(FlightSearchCrit searchFlight) throws RemoteException;
    
    //METHODOS GIA THN KRATHSH THS PTHSHS DEXETAI SAN ORISMA MIA PTHSH KAI EPISTREFEI TO AN EGINE H OXI
    String bookFlight(FlightBooking flight) throws RemoteException;
    
    //METHODOS GIA NA ELEXOUME THN SYNDESH
    void dummyMethod() throws RemoteException; 
    
}
