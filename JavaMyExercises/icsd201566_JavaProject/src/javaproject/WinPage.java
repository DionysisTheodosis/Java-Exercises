/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


//KLASH GIA TO PANEL POU THA EMFANISTEI AN NIKISEI 
public class WinPage extends JPanel{
    //ORISMOS METAVLITWN
    private MyFrame mainFrame; // GIA TO FRAME
    private static JPanel winPannel; //GIA TO SYGKEKTRIMENO PANEL
    private static  JButton exitButton; 
    private static  JButton homeButton;
    private static  JButton newGameButton; 

    
    //CONSTRUCTOR THS KLASH POU PAIRNEI WS ORISMA TO MAIN FRAME
    public WinPage(MyFrame mainFrame){
        this.mainFrame=mainFrame;
     
        //DIMIOURGEIA JLABEL GIA THN EIKONA
        JLabel picLabel = new JLabel(new ImageIcon(mainFrame.getKit().getImage(".\\Images\\WinImage.jpg")));
     
        //THETEI TO XRWMA KAI THN DIATAXEI GIA TO PANEL
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        //DHMIOUIRGEIA PANEL GIA TA PLHKTRA KAI PROSTHIKI DIATAXEIS
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        //DIMIOURGEI KOUMPIWN KAI TOU KEIMENOU TOUS
        exitButton = new JButton("Έξοδος");
        homeButton = new JButton("Αρχική");
        newGameButton = new JButton("Νέο Παιχνίδι");
        //ARXIKOPOIHSH TOU KOUMPIOU EXODOU KAI PARAMETROPOIHSH 
        exitButton.setEnabled(true);
        exitButton.setFocusable(false);
        exitButton.setVisible(true);
        exitButton.setEnabled(true);
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  
                   System.exit(0);
                }  
            });   
        //ARXIKOPOHSH TOU KOMPIOU POU TO STENLNEI STHN 1H SELIDA
        homeButton.setEnabled(true);
        homeButton.setFocusable(false);
        homeButton.setVisible(true);
        homeButton.setEnabled(true);
        homeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.deleteContent();//KALSEMA THS METHODOU POU DIAGRAFH TO MAINPANEL
                mainFrame.homePageContainer();//DIMIOURGEIA TOU PANEL THS ARXIKHS SELIDAS
              
                }  
            });
        //ARXIKOPOIHSH TOU KOUMPIOU NEOU PAIXNIDIOU
        newGameButton.setEnabled(true);
        newGameButton.setFocusable(false);
        newGameButton.setVisible(true);
        newGameButton.setEnabled(true);
        newGameButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                mainFrame.setJMenuBar(mainFrame.getMenu());//VAZEI TO MENU
                mainFrame.deleteContent();//DIAGRAFH TO PROHGOUMENO PANEL
                mainFrame.newGame();//DIMIOURGEI NEO PAIXNIDI KAI TO PANEL TOU PAIXNIDIOU
                }  
            });
        //PROSTHETEI TA KOUMPIA STO PANEL TOU KOUMPIOU
        buttonPanel.add(newGameButton);
        buttonPanel.add(homeButton);
        buttonPanel.add(exitButton);
       //KAI PROSTHETOI OLA TA PANEL STO KENTRIKO
        add(picLabel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        this.setVisible(true);
        mainFrame.add(this);//PROSTHETEI TO PANEL STO FRAME
        
       
        
        
   
    }
   
        
        
    
}
