
package test2;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class PinakasJPanel extends JPanel {
   private  char word;
   private int number;
   private final JPanel keliJpanel;
   private final CharPanel[] kelia;
   private final ArrayList<Cell> a;
  // private final Cell[][] arr;
   private CharPanel[] p; 
   private int count;
   private int ola;
   private int i,j;
   private static int prevChanged;
   private static  boolean pressedB;
   
   
   
   public PinakasJPanel(ArrayList<Cell> b,MyFrame frame){
      
       this.p = new CharPanel[2];
       this.a = b;
       this.word= word;
       this.number= number;
       kelia = new CharPanel[a.size()];
       keliJpanel = this;
       
       keliJpanel.setLayout(new GridLayout(8,8,10,10));
       
       count =0;
       for(i=0;i<a.size();i++){
           kelia[i] = new CharPanel(a.get(i),i,frame);
         
          ola =i;
         
          keliJpanel.add(kelia[i]);
           
           
       }
       // keliJpanel.setPreferredSize(new Dimension(400,400));
       keliJpanel.setPreferredSize(new Dimension(1000,600));
       setMaximumSize(new Dimension(1200,600));
       //keliJpanel.setBackground(Color.gray);
       keliJpanel.setVisible(true);
        
       
        
   }/*
   public PinakasJPanel(Cell[][] arr){
       this.p = new CharPanel[2];
       this.arr = arr;
       this.word= word;
       this.number= number;
       kelia = new CharPanel[8][8];
       keliJpanel = this;
       
       keliJpanel.setLayout(new GridLayout(8,8,10,10));
       
       count =0;
       for(i=0;i<arr.length;i++){
         for(j=0;j<arr.length;j++){
           kelia[i][j] = new CharPanel(arr[i][j]);
         
          ola =i;
           /*kelia[i][j].addMouseListener(new MouseListener(){
               @Override
               public void mouseClicked(MouseEvent e) {
                   if(count<2){
                      // p[count] = kelia[ola];
                       count++;
                       System.out.println(a.get(ola).getWord());
                       
                   }
                   else{
                       count=0;
                       
                   }
               }
               @Override
               public void mousePressed(MouseEvent e) {
       
               }

               @Override
               public void mouseReleased(MouseEvent e) {
                
               }

               @Override
               public void mouseEntered(MouseEvent e) {
                
               }

               @Override
               public void mouseExited(MouseEvent e) {
              
               }
              
           
           });
          keliJpanel.add(kelia[i]);
           }
           
       }
        keliJpanel.setPreferredSize(new Dimension(400,400));
       // keliJpanel.setPreferredSize(new Dimension(600,600));
       //keliJpanel.setBackground(Color.gray);
        keliJpanel.setVisible(true);
   }
   */
   public CharPanel[] getP(){
       
       return p;   }
    public void setPrevChange(int prev){
        prevChanged = prev;
    }
    public void setPressed(boolean pr){
        pressedB = pr;
    }
     public static int getPrevChange(){
        return prevChanged;
    }
    public static boolean getPressed(){
        return pressedB;
    }
}
