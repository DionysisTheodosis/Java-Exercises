package exercise1;//TO SYMPERILAMVANOUME GIA NA DEIXOUME SE POIO PAKETO EINAI GIATI DEN EXOYME TO DEFAULT
//IMPORT GIA THN XRHSIMOPOIHSH THS RANDOM
import java.util.*;

public class NumbersTable {
    
    //METHODOS GIA TO GEMISMA ME TYXAIAES TYMES APO TO 1-50
    public static void fillTableRandomly(int[] array){
        
        //DIMIOURGEIA ANTIKEIMENOU RANDOM
        Random randomNumbers = new Random();
        
        //PROSPELASH TOU PINAKA K EISAGWGH TIMWN
        for(int i = 0;i<array.length;i++){
            array[i]= 1 + randomNumbers.nextInt(50);//APO TO 1 MEXRI TO 50
        }  
    }
    
    //METHODOS GIA THN EKTYPWSH TOU PINAKA SE MIA GRAMMH
    public  static void printTableΗ(int[] array){
        
        for(int i : array ){ //PROSPELASH TWN STOIXEIWN TOU PINAKA
            
            System.out.print(i+" ");//EKTYPWSH TOU KATHE STOIXEIOU K KENO GIA NA XEXWRIZOUN
        }
        System.out.println();//ALLAGH GRAMMHS
    }
    
    //METHODOS GIA THN EKTYPWSH TOU KATHE KELIOU TOU PINAKA SE XEXWRISTI GRAMMH
    public static void printTableV(int[] array){
         for(int i : array ){//PROSPELASH TWN STOIXEIWN TOU PINAKA
             
            System.out.println(i);//EKTYPWSH TOU KATHE STOIXEIOU ME PRINTLN GIA THN ALLAGH GRAMMHS
        }
    }
    
    //METHODOS GIA THN ENNALAGH TWN TIMWN STA DOSMENA KELIA TOU PINAKA
    public static void swapValues(int[] array, int firstIndex, int secondIndex){
           int temp; //PROSWRINH METAVLITI GIA NA APOTHUKEUSH THN MIA TIMI
           temp = array[firstIndex];
           array[firstIndex] = array[secondIndex];
           array[secondIndex] = temp;
    }
    
    //METHODOS GIA THN EYRESH TOU MIKROTEROU ARITHMOU APO THN TIMH TOU KELIOU POU EXOUME PERASEI fromIndex
    public static int minLocationFrom(int[] array, int fromIndex){
        //DIMIOURGEIA KAI DILWSH METAVLITWN K ARXIKOPOIHSH ME TO SOIXEIO STO fromIndex
        int minNumber=array[fromIndex]; 
        int minIndex=fromIndex;
        //PROSPELASH TOU PINAKA
        for(int i = (fromIndex+1) ;i<array.length;i++){
            if(array[i]<minNumber){ //ELEGXOS AN TO STOIXEIO TOU PINAKA EINAI MIKROTERO KAI TOTE TO VAZEI STO MIN TIMH
                minNumber=array[i];
                minIndex = i; //APOTHYKEUSHS THS TIMHS TOU DEIKTI
            }
        }
        return minIndex; //EPISTROFH THS THESHS
    }

    //METHODOS GIA THN EYRESH TOU MEGALUTEROU ARITHMOU APO THN TIMH TOU KELIOU POU EXOUME PERASEI fromIndex    
    public  static int maxLocationFrom(int[] array, int fromIndex){
        //DIMIOURGEIA KAI DILWSH METAVLITWN K ARXIKOPOIHSH ME TO SOIXEIO STO fromIndex
        int maxNumber=array[fromIndex];
        int maxIndex=fromIndex;
        //PROSPELASH TOU PINAKA
        for(int i = (fromIndex+1);i<array.length;i++){
            if(array[i]>maxNumber){ //ELEGXOS AN EINAI MEGALUTERH H TIMH TOTE THN EKXWREI STHN METAVLITI
                maxNumber=array[i];
                 maxIndex = i; //APOTHYKEUSHS THS TIMHS TOU DEIKTI
             }
        }
        return maxIndex; // EPISTROFH THS THESHS
    }
    
