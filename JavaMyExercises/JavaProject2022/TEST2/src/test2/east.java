/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;

public class east extends JPanel {
    private final PlayerHelp help;
    private final StatsJpanel stats;
    
    public east(MyFrame pane){
       this.setLayout(new GridLayout(2,1,-600,-200));
       help = new PlayerHelp(pane); 
       stats= new  StatsJpanel() ;
       //pane.setBackground(Color.gray);
       add(help);
       add(stats);
       
       setVisible(true);
         
    }
}
