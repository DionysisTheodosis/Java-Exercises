/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package game;
import java.util.Random; //eisaigwgh thn vivliothikis Random giati tha thn xrhsimopoihsoume gia thn tyxaia kinisi tou dolofonou
import java.util.ArrayList;//eisaigwgh thn vivliothikis ArrayList giati tha thn xrhsimopoihsoume gia thn eisagwgh sygkekrimenwn thesewn ws tuxaia kinisi tou dolofonou


public class Killer {//klash tou dolofonou
     private int kinisi;//dilwsh metavlitis pou tha dixnithn kinisi tou dolofonou
     private String cursor;//dilwsh metavlitis pou tha einai h endeixh tou dolofonou
    
    public Killer(){//constructor gia thn arxikopoihsh twn metavlitwn
        kinisi=2;
        cursor="M";
    }
    
    public String[][] moveK(String[][] B){
        int t=0;//dilwsh kai arxikopoihsh tou t pou tha einai gia to i ,h thesh ths grammhs
        int u=0;//dilwsh kai arxikopoihsh tou u pou tha einai gia to j ,h thesh ths sthlhs
        for(int i=0;i<10;i++){//epanalipsi gia prospelash tou pinaka me skopo na doume thn thesh tou dolofonou
            for(int j=0;j<10;j++){
                if(B[i][j].equals(cursor)){//synthiki pou sygkrinei thn endeixh me to stoixeio tou pinaka
                    t=i; //ekxwrei to i sto t
                    u=j; //ekxwrei to j sto u
                }
            }
        }
       B[t][u]="-";//antikathistoume thn endeixh me to '-'
       ArrayList<Integer> l = new ArrayList<>(); //dimiourgia arraylist gia thn eisagwgh twn entolwn
       l.add(2); //eisagei to 2 gia thn kinisi katw
       l.add(4); //eisagei to 4 gia thn kinisi aristera
       l.add(8);//eisagei to 8 gia thn kinisi panw
       l.add(6);//eisagei to 6 gia dexia
       Random rand = new Random();//arxikopoihsh kai dimiourgia random antikeimenou
       for(;;){//synexeis loop thn xrhsimopoioume gia ton elegxo swsths kataxwrishs wste na mhn xepernaei ta oria tou pinaka
         int move= l.get(rand.nextInt(l.size()));//pernei tyxaio stoixeio apo thn lista pou exoume dimiourghsei
         if((move==8)&&((u-kinisi)>=0)){//elegxos gia ton an to tyxaio stoixeio einai to 8 dhladh kinisi panw kai an epitrepete sta oria tou pinaka
            u=u-kinisi; //tote kanei to u=u-2
            break;//vgainei apo thn loop
          }
         if((move==4)&&((t-kinisi)>=0)){//elegxos gia ton an to tyxaio stoixeio einai to 4 dhladh kinisi aristera kai an epitrepete sta oria tou pinaka
            t=t-kinisi;//tote kanei to t=t-2
            break;//vgainei apo to loop
          }
         if((move==6)&&((t+kinisi)<10)){//elegxos gia ton an to tyxaio stoixeio einai to 6 dhladh kinisi dexia kai an epitrepete sta oria tou pinaka
            t=t+kinisi; //tote kanei to t=t+2
            break;//vgainei apo thn loop
            }
         if((move==2)&&((u+kinisi)<10)){//elegxos gia ton an to tyxaio stoixeio einai to 2 dhladh kinisi katw kai an epitrepete sta oria tou pinaka
            u=u+kinisi;//tote kanei to u=u+2
            break;//vgainei apo thn loop
         }
       }
       B[t][u]=cursor;//vazei sthn thesh tou pinaka thn endeixh tou dolofonou
       return B;//epistrefei ton pinaka
    }
    
}
