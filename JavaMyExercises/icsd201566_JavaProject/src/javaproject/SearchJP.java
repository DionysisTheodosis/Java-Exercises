
package javaproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//KLASH GIA TO PANEL TOU KOUMPIOU ANAZITISIS
public class SearchJP extends JPanel {
    //METAVLITI GIA TO KOUMPI KAI GIA TO PANEL
    private JButton buttonSearch;
    private JFrame pane;
    //CONSTRUCTOR O OPOIOS PAIRNEI WS ORISMA TO FRAME
    public SearchJP(MyFrame pane){
        
        this.pane = pane;
        //DIMIOURGIA TOU KOUMPIOU
        buttonSearch = new JButton();
        buttonSearch.setFocusable(false);
        buttonSearch.setText("Έλεγχος Λέξης");//DINOUME TO TEXT
        buttonSearch.setPreferredSize(new Dimension(120,30));//TO EPITHIMITO MEGETHOS
        buttonSearch.addActionListener(new ActionListener(){//DINOUME TI THA KANEI AN PATITHEI
         
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.lettersClicked()){//AN MPOREI NA PATITHEI SYMFWNA ME THN EFARMOGH TOTE
                    pane.searchWord();//PSAXNEI THN LEXH
                    pane.discardWord();//DIAGRAFH THN LEXH
                    pane.updateStats();//ANANEWNEI TO PANEL TWN STATISTIKWN
                    if(Game.winGame()){//AN EXEI NIKISEI TOTE FAIRNEI TO WIN PANEL
                        pane.winPage();
                    }
                }
                else{//ALLIWS AN DEN MPOREI NA PATITHEI EMFANIZEI TO MINIMA
                    JOptionPane.showMessageDialog(pane,"Επέλεξε πάνω από 2 γράμματα για εύρεση","Αδύνατη Εκτέλεση",JOptionPane.ERROR_MESSAGE);
                }
              
            }
        });
        //TO PROSTHETEI STO PANEL KAI TO KANEI EMFANISIMO
        add(buttonSearch);
        setVisible(true);
        
    }
}
