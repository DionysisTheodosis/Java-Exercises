package exercise4;

import java.util.*;

//KLASH H OPOIA YLOPOIEI TO PAIXNIDI
public  class  PlayGame {
    //METAVLITES THS KLASHS
    private static  ArrayList<Word> PoolWords; //DILWSH ARRAYLIST POU THA PERIEXEI TO SYNOLO TWN LEXEWN KAI static GIA NA EXOUN OLA TA ANTIKEIMENA THN IDIA 
    private   WordSearch obWordSearch; //DILWSH ANTIKEIMENOU TUPOU WordSearch
    private final  Scanner input = new Scanner(System.in); //DILWSH KAI DHMIOURGIA ANTIKEIMENOU GIA EISAGWGH APO TO PLHKTROLOGIO
    private static final Random randomNumber = new Random(); //DILWSH GIA THN DHMIOURGEIA ANTIKEIMENOU GIA THN XRHSH TYXAIWN ARITHMWN
    private boolean playFirstTime;  //DILWSH METAVLITHS POU THA VLEPEI AN EINAI H PRWTH FORA POU DINEI O XRHSTHS EPILOGH
    private int wordsNumber;  //METAVLITI H OPOIA THA KRATAEI TO PLITHOS TWN LEXEWN POU EXEI DWSEI O XRHSTHS 
    private TreeSet <String> foundWords;  //DOMH H OPOIA THA KRATAEI TIS LEXEIS POU EXEI VREI O XRHSTHS XWRIS DIPLOTYPA
    
    //CONSTRUCTOR THS KLASHS
    public PlayGame(){
        ReadWords(); //KALEI THN METHODO ReadWords GIA THN ARXIKOPOIHSH THS PoolWords
        numberOfWords(); //KALEI THN METHODO numberOfWords GIA THN ARXIKOPOIHSH TWN wordsNumber DILADH THN EISAGWGH TOU ARITHMOU TWN LEXEWN PROS EURESH
        playFirstTime=true; //ARXIKOPOIEI THN METAVLITI POU THA THN XRHSIMOPOIHSOUME WS FLAG SE TRUE
        
        
    }
    
    //METHODOI KLASHS
    
