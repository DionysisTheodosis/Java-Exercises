/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author dionysis
 */
public class StatsJpanel extends JPanel {
    private final JLabel labelGoalT;
    private final JLabel labelToTScoreT;
    private final JLabel labelWordScoreT;
    private final JLabel labelFndWordsT;
   // private final JLabel labelResultT;
    private final JLabel labelGoalF;
    private final JLabel labelToTScoreF;
    private final JLabel labelWordScoreF;
    private final JLabel labelFndWordsF;
   // private final JLabel labelResultF;
    private final JPanel panel,ht;
    
    
    public StatsJpanel(){
       setLayout(new BorderLayout());
       ht = new JPanel();
       ht.setLayout(new BorderLayout());
       int a=200,b=50,c=24,d=2;
       String r = "Φάρσα";
       
       labelGoalT = new JLabel("Στόχος:",JLabel.LEFT);
       
       labelToTScoreT  = new JLabel("Συνολική Βαθμολογία:",JLabel.LEFT);
       
       labelWordScoreT = new JLabel("Βαθμολογία Λέξης:",JLabel.LEFT);
       labelFndWordsT = new JLabel("Λέξεις Που Βρέθηκαν:",JLabel.LEFT);
       //labelResultT = new JLabel("Συγχαρητήρια Βρήκες Την Λέξη: ",JLabel.LEADING);
       
       labelGoalF = new JLabel(String.valueOf(a),JLabel.CENTER);
       labelToTScoreF = new JLabel(String.valueOf(b),JLabel.CENTER);
       labelWordScoreF = new JLabel(String.valueOf(c),JLabel.CENTER);
       labelFndWordsF = new JLabel(String.valueOf(d),JLabel.CENTER);
       //labelResultF = new JLabel(r,JLabel.TRAILING);
    
      
       panel = new JPanel();
       panel.setLayout(new GridLayout(4,1,60,5));
       panel.add(labelGoalT);
       panel.add(labelGoalF);
       panel.add(labelToTScoreT);
       panel.add(labelToTScoreF);
       panel.add(labelWordScoreT);
       panel.add(labelWordScoreF);
       panel.add(labelFndWordsT);
       panel.add(labelFndWordsF);
       //panel.add(labelResultT);      
       //panel.add(labelResultF);
      panel.setPreferredSize(new Dimension(400,200));
      ht.add(panel,BorderLayout.SOUTH);
       //setBackground(Color.gray);
       add(ht);
        
        
        
        
    }
}
