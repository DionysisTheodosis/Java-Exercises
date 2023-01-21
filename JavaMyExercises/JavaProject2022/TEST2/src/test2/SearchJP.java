/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
/**
 *
 * @author dionysis
 */
public class SearchJP extends JPanel {
    private JButton buttonSearch;
    private JFrame pane;
    public SearchJP(MyFrame pane){
        this.pane = pane;
        buttonSearch = new JButton();
        buttonSearch.setFocusable(false);
        buttonSearch.setText("Έλεγχος Λέξης");
        buttonSearch.setPreferredSize(new Dimension(120,30));
        //buttonSearch.setBackground(Color.GRAY);
        //buttonSearch.setBorder(BorderFactory.createEtchedBorder());
        buttonSearch.addActionListener(new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.searchWord();
                pane.discardWord();
                //pane.updateTable(pane.));
                //setVisible(true);
            }
        });
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getButton() == MouseEvent.BUTTON3){
                   pane.discardWord();
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
        add(buttonSearch);
       // setBackground(Color.gray);
        setVisible(true);
        
    }
}
