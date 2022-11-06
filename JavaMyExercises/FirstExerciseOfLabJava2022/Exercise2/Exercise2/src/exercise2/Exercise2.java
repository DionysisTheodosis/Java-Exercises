
package exercise2;

import javax.swing.JOptionPane;

public class Exercise2 {

    public static void main(String[] args) {
       Game game = new Game();
       game.insertTeamData();
       System.out.println();
       game.dortD();
       //game.displayCountryNameAcSorted();
       System.out.println();
       //game.displayCountryNameDcSorted();
       System.out.println();
       game.averagePoints();
       System.out.println();
       game.teamNearAverage();
       System.out.println();
       game.numberOfQualifiedTeams();
       System.out.println();
       game.displayQualifiedTeams();
       System.out.println();
    }
    
}
