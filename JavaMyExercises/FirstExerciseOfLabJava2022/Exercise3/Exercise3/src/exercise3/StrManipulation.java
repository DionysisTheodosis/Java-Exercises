package exercise3;
import java.util.*;
/*KLASH H OPOIA PAREXEI METHODOUS GIA THN DIAXEIRISI ENOS ALFARITHMITIKOU,
  THN EISAGWGH TOU,THN EPEXERGASIA TOU KATHE XARAKTHRA KAI EPANADIAMORFWSH TOU STRING,
  KAI EVRESH TWN ELAXISTWN KAI MEGISTWN EMFANISEWN TWN XARAKTHRWN STO STRING
*/

public class StrManipulation {
    private static Scanner input; //DILWSH METAVLITIS SCANNER GIA THN EISAGWGH APO TO PLHKTROLOGIO
    private final HashMap<Character,HashSet> charMap; //DILWSH METAVLITIS HASHMAP GIA THN APOTHUKEUSH THS KATHE TIMHS THS THESHS TOU XARAKTHRA STON XARAKTHRA
    
    //CONSTRUCTOR GIA THN ARXIKOPOIHSH TWN METAVLITWN
    public StrManipulation(){
        input = new Scanner(System.in);
        charMap = new HashMap<>();
    }
    
    //METHODOS POU DIAVAZEI ENA STRING KAI APOTHYKEUH SE HASHMAP ANA XARAKTHRA WS KEY KAI GIA KATHE XARAKTHRA WS VALUE THS THESEIS POU EMFANIZETAI
    public void indexesByCharacter(){
        //EISAGWGH STRING
        System.out.print("Ekxwrise Mia Symvoloseira: ");
        String inputString = input.nextLine(); 
        
        //DHMIOURGEIA TREESET GIA THN APOTHYKEUSH TWN XARAKTHRWN XWRIS DIPLOTYPA
        TreeSet<Character> charactersOfStr = new TreeSet<>();
        
        //DIMIOURGEIA HASHET GIA THN APOTHUKEUSH TWN THESEWN
        HashSet<Integer> values;
        
        //EPANALIPSI KAI APOTHUKEUSH KATHE XARAKTHRA TOY STRING
        for(int i=0;i<inputString.length();i++){
           if(!Character.isSpaceChar(inputString.charAt(i))){//SYNTHIKI H OPOIA AN VREI KENO TOTE DEN TO APOTHYKEUH STHN DOMH
               charactersOfStr.add(inputString.charAt(i));
            }
        }
        //PROSPELASH THS STRING KAI APOTHYKEUSH SE HASHMAP ANA XARAKTHRA POU THA VRISKEI THS THESEIS TOU XARAKTHRA
        
        for(Character s : charactersOfStr){//PROSPELASH ANA XARAKTHRA
            //DOMH H OPOIA THA KRATAEI TA KLEIDIA KATHE XARAKTHRA
            values = new HashSet<>(); 
            //PROSPELASH THS STRING 
            for(int i=0;i<inputString.length();i++){
                //AN VREI TON XARAKTHRA
                if(s.equals(inputString.charAt(i))){
                   values.add(i);//APOTHYKEUH THN TIMH TOU DEIKTI STHN DOMH TWN DEIKTWN
             
                    }
            }
            //EISAGWGH STHN DOMH TOU XARAKTHRA KAI TWN DEIKTWN TWN THESEWN POU EMFANIZETAI
            charMap.put(s,values);
       }
    }
    
