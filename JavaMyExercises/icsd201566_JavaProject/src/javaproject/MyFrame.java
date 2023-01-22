
package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class  MyFrame extends JFrame {

    private east East;
    private West west ;
    private  Game game;
    private Toolkit thekit; 
    private HomePage homePanel;
    private int a;
    private MenuJPanel menuJpl;
    private WinPage winPage;
    public MyFrame(){
        
       
     
        thekit = this.getToolkit();
        this.setTitle("Βρες την λέξη");
        this.setIconImage(thekit.getImage(".\\Images\\FrameIcon.png"));
       
       
        setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        homePageContainer();
      
        setSize(1100,800);
        setVisible(true);
        
      
        
      
        
    }
      
  
    public void updateTable(Game game){
        Game.removeWord();
        this.remove(west);
       
        west = new West(game.getWords(),this);
        add(west,BorderLayout.CENTER);
        setVisible(true);
    }
    public void updateStats(){
        East.remove(East.upDateStats());
        East.setStats();
        setVisible(true);
    }
    public void newGame() {
       game = new Game();
       if(East!=null&& west!=null){
         this.remove(East);
         this.remove(west);
       }
       west = new West(game.getWords(),this);
       add(west,BorderLayout.CENTER);
       East = new east(this);
  
       add(East,BorderLayout.LINE_END);
       setVisible(true);
    }

    public Game getGame(){
        return game;
    }
    public void homePageContainer(){ 
        setJMenuBar(null);
        homePanel = new HomePage(this);
        setVisible(true);

    }
    public  void winPage(){
        setJMenuBar(null);
        deleteContent();
        winPage= new WinPage(this);
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
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(e.getButton() == MouseEvent.BUTTON3){
                    discardWord();
                    WildCardPopup.disablePopUp();
                   
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
        setVisible(true);
    
        
    }
    public Toolkit getKit(){
        return thekit;
    }
    public  MyFrame getFrame(){
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
    public void setWild(char chara,Cell cell){
        game.setWildCard(chara, cell);
        updateTable(game);
        
    }
    public JMenuBar getMenu(){
        return menuJpl;
    }
}
