
package exercise01;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

//KLASH GIA KATHE KRATHSH
public class Reservation implements Serializable  {//KANOUME IMPLEMENT THN SERIALIZABLE EPEIDH THELOUME NA EINAI IKANO TO ANTIKEIMENO THS KLASH GIA EGGRAFH SE ARXEIOP
   //DILWSH METAVLITWN KLASHS
   private final Person person; //DILWSH METAVLITHS TYPOU KLASHS PERSON
   private final Room beds; //DILWSH METAVLITHS TYPOU KLASH ROOM
   private final boolean breakfast; //DILWSH METAVLITHS GIA TO AN EXEI PRWINO
   private final Date checkin; //DILWSH METAVLITHS TYPOU MERAS GIA THN AFIXH
   private final Date checkout; //DILWSH METAVLITHS TYPOU MERAS GIA THN ANAXWRISI
   private  double cost; //DILWSH METAVLITHS DOUBLE GIA TO SYNOLIKO KOSTOS THS KRATHSHS
   private static final int COST_BR=8;  //DILWSH STATHERAS METAVLITIS GIA TO KOSTOS TOU PRWINOU
   private String numberOfBeds; //DILWSH METAVLITIS GIA TON TUPO TOU DWMATIOY

    //CONSTRUCTOR O OPOIOS DEXETAI WS ORISMA ENA ANTIKEIMENO TYPOU PERSON,TYPO DWMATIOU,AN EXEI PRWINO,HMERA AFIXHS ,HMERA ANAXWRISHS
    public Reservation(Person person,Room beds,boolean breakfast,Date checkIn,Date checkOut){
       this.person = person;
       this.beds = beds;
       this.checkin= checkIn;
       this.checkout = checkOut;
       this.breakfast = breakfast;
       //ANALOGOS THN EPILOGH ORIZEI KAI TON TYPO TOY DWMATIOY WS ALFARITHMITIKO
       if(beds.getNumberOfBeds()==1){
          this.numberOfBeds="Μονόκλινο";
       }     
        else if(beds.getNumberOfBeds()==2){
                this.numberOfBeds="Δίκλινο";
               
        }
        if(beds.getNumberOfBeds()==3){
            this.numberOfBeds="Τρίκλινο";                
        }
       calcCost();//KALESMA THS METHODOU GIA TON YPOLOGISMO TOU SYNOLIKOU KOSTOUS
    }
   
    //METHODOS GIA TON YPOLOGISMO TOU KOSTOUS
    private void calcCost(){
        Calendar cal = Calendar.getInstance();//DHMIOURGEIA HMEROLOGIOU KAI ARXIKOPOIHSH THS HMEROMHNIA ME THN SHMERINH
        cal.setTime(checkin);//THETH THN HMEROMHNIA WS TO CHECK IN
        Calendar cal2 = Calendar.getInstance();//DHMIOURGEIA HMEROLOGIOU KAI ARXIKOPOIHSH THS HMEROMHNIA ME THN SHMERINH
        cal2.setTime(checkout);  //THETH THN HMEROMHNIA WS TO CHECK OUT
        long milliseconds1 = cal.getTimeInMillis(); //DHMIOURGEIA METAVLITIS POU PERNEI THN HMEROMHNIA SE XRONO
        long milliseconds2 = cal2.getTimeInMillis();
        long dif = milliseconds2 - milliseconds1; //VRISKEI THN DIAFORA METAXY CHECK OUT CHECK IN SE XRONO
        long daysBetween = dif / (24 * 60 * 60 * 1000);//TO METATREPEI SE MERES
        if(breakfast){//AN EXEI PRWINO
            cost = daysBetween*(beds.getCost()+COST_BR);//KAI YPOLOGIZEI TO KOSTOS ME TIS MERES METAXY * TON TYPO ME K TO KOSTOS TOU PRWINOU
        }
        else{//AN DEN EXIE PRWINO
            cost = daysBetween*beds.getCost();//KAI YPOLOGIZEI TO KOSTOS ME TIS MERES METAXY * TON TYPO 
        }
        
       
    }
   //METHODOS GIA THN EPISTROFH TWN PROSWPIKON STOIXEIWN TOU ATOMU
    public Person getPersonData(){
       return person;
    }
    //METHODOS GIA THN EPISTROFH TOU TYPOU DWMATIOU
    public String getNBeds(){
        return numberOfBeds;
    }
    //METHODOS GIA THN EPISTROFH TOU SUNOLIKOU KOSTOUS
    public double getCost(){
       return cost;
    }
    //METHODOS GIA THN EPISTROFH THS MERAS AFIXHS
    public Date getCheckIn(){
       return checkin;
    }
    //METHODOS GIA THN EPISTROFH THS MERAS ANAXWRISHS
    public Date getCheckOut(){
       return checkout;
    }
    //METHODOS GIA THN EPISTROFH AN EXEI PRWINO
    public boolean getBreakfast(){
        return breakfast;
    }
   //METHODOS TOSTRING H OPOIA EPISTREFEI MONO TA STOIXEIA TOU ATOMOU KAI AUTO GT THA TO XRHSIMOPOIHSOUME STHN ANAZHTHSH
   @Override
    public String toString(){
            return person.toString();
        
    }
}