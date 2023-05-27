//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package server1;

import shared.FlightServiceImpl;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.util.Scanner;

//H MAIN KLASH GIA TON SERVER1
public class Server1 {
    public static void main(String args[]){
        //FTIAXNW XEXWRISTW THREAD GIA NA AKOUEI APO TO PLHKTROLOGIO WSTE NA TERMATISEI TO PROGRAMMA OTAN DOTHEI H LEXH STOP
        Thread keyboardThread = new Thread(() -> {                          //DHMIOURGIA TOU NUMATOS
            Scanner scanner = new Scanner(System.in);                 //DHMIOURGIA TOU ANTIKEIMENOU GIA NAAKOUEIE APO TO PLHKTROLOGIO
            while (true) {                                                  //SYNEXEIS EPANALIPSI
                if (scanner.hasNextLine()) {                                //ELEGXEI AN EXEI EPOMENH GRAMMH
                    String input = scanner.nextLine();                      //DIAVAZEI KAI APOTHYKEUEI THN EPOMENH GRAMMH STO INPUT
                    if (input.equalsIgnoreCase("stop")) {       //AN EINAI STOP AGNOONTAS TA PEZA-KEFALAIA
                        System.exit(0);                              //KLEINEI TO PROGRAMMA
                    }   
                }
            }
        });
        keyboardThread.start(); //XEKINAW TO THREAD
        //O KWDIKAS GIA THN DIMIOURGEIA TOU RMI CONNECTION
        try{
            FlightServiceImpl flSer = new FlightServiceImpl();                           //DHMIOURGEIA ANTIKEIMENOU GIA THN KLASH YLOPOIHSH TOU RMI INTERFACE
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);     //DHMIOURGIA TOU REGISTRY GIA THN PORTA KAI THN IP POU AKOW O SERVER 
            Naming.rebind("//localhost/FlightServiceImpl",flSer);               //KANEI BIND TO RGISTRY ME THN KLASH YLOPOIHSHS
            System.out.println("Server up and running...");                           //GIA PROVOLH OTI O SERVER XEKINISE 
        }
        catch(Exception e){
            System.out.println("Server not connected"+e);                               //GIA PROVOLHJ OTI O SERVER DEN EXEI SYNDETHEI MAZI K ME TON LOGO
        }
    }
}
