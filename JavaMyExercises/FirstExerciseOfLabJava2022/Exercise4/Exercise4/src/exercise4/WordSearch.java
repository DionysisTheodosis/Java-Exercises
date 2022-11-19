package exercise4;
//EISAGWGH TWN KATALHLWN VIVLIOTHIKWN POU XREIAZOMASTE
import java.util.*;
import java.util.Random;

//KLASH H OPOIA YLOPOIEI THN EISAGWGH KAI THN EURESH TWN LEXEWN STON PINAKA KATHWS KAI THN EKTYPWSH TOY
public class WordSearch {
    
    //DILWSH METAVLITWN KLASHS
    private final int lines;            //METAVLITI GIA TIS GRAMMES TOU PINAKA
    private final int rows;             //METAVLITI GIA TIS STHLES TOU PINAKA
    private final char[][] array;       //DILWSH TOU DISDIASTATOU PINAKA
    //METAVLITES GIA POIO EVANAGNWSTO KWDIKA
    private static final int  LINE = 0;
    private static final int  ROW = 1;
    
    //CONSTRUCTOR GIA THN DHMIOURGEIA  TOU PINAKA
    public WordSearch(){
        lines=15; 
        rows=25;
        array = new char[lines][rows];
    }
    
    //METHODOI TIS KLASHS
    //METHODOS GIA THN EISAGWGH LEXHS STON PINAKA
    public int addWord(Word wordTadd){
        
        //DILWSH METAVLITWN WSTE NA EXOUME PIO APLO KWDIKA STO DIAVASMA GIA THS METAVLITES THS LEXHS
        String word = wordTadd.getWord();
        int type =wordTadd.getType();
        int possitionType = wordTadd.getPossitionType();
        int firstCharIndex = wordTadd.getFirstCharIndex();
        //METAVLITI POU THA KRATAEI THN THESH TOU TELEUTAIOU XARAKTHRA 
        int lastIndex = word.length();
        
        //DILWSH PINAKA XARAKTHRWN POU THA KRATAEI THN METATROPOIHMENH STRING LEXH SE PINAKA
        char[] wordChar;
        wordChar = word.toCharArray(); 
        //METAVLITI GIA TON YPOLOGISMO THS THESHS TOU PINAKA XARAKTHRWN 
        int t =0;
        
        //SWITCH GIA THN EPILOGH THS KATALHLHS EISAGWGHS AN EINAI GIA STHLH H GIA GRAMMH WSTE NA GINEI O ELEGXOW AN MPOREI NA GINEI H EISAGWGH
        switch(type){
            //AN THN APOTHYKEUSEI SE GRAMMH TOTE
            case LINE: 
                //ELEGXEI AN TO MEGETHOS THS LEXHS PERNAEI TA OREIA TOU PINAKA KAI EPISTREFEI -1
                if(rows-firstCharIndex<word.length()){
                     return -1;
                }
                //ELEGXOS GIA TO AN DEN YPARXEI ALLH LEXH H XARAKTHRAS LEXHS THS OPOIAS DEN EINAI IDIOI STHN ENLOGO THESH KAI TOTE EPISTREFEI -1
                for(int i=firstCharIndex;i<lastIndex+firstCharIndex;i++){
                    if((Character.compare(array[possitionType][i],'\0')!=0)&&(Character.compare(array[possitionType][i],wordChar[t++])!=0)){
                        return -1;
                    }
                }    
                break;
            //AN THN APOTHYKEUSEI SE STHLH TOTE
            case ROW:
                //ELEGXEI AN TO MEGETHOS THS LEXHS PERNAEI TA OREIA TOU PINAKA KAI EPISTREFEI -1
                 if(lines-firstCharIndex<word.length()){
                     return -1;
                }
                 //ELEGXOS GIA TO AN DEN YPARXEI ALLH LEXH H XARAKTHRAS LEXHS THS OPOIAS DEN EINAI IDIOI STHN ENLOGO THESH KAI TOTE EPISTREFEI -1
                for(int i=firstCharIndex;i<lastIndex+firstCharIndex;i++){
                    if((Character.compare(array[i][possitionType],'\0')!=0)&&(Character.compare(array[i][possitionType],wordChar[t++])!=0)){
                        return -1;
                    }
                }  
                break;
        }
        //DILWSH METAVLITIS POU THA THN EXOUME WS COUNTER ANALOGOS ME TO PLITHOS TO STOIXEIWN TOU STRING
        int breakCount= word.length();
        t=0; //DINOUME TO 0 GIA NA TO XRISIMOPOIHSOUME PALI WS DEIKTH
        
        //EISAGWGH THS LEXHS STON PINAKA
       
        if(type==LINE){//AN EINAI KATA GRAMMH
            //EPANALIPSI GIA TA STOIXEIA TOU PINAKA APO THN STHLH POU DIXNEI O 1O XARAKTHRAS MEXRI THN STHLH TOU TELEUTAIOU THS LEXHS
            for(int i=firstCharIndex;i<lastIndex+firstCharIndex;i++){
                if(t!=breakCount){//EISAGWGH OSO EINAI TO MEGETHOS TOU STRING
                    array[possitionType][i] = wordChar[t++]; //APOTHUKEUSH STON PINAKA TOU EKASTOTE XARAKTHRA TOU STRING
                }    
            }
           
        }
        else if(type==ROW){//AN EINAI KATA STHLH,ELSE IF GIA KALUTERH PROSTASIA APO THN ELSE
            for(int i=firstCharIndex;i<lastIndex+firstCharIndex;i++){
                if(t!=breakCount){//EISAGWGH OSO EINAI TO MEGETHOS TOU STRING
                   array[i][possitionType] = wordChar[t++]; //APOTHUKEUSH STON PINAKA TOU EKASTOTE XARAKTHRA TOU STRING
                }    
            }  
        }
        
        return 0;//EPISTREFEI 0 WS ENDEIXH OTI EGINE H EISAGWGH
        
    }
    
