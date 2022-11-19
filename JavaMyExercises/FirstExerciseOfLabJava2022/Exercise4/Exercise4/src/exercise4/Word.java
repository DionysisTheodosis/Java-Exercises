
package exercise4;

//KLASH H OPOIA APOIKWNIZEI THS METAVLITES KAI TIS METHODOUS MIAS LEXEIS
public class Word {
    //DILWSH METAVLITWN
    private final String word;       //METAVLITH POU APOTHYKEYEI THN LEXH
    private final int firstCharIndex;//METAVLITH POU APOTHYKEYEI THN THESH TOU PRWTOU XARAKTHRA POU THA PAREI STON PINAKA
    private final int type;          //METAVLITH POU APOTHYKEYEI TON TUPO GRAMH H STHLH
    private final int possitionType; //METAVLITH POU APOTHYKEYEI THN STATHERH THESH THS STHLHS H GRAMMHS
    
    //CONSTRUCTOR POU PERNEI TA ORISMATA KAI ARXIKOPOIEI ME TO KALESMA 
    public Word(String word,int type,int possitionType,int firstCharIndex){
        this.word = word;
        this.firstCharIndex = firstCharIndex;
        this.type = type ;
        this.possitionType =possitionType;
    }
    //METHODOI THS KLASHS GIA THN EPISTROFH TWN DEDOMENWN
    
    //METHODOS POU EPISTREFH TO STRING THS LEXHS 
    public String getWord(){
        return word;
    }
    //METHODOS POU EPISTREFH THN THESH TOU 1OU XARAKTHRA
    public int getFirstCharIndex(){
        return firstCharIndex;
    }
    //METHODOS POU EPISTREFEI AN EINAI GRAMMH H STHLH
    public int  getType(){
        return type;
    }
    //METHODOS POU EPISTREFEI TO STATHERO NOUMERO GIA GRAMMH H STHLH
    public int getPossitionType(){
        return possitionType;
    }
}
