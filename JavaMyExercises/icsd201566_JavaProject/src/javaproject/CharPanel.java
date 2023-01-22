package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

//KLASH GIA TO GRAFIKO PANEL TOU KATHE GRAMMATOS
public class CharPanel extends JTextPane {
    //METAVLITES KLASHS
    private final  char word;//GIA TON XARAKTHRA
    private final  int number;//GIA TOUS PONTOUS
    private final  Color color;//GIA TO XRWMA TOU
    private Color prevColor;//GIA TO PROHOUMENO XRWMA ,GIA NA XEREI GIA THN APOEPIOGH
    private int count;
    private  JTextPane thisPanel;//GIA THN KLASH WSTE NA FYGEU TO HINT
    private WildCardPopup popUp;//METAVLITI GIA TO POPUP MENU GIA THN EPILOGH GRAMMATOS AN TO GRAMMA EINAI ERWTHMATIKO
    
    //CONSTRUCTOR THS KLASHS O OPOIOS PAIRNEI WS ORISMATA TO FRAME KAI TO KELI
    public CharPanel(Cell cell,MyFrame frame){
       
        popUp=null;
        thisPanel=this;
        CharPanel pane = this;
        pane.setLayout(new BorderLayout());
        //ARXIKOPOIHSH TWN METAVLITWN
        this.word=cell.getWord();
        this.number=cell.getNumber();
        this.color=cell.getColor();
        int c = 0x2080;//METAVLITI GIA NA DWSEI TON ARITHMO POU DEIXNEI WS DEIKTHS  
        String o; 
        //ELEGXOS GIA NA DWSH TWN XARAKTHRA MAZH ME TON ARITHMO WS DEIKTH SE ENA STRING
        if(number==10){//ELEGXOS GIA TO AN EINAI 10 O ARITHMOS GIATI EINAI SAN DIPLOS XARAKTHRAS
           c+=1;
           o = word+ Character.toString((char)c)+Character.toString((char)c-1);
        }
        else if(number==111) {//ELEGXOS GIA TO AN EINAI ERWTIMATIKO STO OPOIO DEN DINOUME ARITHMO
           o = Character.toString(word);
        }
        else{//GIA TA YPOLOIPA
           c+=number;
           o = word+ Character.toString((char)c);
        }
       
        thisPanel.setPreferredSize(new Dimension(60,60));//DINOUME TO EPITHIMITO MEGETHOS TOU KELIOU
        thisPanel.setText(o);//DINOUME TO KEIMENO POU THA EMFANIZETAI
        thisPanel.setBackground(color);//DINOUME TO XRWMA
        prevColor =thisPanel.getBackground(); //APOTHYKEUH TO XRWMA STO PREV WSTE NA TO THIMATE 
        //DIMIOURGEIA ANTIKEIMENWN GIA THN DIAXEIRISI TOU KEIMENOU
        StyledDocument doc = thisPanel.getStyledDocument(); 
        SimpleAttributeSet center = new SimpleAttributeSet(); //
        StyleConstants.setFontSize(center,40);//VAZEI TO KEIMENO NA EINAI SE 40 TO MEGETHOS
        StyleConstants.setBold(center, true);//TO KANEI BOLD
        //ELEGXOS GIA TO XRWMMA TOU KELIOU KAI GEMISMA ANALOGA WSTE NA FENETAI
        
        if(color == Color.WHITE){
           StyleConstants.setForeground(center,Color.BLACK );
        }
        else{
           StyleConstants.setForeground(center,Color.WHITE);
        }
        //VAZEI TO KEIMENO NA EINAI STO KENTRO
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
      
      
       count = 0;//METRHTHS GIA NA VLEPEI THS FORES POU EXEI PATHTHEI ENA GRAMMA
       thisPanel.setEditable(false);//GIA NA MHN ALLAZEI EPEIDH TO THELOUME MONO GIA DISPLAY
       thisPanel.setFocusable(false);//GIA NA MHN FAINETAI H GRAMMH
       //PROSTHIKI LISTENER GIA TO AN PATITHEI TI NA KANEI
       thisPanel.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
               //AN PATITHEI TO KELI KAI ME TO ARISTERO 
               if((e.getButton() == MouseEvent.BUTTON1)&& !WildCardPopup.isActive()){
                   if(cell.getWord()=='?'){//AN O XARAKTHRAS EINAI TO ERWTIMATIKO TOTE KALH TO POPUP GIA THN DIMOIURGEI THS EPILOGHS
                       popUp = new WildCardPopup(frame, (CharPanel) thisPanel,cell); 
                       frame.updateT();//ANANEWNEI TO FRAME
                       popUp=null; //KAI THETEI TO POPUP PALI SE NULL
                       setVisible(true);
                      
                   }
                   //ALLIWS AN EINAI ALLO KELI KAI MPOREI NA PATITHEI
                   else{
                   if(Game.isClickable(cell)&&count==0){//ELEGXOS GIA TO AN MPOREI SYMFWNA ME THN METHODO TOU PAIXNIDIOU KAI AN EXEI MPEI MIA FORA H ANA 2
                 
                        count++;
                        Game.setWord(cell);//APOTHIKEUH THN LEXEI
                        pane.setBackground(Color.YELLOW); //KAI ORIZEI TO XRWMA TOU PANEL SE KITRINO
                                    
                 
                    }
                    else if((thisPanel.getBackground()==Color.YELLOW)&&count==1&&Game.isremoveLett(cell) ){//AN EINAI TO IDIO KELI 2H GORA TOTE ALLAZEI TO XRWMA
                        count=0;
                        Game.removeLett(cell);
                        pane.setBackground(prevColor);
             
                    }
                    else if (getBackground()!=Color.YELLOW){//ALLIWS AN PATITHEI KAI DEN EINAI TO IDIO H GEITONIKO
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
       
       //TO KANEI EMFANISIMO
       thisPanel.setVisible(true);
       
       
    }
    //METHODOS GIA THN PROSTHIKI XRWMATOS
    public void setTextW(){
       thisPanel.setBackground(Color.yellow);
        repaint();
    }
    //METHODOS GIA TH EPISTROFH TOU XRWMATOS 
    public Color getColor(){
        return thisPanel.getBackground();
    }
    //METHODOS GIA THN EPISTROFH TOU KEIMENOU
    public String getTextW(){
          return thisPanel.getText();
    }
}
