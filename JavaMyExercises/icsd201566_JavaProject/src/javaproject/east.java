/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;
//KLASH GIA TO DEXI MEROS TOU FRAME STO PANEL TOU PAIXNIDIOU
import java.awt.GridLayout;
import javax.swing.*;

public class east extends JPanel {
    //METAVLITES 
    private final PlayerHelp help;//GIA TO PANEL TWN VOITHEIWN
    private  StatsJpanel stats; // GIA TO PANEL TWN ENHMERWSEWN TWN PONTWN
    private MyFrame mainFrame; //GIA TO MAIN FRAME
    
    //CONSTRUCTOR THS KLASHS POU PERNEI TO MAIN FRAME
    public east(MyFrame mainFrame){
       this.mainFrame=mainFrame;
       
       this.setLayout(new GridLayout(2,1,-600,-200));//DINEI THN DIATAXH ME MORFH PINAKA 
       help = new PlayerHelp(mainFrame); //DIMIOURGEIA TOU PLAYERHELP
       stats= new  StatsJpanel(mainFrame);//DIMIOURGEIA TWN STATISTIKWN
       //TA PROSTHETEI STO PANE;
       add(help);
       add(stats);
       setVisible(true);
    }
    //METHODOS GIA THN ANANEWSH TWN STATISTIKWN
    public StatsJpanel upDateStats(){
        return stats;
    }
    //METHODOS GIA THN EPANARXIKOPOIHSH 
    public void setStats(){
        stats= new  StatsJpanel(mainFrame) ;
        add(stats);
        setVisible(true);
    }
    
}
