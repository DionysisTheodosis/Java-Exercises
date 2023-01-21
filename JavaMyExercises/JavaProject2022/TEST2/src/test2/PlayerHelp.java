/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import javax.swing.*;
import java.awt.*;
import static java.awt.FlowLayout.TRAILING;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author Dionysis Theodosis 
 */
public class PlayerHelp extends JPanel {
    private final JLabel title;
    private final JButton buttonDel;
    private final JButton buttonShLine;
    private final JButton buttonShCol;
    private final JButton buttonShTable;
    private final JButton buttonSwWords;
    private final JTextField textDel;
    private final JTextField textShLine;
    private final JTextField textShCol;
    private final JLabel textDispDelTimes;
    private final JLabel textDispShLineTimes;
    private final JLabel textDispShColTimes;;
    private final JLabel textDispShTableTimes;;
    private final JLabel textDispSwWordsTimes;;
    private final JPanel panel;
    private final Game game;
    private JFrame frame;
    private int count, countline,countcol,countDel,tip,countSwaps;
    String a ;
    private PinakasJPanel lola;
    GridBagConstraints gbc =  new GridBagConstraints();
    
    public PlayerHelp(MyFrame pane){
        setLayout(new FlowLayout(FlowLayout.TRAILING));
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        game = pane.getGame();
       
        gbc.fill = 1;
        
        title = new JLabel("Βοήθειες",null,TRAILING);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(title,gbc);   
        
      
        
        buttonDel = new JButton();
        buttonDel.setText("Διαγραφή Γραμμής");
        buttonDel.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
       
        panel.add(buttonDel,gbc);
        
        
        
        
        
        buttonShLine = new JButton();
        buttonShLine.setText("Αναδιάταξη Γραμμής");
        buttonShLine.setFocusable(false);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        
        panel.add(buttonShLine,gbc);
        
        
        
        buttonShCol = new JButton();
        buttonShCol.setText("Αναδιάταξη Στήλης");
        buttonShCol.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx =10; 
        panel.add(buttonShCol,gbc);
        
        
        buttonShTable = new JButton();
        buttonShTable.setText("Αναδιάταξη Ταμπλό");
        buttonShTable.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        
        panel.add(buttonShTable,gbc);
        
        buttonSwWords = new JButton();
        buttonSwWords.setText("Εναλλαγή Γραμμάτων");
        buttonSwWords.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        
       countSwaps = 1;
        buttonSwWords.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textDispSwWordsTimes.setText(countSwaps+"/"+"3");
                int flag = Game.swapWords();
                if(countSwaps<=3){ 
                    
                if(flag==0){
                    JOptionPane.showMessageDialog(pane,"Επέλεξε πρώτα 2 Γράμματα","Warnign",JOptionPane.WARNING_MESSAGE);
                }
                else if(flag==1){
                    JOptionPane.showMessageDialog(pane,"Πρέπει να επιλέξεις ακόμα 1 γράμμα","Warnign",JOptionPane.WARNING_MESSAGE);
                }
                else if(flag==2){
                    countSwaps++;
                    if(countSwaps==4){
                        buttonSwWords.setEnabled(false);
                    }
                    pane.updateTable(game);
                    pane.setVisible(true);
                }
                
            }
              
            }
        });
        
        buttonSwWords.setToolTipText("Κλίκαρε σε 2 γράμματα και μετά πάτα για την εναλλαγή τους");
        
        panel.add(buttonSwWords,gbc);
        
        textDel = new JTextField();
        textDel.setText("0");
        textDel.setMinimumSize(new Dimension(30,20));
        textDel.setDisabledTextColor(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(textDel,gbc);
        
        textShLine = new JTextField();
        textShLine.setText("0");
        textShLine.setMinimumSize(new Dimension(30,20));
        textShLine.setDisabledTextColor(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(textShLine,gbc);
        
        textShCol = new JTextField();
        textShCol.setText("0");
        textShCol.setMinimumSize(new Dimension(30,20));
        textShCol.setDisabledTextColor(Color.LIGHT_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(textShCol,gbc);
        
        
        
        a = "0";
        textDispDelTimes = new JLabel();
        textDispDelTimes.setText(a+"/"+"3");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(textDispDelTimes,gbc);
        
        
        
        textDispShLineTimes = new JLabel();
        textDispShLineTimes.setText(String.valueOf(0)+"/"+"3");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(textDispShLineTimes,gbc);
        
        
        textDispShColTimes = new JLabel();
        textDispShColTimes.setText(a+"/"+"3");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(textDispShColTimes,gbc);
        
        
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        
        textDispShTableTimes = new JLabel();
        setTextDispShTableTimes(0);
        panel.add(textDispShTableTimes,gbc);
        
        
        textDispSwWordsTimes = new JLabel();
        textDispSwWordsTimes.setText("0"+"/"+"3");
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        
        panel.add(textDispSwWordsTimes,gbc);
        count = 1;
        buttonShTable.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                if(count<=5){ 
                    setTextDispShTableTimes(count);
                    game.shuffleWords();                       
                    pane.updateTable(game);                      
                    pane.setVisible(true);
                    count+=1;  
                }
                if(count==6){
                    buttonShTable.setEnabled(false);
                      
                }
            }
        }
        );
        countcol =1;
        buttonShCol.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tip = Integer.valueOf(textShCol.getText());
                if((textShCol.getText().equals("1")||textShCol.getText().equals("2")||textShCol.getText().equals("3")||textShCol.getText().equals("4")||textShCol.getText().equals("5")||textShCol.getText().equals("6")||textShCol.getText().equals("7")||textShCol.getText().equals("8"))&&countcol<=3){
                    textDispShColTimes.setText(String.valueOf(countcol)+"/"+"3"); 
                    game.shuffleCol(Integer.valueOf(textShCol.getText()));
                    pane.updateTable(game);                       
                    pane.setVisible(true);
                    countcol+=1;  
                  }
                  if(countcol==4){
                    buttonShCol.setEnabled(false);
                    textShCol.setEnabled(false);
                  }
            }
        }
        );
        
        countline = 1;
        buttonShLine.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if((textShLine.getText().equals("1")||textShLine.getText().equals("2")||textShLine.getText().equals("3")||textShLine.getText().equals("4")||textShLine.getText().equals("5")||textShLine.getText().equals("6")||textShLine.getText().equals("7")||textShLine.getText().equals("8"))&&countline<=3){
                    textDispShLineTimes.setText(String.valueOf(countline)+"/"+"3");    
                    game.shuffleLine(Integer.valueOf(textShLine.getText()));
                    pane.updateTable(game);
                    pane.setVisible(true);
                    countline+=1;  
                }
                if (countline==4){
                    buttonShLine.setEnabled(false);
                    textShLine.setEnabled(false);
                  }
            }
        }
        );
        
        countDel = 1;
        
        buttonDel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if((textDel.getText().equals("1")||textDel.getText().equals("2")||textDel.getText().equals("3")||textDel.getText().equals("4")||textDel.getText().equals("5")||textDel.getText().equals("6")||textDel.getText().equals("7")||textDel.getText().equals("8"))&&countDel<=3){
                    textDispDelTimes.setText(String.valueOf(countDel)+"/"+"3");
                    game.delLine(Integer.valueOf(textDel.getText()));
                    pane.updateTable(game);
                    pane.setVisible(true);
                    countDel+=1;  
                }
                if(countDel==4){
                    buttonDel.setEnabled(false);
                    textDel.setEnabled(false);
                }
            }
        }
        );
        setPreferredSize(new Dimension(400,100));
        setVisible(true);
        this.add(panel);

           
    }
    private void setTextDispShTableTimes(int number){
        textDispShTableTimes.setText(String.valueOf(number)+"/"+"5");
    }
    
}
