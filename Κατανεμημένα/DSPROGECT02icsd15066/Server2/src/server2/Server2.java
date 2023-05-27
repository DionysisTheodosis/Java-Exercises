//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package server2;

import java.util.Scanner;

//H MAIN KLASH GIA TON SERVER2
public class Server2 {
    public static void main(String[] args) {
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
        keyboardThread.start();                                            //XEKINAEI TO THREAD                         
        TcpServer server = new  TcpServer();               //FTIAXNEI ENA NEO ANTIKEIMENO GIA THN KLASH POU YLOPOIEI TON SERVER
        server.start();                                    //XEKINAEI TON SERVER
    }
    
    
}