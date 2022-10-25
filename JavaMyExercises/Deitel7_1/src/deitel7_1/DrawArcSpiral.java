
package deitel7_1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawArcSpiral extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int width = 10;
        int height = 10;
        int x= getWidth()/2;
        int y= getHeight()/2;
        int size = 0;
        
       g.drawArc(x, y,width-=size, height, 0, 180);
       size=5;
       while(y>=0){
           
            g.drawArc(x-=width, y-=size,width*=2, height*=2, 0, -180);
            size*=2;
            g.drawArc(x, y-=size,width*=2, height*=2, 0, 180);
            size*=2;
        }
    }
}
