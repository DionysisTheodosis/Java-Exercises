
package exercise01;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//KLASH H OPOIA EINAI GIA THN EGGRAFH KAI DIAVASMA ARXEIOU TO OPOIO THA KRATAEI TIS KRATISEIS 
public class Reservations  {
    private static ArrayList<Reservation> reservations;//ARRAYLIST POU THA PERIEXEI OLES TIS KRATHSEIS
    
    //CONSTRUCTOR XWRIS ORISMA GIA THN DHMIOURGIA KENOU ARRAYLIST
    public Reservations(){
        reservations = new ArrayList<>();
    }
    
    //METHODOS POU PROSTHETEI MIA KRATHSH STHN ARRAYLIST 
    public static void setReservation(Reservation reservation){
        Reservations.reservations.add(reservation);
    }
    
    //METHODOS POU APOTHYKEUEI THN ARRAYLIST SE ARXEIO DHLADH OLES TIS KRATHSEIS
    public static void saveReservations(){
        ObjectOutputStream out;// DILWSH STREAMEXODOU TUPOU ANTIKEIMENOU
        try{
            out=new ObjectOutputStream(new FileOutputStream("reservations.dat"));//DHMIOURGEI TOU ANTIKEIMENOU KAI ARXIKOPOIHSH TOU
            //PROSPELASH TOU ARRAYLIST TWN KRATHSEWN KAI EGGRAFH STO ARXEIO
            for(int i=0;i<reservations.size();i++){
                 out.writeObject(reservations.get(i));
            }
            out.flush();
            out.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println("Error with specified file") ;
            JOptionPane.showMessageDialog(null,"Σφάλμα με το συγκεκριμένο αρχείο", "Σφάλμα",JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex) {
            System.err.println("Error with I/O processes") ;
            JOptionPane.showMessageDialog(null,"Σφάλμα Ι/Ο processes", "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    } 
    //METHODOS GIA THN FORTWSH DIAVASMA TWN ANTIKEIMENWN APO TO ARXEIO KAI PROSTHIKI STHN ARRAYLIST
    public static void uploadReservations(){
        File a = new File("reservations.dat");//DIMIOURGIA ANTIKEIMENOU TYPOU FILE
        if(a.exists()){//KAI MONO AN UPARXEI TOTE
        ObjectInputStream in =null; //DHMIOURGEIA STREAM EISAODOU
        try{
            in = new ObjectInputStream(new FileInputStream("reservations.dat"));
            Reservation reservation;
                    
            while((reservation = (Reservation) in.readObject()) != null){//OSO YPARXEI EPOMENH GRAMMH TOTE PROSTHIKI STHN ARRAYLSIT
                Reservations.reservations.add(reservation);
            }
        }
        catch (EOFException ex) {
            
            
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Error casting") ;
            ex.printStackTrace();
        }
        catch (FileNotFoundException ex) {
            System.err.println("Error specified file does not exist") ;
            JOptionPane.showMessageDialog(null,"Σφάλμα το συγκεκριμένο αρχείο δεν υπάρχει", "Σφάλμα",JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex) {
            System.err.println("Error with I/O processes") ;
            JOptionPane.showMessageDialog(null,"Σφάλμα Ι/Ο processes", "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        finally {
            try{
                in.close();
            }
            catch(IOException ex){
                System.err.println("Another IOException during the closing");
                 JOptionPane.showMessageDialog(null,"Σφάλμα Ι/Ο processes στην διάρκεια του κλεισίματος", "Σφάλμα",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        
        }
    }
    
    //METHODOS POU EPISTREFEI TO SYNOLO TWN APOTHYKEUMENW KRATHSEWN
    public static int getNumber(){
        return Reservations.reservations.size();
    }
    //METHODOS POU EPISTREFEI TIS KRATHSEIS
    public static  ArrayList<Reservation> getReservations(){
        return Reservations.reservations;
    }
}
