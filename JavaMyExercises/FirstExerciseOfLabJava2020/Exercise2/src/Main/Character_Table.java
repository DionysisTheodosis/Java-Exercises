/*Dionysis Theodosis A.m:321/2015066
Askhsh 2*/
package Main;
import java.util.Random; //ergaleio ths java gia tuxaious arithmou k.t.l.


public class Character_Table {
    public void  fillTableRandomly(char A[]){   //synartisi gia gemisma pinaka me tyxaies metavlites
        Random rand = new Random(); //arxikopoihsh antikeimenou rand typou random
        for (int i=0;i<A.length;i++){   //epanalipsh gia to gemisma tou pinaka 
                int rand_int1 =rand.nextInt(26)+65; //rand gia times apo 65 ws 90 gia auto mesa sthn parethesh exoume 26 giati 91-65=26 kai etsi prokuptei wste na exoume apo 65-90
                A[i]=(char) rand_int1;}}    //ekxwrisei tycaiou xarakthra ston pinaka
    void printTableΗ(char A[]){
        for (int i=0;i<A.length;i++){ 
              System.out.print(A[i]);}  //ektupwsh pinaka katagramh me thn print
        System.out.println();
    }
    void printTableV(char A[]){
        for (int i=0;i<A.length;i++){ 
              System.out.println(A[i]);} //ektypwsh pinaka kata sthlh me to println
    }
    void swapValues(char A[], int first, int second ){//synartish gia na allazei tis times
        char temp;  //arxikopoihsh tupou xarakthra proswrinhs metavliths
        temp=A[second]; //ekxwrish tou deuterou stoixeiou pou edwse o xrhsths sthn temp
        A[second]=A[first];//ekxwrisei tou prwtou sto deutero
        A[first]=temp;} //ekxwrish tou temp sthn prwth wste na ginei h allagh
    int LocationChar(char A[], char key){   //anazitish stoixeiou ston pinaka
        for (int i=0;i<A.length;i++){  //psaxnei se olo to euros tou pinaka
              if(A[i]==key){    //an to vrei 
                  return i;     //epistrefei thn thesh
              }}
        return 0;   //alliws epistrefei 0
    }
    char [] cloneTable (char A[]){ 
        char[] k; //arxikopoihsh pinaka tupou xarakthrwn
        k=A.clone(); //kai mesw ths synarthseis clone kanoume antigrafo tou pinaka a ton k
        return k; //epistrefoume ton pinaka
    }
    char [] mergeTables (char T[], char G[] ){  //dimiourgeia pinaka me ta stoixeia kai twn 2 pinakwn
        char []D=new char[T.length+G.length];    //arxikopoihsei neou pinaka D me megethos to athroisma tou megethous twn 2 pinakwn
        int q=0; //arxikopoihsh enws metrith gia na krataei thn thesei twn stoixeiwn tou neou pinaka
        for (int i=0;i<T.length;i++){
            D[i]=T[i];  //auth h for vazei ta stoixeia tou pinaka T(A diladi) sto D 
            q++;        //auxisi tou metriti
        }
        for (int i=0;i<G.length;i++){
            D[q++]=G[i];    //vazei ta stoixeia tou g ston d gia auto eixame kai to count prin gia na krataei thn thesh
        }
        return D;   //epistrefei ton pinaka
    }
    String ConvertToString (char A[]){
        String s=new String(A);      //arxikopoihsh String s me ta stoixeia tou pinaka
        return s;   //epistrefei ton String
    }
    String ConvertToString (char A[], int w, int e){
     int q=0;   //arxikopoihsh metriti
     char []temp=new char[e-w]; //dimiourgia pinaka wste na krataei ta stoixei anamesa apo to w kai to e stoixeia pou dwsame
     for(int i=w;i<e;i++){  //xekinaei apo to stoixeio w mexri to stoixeio e
            temp[q++]=A[i]; //kai vazei ta stoixeia stou a ston neo pinaka
        }
     String z=new String(temp); //metatrepei ton pinaka se string
        return z; //epistrefei to String
    }
}

