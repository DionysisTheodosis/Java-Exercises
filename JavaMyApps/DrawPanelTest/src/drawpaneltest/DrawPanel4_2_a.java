
package drawpaneltest;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel4_2_a extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int  width = getWidth();
        int height = getHeight();
        
       int  c = width/15;
       width=0;
       height=0;
       while(width<getWidth()){
           g.drawLine(0, height, width+=c,getHeight());
           height+=c;
       }
        
    }
        
    }

