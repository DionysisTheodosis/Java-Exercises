//Deitel Example page 228
package drawsmileytest;

import javax.swing.JFrame;


public class DrawSmileyTest {

  
    public static void main(String[] args) {
        DrawSmiley panel = new DrawSmiley();
        JFrame application = new JFrame();
    
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(230,230);
        application.setVisible(true);
    }
    
}
