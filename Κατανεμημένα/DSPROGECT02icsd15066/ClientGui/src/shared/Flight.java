//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package shared;

import java.io.Serializable;
import java.time.LocalDateTime;

//KLASH GIA THN PTHSH
public class Flight implements Serializable {
    //DILWSH METAVLITWN KLASHS
    private static final long serialVersionUID = 9876543210L;   //TO UNIQUE ID POU THA XEROUN OTI EINAI H IDIA KLASH H OPOIA MOIRAZONTAI
    private final int flightId;                                 //METAVLITI GIA TON ARITHMO THS PTHSHS
    private final String origin;                                //METAVLITI GIA THN POLH ANAXWRHSHS
    private final String destination;                           //METAVLITI GIA THN POLH PROORISMOU
    private final String originAirportId;                       //METAVLITI GIA TON ATA KWDIKO TOU AERODROMIOU THS POLHS ANAXWRHSHS
    private final String destinationAirportId;                  //METAVLITI GIA TON ATA KWDIKO TOU AERODROMIOU THS POLHS ANAXWRHSHS
    private final LocalDateTime departureDate;                  //METAVLITI GIA THN HMERA KAI WRA ANAXWRHSHS
    private final LocalDateTime arrivalDate;                    //METAVLITI  GIA THN HMERA KAI WRA POU FTANEI
    private int availableSeats;                                 //METAVLITI POU KRATAEI TIS DIATHESIMES THESEIS
    private double price;                                       //METAVLITI GIA THN TIMH THS PTHSHS
    
    //CONMTRUCTOR KLASHS
    //CONSTRUCTOR GIA TIS PTHSEIS XWRIS TA PEDIA TWN KWDIKWN TWN AERODROMIWN
    public Flight(int flightId, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, int availableSeats, double price) {
      this(flightId,origin,destination,departureDate,arrivalDate,availableSeats,price,null,null);
    }
    //CONMSTRUCTOR ME OLA TA PEDIA
    public Flight(int flightId, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, int availableSeats, double price,String originAirportId,String destinationAirportId) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.availableSeats = availableSeats;
        this.price = price;
        this.originAirportId=originAirportId;
        this.destinationAirportId=destinationAirportId;
    }
    
    //METHODOI THS KLASHS
    
    //METHODOS GIA NA KANEI EKXWREI TIS DIATHESIMES THESEIS
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    //METHODOS GIA NA KANEI EKXWREI THN TIMH
    public void setPrice(double price) {
        this.price = price;
    }
    //METHODOS GIA NA EPISTREFEI TON KWDIKO THS PTHSHS
    public int getFlightId() {
        return flightId;
    }
    //METHODOS GIA NA EPISTREFEI THN TOPOTHESIA ANAXWRHSHS
    public String getOrigin() {
        return origin;
    }
    //METHODOS GIA NA EPISTREFEI THN TOPOTHESIA PROORISMOU
    public String getDestination() {
        return destination;
    }
    //METHODOS GIA NA EPISTREFEI THN HMEROMHNIA KAI WRA THS ANAXWRHSHS
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }
    //METHODOS GIA NA EPISTREFEI THN HMEROMHNIA KAI WRA THS AFIXHS
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
    //METHODOS GIA NA EPISTREFEI TON ARITHMO TWN DIATHESIMWN THESEWN
    public int getAvailableSeats() {
        return availableSeats;
    }
    //METHODOS GIA NA EPISTREFEI THN TIMH THS PTHSHS
    public double getPrice() {
        return price;
    }
    //METHODOS GIA NA EPISTREFEI TON KWDIKO AERODROMIOU ANAXWRHSHS
    public String getOriginAirportId() {
        return originAirportId;
    }
    //METHODOS GIA NA EPISTREFEI TON KWDIKO AERODROMIOU AFIXHS
    public String getDestinationAirportId() {
        return destinationAirportId;
    }
    //METHODOS TOSTRING POU EPISTREFEI THN KLASH WS STRING
    @Override
    public String toString() {
        return "Flight{" + "flightId=" + flightId + ", origin=" + origin + ", destination=" + destination + ", originAirportId=" + originAirportId + ", destinationAirportId=" + destinationAirportId + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", availableSeats=" + availableSeats + ", price=" + price + '}';
    }
    
   
    
    
}
