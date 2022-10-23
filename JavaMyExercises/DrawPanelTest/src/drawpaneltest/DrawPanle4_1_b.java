
package drawpaneltest;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanle4_1_b extends JPanel {
    public void paintComponent(Graphics g){
       super.paintComponent(g);
        
       int  width = getWidth();
       int height = getHeight();
       height=0;
       int  c = width/15;
       g.drawLine(0, 0, width,0);
       g.drawLine(width, 0, getWidth(),getHeight());
       for(int i=0;i<15;i++){
            g.drawLine(0, 0, width-=c,height+=c);
            g.drawLine(width,height ,getWidth(),getHeight());
        }
        height= getHeight();
        width=getWidth();
        g.drawLine(0,getHeight(),width,height);
        g.drawLine(width,height ,getWidth(),0);
        for(int i=0;i<15;i++){          
            g.drawLine(0,getHeight(),width-=c,height-=c);
            g.drawLine(width,height ,getWidth(),0);
         
        }
    }
}