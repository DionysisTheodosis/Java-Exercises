//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package mytools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//KLASH H OPOIA KANEI SWSTO FORMAT THN DWSMENH HMERA
public class StringDate {
    //KANOUME TON CONSTRUCTOR PRIVATE GIATI DEN THELOUME NA PERNEI ORISMA APEXW
    private StringDate(){
        
    }
    //METHODOS H OPOIA PERNEI MIA HMEROMHNIA KAI EPISTREFEI TO STRING FORMARISMENO OPWS TO THELOUME
    public static String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
        return date.format(formatter); //EPISTREFEI FORMARISMNH THN HMERA
    }
}