    //METHODOS GIA THN SYMPLHRWSH TWN KENWN KELIWN ME TUXAIA GRAMMATA
    public void fillBlanks(){
        //DHMIOURGWEIA ANTIKEIMENOU RANDOM GIA THN XRHSH THS RANDOM GIA TYXAIOUS ARITHMOUS
        Random randomChar = new Random();
        //PROSPELASH OLWN TWN STOIXEIWN TOU PINAKA
        for(int i=0;i<15;i++){
            for(int j=0;j<25;j++){
                if(array[i][j]=='\0'){//SYNTHIKI GIA TO AN TO STOIXEIO EINAI MIFEN 
                    array[i][j] =(char) (97 + randomChar.nextInt(25));//EPILEGH NA GURISEI ENAN ARITHMO APO TO 97-122 POU EINAI OI XARAKTHRES STO ASCII
                }
            }
        }
    }
    
    //METHODOS GIA THN EURESH MIAS LEXHS STON PINAKA
    public String search(Word word){
        //DILWSH PIBNAKA XARAKTHRWN POU THA APOTHIKEUSOUME THN LEXH ANA XARAKTHRA
        char[] wordChar;
        wordChar = word.getWord().toCharArray();
        //DILWSH METAVLITHS POU THA THN XRHSIMOPOIHSOUME WS FLAG GIA NA STAMATHSEI H EPANALIPSH
        int breakCount= wordChar.length;
        //DHMIOURGEIA STRING KAI ARXIKOPOIHSH TOU WS KENO WSTE NA EPISTREPSEI THN THESH THS LEXHS
        String find ="";
        
        //ELEGXOS GIA TO AN YPARXH H LEXH
        if(word.getType()== LINE){//SYNTHIKI AN EINAI KATA GRAMMH
            //DIMIOURGEIA ENOS PINAKA XARAKTHRWN POU THA KRATISEI THN LEXH POU YPARXH STIS DOSMENES THESEIS TOU PINAKA 
            char [] tempArr = new char[word.getWord().length()];
               
            //ARXIKOPOIOUME TON tempArr ME TA DEDOMENA TOU PINAKA TOU KRYPTOLEXOU STIS THESEIS POU MAS EXEI DWSEI H LEXH
            //EDW XRHSIMOPOIOUME TO array[] MIAS KAI MPOROUMR NA TO KANOUME AFOU EINAI KATA GRAMMH KAI EINAI  DIPLOS PINAKAS
            tempArr = Arrays.copyOfRange(array[word.getPossitionType()],word.getFirstCharIndex(),word.getWord().length()+word.getFirstCharIndex());
            //XRHSIMOPOIONTAS THN METHODO THS SYGKRISHS APO THN ARRAYS SYGKRINOUME AN O TEMPAR EINAI IDIOS ME TON PINAKA XARAKTHRWN  THS LEXHS
            if(Arrays.compare(tempArr,wordChar)==0){//AN EINAI TOTE EKTYPWNEI TO KATALLHLO STRING
                find = "Grammh:"+word.getPossitionType()+" Sthlh 1ou Xarakthra:"+word.getFirstCharIndex()+" Sthlh Teleutaiou Xarakthra:"+((word.getFirstCharIndex()+word.getWord().length())-1);
            }
                 
        }
        else if(word.getType()== ROW){//SYNTHIKI AN EINAI KATA STILI
            //DIMIOURGEIA ENOS PINAKA XARAKTHRWN POU THA KRATISEI THN LEXH POU YPARXH STIS DOSMENES THESEIS TOU PINAKA
            char [] tempArr = new char[word.getWord().length()];
            //DILWSH METRHTH GIA TON PINAKA   
            int t=0;
            
            //EDW EPEIDH EINAI KATA STHLH THA PREPEI NA GINEI PROSPELASH ANA STHLH 
            for(int j=word.getFirstCharIndex();j<word.getFirstCharIndex()+word.getWord().length();j++){
                if(breakCount>0){//SYNTHIKI H OPOIA MAS EXASFALIZEI NA MHN PETAXEI SFALMA  PROS THN KATAXWRISI  
                    tempArr[t++] = array[j][word.getPossitionType()]; //KATAXWRISI TWN TIMWN TOU PINAKA STON PROSWRINO
                }
                   
            }
            //ELEGXOS GIA TO AN O PROSWRINOS POU EXEI TA STOIXEIA TOU PINAKA EINAI IDIOS ME TON PINAKA TWN XARAKTHRWN THS LEXHS
            if(Arrays.compare(tempArr,wordChar)==0){
                //EKTYPWSH TOU STRING
                find = "Stili:"+word.getPossitionType()+" Grammh Tou 1ou Xarakthra:"+word.getFirstCharIndex()+" Grammh Tou Teleutaiou Xarakthra:"+((word.getFirstCharIndex()+word.getWord().length())-1);
            }       
        }
        //EPISTREFEI TO ALFARITHMITIKO ME THN THESH THS LEXHS
        return find; 
    }
    
