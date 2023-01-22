package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

//KLASH GIA TO POPUP TOU ERWTIMATIKOU GIA NA EPILEXEI O XRHSTHS LEXH
public class WildCardPopup  {
    //METAVLITES KLASHS
    private MyFrame mainFrame; //METAVLITI GIA TO MAINFRAME 
    private static JPanel letterPanel,popUpPanel;
    private static  JButton[] letter;//GIA THN DIMIOURGEIA PINAKA KOUMPIWN
    private final int SIZE=24;//TO MEGETHOS TWN ELLHNIKWN GRAMATWN
    private final int FirstGrLetter=913;//O ARITHMOS TOU A STON ASSCI
    private PopupFactory popF;
    private char charClicked; //O XARAKTHRAS POU PATITHIKE
    private static Popup p;//GIA TO POPUP
    private CharPanel charPanerl;//PANEL GIA TON XARAKTHRA
    private Cell cell;
    private static boolean isActive;//NA MAS DEIXNEI AN EINAI ENERGO TO POPUP
    int letterCount;//METRITIS GRAMMATWN
    private Point cellPossition;//METAVLITI GIA NA PAREI TIS SYTETAGMENES TOU KELIOU POU TO KALESE
    
    //COSTRUCTOR O OPOIOS DEXETAI TO FRAME ,TO PANEL TOU KELIOU WSTE NA EMFANISEI KONTA TO POPUP,KAI TO KELI GIA THN LEXH
    public WildCardPopup(MyFrame maiFrame,CharPanel charPanerl,Cell cell){
        this.cell=cell;
        this.charPanerl=charPanerl;
        this.mainFrame = maiFrame;
        cellPossition = charPanerl.getLocationOnScreen();//APOTHIKEUH THN TOPOTHESIA TOU KELIOU
        isActive=true;//THETH THN ENDEIXH OTI TO POP UP EINAI ACTIVE
        popF = new PopupFactory();
        setContent();
            
    }
    
    private void setContent(){
        
        letterCount =FirstGrLetter;//XEKINAEI TON METRHTH APO TON ARITHMO TOU A
        //DIMIOURGEI TO PANEL TOU POPUP
        popUpPanel =new JPanel();
        popUpPanel.setBackground(Color.LIGHT_GRAY);
        popUpPanel.setLayout(new BorderLayout());
        //DIMIOURGEI TO PANEL TOU KOUMPIOU
        letterPanel = new JPanel();
        letterPanel.setBackground(Color.GRAY);
        //THETH THN DIATAXH TWN KOUMPIWN ANALOGA 
        letterPanel.setLayout(new GridLayout((int)Math.sqrt(SIZE),SIZE/(int)Math.sqrt(SIZE),0,0));
        //THETH TO MEGETHOS
        letterPanel.setSize(new Dimension(120,190));
        letter = new JButton[SIZE];//DIMIOURGEI TON PINAKS KOUMPIRWN
        //PROISELASH GIA THN DIMIOURGEIA OLWN TWN KOUMPIWN
        for(int i=0;i<SIZE;i++){
            //ELEGOXS GIATI STO 930 DEN EINAI TO S ALLA ALLOS XARAKTHRAS KAI PROSTHIKI KATA 1
            if(letterCount==930){
                letterCount++;
            }
            //PROSTHIKI TOU GRAMMATOS 
            letter[i] = new JButton(Character.toString((char)letterCount++));
            letter[i].setFocusable(false);
            letter[i].setBackground(Color.white);
            letter[i].setVisible(true);
            letter[i].setEnabled(true);
            letter[i].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {//AN PATITHEI KAPOIO GRAMMA APO TO POPUP
                    mainFrame.setWild(e.getActionCommand().charAt(0), cell);//KALESMA THS METHODOU H OPOIA THA THESH TO NEO GRAMMA
                    p.hide();//APOKRYPSH TOU POPUP
                    isActive=false;//THETOUME OTI DEN EINAI ENERGO
                    }
           
        });      
            //PROSTHETH TO KOUMPI STO PANEL TWN KOUMPIWN     
            letterPanel.add(letter[i]);
        }
        //KEIMENO ETIKETAS GIA TON TITLO TOU POPUP KAI KATHORISMOS TOU STO PANW MEROS KAI PROSTHIKI STO PANEL
        JLabel title = new JLabel("Επέλεξε γράμμα");
        popUpPanel.add(title,BorderLayout.NORTH);
        //PROSTHETEI TO PANEL TWN KOUMPIWN STO KENTRIKO
        popUpPanel.add(letterPanel,BorderLayout.CENTER);
        popUpPanel.setSize(new Dimension(200,200));
        popUpPanel.setToolTipText("Πάτα το δεξί κλίκ έξω για να βγεις, αλλίως επέλεξε γράμμα");//GIA NA ENHMERWNEI TON XRHSTH
        p = popF.getPopup(charPanerl,popUpPanel,cellPossition.x,cellPossition.y);//PROSTHIKI TOU POPUP STHN THESH TOU KELIOU 
        p.show();//EMFANISH TOU POPUP
    }
    //METHODOS GIA NA DEIXNEI AN TO POPUP EINAI ENERGO
    public static boolean isActive(){
        return isActive;
    }
    //METHODOS GIA THN ENERGOPOIHSH TOU POPUP
    public static void disablePopUp(){
        if(isActive){
            p.hide();
            isActive = false;
        }
                
    }
   
}
