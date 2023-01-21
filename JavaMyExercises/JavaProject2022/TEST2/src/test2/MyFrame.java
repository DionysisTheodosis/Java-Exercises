
package test2;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.FlowLayout.CENTER;
import java.awt.Frame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class  MyFrame extends JFrame {
    //ArrayList<Cell> arr
    private east East;
    private West west ;
    private Cell[][] arr;
    private  Game game;
    private Toolkit thekit; 
    private HomePage asd;
    private int a;
    private MenuJPanel menuJpl;
    public MyFrame(){
        
       
     
        thekit = this.getToolkit();
        this.setTitle("Βρες την λέξη");
        this.setIconImage(thekit.getImage("C:\\Users\\dionysis\\Desktop\\words-with-friends-icon.png"));
       
       
        setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        homePageContainer();
      
        setSize(1100,800);
        setVisible(true);
        
      
        
      
        
    }
    
    public West actiond(){
       return west;
    
    }
    public void Swap(){
        west.getPinakasJPanel().getP();
    }
  
    public void updateTable(Game game){
        this.remove(west);
        west = new West(game.getWords(),this);
        add(west,BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void newGame() {
       game = new Game();
       if(East!=null&& west!=null){
         this.remove(East);
         this.remove(west);
       }
       
       
       
       west = new West(game.getWords(),this);
       add(west,BorderLayout.CENTER);//To change body of generated methods, choose Tools | Templates.
       East = new east(this);
       East.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(e.getButton() == MouseEvent.BUTTON3){
                    System.out.println("clicked outside");
                    discardWord();
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
       add(East,BorderLayout.LINE_END);
       setVisible(true);
    }

    public Game getGame(){
        return game;
    }
    public void homePageContainer(){ 
        setJMenuBar(null);
        asd = new HomePage(this);
        setVisible(true);

    }
    public void deleteContent(){
        
        this.getContentPane().removeAll();    
        this.repaint();
        this.validate();
     
    }
    public void gameContainer(){
        menuJpl = new MenuJPanel(this); 
        setJMenuBar(menuJpl);
        newGame();
        setVisible(true);
    
        
    }
    public Toolkit getKit(){
        return thekit;
    }
    public MyFrame getFrame(){
        return this;
    }
    public void discardWord(){
         Game.removeWord();
         updateTable(game);
         setVisible(true);
    }
    public void searchWord(){
        game.searchWord();
    }
    public  void updateT(){
        updateTable(game);
    }
}
