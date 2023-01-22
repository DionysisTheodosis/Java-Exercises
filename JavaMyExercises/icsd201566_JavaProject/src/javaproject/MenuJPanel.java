package javaproject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuJPanel extends JMenuBar{
    private final JMenu menuMenu;
    private final JMenu menuTools;
    private final JMenuItem menuNewGame;
    private final JMenuItem menuCancel_Exit;
    private final JMenuItem menuPlayerCred;
    private final JMenuItem menuOptHelp;
    private final JMenuItem menuSearchFile;
    private final JMenuItem menuExit;
    private final JMenuItem menuHelp;
    private final JMenuItem menuAbout;
    private GameManual manualDialog;
    
    private  Dimension  size;
    GridBagConstraints gbc = new GridBagConstraints();
   

    public MenuJPanel(MyFrame pane){        
    
       //Dimiourgeia Tou Upomenou Kai Twn Antikeimenw Tou 
       menuMenu = new JMenu("Μενού");
       menuNewGame = new JMenuItem("Νέο Παιχνίδι");
       menuNewGame.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                         
                pane.newGame();
                pane.setVisible(true);
            }   
           
       });
       menuMenu.add(menuNewGame);
       menuCancel_Exit = new JMenuItem("Ακύρωση/Τερματισμός Παιχνιδιού");
       menuCancel_Exit.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
                pane.deleteContent();
                Game.setChanges();
                pane.homePageContainer();
           }
       });
       menuMenu.add(menuCancel_Exit);
       menuPlayerCred = new JMenuItem("Εισαγωγή Στοιχείων Παίχτη");
       menuPlayerCred.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               while(true){
               String name = (String)JOptionPane.showInputDialog(pane,"Όνομα:","Ενημέρωση Ονόματος",1,null,null,Game.getUsername());
               if(name!=null){
                   if(name.isBlank() && name.isEmpty()){
                        JOptionPane.showMessageDialog(pane,"Λάθος Καταχώρηση,Γράψε Το Ονομά Σου");
                   }
                   else{    
                       Game.setUsername(name);
                       break;
                   }
                  
               }
               else {
                   break;
               }
               }
           }
       });
       menuMenu.add(menuPlayerCred);
       menuOptHelp = new JMenuItem("Ρυθμίσεις Βοηθειών");
       menuMenu.add(menuOptHelp);
       menuSearchFile = new JMenuItem("Αναζήτηση Αρχείου Λέξεων");
       menuSearchFile.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(".\\WordsFiles"));
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
               
                    
                fileChooser.showOpenDialog(pane);
                if(fileChooser.getSelectedFile()!=null){
                    
                    Game.setFile(fileChooser.getSelectedFile());
                }
                
           }   
           
       });
        
       menuMenu.add(menuSearchFile);
       menuExit = new JMenuItem("Έξοδος");
       menuExit.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              
              if(0==JOptionPane.showConfirmDialog(pane,"Τερματισμός Παιχνιδιού;","Έξοδος",JOptionPane.OK_CANCEL_OPTION)){
                   System.exit(0); 
              }
             
           }   
       });
       menuMenu.add(menuExit);
      
       System.out.print(menuMenu.getBackground());
       add(menuMenu);
       //Dimiourgeia Tou Upomenou Kai Twn Antikeimenw Tou 
       menuTools = new JMenu("Εργαλεία");
       menuHelp = new JMenuItem("Βοήθεια");
       menuHelp.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               manualDialog = new GameManual(pane);
           }
       });
       menuTools.add(menuHelp);
       menuAbout = new JMenuItem("About...");
       menuTools.add(menuAbout);
       
       
       menuAbout.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              JFrame about = new JFrame();
              about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              about.setLocationRelativeTo(pane);
              about.setTitle("About");
              JTextArea text = new JTextArea();
              text.setText("Φοιτητής: Διονύσης Θεοδόσης\nΑριθμός Μητρώου 3212015066");
              text.setEditable(false);
              text.setFocusable(false);
              about.setPreferredSize(new Dimension(200,200));
              about.add(text);
              about.setVisible(true);
              about.getBounds();
              about.pack();
           }   
       });
      
      add(menuTools);
        
    
      System.out.print(this.getSize());
      
      
       setVisible(true);
       
    }

}
