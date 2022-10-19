
package deitel5_1;
import javax.swing.JFrame;
public class Deitel5_1 {
    
    public static void main(String[] args) {
        CircleDraw panel = new CircleDraw();
        
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300,300);
        application.setVisible(true);
    }
    
}