    //METHODOS GIA THN DHMIOURGEIA KAI ARXIKOPOIHSH THS ARRAYLIST POU THA KRATAEI TO SYNOLO TWN LEXEWN APO TIS OPOIES THA EPILEGOUME NA VALOUME STON PINAKA KAI ORISMOS WS STATIC GIA NA THN EXOUN OLA TA ANTIKEIMENA
    private  static  void ReadWords(){
        //DIMIOURGEIA THS PoolWords
        PoolWords = new ArrayList<>();
        //DILWSH METAVLITWN WSTE NA EINAI PIO EUKOLH H ANAGNWSH TOU KWDIKA
        final int ARRAYROWS = 25;
        final int ARRAYLINES = 15;
        final int LINE = 0;
        final int ROW = 1;
        //DILWSH METAVLITWN GIA THN EISAGWSH ME VASH TA STOIXEIA THS WORD KLASHS
        int firstCharIndex; //KELI TOU PRWTOU XARAKTHRA POU THA EXEI H LEXH STON PINAKA 
        int type; //TYPOS ANALOGOS AN APOTHYKEUTH ANA STHLH H GRAMMH 
        int possitionType; //O ARITHMOS THS STHLHS H GRAMMHS POU THA VRISKETE H LEXH
        //DILWSH METAVLITHS WS COUNTER GIA NA VLEPEI SE POIA LEXH VRISKETE
        int numberOfWords=0;    
        //DHMIOURGEIA STRING KAI ARXIKOPOIHSH TOU ME TIS LEXEIS POU THELOUME NA EXOUME 
        String[] wordString = {"toyota","honda","chevrolet","ford","mercedes",
            "jeep","bmw","porche","subaru","nissan","cadillac","volkswagen",
            "lexus","audi","ferrari","volvo","jaguar","gmc","buick","acura",
            "bentley","dodge","hyundai","lincoln","mazda","seat","tesla",
            "ram","kia","chrysler","pontiac","infinity","mitsubishi","oldsmobile",
            "maserati","opel","fiat","bugatti","mini","alfaromeo","saab",
            "genesis","suzuki","studebaker","renault","peugeot","daewoo","hudson",
            "cintroen","mg"};
       
        //EPANALIPDI GIA THN EISAGWGH TWN LEXEWN STHN PoolWords 
        while(numberOfWords<wordString.length){
            type = randomNumber.nextInt(2); //EISAGEI TYXAIA TIMH 0 H 1 
            if(type==LINE){ //AN EINAI SE GRAMMH 
                possitionType = randomNumber.nextInt(ARRAYLINES); //DINEI MIA TYXAIA TIMH STO RANGE TWN GRAMMWN TOU PINAKA
                firstCharIndex = randomNumber.nextInt(ARRAYROWS-wordString[numberOfWords].length()); //DINEI MIA TYXAIA TIMH ANALOGOS STO RANGE TWN STHLWN TOU PINAKA KAI EFOSWN XWRAEI DINEI THN SWSTH THESH GIA TON 1O XARAKTHRA
                PoolWords.add(new Word(wordString[numberOfWords],type,possitionType,firstCharIndex)); //PROSTHIKH TWRA WS TYPOU Word STHN PoolWords
            }
            else if(type==ROW){ //AN EINAI SE STHLH
                possitionType = randomNumber.nextInt(ARRAYROWS);//DINEI MIA TYXAIA TIMH STO RANGE TWN STHLWN TOU PINAKA
                firstCharIndex = randomNumber.nextInt(ARRAYLINES-wordString[numberOfWords].length());//DINEI MIA TYXAIA TIMH ANALOGOS STO RANGE TWN GRAMWN TOU PINAKA KAI EFOSWN XWRAEI DINEI THN SWSTH THESH GIA TON 1O XARAKTHRA
                PoolWords.add(new Word(wordString[numberOfWords],type,possitionType,firstCharIndex));//PROSTHIKH TWRA WS TYPOU Word STHN PoolWords
            }
            
            numberOfWords++; //AUXANEI TON METRHTH
        }   
    }
    
