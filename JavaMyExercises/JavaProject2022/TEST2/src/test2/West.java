/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author dionysis
 */
public class West extends JPanel{
    private  PinakasJPanel pinakas;
    private final SearchJP search;
    
    
    public West(ArrayList<Cell> arr,MyFrame frame){
        
       //this.setLayout(new GridLayout(2,0,-200,50));
       setLayout(new BorderLayout());
       pinakas = new PinakasJPanel(arr,frame);
       search = new SearchJP(frame);
      // setBackground(Color.gray);
       this.add(pinakas,BorderLayout.NORTH);
       this.add(search,BorderLayout.CENTER);
       
    }
    public PinakasJPanel getPinakasJPanel(){
        return pinakas;
    }
   
    void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
