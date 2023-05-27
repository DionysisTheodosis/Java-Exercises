//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package shared;

import java.io.Serializable;
import java.time.LocalDate;


//KLASH GIA TA KRITHRIA THS ANAZHTHSHS THS PTHSHS
public class FlightSearchCrit implements Serializable{//SERIALIZABLE GIA NA GINETAI H METAFORA
    //DILWSH TWN METAVLITWN
    private static final long serialVersionUID = 987654321L; //DINOUME ENA UNIC ID GIA NA M,HN EXOUME THEMATA ME CLASSNOTFOUND
    private String origin;  //METAVLITI GIA THN POLH ANAXWRHSHS
    private String destination; //METAVLITI GIA THN POLH PROORISMOU
    private LocalDate departureDate; //METAVLITI GIA THN HMERA ANAXWRHSHS
    private int passengers; //METAVLITI GIA TON ARITHMO TWN EPIVATWN-THESEWN
    private boolean isRoundTrip; //METHODOS GIA TO AN EINAI MONH PTHSH H ME EPISTROFH
    private LocalDate returnDate; //METHODOS GIA THN HMERA THS EPISTROFHS
    
    //CONSTRUCTOR KLASHS SAN DEFAULT
    public FlightSearchCrit() {
    }
    //CONSTRUCTOR KLASHS GIA TIS MONES PTHSEIS 
    public FlightSearchCrit(String origin, String destination, LocalDate departureDate, int passengers) {
        this(origin,destination,departureDate,passengers,null);
    }
    //CONSTRUCTOR KLASHS GIA TIS PTHSEIS ME EPISTROFH
    public FlightSearchCrit(String origin, String destination, LocalDate departureDate, int passengers,LocalDate returnDate) {
        this.origin = origin; 
        this.destination = destination;
        this.departureDate = departureDate;
        this.passengers = passengers;
        if(returnDate!=null){ //ELGXOS AN EINAI ME EPISTROFH
            this.isRoundTrip = true; 
            this.returnDate = returnDate;
        }
        
    } 
    //METHODOI KLASHS
    
    //METHODOS GIA THN EPISTROFH THS HMERAS EPISTROFHS
    public LocalDate getReturnDate() {
        return returnDate;
    }
    //METHODOS GIA THN EPISTROFH THS POLHS ANAXWRHSHS
    public String getOrigin() {
        return origin;
    }
    //METHODOS GIA THN EPISTROFH THS POLHS PROORISMOU
    public String getDestination() {
        return destination;
    }
    //METHODOS GIA THN EPISTROFH THS HMERAS ANAXWRHSHS
    public LocalDate getDepartureDate() {
        return departureDate;
    }
    //METHODOS GIA THN EPISTROFH TOU ARITHMOU TWN EPIVATWN
    public int getPassengers() {
        return passengers;
    }
    //METHODOS GIA THN EPISTRFH AN EINAI TAXIDI ME EPISTROFH
    public boolean isIsRoundTrip() {
        return isRoundTrip;
    }
    //METHODOS GIA THN APEIKONISH THS KLASHS WS STRING
    @Override
    public String toString() {
        return "FlightSearchCrit{" + "origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate + ", passengers=" + passengers + ", isRoundTrip=" + isRoundTrip + ", returnDate=" + returnDate + '}';
    }          
}