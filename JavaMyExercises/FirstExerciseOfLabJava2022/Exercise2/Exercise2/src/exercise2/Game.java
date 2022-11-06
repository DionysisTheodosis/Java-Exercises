package exercise2;

import java.util.*;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Game {
    private double average;
    private ArrayList<Team> listOfTeams;
    
    public void insertTeamData(){
        listOfTeams= new ArrayList<>();
        int totalNumberOfTeams=3;
        while(totalNumberOfTeams>0){
            String name = JOptionPane.showInputDialog("Insert Team's Name");
            String country = JOptionPane.showInputDialog("Insert The Country Name Of The Team");
            int points = Integer.parseInt(JOptionPane.showInputDialog("Insert Team's Points"));
            listOfTeams.add(new Team(name,country,points));
            totalNumberOfTeams--;
        }
    }
    
    public void averagePoints(){
        average=0.0;
        for(Team i: listOfTeams){
            average +=i.getPoints();
        }
        average/=listOfTeams.size();
        System.out.printf("O Mesos Oros Olwn Twn Omadwn Einai: %5.2f\n",average);
        
        //JOptionPane.showInternalMessageDialog(null,average);
    }
    
    public void teamNearAverage(){
        double nearest;
        nearest = Math.abs(average-listOfTeams.get(0).getPoints());
        int nearestIndex=0;
        for(int i=1;i<listOfTeams.size();i++){
            if(nearest>Math.abs(average-listOfTeams.get(i).getPoints())){
                nearest = Math.abs(average-listOfTeams.get(i).getPoints());
                nearestIndex = i;
            }
            
        }
        System.out.println("H Omada Pio Konta Ston Meso Oro Einai: "+listOfTeams.get(nearestIndex).getName());
        //JOptionPane.showInternalMessageDialog(null,listOfTeams.get(nearestIndex));
    }
   
    public void displayCountryNameAcSorted(){
        
        Collections.sort(listOfTeams,new SortByCountry());
        System.out.println("Oles Oi xwres Twn Omadwn");
        for(Team i: listOfTeams){
             System.out.println(i.getCountry());
        }
    }
    public void displayCountryNameDcSorted(){
        
        Collections.sort(listOfTeams,new SortByCountry());
        Collections.reverse(listOfTeams);
        System.out.println("Oles Oi xwres Twn Omadwn");
        for(Team i: listOfTeams){
             System.out.println(i.getCountry());
        }
    }
    
    public void numberOfQualifiedTeams(){
        int sum=0;
        for(Team i : listOfTeams){
            if(i.getPoints()>(average*0.8)){
                sum++;
            }
        }
        System.out.println("To PLithos Twn Omadwn Pou Prokrithikan einai:"+sum);
       //JOptionPane.showMessageDialog(null,"To plithos Twn Omadwn: "+sum);
        
    }
    public void displayQualifiedTeams(){
        System.out.println("\t\tOi Prokrinomenes Omades Einai Oi:");
        System.out.println();
        String menu = String.format("%s\t\t%s\t\t%s","Name","Points","Country");
        System.out.println(menu);
        for(int i = 0; i<39; i++){
            System.out.print("-");
        }
        System.out.println();
        for(Team i : listOfTeams){
            if(i.getPoints()>(average*0.8)){
                System.out.printf("%s\t\t",i.getName());
                System.out.printf("%s\t\t",i.getPoints());
                System.out.printf("%s",i.getCountry());
                System.out.println();
            }
        }
    }
    public void dortD(){
       
        //TreeSet<Team> t= new TreeSet<>();
        ArrayList<String> countries = new ArrayList<>();
        for(int i=0;i<listOfTeams.size();i++){
            countries.add(listOfTeams.get(i).getCountry());
        }
        SortedSet<String> tree = new TreeSet<>(countries);
        for(String s :tree){
            System.out.println(s);
        }
     
    }
}
