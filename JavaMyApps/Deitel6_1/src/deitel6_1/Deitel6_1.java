//Exercise 6_1 FROM BOOK OF DEITEL JAVA, PAGE 229
package deitel6_1;
import javax.swing.JFrame;

public class Deitel6_1 {

  
    public static void main(String[] args) {
       
        DrawTarget panel = new DrawTarget();
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(230,250);
        application.setVisible(true);
        
        
    }
    
}
