/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;


import java.awt.BorderLayout;
import static java.awt.BorderLayout.NORTH;
import java.awt.Container;
import java.awt.Dimension;
import static java.awt.FlowLayout.CENTER;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author dionysis
 */
public class HomePage extends JPanel{
    
    private JLabel txtUsername;
    private JLabel txtFile;
    private JButton but;
    private JButton fileButton;
    private JTextField username;
    private JTextField urlBar;
    private JButton searchButton;
    private JPanel userPanel;
    private JPanel filePanel;
    private JButton playButton;
    private static String chUsername,fileUrl;
    private static File file;
    private JFrame pane;
    private JPanel imageJPanel;
    
    GridBagConstraints gbc =  new GridBagConstraints();
    
    public HomePage(MyFrame pane){
        file=null;
        chUsername=null;
        this.pane = pane;
        pane.setLayout(new BorderLayout());
        
        JLabel picLabel = new JLabel(new ImageIcon(pane.getKit().getImage("C:\\Users\\Dionysis\\Desktop\\ΩΡΕΣ.png")));
        picLabel.setPreferredSize(new Dimension(1100,200));
        
        
        
        
        userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        filePanel = new JPanel();
       
        
        txtUsername = new JLabel("Καταχώρησε το Ονομά σου:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 18;
        gbc.insets = new Insets(100,5,5,5);
        userPanel.add(txtUsername,gbc);   
        
        gbc.ipadx = 0;
        username = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //gbc.insets = new Insets(15,5,5,5);
        
        userPanel.add(username,gbc); 
       
        but = new JButton("Αποθήκευση");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //gbc.insets = new Insets(5,5,5,5);
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!username.getText().isBlank()){
                    chUsername = username.getText();
                    System.out.print(chUsername);
                }
            }
            
        });
        userPanel.add(but,gbc);
        
        
        but.setFocusable(false);
        
        txtFile = new JLabel("Επέλεξε το αρχείο των λέξεων:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        
        gbc.insets = new Insets(5,5,5,5);
        userPanel.add(txtFile,gbc); 
        
        urlBar = new JTextField(20);
        //urlBar.setEnabled(false);
        urlBar.setText(".\\τεστ.txt");
        urlBar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              urlBar.setText(urlBar.getText());  
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        //gbc.insets = new Insets(5,5,20,20);
        userPanel.add(urlBar,gbc);
        
        searchButton = new JButton("Αναζήτηση");
        
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                if(fileChooser.showOpenDialog(pane)==JFileChooser.APPROVE_OPTION){
                    
                    File selectedFile = fileChooser.getSelectedFile();
                    file = fileChooser.getSelectedFile();
                    urlBar.setText(selectedFile.getAbsolutePath());
                }
                
            }
            
        });
        searchButton.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0,-25,0,0);
        userPanel.add(searchButton,gbc);
        
        
        
        fileButton = new JButton("Επιλογή");
        fileButton.setFocusable(false);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 20;
        //gbc.insets = new Insets(0,-30,0,0);
        
        fileButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //file = new File(urlBar.getText());
                if(new File(urlBar.getText()).exists()){
                    fileUrl = urlBar.getText();
                    file = new File(urlBar.getText());
                    System.out.print("to arxeio");
                }
                    
                }
            
        });
        userPanel.add(fileButton,gbc); 
        
        playButton = new JButton("Παίξε");
        playButton.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 100;
        gbc.insets = new Insets(5,5,50,5);
        
        playButton.addActionListener(new ActionListener(){
                  
            @Override
            public void actionPerformed(ActionEvent e){
                if(chUsername!=null && file!=null){
                  pane.deleteContent();
                    
                  // pane.invalidate();
                   pane.gameContainer();
                }
                else{
                    if(chUsername==null && file==null){
                        JOptionPane.showMessageDialog(pane,"Καταχώρησε όνομα για να συνεχήσεις\nΚαι επέλεξε αρχείο");
                    }
                    else if(chUsername==null){
                        JOptionPane.showMessageDialog(pane,"Καταχώρησε όνομα για να συνεχήσεις");
                    }
                    else if(file==null){
                        JOptionPane.showMessageDialog(pane,"Επέλεξε αρχείο");
                    }
                }
            }
        });
        
        
        userPanel.add(playButton,gbc);
        gbc.ipadx = 0;
        pane.add(picLabel,BorderLayout.NORTH);
        pane.add(userPanel,CENTER);
        setPreferredSize(new Dimension(1000,1000));
        this.setVisible(true);
    }
    public  static File getFile(){
        return file;
    }
    public static  String getUsername(){
        return chUsername;
    }
}
