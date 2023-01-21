
package test2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.MOUSE_PRESSED;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class CharPanel extends JTextPane {
    private final  char word;
    private final  int number;
    private final  Color color;
    private static ArrayList<CharPanel > mouseC;
    private Color prevColor;
    private  int y;
    private  int x;
    private int count;
    private static ArrayList<JTextPane>  prevword;
    private int poss;
    private int prevPoss;
    private PinakasJPanel pan;
   
    //private final  JTextPane textW;
 
    public CharPanel(Cell cell,int posS,MyFrame frame){
      // pan = pinPane;
        
        poss=posS;
        prevPoss=-100;
           
       CharPanel pane = this;
       pane.setLayout(new BorderLayout());
       
       mouseC = new ArrayList<>();
       this.word=cell.getWord();
       this.number=cell.getNumber();
       this.color=cell.getColor();
       prevword= new ArrayList<>();
       int c = 0x2080;
       String o; 
       if(number==10){
           c+=1;
           o = word+ Character.toString((char)c)+Character.toString((char)c-1);
       }
       else if(number==111) {
           o = Character.toString(word);
       }
       else{
           c+=number;
           o = word+ Character.toString((char)c);
       }
       //textW = new JTextPane(); 
       /*textW.*/setPreferredSize(new Dimension(60,60));
       /*textW.*/setText(o);
       /*textW.*/setBackground(color);
       prevColor = /*textW.*/this.getBackground();
       StyledDocument doc = /*textW.*/getStyledDocument();
       SimpleAttributeSet center = new SimpleAttributeSet();
       StyleConstants.setFontSize(center,40);
       StyleConstants.setBold(center, true);
       if(color == Color.WHITE){
           StyleConstants.setForeground(center,Color.BLACK );
       }
       else{
           StyleConstants.setForeground(center,Color.WHITE);
       }
      
       StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
       doc.setParagraphAttributes(0, doc.getLength(), center, false);
         ArrayList<Object> asd = new ArrayList<>();
       c=0;
        int t=0;
        count = 0;
       /*textW.*/setEditable(false);
       /*textW.*/setFocusable(false);
       /*/*textW.*/addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
               if(e.getButton() == MouseEvent.BUTTON1){
                   if(cell.getWord()=='?'){
                       cell.setWord('Α');
                       
                       frame.getGame();
                       frame.updateT();
                       //setVisible(true);
                      
                   }
                   
                   else{
                   if(Game.isClickable(cell)&&count==0){
                   
                        System.out.println("oi geines tou"+cell.getWord()+" einai "+cell.getNeighbours().toString());
                        count++;
                        Game.setWord(cell);
                       
                       pane.setBackground(Color.YELLOW); 
                       //repaint();
                               
              
                   
                   //System.out.print(prevword.getBackground());
                  
                 
                    }
                    else if((/*textW.*/getBackground()==Color.YELLOW)&&count==1&&Game.isremoveLett(cell) ){
                        count=0;
                        Game.removeLett(cell);
                        pane.setBackground(prevColor);
                    //repaint();
                    }
                    else if (getBackground()!=Color.YELLOW){
                        JOptionPane.showMessageDialog(pane,"Επέλεξε Γειτονικό Γράμμα","Λάθος Εκτέλεση",JOptionPane.ERROR_MESSAGE);
                    }
               }
           }}

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
    public void setTextW(){
        /*textW.*/setBackground(Color.yellow);
        repaint();
    }
    public Color getColor(){
        return /*textW.*/getBackground();
    }
      public String getTextW(){
          return this.getText();
    }
      public void setColor(){
          
      }
}
