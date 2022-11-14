//KLASH GAME H OPOIA ORIZEI TIS METHODOUS KATHWS KAI TIS METAVLITES POU THA XREIASTOUME GIA THN DHMIOURGEIA TOU PROGRAMMATOS
package exercise2;
//EISAGWGH OLWN TWN STOIXEIWN THS VIVLIOTHIKHS WSTE NA MHN EISAGOUME ENA ENA AUTA POU THA XREIASTOUME
import java.util.*;

public class Game {
   //METAVLITES KLASHS
    private double average;//METAVLITI POU THA KRATAEI TON MESO ORO
    private ArrayList<Team> listOfTeams;//METAVLITI ARRAYLIST H OPOIA THA KRATAEI OLES TIS OMADES POU SIMETASXOUN
    private ArrayList<Team> qualifiedTeamsList;//METAVLITI ARRAYLIST H OPOIA THA KRATAEI TIS OMADES POU EXOUN PROKRITHEI
    private  final Scanner input = new Scanner(System.in);; //METAVLITI SCANNER GIA THN EISAGEGH STOIXEIWN APO TO PLHKTROLOGIO 
    
   
   //METHODOI KLASHS
    
    //METHODOS GIA THN EISAGWGH TWN OMADWN 
    public void insertTeamData(){
        //DIMIOURGEIA ANTIKEIMENOU ARRAYLIST KAI EISAGWGH TOU STO listOfTeams
        listOfTeams= new ArrayList<>(); 
        int totalNumberOfTeams=50;
        //EPANALIPSI MEXRI NA PERASTOUN KAI OI 50 OMADES
        while(totalNumberOfTeams>0){
            //EISAGWGH APO TO PLHKTROLOGIO TOU ONOMATOS THS OMADAS
            System.out.println("Insert Team's Name");
            String name = input.nextLine();
            //EISAGWGH APO TO PLHKTROLOGIO THS XWRAS THS OMADAS
            System.out.println("Insert The Country Name Of The Team");
            String country= input.nextLine();
            //EISAGWGH TWN PONTWN APO TO PLHKTROLOGIO KAI ELEGXOS GIA TO AN PLHRH THN SYNTHIKI
            int points; 
            do{
                System.out.println("Insert Team's Points");
                points = input.nextInt();
            }
            while(points==0 || points>100);
            input.nextLine();//TO XRHSIMOPOIW GIA NA APOROFISEI TON XARAKTHRA ALLAGHS GRAMMHS
            //EISAGWGH TWN STOIXEIWN WS TEAM STHN LISTA
            listOfTeams.add(new Team(name,country,points));
            //MEIWNOUME TO COUNTER GIA THN WHILE
            totalNumberOfTeams--;
        }
    }
    //METHODOS GIA THN EUVRESH TOU MESOU OROU KAI EKTUPWSH TOU
    public void averagePoints(){
        average=0.0;//METAVLITI GIA NA KRATAEI TON MESO ORO KAI ARXIKOPOIHSH THS ME 0
        //EPANALIPSI GIA THN PROSPELASH OLWN TWN STOIXEIWN THS LISTAS
        for(Team i: listOfTeams){
            average +=i.getPoints();//PROSTHIKI OLWN TWN PONTWN STHN METAVLITI
        }
        average/=listOfTeams.size();//YPOLOGISMOS TOU MESOU OROU K EKXWRISI STHN METAVLITI
        System.out.printf("The Average Points Of Teams Is: %5.2f\n",average);//EKTYPWSH
  
    }
    
    //METHODOS GIA THN EVRESH THS OMADAS POU OI PONTOI THS EINAI PIO KONTA STO MESO ORO
    public void teamNearAverage(){
        //DILWSH METAVLITIS POU THA KRATAEI THN DIAFORA TWN PONTWN THS OMADAS APO TON MESO ORO 
        double nearest; 
        nearest = Math.abs(average-listOfTeams.get(0).getPoints()); //XRHSIMOPOIOUME THN Math.abs GIA NA PAROUME THN APOLUTH TIMI KAI ARXIKOPOIUME ME TO PRWTO STOIXEIO THS LISTAS
        int nearestIndex=0; //METAVLITI POU THA DIXNEI STO STOIXEIO THS LISTAS POU VRYKE
        //PROSPELASH OLHS THS LISTAS
        for(int i=1;i<listOfTeams.size();i++){
            //ELEGXOS GIA NA DEI AN KAPOIO STOIXEIO EINAI POIO KONTA K TOTE TO EKXWREI STHN METAVLITI
            if(nearest>Math.abs(average-listOfTeams.get(i).getPoints())){
                nearest = Math.abs(average-listOfTeams.get(i).getPoints());
                nearestIndex = i;
            }
            
        }
        //EKTYPWSH 
        System.out.println("The Team Closest To Average Is: "+listOfTeams.get(nearestIndex).getName());
       
    }
    
