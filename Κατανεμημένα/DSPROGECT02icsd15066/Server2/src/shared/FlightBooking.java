//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package shared;

import java.io.Serializable;

//KLASH GIA THN KRATHSH THS PTHSHS
public class FlightBooking implements Serializable {
    //DILWSH METAVLITWN KLASHS
    private static final long serialVersionUID = 1357924680L;//TO UNIQUE ID POU THA XEROUN OTI EINAI H IDIA KLASH H OPOIA MOIRAZONTAI
    private Flight outboundFlight;   //METAVLITI GIA THN PTHSH ANAXWRISIS
    private Flight returnFlight;    //METAVLITI GIA THN PTHSH EPISTROFHS
    private double price;          //METAVLITI GIA THN TIMH THS KRATHSHS
    private int passengers;       //METAVLITI GIA TON ARITHMO TWN EPIVATWN(OTAN THN YLOPOIEI O CLIENT)-DIATHESIMWN THESEWN(OTAN THN YLOPOIEI O SERVER) 
    
    //CONSTRUCTOR KLASHS
    //CONSTRUCTOR ME 2 ORISMATA GIA TO OTAN EINAI MONH PTHSH
    public FlightBooking(Flight outboundFlight, int passengers) {
        this(outboundFlight,null,passengers);
    }
    //CONSTRUCTOR ME 3 ORISMATA GIA OTAN EINAI PTHSH ME EPISTROFH
    public FlightBooking(Flight outboundFlight, Flight returnFlight, int passengers) {
        this.outboundFlight = outboundFlight;
        this.returnFlight = returnFlight;
        //ELEGXOS GIA TO AN EINAI MONH H PTHSH GIA TON YPOLOGISMO THS TIMHS
        if(returnFlight==null){    //GIA THN MONH
            this.price = outboundFlight.getPrice()*passengers;     
        }
        else{   //GIA ME EPISTROFH
            this.price = (outboundFlight.getPrice()+returnFlight.getPrice())*passengers;
        }
        this.passengers = passengers;
    }
    
    //METHODOI KLASHS
    //METHODOS GIA THN EPISTROFH TOU ANTIKEIMENOU THS ARXIKHS PTHSHS
    public Flight getOutboundFlight() {
        return outboundFlight;
    }
    //METHODOS GIA THN EPISTROFH TOU ANTIKEIMENOU THS PTHSHS EPISTROFHS
    public Flight getReturnFlight() {
        return returnFlight;
    }
    //METHODOS GIA THN EPISTROFH THS TIMHS THS KRATHSHS
    public double getPrice() {
        return price;
    }
    //METHODOS GIA THN EPISTROFH (TWN DIATHESIMWN THESEWN AN EINAI APO SERVER)-(TWN EPIVATWN AN EINAI APO CLIENT)
    public int getPassengers() {
        return passengers;
    }
    //METHODOS APEIKONISHS ANTIKEIMENOU WS STRING
    @Override
    public String toString() {
        return "FlightBooking{" + "outboundFlight=" + outboundFlight + ", returnFlight=" + returnFlight + ", price=" + price + ", passengers=" + passengers + '}';
    }
    
    
    
}
