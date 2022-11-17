//DIONYSIOS THEODOSIS A.M 321/2015066
package exercise3;
//KLASH H OPOIA PERIEXEI THN MAIN
public class Exercise3 {

   
    public static void main(String[] args) {
        //DIMIOURGEIA ANTIKEIMWNOU THS KLASH StrManipulation 
        StrManipulation ob = new StrManipulation();
        
        //KALESMA THS METHODOU GIA THN EKXWRISH THS SUMVOLOSEIRAS K APOTHIKEUSH GIA KATHE XARAKTHRA TIS THESEIS POU EMFANIZETE
        ob.indexesByCharacter();
        System.out.println();//ALLAGH GRAMMHS
        
        //KALESMA THS METHODOU POU DIMIOURGEI TO ALFARITHMITIKO KAI EMFANISI TOU
        ob.buildString();
        System.out.println();//ALLAGH GRAMMHS
        
        //KALESMA THS METHODOU GIA NA YPOLOGISH TOUS XARAKTHRES ME THN MEGALUTERH K MIKROTERH SYXNOTHTA EMFANISIS
        ob.characterFrequency();
    }
    
}
