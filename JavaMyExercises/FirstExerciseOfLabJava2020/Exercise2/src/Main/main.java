/*Dionysis Theodosis A.m:321/2015066
Askhsh2*/
package Main;

public class main {
    public static void main(String[] args) {
        Character_Table b=new Character_Table(); //dhmiourgia antikeimenou b tupou ths klash character_table
        char [] A =new char [5];        //arxikopoihsh pinaka 5 thesewn
        b.fillTableRandomly(A);         //ekxwrisei tou pinaka mesw tou antikeimenou kai ths sunaartiseis sthn klash
        System.out.println("Pinakas orizontia ektypwmenos:"); //ektypwsh minimatos
        b.printTableΗ(A); //ekxwrish tou pinaka sthn synarthsh pou ton ektupwnei se grammh
        System.out.println("Pinakas Katakoryfa ektypwmenos:");
        b.printTableV(A);//ekxwrish tou pinaka sthn synarthsh pou ton ektupwnei se sthlh
        b.swapValues(A,2,4); //dinoume times sthn sunarish swap kai thn kaloume
        System.out.println("Pinakas meta apo swap");
        for (int i=0;i<A.length;i++){   //emfanish pinaka gia na elexoume thn swap
            System.out.println(A[i]);
        }
       System.out.println("Anazitish xarakthra");
        if (0<b.LocationChar(A,'Q')){ //edw kanoume apeutheias thn klhsh ths sunartishs me thn synthikh gia syntomia diladi an auto pou tha epistrepsei einai panw apo to mhden pou exoume dilwsei tha ektypwsei thn thesh 
            System.out.println("H Thesh Pou Vrethike To Stoixeio Einai H:"+ b.LocationChar(A,'Q'));
        }
        else {  //alliws ektypwnei oti den vrethike
            System.out.println("Den vrethike o xarakthras ston pinaka");}
        System.out.println("Clone pinakas tou A");
        b.cloneTable(A);    //kalesma synartiseis dinwntas ton pinaka A gia na mhn ftiaxnoume allon ,wste na dimiourgisei ton klwno tou
        for (int i=0;i<b.cloneTable(A).length;i++){ //epanalhpsh gia na ektypwsoume ton klwno pinaka ,b.cloneTable(A).length einai to megethos tou
            System.out.println(b.cloneTable(A)[i]); //ektypwsh
        }
        System.out.println("Synxgwneush pinakwn");
        for (int i=0;i<A.length+b.cloneTable(A).length;i++){//sygxwneush pinakawn tou A kai tou klwnou tou 
            System.out.println(b.mergeTables(A,b.cloneTable(A))[i]); //ektypwnei ton sygxwneumeno pinaka
        }
        System.out.println("alfarithmitiko");   
        System.out.println(b.ConvertToString(A));   //kalh thn synarthsh vazwntas ws parametro ton pinaka A
        System.out.println("String anamesa apo parametrous");
        System.out.println(b.ConvertToString(A, 1, 5));   
    }
}