    //METHODOS GIA TON YPOLOGISMO TWN PROKRINOMENWN OMADWN KAI APOTHYKEUSH TOUS SE MIA ARRAYLIST
    public void qualifiedTeams(){
         qualifiedTeamsList =new ArrayList<>();
         //PROSPELASH THS LISTAS TWN OMADWN
         for(Team k : listOfTeams){
           if(k.getPoints()>(average*0.8)){//ELEGXOS GIA TO AN OI PONTOITHS OMADAS EINAI MEGALHTERH APO TA 4/5 TOU MESOU OROU
               qualifiedTeamsList.add(k); //EISAGWGH THS OMADAS STHN LISTA
            }
        }
    }
      //METHODOS GIA THN EMFANISH TOY PLITHOUS TWN OMADWN POU PROKRITHIKAN
    public void numberOfQualifiedTeams(){
        System.out.println("The Total Number Of Qualified Teams Is:"+qualifiedTeamsList.size());  
    }
    
    //METHODOS GIA THN EKTYPWSH TWN XWRWN TWN OMADWN POU EXOUN PROKRITHEI XWRIS DIPLOTYPA
    public void displayQualifiedCountries(){
        //METAVLITI POU THA KRATAEI THN EISAGWGH TOU XRHSTH APO TO PLHKTROLOGIO GIA TO AN THELEI NA EXEI FTHINOUSA H AUXOUSA TAXINOMHSH
        String choice="";
        
        //EISAGWGH EPILOGHS K ELEGXOS EGKYROTHTAS
        System.out.println("To Preview The Qualified Countries On Ascending  Press A, Or Press D For Descending Order");
        do{
            choice = input.nextLine();
        }
        while(!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("D"));
        System.out.print("The Qualified Countries ");
        
        //XRHSIMOPOIOUNME THN COLLECTION TREESET GIA NA APOTHYKEUSOUME TIS XWRES TWN OMADWN ETSI WSTE NA PAROUME KATHE XWRA MIA FORA KAI TAUTOXRONA TAXINOMHMENA KATA AUXOUSA
        TreeSet<String>  countries= new TreeSet<>();
        for(int i=0;i<qualifiedTeamsList.size();i++){
            countries.add(qualifiedTeamsList.get(i).getCountry());
        }
        //ELEGGXOS GIA TO PIA TAXINOMHSH DIALEXE O XRHSTHS 
        
        if(choice.equalsIgnoreCase("A")){//AN DIALEXE THN AUXOUSA TOTE APLA EKTYPWSH
           System.out.println("On Ascending Order Are: ");
           for(String s :countries){
            System.out.println(s);
           }
        }
        else{//AN EINAI FTHINOUSA TOTE XRISIMOPOIOUME ENAN ANTISTROFO ITERATOR GIA THN EKTYPWSH
           System.out.println("On Descending Order Are: ");
           Iterator c = countries.descendingIterator();// DILWSH KAI ARXIKOPOIHSH TOU ITERATOR
           while(c.hasNext()){ //PROSPELASH OLHS THS LISTA
                System.out.println(c.next());
           }
        }
    }
    //METHODOS GIA THN EKTYPWSH TWN OMADWN POU PROKRITHIKAN
    public void displayQualifiedTeams(){
        //EKTYPWSH MENU KAI FORMARISMATOS TOU KATALLHLA
        System.out.println("\t\tThe Qualified Teams Are:");
        System.out.println();
        System.out.printf("%s\t\t%s\t\t%s\n","Name","Points","Country");
        for(int i = 0; i<39; i++){//GIA NA FENETAI SAN PINAKAS
            System.out.print("-");
        }
        System.out.println();
        //PROSPELASH OLWN TWN OMADWN THS LISTAS TWN PROHGHMENWN
        for(Team i : qualifiedTeamsList){
            System.out.printf("%s\t\t",i.getName()); //EKTYPWSH ONOMATOS
            System.out.printf("%s\t\t",i.getPoints());//EKTYPWSH PONTWN
            System.out.printf("%s",i.getCountry()); //EKTYPWSH XWRAS
            System.out.println(); //ALLAGH GRAMMHS 
            
        }
    }
  
    //METHODOS display GIA THN EMFANISEI OLWN TWN OMADWN AN KAI DEN THA THN XRHSIMOPOIHSOUME KALO EINAI NA YPARXEI
    public void display(){
        //EKTYPWSH MENU KAI FORMARISMATOS TOU KATALLHLA
        System.out.println("\t\tTeams:");
        System.out.println();
        System.out.printf("%s\t\t%s\t\t%s\n","Name","Points","Country");
        for(int i = 0; i<39; i++){
            System.out.print("-");
        }
        System.out.println();
        //PROSPELASH OLWN TWN OMADWN THS LISTAS listOfTeams
        for(Team i : listOfTeams){
            System.out.printf("%s\t\t",i.getName());//EKTYPWSH ONOMATOS
            System.out.printf("%s\t\t",i.getPoints());//EKTYPWSH PONTWN
            System.out.printf("%s",i.getCountry());//EKTYPWSH XWRAS
            System.out.println();//ALLAGH GRAMMHS 
            
        }
    }
}
