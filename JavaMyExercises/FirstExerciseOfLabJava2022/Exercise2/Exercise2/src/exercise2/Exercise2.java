//Dionysios Theodosis A.M:321/2015066
package exercise2;
//KLASH H OPOIA PERIEXEI THN MAIN GIA NA ARXIKOPOIEI ENA ANTIKEIMENO GAME KAI NA KALEI TIS APARAITHTES METHODOUS GIA NA TREXEI TO PROGRAMMA
public class Exercise2 {

    public static void main(String[] args) {
       //DIMIOURGEIA ANTIKEIMENOU TYPOU GAME
       Game game = new Game();
       //KALESMA THS METHODOU INSERT GIA NA EKXWRISEI TA STOIXEIA TWN OMADWN
       game.insertTeamData();
       System.out.println();//ALLAGH GRAMMHS
       //KALESMA THS METHODOU averagePoints GIA NA YPOLOGISEI KAI NA EMFANISEI TO AVERAGE
       game.averagePoints();
       System.out.println();
       //KALESMA THS METHODOU teamNearAverage GIA NA YPOLOGISEI KAI NA EMFANISEI THN OMADA KONTA STON MESO ORO
       game.teamNearAverage();
       System.out.println();
       //KALESMA THS METHODOU qualifiedTeams GIA NA YPOLOGISEI TIS OMADES POU PROKRINONTAI
       game.qualifiedTeams();
       System.out.println();
       //KALESMA THS METHODOU displayQualifiedCountries GIA NA EMFANISEI TIS XWRES POU PROKRINONTAI
       game.displayQualifiedCountries();
       System.out.println();
       //KALESMA THS METHODOU numberOfQualifiedTeams GIA NA EMFANISEI TO PLITHOS TWN OMADWN POU PROKRINONTAI
       game.numberOfQualifiedTeams();
       System.out.println();
       //KALESMA THS METHODOU displayQualifiedTeams GIA NA EMFANISEI OLES TIS OMADES POU PROKRINONTAI
       game.displayQualifiedTeams();
       System.out.println();
      
    }
    
}
