package deitel7_1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawLineSpiral extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int height = getHeight()/2;
        int width = getWidth()/2;
        int size = getWidth()/36;
        while(size<=getHeight()){
            //DOWN
            g.drawLine(width, height, width, height+=size);
            //LEFT
            g.drawLine(width, height, width-=size, height);
            //INCREASE SIZE OF LINE
            size*=2;
            //UP
            g.drawLine(width, height, width, height-=size);
            //RIGHT
            g.drawLine(width, height, width+=size,height);
            //INCREASE SIZE OF LINE
            size*=2;
        }
    }
}
