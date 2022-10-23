/*Dionysios Theodosis
  A.M:321/2015066
  Askisi 3
*/
package passwords;
import javax.swing.JOptionPane;
import java.util.*;

public class PasBuilder {//dilwsh klashs gia thn paragwgh twn kwdikwn
    private int numberOfPasswords;//dilwsh ths metavlitis pou tha krataei ton arithmo twn kwdikwn
    private int numberOfCharacters;//dilwsh ths metavlitis pou tha krataei twn arithmo twn xarakthrwn
    private HashSet<String> pasSWords;//dilwsh metavlitis typou hashet  pasSWord h opoia tha krataei tous kwdikou etsi wste na mporoume na thn ektypwsoume me thn display 
    
    public PasBuilder(){//constructor pou arxikopoiei tis metavlitis an kalesthei xwris parametrous
        numberOfPasswords=0;
        numberOfCharacters=0;
        
    }
      public PasBuilder(int numberOfPasswords,int numberOfCharacters){//constructor me parametrous gia na pernaei tis metavlites pou edwse o xrhsths
        
        for(;;){//loop wste na elegxei gia to an exei dwsei thn katalhlh timh
            
            if(numberOfCharacters<4){//o elegxos
                numberOfCharacters=Integer.parseInt(JOptionPane.showInputDialog("Dwse plithos xarakthrwn megalutero h iso me 4"));//alliws ektypwnei to grafiko minima kai pernei kai thn timh sygxronos 
            }
            else{//alliws vgainei apo thn loop
                  break;
            }
        }
        //arxikopoiei tis metavlites xrhsimopoiontas to this. gia na mhn mperdeutei o compiler
        this.numberOfCharacters=numberOfCharacters;
        this.numberOfPasswords=numberOfPasswords;
        pasSWords =new HashSet<String>();
    }
    public void build(){//h methodos gia thn dhmiourgia twn kwdikwn
            //dimiourgeia arraylist pou tha periexei ola ta dedomena
            ArrayList<String>data=new ArrayList<String>();
            
            for(int i=65;i<91;i++){//loop gia thn ekxwrisi olwn twn xarakthrwwn  Kefalaiou grammatos apo ton pinaka ASCII
               data.add(String.valueOf((char)i));
            }
            for(int i=97;i<123;i++){//loop gia thn ekxwrisi olwn twn xarakthrwwn pezou grammatos apo ton pinaka ASCII
               data.add(String.valueOf((char)i));
            }
            for(int i=48;i<58;i++){//gia tous arithmitikous xarakthres
               data.add(String.valueOf((char)i));
            }
            //eisagwgh twn parakatw xarakthrwn sthn arraylist
            data.add("!");
            data.add("#");
            data.add("@");
            data.add("%");
            data.add("$");
           
            String pass="0";//dilwsh kai arxikopoihsh metavlitis pass pou tha thn xrhsimopoihsoume giaws string gia na krataei tpus tuxaious xarakthres
            do{//epanalipsi gia ton arithmos ton kwdikwn 
            char a;//arxikopoihsh xarakthra a ,o opoios tha krataei to tyxaio xarakthra
            Random r=new Random();//dilwsh random
            int t=r.nextInt(26)+97;//pernaei sthn t ton tyxaio paizo xarakthra 
            a=(char) t; //metatrepei to t se char kai to dinei sthn a gia na to kratisei san xarakthra
            pass=String.valueOf(a);//vazei sthn string ton xarakthra a 
            t=r.nextInt(26)+65;//pernaei sthn t ton tyxaio kefalaio xarakthra
             a=(char) t;
            pass+=String.valueOf(a);
            t=r.nextInt(10)+48;//pernaei sthn t ton tyxaio arithmitiko xarakthra
            a=(char) t;
            pass+=String.valueOf(a);
            String[]P={"!","#","@","$","%"};//dilwsh kai arxikopoihsh string me tous xarakthres
            t=r.nextInt(P.length);//epilogh enos apop tous parapanw xarakthres
             pass+=P[t];//prosthiki sthn String pass
            Random ena=new Random();//arxikopoihsh random
            int temp=0;
            for(int i=0;i<numberOfCharacters-4;i++){//me auth thn loop efoson exoume idi valei 1 toulaxiston apo ta 4 theloume na gemisoume thn sumvolosira analogos tou plithous ara plithos -4
                temp=ena.nextInt(data.size());//pairnei tyxaio dikti ths listas
               pass+=data.get(temp);//pernaei sthn sumvoloseira pass to stoixeio ths listas sthn thesh temp
            }
           //Mperdeuei thn symvoloseira
           List<String> change = new ArrayList<String>(Arrays.asList(pass.split("")));//metatrepoume thn symvoloseira se arraylist gia na mporesoume na xrhsimopoihsoume thn collection
           Collections.shuffle(change);//anakateei ta stoixeia
           String s="0";//arxikopoihsh ths symvoloseiras s
           for(int i=0;i<change.size();i++){//metatrepei thn lista se symvoloseira
               if(i==0){//etsi gemizei to prwth thesh thn symvoloseiras
                   s=change.get(i);
               }
               else{//gemizei apo thn 1 thesh kai meta
               s+=change.get(i);}
           }
           //apothykeysh se lista hashset gia monadika pass
           pasSWords.add(s);
            }
          while(pasSWords.size()<numberOfPasswords);
            
      
    }
    public void display(){//methodos gia thn ektypwsh twn kwdikwn
        Iterator<String>it=pasSWords.iterator();//dilwsh iterator 
           int i=0; //dilwsh kai arxikopoihsh metriti i
           String ektypwsh="";
           while(it.hasNext()){//loop gia thn prospelash olwn twn stoixeiwn tou pasSWords
               if(i%8==0){//synthiki gia thn ektypwsh allaghs grammhs meta apo 8 kwdikous h ana 8 theseis 
                   ektypwsh+="\n";
               }
                   i++;//auxisi tou dikti
                   ektypwsh+=it.next()+" ";//eisagwgh sthn sumvoloseira ektypwsh thn timi ths listas sthn thesh tou iterator
               }
           JOptionPane.showMessageDialog(null,ektypwsh);//ektypwsh se grafiko perivalon
    }
}
