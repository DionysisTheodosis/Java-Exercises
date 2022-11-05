//ASKHSH 1 DIONYSIOS THEODOSIS A.M:3212015066
//PAKETO STO OPOIO ANHKEI H KLASH
package exercise1;

public class Exercise1 {
    
    public static void main(String[] args) {
        //DILWSH PINAKA KAI DHMIOURGEIA 8 THESEWN
        int[] array = new int[8];
        
        //GEMISMA PINAKA ME TYXAIES TIMES
        NumbersTable.fillTableRandomly(array);
        
        //EKTYPWSH TWN STOIXEIWN TOU PINAKA ORIZONTIA
        System.out.println("O Pinakas Ektypwmenos Orizontia Einai:");
        NumbersTable.printTableΗ(array);
        System.out.println();
        
        //EKTYPWSH TWN STOIXEIWN TOU PINAKA KATHETA
        System.out.println("Ektypwsh Pinaka Katheta");
        NumbersTable.printTableV(array);
        System.out.println();
        
        //ENNALASEI TIS TIMES TOU PINAKA, STO KELI 5 VAZEI THN TIMH TOU KELIOU 6 KAI TO ANTISTROFO
        NumbersTable.swapValues(array, 5, 6);
        
        //EKTYPWSH TWN STOIXEIWN TOU PINAKA GIA NA DOUME OTI EGINE H ALLAGH
        System.out.println("O Pinakas Meta Thn Enalagh Twn 5 K 6 Keliwn Einai:");
        NumbersTable.printTableΗ(array);
        System.out.println();
        
        //EPISTROFH TOU MIKROTEROU STOIXEIOY ANAZITWNTAS TO APO THN THESH 3 POU EXOUME DWSEI WS ORISMA KAI TO EKTYPWNEI
        System.out.println("H Thesh me Thn Mikroterh Timi Tou Pinaka Apo To Keli 3 einai:");
        System.out.println(NumbersTable.minLocationFrom(array,3));
        System.out.println();
        
        //EPISTROFH TOU MEGALYTEROU STOIXEIOY ANAZITWNTAS TO APO THN THESH 4 POU EXOUME DWSEI WS ORISMA KAI TO EKTYPWNEI
        System.out.println("H Thesh me Thn Megaluterh Timi Tou Pinaka Apo To Keli 4 einai:");
        System.out.println(NumbersTable.maxLocationFrom(array, 4));
        System.out.println();
        
        //ANAZITISI THS THESHS THS TIMHS 5 STON PINAKA K EKTYPWSH KATALLHLOU MYNHMATOS
        System.out.println("Anazitisi Tou Arithmou 5 Ston Pinaka");
        int search = NumbersTable.LocationNumber(array, 5);
        System.out.println(search==-1?"Den Vrethike To Stoixeio":"To Stoixeio Vrethike Sthn Thesh:"+search);
        System.out.println();
        
        //DIMIOURGOUME ENAN KAINOURGIO PINAKA ANTIGRAFO TOU PROIGOUMENOU
        int[] cloneArray = NumbersTable.cloneTable(array);
        //EKTYPWNOUME GIA NA DOUME AN HTAN SWSTH
        System.out.println("Neos Pinakas Antigrafo Tou Prohgoymenoy");
        NumbersTable.printTableΗ(cloneArray);
        System.out.println();
        
        //SYGXWNEUSH PINAKWN EDW GIA TON CLONED PINAKA KAI TON ARXIKO
        int[] mergedArray=NumbersTable.mergeTables(array, cloneArray);
        System.out.println("Ektypwsh Tou Sygxwneumenoy Pinaka");
        NumbersTable.printTableΗ(mergedArray);
        System.out.println();
        
        //KALESMA THS SYNARTHSHS GIA THN DIMIOURGEIA ENOS ALFARITHMITIKOU ME OLES TIS TIMES TOU PINAKA
        System.out.println("Dimiourgia String Gia Tis Times Tou pinaka");
        String arrayStr = NumbersTable.ConvertToString(array);
        System.out.println("String: "+arrayStr);
        System.out.println();
        
        //KALESMA THS SYNARTHSHS GIA THN DIMIOURGEIA ENOS ALFARITHMITIKOU ME  TIS TIMES TOU PINAKA APO TO 2 MEXRI TO 7 KELI
        System.out.println("Dimiourgia String Gia Tis Times Tou pinaka Apo Thn Thesh 2 Mexri Thn 7");
        String arrayStr2 = NumbersTable.ConvertToString(array,2,7);
        System.out.println("String: "+arrayStr2);
        
      
    }
    
}
