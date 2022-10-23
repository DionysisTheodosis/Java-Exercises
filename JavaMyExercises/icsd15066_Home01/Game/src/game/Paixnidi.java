/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package game;
import java.util.Random;
import javax.swing.JOptionPane;
public class Paixnidi {
    private String[][] A;
   
    public Paixnidi(){//constructor gia tin arxikopoihsh tou pinaka 
        A=new String[10][10];//arxikopoihsh tou pinaka
        for(int i=0;i<10;i++){//prospelash tou pinaka
            for(int j=0;j<10;j++){
                A[i][j]="-";//arxikopoihsh olwn twn thesewn tou pinaka me to symvolo '-'
            }
        }
        Random randNums=new Random();//dilwsh antikeimenou tupou random
        int  t=randNums.nextInt(10);//arxikopoihsh tou t me tuxaia timi apo 0 ews 10 pou tha einai gia ton dikti grammhs
        int  b=randNums.nextInt(10);//arxikopoihsh tou b me tuxaia timi apo 0 ews 10 pou tha einai gia ton dikti sthlhs
        A[t][b]="H";//arxikopoihsh ths arxikhs tyxaias theshs tou astynomou 
        t=randNums.nextInt(10);//arxikopoihsh tou t me tuxaia timi apo 0 ews 10 pou tha einai gia ton dikti grammhs
        b=randNums.nextInt(10);//arxikopoihsh tou b me tuxaia timi apo 0 ews 10 pou tha einai gia ton dikti sthlhs
        A[t][b]="M";//arxikopoihsh ths arxikhs tyxaias theshs tou dolofonou
    }
    public void play(){//methodos gia to paixnidi
        int check=0; //dilwsh kai arxikopoihsh ths metavlitis check apo thn opoia tha kanoume ton elegxo gia to an uparxei nikitis
        Hole H=new Hole();//dilwsh antikeimenou H gia thn klash tou astynomou
        Killer M=new Killer();//dilwsh antikeimenou M gia thn klash tou dolofonou
        JOptionPane.showMessageDialog(null,"O Astynomos Holes Se Nees Peripeteies");//ektypwsh grafikou minimatos 
        System.out.println("Arxikh Othoni");//ektypwsh minimatos
        display();//ektypwsh pinaka
        for(;;){//synexeis loop giati etsi k alliws tha thn kopsoume me thn break wste na synexizei na paizei to paixnidi
            JOptionPane.showMessageDialog(null,"Grapse up gia na metakinithei panw,left gia aristera,right gia dexia,down gia katw");//ektypwsh tou  grafikou minimatos
            A=H.moveH(JOptionPane.showInputDialog("Metakinise ton Astynomo"), A);//ektypwsh grafikou minimatos pou ekxwrei kai thn apanthsh tautogxrona sthn parametro ths klash tou astynomou kai epistrefei ton allagmeno pinaka 
            for(int i=0;i<10;i++){//loop gia thn prospelash toy pinaka me skopo na doume an kapoio stoixeio exei epikalipsei to allo
                for(int j=0;j<10;j++){
                    if(A[i][j].equals("H")||A[i][j].equals("M")){//an yparxei ena apo ta 2 auxanoume thn check,skopos einai an h check
                        check+=1;
                    }
                }
            }
            System.out.println();
            if(check==1){//elegxos gia ton kerdise o astynomos giati h check tha exei vrei 1 diladi tha einai ena symvolo ston pinaka
                JOptionPane.showMessageDialog(null,"O Astynomos Kerdise");//ektypwsh grafikou minimatos 
                break;//vgainei apo thn loop gia na termatisei to programma
            }
            else{//alliws tote kanei to check =0 giati xrhsimopoioume ws eolegxo
                check=0;
            }
            System.out.println("Kinisi Astynomou");//ektipwsh minimatos
            display();//ektypwsh tou pinaka
            A=M.moveK(A);//kalesma tou antikeimenou tou dolofonou, dinoume ton pinaka kai ton pernoume allagmeno
             for(int i=0;i<10;i++){//loop gia thn prospelash toy pinaka me skopo na doume an kapoio stoixeio exei epikalipsei to allo
                for(int j=0;j<10;j++){
                    if(A[i][j].equals("H")||A[i][j].equals("M")){//an yparxei ena apo ta 2 auxanoume thn check,skopos einai an h check
                        check+=1;
                    }
                }
            }
             //an h check einai =2 tote shmenei oti den exei nikisei kaneis alliws an einai isi me ena tote kapoios exei kerdisei
            if(check==1){//elegxos gia ton kerdise o dolofonos giati h check tha exei vrei 1 diladi tha einai ena symvolo ston pinaka
                JOptionPane.showMessageDialog(null,"O Dolofonos Kerdise Kerdise");//ektypwsh grafikou minimatos
                break;//vgainei apo thn loop gia na termatisei to programma
            }
            else{//alliws tote kanei to check =0 giati xrhsimopoioume ws eolegxo
                check=0;
            }
            System.out.println("Kinisi Dolofonou");//ektypwsh minimatos
            display();  //ektypwsh pinaka      
    }}
    public void display(){//methodos gia thn ektypwsh tou pinaka
         for(int i=0;i<10;i++){//loop gia thn prospelash tou pinaka
            for(int j=0;j<10;j++){
                System.out.print(A[i][j]);//ektypwsh tou pinaka
            }
            System.out.println();//ektypwsh allagh grammhs
        }
    }
    
    
   
  
}