    //METHODOS GIA THN EKTYPWSH TOU PINAKA
    public void display(){
        //EKTYPWSH MINIMATOS SWSTA MORFOPOIJMENOU
        System.out.printf("%72s\n","PINAKAS");
        //EKTYPWSH * SAN ORIOGRAMMH 2 STRWSEWN TOU PINAKA
        for(int i=0;i<2;i++){
            System.out.print("*");
            for(int k=0;k<132;k++){
                 System.out.print("*");
             } 
            System.out.println("*");
        }
        System.out.print("** -  *");
        //EKTYPWSH TWN ARITHMWN GIA TOUS DEIKTES THS STHLHS KAI SWSTA MORFOPOIHMENO KAI ME * SAN DIAXWRISTIKA
        for(int k=0;k<25;k++){
            if(k<10){//SYNTHIKI GIA NA AFHNEI PERISOTERO KENO OSO EINAI 1 PSIFIOU
                System.out.print("*  "+k+" ");
            }
            else{//AN EINAI 2 K PANW PSIFIA
                System.out.print("* "+k+" ");
            }       
        }
        System.out.println("**");
        //EKTYPWSH * SAN GRAMMH POU XEXWRIZEI TA STOIXEIA TOU PINAKA ME THN ARITHMISI
        for(int i=0;i<2;i++){
            for(int k=0;k<134;k++){
                    System.out.print("*");
            }
            System.out.println();
        }
        
        //EKTYPWSH TWN STOIXEIWN TOU PINAKA
        for(int i=0;i<15;i++){
            //EKTYPWSH TOU ARITHMOU THS GRAMMHS ME KATALLHLA * SAN DIAXWRISTIKA
            System.out.print("*");
            if(i<10){
                System.out.print("*  "+i+" *");
            }
            else{
                System.out.print("* "+i+" *");
            }
            //EKTYPWSH TWN STOIXEIWN TOU PINAKA
            for(int j=0;j<25;j++){
                System.out.print("*  "+array[i][j]+" ");  
            }
            //EKTYPWSH * GIA THN EPISYMANSH TOU DEXIOU TELOUS TOU PINAKA 
            System.out.println("**");
            //EKTYPWSH * SAN GRAMMH POU KANEI SAN PLEGMA
            for(int k=0;k<134;k++){
                 System.out.print("*");
            }
            System.out.println();
        }
        //EKTYPWSH * GIA NA FAINETAI SAN DIPLH GRAMMH GIA TO TELOS TOU PINAKA
        for(int k=0;k<134;k++){
            System.out.print("*");
        }
    }
   
}
