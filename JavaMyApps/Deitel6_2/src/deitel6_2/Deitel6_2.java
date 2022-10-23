//EXERCISE 6.2 FROM BOOK OF DEITEL PAGE 229
package deitel6_2;

import javax.swing.JFrame;
        
public class Deitel6_2 {

   
    public static void main(String[] args) {
        
        DrawShapes panel = new DrawShapes();
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(360,360);
        application.setVisible(true);
    }
    
}