    //METHODOS GIA THN EURESH THS PRWTHS EMFANISHS TOU ARITHMOU K EPISTROFH THS THESHS TOU
    public static int LocationNumber(int[] array, int number){
        //DILWSH KAI ARXIKOPOIHSH THS TIMIS SEARCH WSTE NA EPIOSTREPSEI TO -1 AN DEN VREI
        int search = -1;
        
        //PROSPELASH TOU PINAKA
        for(int i=0;i<array.length;i++){
            if(number==array[i]){ //ELEGXOS GIA TO AN EINAI ISO
                search = i; //TOTE DINEI THN TIMI DEIKTI STHN SEARCH
                break; //VGAINEI APO THN FOR GIATI THELOUME THN PRWTH EMFANISH
            }
        }
        return  search; //EPISTREFEI TON DEIKTI TOU KELIOU
    }
    
    //METHODOS GIA THN DHMIOURGEIA ANTIGRAFOU TOU PINAKA
    public static int[] cloneTable (int[] array){
       //DILWSH K DHMIOURGEIA ENOS PINAKA TYPOU INT ME XWRO OSO O array 
       int[] clonedArray = new int[array.length];
       int i=0; // DILWSH METAVLITIS WS DEIKTI GIA TON NEO PINAKA
       //PROSPELASH TOU PINAKA array
       for(int j: array){
           clonedArray[i++]=j;//PROSTHIKI TWN TIMWN TOU POINAKA array ston NEO K VAZOUME TO I NA AUXANETAI
       }
       return clonedArray;  //EPISTROFH TOU KLWNOU PINAKA
    }
    
    //METHODOS GIA THN DHMIOURGEIA NEOU PINAKA APO 2
    public static int[] mergeTables (int[] array1, int[] array2){
        //DILWSH NEOU PINAKA ME XWRO OSO TO ATHROISMA TWN 2
        int[] mergedArray= new int[array1.length+array2.length];
        //DILWSH KAI ARXIKOPOIHSH DEIKTH GIA TON NEO PINAKA
        int i=0;
        //PROSPELASH TOU PINAKA array1
        for(int j:array1){
                mergedArray[i++]=j;//PROSTHIKI TWN STOIXEIWN TOU array1 STON NEO
        }
        for(int j:array2){
                mergedArray[i++]=j;//PROSTHIKI TWN STOIXEIWN TOU array2 STON NEO
        }
        return mergedArray;// EPISTROFH TOU MERGED PINAKA
    }      
    
    //METHODOS GIOA THN DHMIOURGEIA STRING ME TIS TIMES TOU PINAKA
    public static String ConvertToString (int[] array){
        //DILWSH KAI ARXIKOPOIHSH TOU STRING ME TO KENO
        String arrayString = "";
        //PROSPELASH TWN STOIXEIWN TOU PINAKA APO TO 2o STOIXEIO K META
        for(int i=0;i<array.length;i++){
            arrayString+=array[i]; //PROSTHIKI STO STRING TO KATHE STOIXEIO TOPU PINAKA K KENO ANAMESA
        }
        return arrayString; //EPISTROFH TOU STRING
    }        
    
    //METHODOS GIA THN DHMIOURGEIA STRING GIA SYGKEKRIMENES TIMES STO DOSMENO EUROS TOU PINAKA
    public static String ConvertToString (int[] array, int fromIndex, int toIndex){
        //DILWSH KAI ARXIKOPOIHSH TOU STRING ME TO KENO
        String arrayString = "" ;
        
        //PROSPELASH TOU PINAKA APO TO  fromIndex
        for(int i=fromIndex;i<=toIndex;i++){
            arrayString+=array[i];  //PROSTHIKI STO STRING TO KATHE STOIXEIO TOPU PINAKA K KENO ANAMESA
        }
        return arrayString;//EPISTROFH TOU STRING
    }          
}