    //METHODOS GIA THN DHMIOURGEI STRING APO THN DOMH POU TO EXOUME APOTHYKEUSH
    public void buildString(){
        
        char[] strArray;//DILWSH PINAKA XARAKTHRWN POU THA KRATHSEI OLOUS TOUS XARAKTHRES SE SWSTH THESI
        int max=0;//METAVLITI GIA NA VREI TO MEGETHOS GIA TON PINAKA XARAKTHRWN
        
        //PROSPELASH THS DOMHS GIA NA VROUME SE POIA APO TIS TIMES TWN KLEIDIWN EINAI TO MEGALUTERO INDEX KAI APOTHYKEUSH STO MAX
        for(Map.Entry<Character,HashSet> entry : charMap.entrySet()) {
            if(max < (int) Collections.max(entry.getValue())){
                max=(int) Collections.max(entry.getValue());
            }
        }
        
        strArray = new char[max+1]; //DHMIOURGEIA TOU PINAKA ME TO MEGALUTERO INDEX POU VRETHIKE THESH XARAKTHRA +1
        Arrays.fill(strArray, 0, max,' ');//ARXIKOPOIHSH OLOU TOU PINAKA ME TO KENO
        
        //PROSPELASH THS DOMHS POU EXOUME APOTHUKEYSH TOUS XARAKTHRES GIA THN APOTHYKEYSH TOUS STHN SWSTH THESH STON PINAKA XARAKTHRWN
        for(Map.Entry<Character,HashSet> entry : charMap.entrySet()) {
            
            //DIMIOURGEIA ITERATOR TYPU HASHET POU EXOUME APOTHYKEUSH TOUS DEIKTES TWN XARAKTHRWN GIA THN PROSPELASH TOUS
            Iterator valueIterator = entry.getValue().iterator();
            //PROSPELASH OLWN TWN DIKTWN
            while (valueIterator.hasNext()) {
                //APOTHYKEUSH STHN THESH TOU SUGKEKRIMENOU DEIKTH TON XARAKTHRA TOU ,KAI KAST SE INT WSTE NA TO PAREI
                strArray[(int) valueIterator.next()]= entry.getKey();
            }
        }
        //DHMIOURGEIA STRING ME THS TIMES TOU PINAKA XARAKTHRWN
        String str = String.valueOf(strArray,0,strArray.length);
        //EKTYPWSH TOU STRING
        System.out.println("To String einai: "+str);
            
    }
    
    
    //METHODOS GIA THN EURESH TOU(TWN) XARAXTHRA - XARAKTHRWN ME TIS ELAXISTES KAI MEGISTES EMFANISEIS
    public void characterFrequency(){
       //DILWSH HASHSET H OPOIA THA APOTHUKEUEI TOUS XARAKTHRES
       HashSet<Character> charSet;
       //DILWSH HASHMAP H OPOIA THA APOTHUKEUEI SAN KLEIDIA TO PLITHOS TWN EMFANISEWN KAI WS TIMES TOUS XARAKTHRES POU EXOUN AUTES TIS EMFANISEIS
       HashMap<Integer ,HashSet> frequentMap = new HashMap<>();
       
       //PROSPELASH THS DOMHS POU KRATAEI TOU XARAKTHRES KAI THN THESH TOUS
       for(Map.Entry<Character,HashSet> entry : charMap.entrySet()) {
            //EURESH TOU PLITHOUS TWN EMFANISEWN TOU EKASTOTE XARAKTHRA KAI APOTHUKEUSH TOU WS ITEGER GIA NA MPORW NA XRHSIMOPOIHSW TO COLLECTIONS
            Integer numberOfChar = entry.getValue().size();
            
            //ITERATOR GIA NA PROSPELASW KATHE TIMI THESHS
            Iterator valueIterator = entry.getValue().iterator();
            //EPANALIPSI GIA KATHE THESH
            while (valueIterator.hasNext()) {
                valueIterator.next();//EDW TO XRHSIMOPOIW SAN COUNTER GIA THN WHILE
                
                //AN DEN YPARXEI TO SYGKEKRIMENO PLITHOS TOTE FTIAXNEI NEO HASHET GIA THN APOTHYKEUSH TWN ALLWN XARAKTHRWN STO ENLOGO PLITHOS
                if(!frequentMap.containsKey(numberOfChar)){
                    charSet = new HashSet<> ();
                    charSet.add(entry.getKey());
                    frequentMap.put(numberOfChar,charSet); //EISAGWGH STO HASHMAP TOUS XARAKTHRES WS VALUE GIA TO PLITHOS numberOfChar:EMANISEIS DILADI
                }
                else{//ALLIWS ANATREXEI OLO TO HASMAP POU KRATAEI TIS EMFANISEIS ANA XARAKTHRES 
                    for(Map.Entry<Integer ,HashSet> entry2 : frequentMap.entrySet()){
                        
                       //AN VREI TO SWSTO PLITHOS TOTE PROSTHETEI TON XARAKTHRA O XARAKTHRAS:entry.getKey() ,O ARITHMOS EMFANISEWN:entry2.getValue()
                        if(numberOfChar == (int)entry2.getKey()){
                            entry2.getValue().add(entry.getKey());
                        }
                    }
                }     
            }   
        }
        //DILWSH KAI ARXIKOPOIHSH TOU MIN KAI TOU MAX MESW THN EVRESH TOUS ME THS METHODOUS THS COLLECTION
        int min = Collections.min(frequentMap.keySet());
        int max = Collections.max(frequentMap.keySet()); 
        
        //TWRA EPEIDH MPOREI NA EXOUN PEIRISSOTEROI APO ENA XARAKTHRA TIS IDIES ELAXISTES, MEGISTES EMFANISEIS PSAXNOUME NA TOUS VROUME GIA NA EKTYPWSOUME KATALHLA
        //PSAXNOUME STHN HASMAP ARITHMOEMFANISEWN/XARAKTHRES
        for(Map.Entry<Integer ,HashSet> entry : frequentMap.entrySet()) {
            
            //DILWSH ITERATOR GIA THN PROSPELASH OLWN TWN XARAKTHRWN
            Iterator valueIterator = entry.getValue().iterator();
            
            //SYNTHIKI GIA TO AN OI EMFANISEIS TOU XARAKTHRA EINAI ISWS ME TO MIN 
            if(entry.getKey()==min){
                
                //SYNTHIKI GIA THN EKTYPWSH KATALHLOU MINIMATOS ANALOGOS ME TO SIZE DILADI AN TO MIN EXEI ENAN XARAKTHRA, ALLIWS TO ALLO MINIMA
                if(entry.getValue().size()==1){
                    System.out.print("O Xarakthras Me Tis Ligoteres Emfaniseis Einai O :[");
                }
                else{
                    System.out.print("Oi Xarakthres Me Tis Ligoteres Emfaniseis Einai Oi :[");
                }
                
                //SYNTIKI GIA THN EKTYPWSH TWN XARAKTHRWN OSWN YPARXOYN ME EMFANISEIS = MIN
                while (valueIterator.hasNext()) {
                    System.out.print(" "+valueIterator.next()+" ");
                }
                System.out.println("]");
            }
            //SYNTHIKI GIA TO AN OI EMFANISEIS TOU XARAKTHRA EINAI ISWS ME TO MAX 
            if(entry.getKey()==max){
                
                //SYNTHIKI GIA THN EKTYPWSH KATALHLOU MINIMATOS ANALOGOS ME TO SIZE DILADI AN TO MAX EXEI ENAN XARAKTHRA, ALLIWS TO ALLO MINIMA
                if(entry.getValue().size()==1){
                    System.out.print("O Xarakthras Me Tis Perissoteres Emfaniseis Einai O :[");
                }
                else{
                    System.out.print("Oi Xarakthres Me Tis Perissoteres Emfaniseis Einai Oi :[");
                }
                //SYNTIKI GIA THN EKTYPWSH TWN XARAKTHRWN OSWN YPARXOYN ME EMFANISEIS = MAX
                while (valueIterator.hasNext()) {
                    System.out.print(" "+valueIterator.next()+" ");
                }
                System.out.println("]");
            }
        }
    }     
}
    
    

