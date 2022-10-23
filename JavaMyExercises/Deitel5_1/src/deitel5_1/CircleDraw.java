
package deitel5_1;
import java.awt.Graphics;
import javax.swing.JPanel;


public class CircleDraw extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int temp_width = 10;
        int width = getWidth();
        int height = getHeight();
        int temp_height = 10;
        int x= (width/2);
        int y = (height/2);
        for(int i=1;i<13;i++){
            g.drawOval(x-(i*5), y-(i*5),temp_width*i ,temp_height*i);
            
            
        }
        
    }
}
