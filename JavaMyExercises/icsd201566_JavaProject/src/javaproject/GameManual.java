
package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class GameManual extends JDialog {
     //METAVLITES KLASHS
    private MyFrame mainFrame; //METAVLITI GIA TO MAINFRAME 
    private static JPanel popUpPanel;
    private static Popup p;
    
    public GameManual(MyFrame mainframe){
        
        
        this.mainFrame = mainframe;
        this.setLayout(new FlowLayout());
        JLabel picLabel = new JLabel(new ImageIcon(mainFrame.getKit().getImage(".\\Images\\helpi2.png")));
        add(picLabel);    
        this.setAutoRequestFocus(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setAlwaysOnTop(true);   
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(mainframe);
        setVisible(true);
     
    
     
            
    }
                
    
}
