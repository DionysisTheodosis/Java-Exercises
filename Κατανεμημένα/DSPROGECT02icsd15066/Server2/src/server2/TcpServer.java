//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA

package server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//KLASH GIA TO CONNECTION TOU SERVER
public class TcpServer {
    //PARAMETROI KLASHS
    private static final int PORT = 9999;   //PARAMETROS GIA THN PULH POU AKOUEI O SERVER
    private boolean running;                //METAVLITI GIA NA ELEGXEI AN O SERVER EINAI ENERGOS
    private ServerSocket serverSocket;      //METAVLITI GIA TO SOCKET TOU SERVER GIA TO POU AKOUW SE PULH KAI IP
    
    //METHODOS GIA TO XEKINIMA TOU SERVER
    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);                   //DHMIOURGIA TOU SOCKET STHN DOSMENH PULH
            System.out.println("Server is running...\n");
            running = true; 
            while (running) {                                            //EPANALIPSH OSO O SERVER EINAI ENERGOS
                Socket socket = serverSocket.accept();                   //DHMIOURGIA TOU SOCKET GIA TON CLIENT
                System.out.println("\nA new client has connected");      //ENHMERWSH OTI EXEI GINEI MIA NMEA SYNDESH
                ClientHandler clientHandler = new ClientHandler(socket); //DHMIOURGIA ENOS ANTIKEIMENOU CLIENTHANDLER WSTE NA ORISMOUME TOU TROPOUS EPIKOINWNIA
                new Thread(clientHandler).start();                 //XEKINAEI NEO THREAD
            }
        } catch (IOException e) {
           System.out.println(e);
        }
    }

}