    //METHODOS GIA THN EISAGWGH TOU PLITHOUS TWN LEXEWN PROS EUVRESH KAI EISAGWGH TYXAIWN LEXEWN ANALOGOS APO TO PLITHOS TOU XRHSTH
    private  void numberOfWords(){
        //DIMIOURGEIA TOU ANTIKEIMENOU GIA THN WordSearch 
        obWordSearch = new WordSearch();
        
        //EKXWRISH TOU PLITHOUS APO TON XRHSTH KAI KATALHLOI ELEXEGXOI GIA THN EGYROTHTA TWN STOIXEIWN
        System.out.print("Dwse Ton Plithos Twn Lexwn Pou Thes Na Anazitiseis(1-12):");
        boolean ExceptionFlag; //FLAG gia na vgainei apo to exception pou tha xrhsimopoihsoume an o xrhsths dwsei kapoion allon xarakthra ektos psifiou
        String c; //METAVLITI POU THA KRATAEI THN EPILOGH TOU XRHSTH WS STRING GIA NA GINEI O ELEGXOS KAI NA MHN VGALEI SFALMA
        do{
            ExceptionFlag=false; //KANOUME TO FLAG OS FALSE
            c = input.nextLine(); //DIAVASMA TOU PLITHOUS
            try{//PROSPATHEI NA TO METATREPSEI APO STRING SE INT
                wordsNumber = Integer.parseInt(c);
            }
            catch(NumberFormatException e){//AN DEN EINAI TOTE KANEI TO FLAG TRUE
                 ExceptionFlag=true;
            }
            if((wordsNumber>12 || wordsNumber==0)){//ELEGXOS GIA TO AN AUTO POU EXEI DWSEI O XRHSTHS DEN EINAI STO EUROS APO 1-12
                System.out.println("Dwse Enan Arithmo Sto Euros (1-12):");
            }
        }
        while((wordsNumber>12 || wordsNumber==0) || ExceptionFlag); //EPANALIPSI OSO PAREI ENA PSIFIO APO 1-12
        
        //EPILOGH TYXAIWN LEXEWN APO THN PoolWords STON PINAKA TOU KRYPTOLEXOU
        int count = wordsNumber; //METAVLITI POU THA EINAI SAN DEIKTIS GIA NA METRAEI TIS LEXEIS POU EXOUN EISAXTHEI
        int i; //METAVLITI DEIKTI POU THA DIXNEI THN THESH MIA LEXHS
        TreeSet<Integer> randomWords= new TreeSet<>(); //DOMH POU THA APOTHYKEUEI THN THESH THS LEXHS POU EISAGOUME ETSI WSTE NA MPOROUME NA MHN VALOUME 2 FORES THN IDIA LEXH
        //EPANALIPSI MEXRI NA GINEI EISAGWGH LEXEWN ISWN ME TO PLITHOS POU EDWSE O XRHSTHS
        while(count>0){ 
            i = randomNumber.nextInt(PoolWords.size());//EPISTREFEI ENAN ARITHMO STO EUROS TWN LEXEWN THS PoolWords
            if(!randomWords.contains(i)){ //AN DEN EXEI EISAXTHEI H LEXH POU YPARXEI STHN THESH i
                if(obWordSearch.addWord(PoolWords.get(i))==0){ //ELEGXOS AN EGINE H EISAGWGH THS LEXHS KAI TOTE MEIWNEI TON COUNTER KAI EISAGEI THN THESH STHN randomWords
                    System.out.println(PoolWords.get(i).getWord());
                    count--;
                    randomWords.add(i);
                }
               
            }
        }
        //KALEI THN METHODO THS WordSearch GIA NA GEMISEI OLEW THS ALLES LEXEIS ME TUXAIA GRAMMATA
        obWordSearch.fillBlanks();
    }
    
