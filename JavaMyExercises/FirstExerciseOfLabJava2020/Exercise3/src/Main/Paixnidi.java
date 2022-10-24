/*Dionysis Theodosis A.m:321/2015066
Askhsh 3*/
package Main;
import static java.lang.Boolean.TRUE;//ergaleio ths java gia thn xrhsh boolean se synthikes
import java.util.ArrayList; //ergaleio ths java gia thn xrhsh arraylist
import java.util.Scanner;//ergaleio ths java("klashs")gia thn eisagwgh apo to plhktrologio
import java.util.Random;//ergaleio ths java genetria tuxaiwn stoixeiwn

public class Paixnidi {
    
   
    ArrayList<Erwtisi> Question=new ArrayList<>();//dimiourgia arraylist question
    ArrayList<Erwtisi> tyxaia=new ArrayList<>();//dimiourgia arraylist tyxaia
    
    public Paixnidi(){
        //dhmiourgia antikeimenw  gia thn klash erwtisi kai eisagwgh mesw tou constructor stoixeia
        Erwtisi er1=new Erwtisi("Poia einai h prwteuaousa ths Ispanias","H madrith",25);
        Erwtisi er2=new Erwtisi("Poia omada exei ta perissotera prwtathlimata podosfairou sthn Ellada","O Olympiakos",30);
        Erwtisi er3=new Erwtisi("Poia einai h prwteusousa ths Xilhs","To Sandiago",70);
        Erwtisi er4=new Erwtisi("Poios podosfairistis exei ta perissotera goal","Josef Bican",100);
        Erwtisi er5=new Erwtisi("Poios htan o xrysos aiwnas tou Periklh","o 5os aiwnas p.X",40);
        Erwtisi er6=new Erwtisi("Pote exafanistikan oi deinosauroi","66 ekatomuria xronia prin",75);
        Erwtisi er7=new Erwtisi("Poia einai h prwteuousa ths Roumanias","To Voukouresti",50);
        Erwtisi er8=new Erwtisi("Pros ta pou gyrizei h gh","Pros ta dexia",45);
        Erwtisi er9=new Erwtisi("Pote pathse prwwth fora o anthrwpos sto feggari","to 1969",35);
        Erwtisi er10=new Erwtisi("Poia htan h prwth prwteusa ths Elladas","h Aigina",84);
        //eisagwgh twn antikeimenwn sthn arraylist
        Question.add(er1);
        Question.add(er2);
        Question.add(er3);
        Question.add(er4);
        Question.add(er5);
        Question.add(er6);
        Question.add(er7);
        Question.add(er8);
        Question.add(er9);
        Question.add(er10);          
    }
   
    public void Trivia(){   //synartisi pou apoikonizei to paixnidi
        Random random = new Random();   //arxikopoihsh kai dimiourgia random metavlitis tupou Random gia tyxaious arithmous
        int thesizeoflist=Question.size();  //arxikopoihsh metavliths sizeoflist kai ekxwrish to megethos ths listas gia na to exoume otan tha theloume na emfanizoume tyxaia tis apantiseis
        //tyxaia emfanish twn erwthsewn
        for(int i=0; i <thesizeoflist; i++){   //epanalipsh gia thn prospelash olwn ton stoixeiwn ths listas
            int randomIndex= random.nextInt(Question.size());//arxikopoihsh metavliths randomindex me mia tuxaia thesh ths listas question
            String randomElement1=(Question.get(randomIndex).getErwtisi()); //dimiourgia a=metavliths string gia thn apothikeush ths erwtishs pou vrisketai sthn thesh randomindex
            String randomElement2=(Question.get(randomIndex).getApantisi());//dimiourgia a=metavliths string gia thn apothikeush ths apantishs pou vrisketai sthn thesh randomindex
            int randomElement3=(Question.get(randomIndex).getPoso());//dimiourgia a=metavliths int gia thn apothikeush tou posoy pou vrisketai sthn thesh randomindex
            Erwtisi a=new Erwtisi(randomElement1,randomElement2,randomElement3); //dimiourgeia antikeimenou typou erwtishs kai to arxikopoioume me tis metavlites pou ftiaxame
            tyxaia.add(a); //eisagwgei tou antikeimenou sthn lista tyxaia         
            Question.remove(randomIndex); //diagrafei tou stoixeiou ths lista question pou vrisketai sthn thesh randomindex wste na mhn ton xanaprospelasoume
        }
        Scanner scan=new Scanner(System.in);    
        String answer;//dilwsh metavliths tupou string 
        int lefta = 0; //dilwsh metavliths tupou int gia na krataei to synoliko poso 
        int k=0;    //dimiourgeia metavliths wste na dixnei ton arithmo kathe erwthshs
        //paixnidi
        for (int i=0;i<tyxaia.size();i++) { //epanalipsh gia ektupwsh twn erwthsewn kai to xekinima tou paixnidiou
            k++;
            System.out.println(k+")"+tyxaia.get(i).getErwtisi()+";");//ektypwsh erwthshs
            answer=scan.nextLine();//eisagwgh apantiseis apo ton xrhsth
            if(answer.equalsIgnoreCase(tyxaia.get(i).getApantisi())==TRUE){ //elegxos gia to an h pantisi pou edwse o xristis einai swsth
                System.out.println("Kerdises "+tyxaia.get(i).getPoso()+" h eurw");//ektypwsh
                lefta+=tyxaia.get(i).getPoso();//prosthetei to poso ths erwtishs sto synoliko
            }
            else {
                System.out.println("H Swsth Apanthsh Einai: "+tyxaia.get(i).getApantisi());//emfanish ths swsths apanthshs
            }
        }
        System.out.println("To Synoliko Poso Pou Kerdises Einai: "+lefta+" eurw");//emfanizei to synoliko poso pou kerdise me to telos tou paixnidiou
    }
}


