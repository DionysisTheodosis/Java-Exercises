
package drawpaneltest;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel4_1_a extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int  width = getWidth();
        int height = getHeight();
        
        width=0;
        g.drawLine(0, 0, 0, height);
        int c =height/15;
        for (int i=1;i<15;i++){
            g.drawLine(0, 0, width=width +c, height=height-c);
        }
        
    }
}
