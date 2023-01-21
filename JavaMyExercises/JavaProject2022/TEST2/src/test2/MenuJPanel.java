package test2;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.event.MouseMotionListener;
import java.io.File;
import static javax.swing.JFileChooser.FILES_ONLY;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuJPanel extends JMenuBar{
    //private final JMenuBar menuBar;
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
    
    private  Dimension  size;
    GridBagConstraints gbc = new GridBagConstraints();
   

    public MenuJPanel(MyFrame pane){        
       //Grammh Menu
       //menuBar = new JMenuBar();
       
       setLayout(new FlowLayout(FlowLayout.LEADING));
       //Dimiourgeia Tou Upomenou Kai Twn Antikeimenw Tou 
       menuMenu = new JMenu("Μενού");
       menuNewGame = new JMenuItem("Νέο Παιχνίδι");
       menuNewGame.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
             Container a = pane.getContentPane();
            // a.remove(menuMenu);
             pane.remove(pane.actiond());
             Game newOne = new Game();
            // pane.repaint();
             pane.newGame();
             
             
             pane.setVisible(true);
            
            //newOne.newGame();
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
                fileChooser.setCurrentDirectory(new File(".\\build"));
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
              System.exit(0); 
           }   
       });
       menuMenu.add(menuExit);
      
       System.out.print(menuMenu.getBackground());
       /*menuBar.*/add(menuMenu);
       //Dimiourgeia Tou Upomenou Kai Twn Antikeimenw Tou 
       menuTools = new JMenu("Εργαλεία");
       menuHelp = new JMenuItem("Βοήθεια");
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
              text.setText("Δημιουργός: Διονύσης Θεοδόσης\nΦοιτητής στο τμήμα ΜΠΕΣ,\nΑριθμός Μητρώου 3212015066");
              text.setEditable(false);
              text.setFocusable(false);
              about.setPreferredSize(new Dimension(200,200));
              about.add(text);
              about.setVisible(true);
              about.getBounds();
              about.pack();
           }   
       });
      
      /* menuBar.*/add(menuTools);
        
      // menuBar.setPreferredSize(new Dimension(1920,20));
      //gbc.fill= GridBagConstraints.HORIZONTAL; 
      System.out.print(this.getSize());
      
      // this.add(menuBar);
       setVisible(true);
       
    }

}
