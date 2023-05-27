//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
//PROGRAMMA GIA TON CLIENT
package clientgui;

import shared.FlightService;
import java.rmi.*;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;


public class ClientGui{
    private static FlightService flightService;
   
    public static void main(String[] args) {
        
       try{
           String name = "//localhost/FlightServiceImpl";//TO URL POU VRISKETAI H KLASH POU YLOPOIEI TO SHARED INTERFACE
           flightService = (FlightService) Naming.lookup(name);//SYNDESH ME TON RMI SERVER
            MainJFrame mainFrame = new MainJFrame(flightService);//DHMIOURGIA TOU FRAME KAI PERASMA SSAN ANAFORA TO ANTIKEIMENO GIA THN SYNDESH
            mainFrame.setLocationRelativeTo(null); //THETEI POU THA EMFANIZETAI TO FRAME
            mainFrame.setVisible(true);//KANEI TO FRAME NA FAINETAI
          
           
       }
       catch(MalformedURLException |NotBoundException  ex){//GIA NA PIASEI ERROR SXETIKA ME THN MH SWSTH SYNTAXH TOU URL,KAI GIA TO AN XRHSIMOPOIEI OBJECTS POU DEN YPARXOUN
           JOptionPane.showMessageDialog(null, ex,null,JOptionPane.ERROR_MESSAGE);
           System.exit(0);
       }
       catch(RemoteException | NullPointerException e){//GIA NA PIASEI AN KAPOIOS SERVER DEN EINAI SYNDEDEMENOS
           if(e instanceof RemoteException){
                JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τον σέρβερ",null,JOptionPane.ERROR_MESSAGE);
           }
           else if(e instanceof NullPointerException){
               JOptionPane.showMessageDialog(null, "Αποτυχία σύνδεσης με τον σέρβερ της βάσης",null,JOptionPane.ERROR_MESSAGE);
           }
          
          
       }
       
     
    }

}