    //METHODOS H OPOIA YLOPOIH TO PAIXNIDI DILADI PWS O XRHSTHS KATHE FORA THA EPILEGEI THN LEXH PROS EVRESH
    public  void Play(){
        //DIMIOURGEIA DOMHS POU THA KRATAEI TIS LEXEIS POU EXEI VREI 
        foundWords = new TreeSet<>();
        System.out.println();
        //EKTYPWSH TOY KATALHLOY MINYMATOS GIA THN ENHMERWSH TOY XRHSTH GIA TO PAIXNIDI
        System.out.println("Vres Poies "+wordsNumber+" Lexeis "+" Apo Tis "+PoolWords.size()+" Ths Listas Yparxoun Ston Pinaka");
        System.out.println();
        String choice; //METAVLITI POU THA KRATAEI THN EPILOGH TOU XRHSTH AN THELEI NA SYNEXISEI STHN EUVRESH TWN LEXEWN H OXI
        int numberOfWords = wordsNumber; //METAVLITI POU THA KRATAEI POSES LEXEIS EXEI MINI GIA NA VREI SAN DIKTEIS
        //EPANALIPSI MEXRI NA VREI TIS LEXEIS H NA STAMATHSEI O XRHSTHS TO PAIXNIDI GIA TIS SYGKEKRIMENES LEXEIS
        do{
            displayPool();//EMFANISH THS LISTAS TWN LEXEWN
            System.out.println();//ALLAGH GRAMMHS
            obWordSearch.display();//EMFANISH TOU PINAKA TOU KRYPTOLEXOU
            System.out.println();//ALLAGH GRAMMHS
            
            //KWDIKAS GIA THN EMFANISH KATW DEXIA TO PLITHOS TWN LEXEWN POU EXEI VREI STO SYNOLIKO KAI KATW ARISTERA TIS LEXEIS POU EXEI VREI
            if(!playFirstTime){     //AN DEN EINAI H PRWTH FORA POU PAIZEI
                System.out.printf("%-127s(%d/%d)\n","",foundWords.size(),wordsNumber);   //EMFANIZEI TO POSES EXEI VREI
                if(foundWords.isEmpty()){   //AN DEN EXEI VREI TOTE
                    System.out.print("[ - ]");
                }
                else{   //AN EXEI VREI EKTYPWNEI TIS LEXEIS
                    System.out.println(foundWords.toString());
                }
                
            }
            System.out.println();   //ALLAGH GRAMMHS
            
            String wordTSearch; //DILWSH METAVLITHS POU THA KRATAEI THN LEXH POU EDWSE O XRHSTHS
            boolean rightInput = true;  //DILWSH METAVLHTHS WS FLAG GIA NA ELEGXEI AN EXEI DWSEI SWSTH LEXH O XRHSTHS
            String search=""; //H LEXH POU EPISTREFETAI APO THN ANAZHTHSH
            //EKTYPWSH MHNIMATOS GIA THN ENHMERWSH TOU XRHSTH
            System.out.print("Dwse Mia Lexh Apo Thn Lista Twn Lexewn: ");
            
            //ELEGXOS GIA TO AN EXEI VREI THN SYGKEKRIMENH LEXH TOTE ZHTAEI NA GRAPSEI NEA
            do{
                wordTSearch = input.nextLine();
                if(foundWords.contains(wordTSearch)){
                    System.out.print("Thn Exeis Hdh Vrei Dwse Allh:");   
                }
                else{
                    break;
                }
            }
            while(true);
            
            //ELEGXOS GIA TO AN H LEXH POU EDWSE O XRHSTHS YPARXEI STHN LISTA TWN LEXEWN POU YPARXOUN PROS ANAZITISO
            do{
                if(rightInput!=true){ //OSO DEN EINAI SWSTH EPILOGH TOTE ZHTAEI NA DWSH THN SWSTH
               
                    System.out.print("Parakalw Dwse Mia Lexh Apo Thn Lista Lexewn:");
               
                    wordTSearch = input.nextLine();
                
                }
                rightInput = false; 
                for(Word i : PoolWords){ // PSAXNEI STHN PoolWords THN LEXH POU EDWSE O XRHSTHS
                    if(i.getWord().equals(wordTSearch)){ //AN VREI THN LEXH STHN PoolWords
                        rightInput = true;
                        search =obWordSearch.search(i); //TOTE PERNAEI THN SYGKEKRIMENH LEXH APO THN PoolWords WS ORISMA GIA ANAZHTHSH STHN obWordSearch.search() KAI APOTHYKEYH THN THESH POU VRETHIKE STHN SEARCH H KENO AN OXI
                        break;
                    }  
                }
            }
            while(!rightInput);
            
            //ELEGXOS GIA TO AN VRETHIKE H OXI KAI EKTYPWSH KATALHLOU MYNHMATOS
            if(search.equals("")){ //AN EINAI KENO
                System.out.println("Den Vrethike");
            }
            else{ //AN OXI DILADI VRETHIKE
                System.out.println("Vrethike Sthn Thesh: "+search); //EKTYPWSH TOU MHNYMATOS KAI THS THESH
                numberOfWords--; //MEIWSH TOU COUNTER POU DIATHREI POSES LEXEIS APOMENOUN MEXRI NA TIS VREI OLES
                foundWords.add(wordTSearch);  //EISAGWGH THS LEXHS STHN foundWords
            }
            
            System.out.println();//ALLAGH GRAMMHS
            displayFoundWords(); // KALESMA THS METHODOU GIA THN EKTYPWSH TWN LEXEWN POU EXEI VREI
            
            //ELEGXEI AN TO numberOfWords=0 DHLADH EXEI VREI OLES TIS LEXEIS KAI EKTYPWSH KATALHLOU MYNHMATOS
            if(numberOfWords==0){
                System.out.println("Sygxarithria Vrykes Oles Tis Lexeis");
                break; //VGAINEI APO THN EPANALIPSI
            }
            
            //KWDIKAS GIA THN ERWTHSH TOU XRHSTH AN THELH NA SYNEXISEI H OXI
            System.out.println("An Theleis Na Stamathseis Pata To 0 Allios Otidipote Allo ");
            choice = input.nextLine(); //ENW ZHTAME PSIFIO XRHSIMOPOIOUME STRING GIA THN APOFYGH SFALMATWN
            System.out.println();
            // EKXWRISH FALSE GIA NA DIXEI OTI H EPOOMENH EISODOS DEN THA EINAI PRWTH FORA
            playFirstTime=false; 
        }
        while(!choice.equals("0"));//OSO DEN EXEI DWSEI THN EPILOGH 0 POU SHMENEI TON TERMATISMO
    }
    
