package javaproject;

import javax.swing.*;
import java.awt.*;

//KLASH GIA TO PANEL TWN ENHMERWSEWN VATHMOLOGIAS STON PAIKTH
public class StatsJpanel extends JPanel {
    
    private final JLabel labelGoalT;//METAVLITI GIA TO KEIMENO TOU STOXOU
    private final JLabel labelToTScoreT;//METAVLITI GIA TO KEIMENO SYNOLIKO SCORE
    private final JLabel labelWordScoreT;//METAVLITI GIA TO KEIMENO SCORE THS LEXHS POU VRYKE
    private final JLabel labelFndWordsT;//METAVLITIGIA TO KEIMENO PLITHOS TWN LEXEWN POU VRYKE
    private final JLabel labelResultT;//METAVLITI GIA TO KEIMENO APOTELESMA THS ANAZITISIS
    private final JLabel labelGoalF;//METAVLITI GIA TO STOXO
    private final JLabel labelToTScoreF;//METAVLITI GIA TO SYNOLIKO SCORE
    private final JLabel labelWordScoreF;//METAVLITI GIA TO SCORE THS LEXHS
    private final JLabel labelFndWordsF;//METAVLITI GIA TO PLITHOS TWN LEXEWN
    private final JLabel labelResultF;//METAVLITI POU THA DEIXNEI THN LEXH
    private final JPanel panel,thisPanel; //GIA NA VALEI  SE DIAFORETIKO PANEL
 
    //CONSTRUCTOR THS KLASHS POU DEXETAI TO FRAME
    public StatsJpanel(MyFrame mainFraim){
      //THETH TO LAYOUT 
       setLayout(new BorderLayout());
       //DIMIOURGEIA TOU PANEL POU THA TA PERIEXEI
       thisPanel = new JPanel(); 
       thisPanel.setLayout(new BorderLayout());
       //DHMIOURGEIA TWN ETIKETWN 
       labelGoalT = new JLabel("Στόχος:",JLabel.LEFT);
       labelToTScoreT  = new JLabel("Συνολική Βαθμολογία:",JLabel.LEFT);
       labelWordScoreT = new JLabel("Βαθμολογία Λέξης:",JLabel.LEFT);
       labelFndWordsT = new JLabel("Λέξεις Που Βρέθηκαν:",JLabel.LEFT);
       labelGoalF = new JLabel(String.valueOf(Game.getGoal()),JLabel.CENTER);
       labelToTScoreF = new JLabel(String.valueOf(Game.getTotalScore()),JLabel.CENTER);
       labelWordScoreF = new JLabel(String.valueOf(Game.getWordPoints()),JLabel.CENTER);
       labelFndWordsF = new JLabel(String.valueOf(Game.getNwords()),JLabel.CENTER);
       //DIMIOURGEIA TOU PANEL GIA TIS ETIKETES POU THA ALLAZOUN
       panel = new JPanel();
       panel.setLayout(new GridLayout(5,1,60,5));
       panel.add(labelGoalT);
       panel.add(labelGoalF);
       panel.add(labelToTScoreT);
       panel.add(labelToTScoreF);
       panel.add(labelWordScoreT);
       panel.add(labelWordScoreF);
       panel.add(labelFndWordsT);
       panel.add(labelFndWordsF);
       //ELEGXOS GIA TO AN EXEI VREI THN LEXH KAI ANALOGOS THN DHMIOURGEIA KAI THN ALLAGH 
       if(Game.findWord()){
           labelResultT = new JLabel("Συγχαρητήρια Βρήκες Την Λέξη: ",JLabel.LEFT);
           labelResultF = new JLabel(Game.getFndWord(),JLabel.CENTER);
           
       }else{//AN DEN EXEI VREI KAI DEN EXEI ANAZHTHSH AKOMA TOTE APLA TO DIMIOURGEI
           if(Game.getFndWord()==""){
               labelResultT = new JLabel(" ",JLabel.LEFT);
               
           }
           else{//ALLIWS
               labelResultT = new JLabel("Η Λέξη Δεν Υπάρχει: ",JLabel.LEFT);
           }
            labelResultF = new JLabel("",JLabel.CENTER);   
       }
       //PROSTHIKI STO PANEL
       panel.add(labelResultT);      
       panel.add(labelResultF);
       //PROTEINOMENO MEGETHOS
       panel.setPreferredSize(new Dimension(460,200));
       thisPanel.add(panel,BorderLayout.SOUTH);//DWSIMO LAYOUT GIA THN KATW PLEURA
      //PROSTHIKI
      add(thisPanel);
        
        
        
        
    }
}
