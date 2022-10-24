/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package game;
import javax.swing.JOptionPane;

public class Hole {//klash gia ton astynomo
    private int kinisi;//dilwsh metavlitis pou tha dixnithn kinisi tou astynomou
    private String cursor;//dilwsh metavlitis pou tha einai h endeixh tou astynomou  
    
    public Hole(){//constructor gia thn arxikopoihsh twn idiothtwn
        kinisi=1; 
        cursor="H";
    }
    public String[][] moveH(String move,String[][] B){ //methodos typou pinaka string gt tha gyrnaei ton pinaka allagmeno kai eisagei thn kinisi pou exei dwsei o paikths kai ton pinaka
       int t=0;//dilwsh kai arxikopoihsh tou t pou tha einai gia to i ,h thesh ths grammhs
       int u=0;//dilwsh kai arxikopoihsh tou u pou tha einai gia to j ,h thesh ths sthlhs
        for(int i=0;i<10;i++){//epanalipsi gia prospelash tou pinaka me skopo na doume thn thesh tou astynomou
            for(int j=0;j<10;j++){
                if(B[i][j].equals(cursor)){//synthiki pou sygkrinei thn endeixh me to stoixeio tou pinaka
                    t=i;    //ekxwrei to i sto t
                    u=j;     //ekxwrei to j sto u
                }
            }
        }
        B[t][u]="-";//antikathistoume thn endeixh me to '-'
        for(;;){ //synexeis loop thn xrhsimopoioume gia ton elegxo swsths kataxwrishs wste na mhn xepernaei ta oria tou pinaka
            if((move.equals("left"))&&((u-kinisi)>=0)){//elegxos gia to ti exei dwsei o xrhsths kai thn katalhlh kinisi an einai dexia kai einai entos twn oriwn tou pinaka
                 u=u-kinisi; //tote kanei to u=u-1
                 break;//kai vgainei apo thn loop
            }
            if((move.equals("up"))&&((t-kinisi)>=0)){//elegxos gia to ti exei dwsei o xrhsths kai thn katalhlh kinisi an einai panw kai einai entos twn oriwn tou pinaka
                t=t-kinisi;//tote kanei to t=t-1
                break;//kai vgainei apo thn loop
            }
            if((move.equals("down"))&&((t+kinisi)<10)){//elegxos gia to ti exei dwsei o xrhsths kai thn katalhlh kinisi an einai katw kai einai entos twn oriwn tou pinaka
                t=t+kinisi;
                break;//kai vgainei apo thn loop
            }
            if((move.equals("right"))&&((u+kinisi)<10)){//elegxos gia to ti exei dwsei o xrhsths kai thn katalhlh kinisi an einai dexia kai einai entos twn oriwn tou pinaka
                u=u+kinisi;
                break;//kai vgainei apo thn loop
            }
            move = JOptionPane.showInputDialog("Ektos oriou pinaka xanadwse thesh:");   //ektypwsh grafikou mhnymatos gia to na xanadwsei thesh kai autopmata kataxwrisi tou
        }
        B[t][u]=cursor;//ekxwroume sthn thesh tou pinaka thn thesh tou astynomou
      return B;//epistrefei ton pinaka
    }
}