    //METHODOS H OPOIA EKTYPWNEI TIS LEXEIS POU EXEI VREI O XRHSTHS KAI PRIVATE GIATI DEN THELOUME NA THN KALESOUME STHN MAIN
    private void displayFoundWords(){
        System.out.print("Oi Lexeis Pou Exeis Vrei Einai: ");
        if(foundWords.isEmpty()){ //SYNTHIKI GIA TO AN DEN EXEI VREI AKOMA LEXH
            System.out.print("[ - ]");
        }
        else{//ALLIWS AN VRYKE TO EKTYPWNEI ME THN VOITHEIA THS toString KAI EXEI HDH TO format SAN PINAKAS
            System.out.print(foundWords.toString());
        }
        System.out.println(" "+"("+foundWords.size()+"/"+wordsNumber+")");//EKTYPWSH ME MIA MORFOPOIHSH TOU PLITHOUS TWN LEXEWN POU EXEI VREI STIS SYNOLIKES
    }
    
    //METHODOS H OPOIA THA EKTYPWNEI TIS LEXEIS POU EINAI DIATHESIMES PROS EVRESH THS PoolWords
    private static void displayPool(){
        //EKTYPWSH KOIMENOU SAN TITLO KAI SWSTH TOPOTHETISI GIA NA EINAI SE ARMONIA ME THN EKTYPWSH TOU PINAKA
        System.out.printf("%81s\n","Lista Lexewn Pou Periexonte");
        //EKTYPWSH * SAN YPOGRAMMISH TOU PARAPANOU TITLOU
        System.out.printf("%54s","*");  
        for(int i=0;i<28;i++){
             System.out.print("*");
        }
        System.out.println();//ALLAGH GRAMMHS
        //EKTYPWSH ME SWSTH STIXISH TWN LEXEWN POU YPARXOUN STO PoolWords
        System.out.printf("%27s","* ");
        int count = 0; //METAVLITI POU THA APOTHYKEUEI TO SYNOLO TWN XARAKTHRWN TWN LEXEWN WSTE NA GINEI SWSTH STOIXISEI
        for(Word a: PoolWords){
            count += a.getWord().length(); //AUXISEI TOU COUNTER
            if(count>50 ){ //SYNTHIKI POU VLEPEI AN EXEI XEPERASEI TOUS 50 XARAKTHRES TOTE EKTYPWNEI SE NEA GRAMMH
                System.out.printf("\n%27s","* ");
                count=0; //ORIZEI PALY TO COUNTER =0
            }
            System.out.print(a.getWord()+" * "); //EKTYPWNEI THN LEXH
           
                   
        }
        System.out.println();//EKTYPWSH ALLAGHS GRAMMHS
    }
}