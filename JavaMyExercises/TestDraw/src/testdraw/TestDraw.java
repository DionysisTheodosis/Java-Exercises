// EXERCISE 8.10 - 9.1 FROM BOOK OF DEITEL PAGE 351 AND PAGE 390
package testdraw;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class TestDraw {

    public static void main(String[] args) {
        DrawPanel panel = new DrawPanel();
        JFrame app = new JFrame();
      
        JLabel status = new JLabel(panel.getLabel()); //FOR EXERCISE 9.1
        
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.add(status,BorderLayout.SOUTH); //FOR EXERCISE 9.1
        app.setSize(600,600);
        app.setVisible(true);
    }
    
}
