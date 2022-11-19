//DIONYSIOS THEODOSIS A.M:321/2015066
package exercise4;
import java.util.*;

//KLASH POU PERIEXEI THN MAIN 
public class Exercise4 {
    public static void main(String[] args) {
        //DILWSH KAI DIMIOURGEIA SCANNER ANTIKEIMENOY GIA THN EISAGWGH APO TO PLHKTROLOGIO
        Scanner input = new Scanner(System.in);
        //DILWSH METAVLITIS GIA THN EPILOGH TOU XRHSTH AN THELEI NA SYNEXISEI ME NEES LEXEIS
        boolean choice = true;
        //EPANALIPSI GIA NA KALEI TO PROGRAMMA GIA KATHE DIAFORETIKH EISAGWGH PLITHOUS LEXEWN
        while(choice){
            //DHMIOURGEIA ANTIKEUIMENOU TYPOU PAIXNIDIOU   
            PlayGame b =new PlayGame();
            
            //KALH THN METHODO POU TREXEI TO PAIXNIDI
            b.Play();
            
            //MINIMA KAI EISAGWGH THS EPILOGHS TOU XRHSTH
            System.out.println("An Theleis Na Xanapaixeis Me Alles Lexeis Pata To 1 Alliws Otidipote Allo Gia Na Vgeis");
            String inputChoice = input.nextLine();
            
            //ANALOGOS THN EPILOGH TOU XRHSTH KATAXWRISI STHN CHOICE 
            if(inputChoice.equals("1")){
                choice=true;
            }
            else{
                choice=false;
            }
        }   
    }
    
}
