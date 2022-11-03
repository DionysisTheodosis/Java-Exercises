//EXERCISE 10.2 FROM BOOK DEITEL AND DEITEL PAGE 435 AS 10.1 BUT WITH MORE ABSTRACT CONCEPT
package myshapetest2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyShapeTest2 {

    public static void main(String[] args) {
        String numberOfShapes = JOptionPane.showInputDialog("Enter The Number Of Shapes That You Want To Make\n");
        DrawPanel panel = new DrawPanel(Integer.parseInt(numberOfShapes));
        JFrame app = new JFrame();
      
        JLabel status = new JLabel(panel.getLabel()); 
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.add(status,BorderLayout.SOUTH); 
      
        app.setSize(600,600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
