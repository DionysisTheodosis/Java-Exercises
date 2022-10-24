/*Dionysis Theodosis A.m:321/2015066
Askhsh 1*/
package Main;
import java.util.Scanner;   //ergaleio ths java gia thn eisagwgh apo to plhktrologio
public class main {

   
    public static void main(String[] args) {
        Odometro b=new Odometro();  //arxikopoihsh enos antikeimenou tupou odometro
        Scanner scan=new Scanner(System.in); //dimiourgeia antikeimenou gia eisagwgh apo to plhktrologio
        System.out.println("Dwse thn katanalwsh tou autokinitou lt/xil."); //ektupwsh
        float n=scan.nextInt(); //eisagwgh apo to plhktrologia tou deikti katanalwshs
        b.Katanalwsh(n);    //ekxwrish tou diktei sthn sunartish katanalwsh thn klashs odometro 
       while(true){     //epanalipsh pou den stamataei pote wste na dixnei pws einai to autokinito
        b.print();  //kalesma mesw antikeimenou gia ektypwsh xiliometrwn
        b.Xiliometra(10); //thetoume oti tha auxanei ta xiliometra kata 10 thn fora
        System.out.println("Pata 1 an thes na mideniseis to konter"); 
        int choise=scan.nextInt(); //ekxwrisei apo to plhktrologio epiloghs
        if(choise==1){ //sunthikh wste an to zitise o xrhsths na sunexisei me midenismo
        b.MidenismosMikrou();   //midenismos konter
        }
        b.print(); //ektypwsh
        System.out.println("Ekapse "+b.Apwleia()+" litra"); //ektypwnei to poso ekapse
       }
         
    }
    
}
