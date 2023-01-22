
package javaproject;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JPanel;


public class PinakasJPanel extends JPanel {
   private  char word;
   private int number;
   private final JPanel tablePanel;
   private final CharPanel[] letterPanel;
   private final ArrayList<Cell> a;
 
   private int i;
 
   
   
   
   public PinakasJPanel(ArrayList<Cell> b,MyFrame frame){
        this.a = b;
        this.word= word;
        this.number= number;
        letterPanel = new CharPanel[a.size()];
        tablePanel = this;
        tablePanel.setLayout(new GridLayout(8,8,10,10));
        for(i=0;i<a.size();i++){
           letterPanel[i] = new CharPanel(a.get(i),frame); 
       
           tablePanel.add(letterPanel[i]);
       }
      
       tablePanel.setPreferredSize(new Dimension(1000,600));
       setMaximumSize(new Dimension(1200,600));
       tablePanel.setVisible(true);
   }
}
