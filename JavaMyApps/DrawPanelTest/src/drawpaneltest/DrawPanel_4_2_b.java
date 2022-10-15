package drawpaneltest;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel_4_2_b extends JPanel {
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
        width = 0;
        height = 0;
        while(height<getHeight()){
         g.drawLine(width, 0, getWidth(),height+=c);
          width+=c;
        }
        width = 0;
        height = getHeight();
        while(height>=0){
         g.drawLine(0, height,width+=c,0);
         height-=c;
        }
        width = 0;
        height = getHeight();
        while(width<getWidth()){
         g.drawLine(width, getHeight(),getWidth(),height-=c);
         width+=c;
        }
     
   
    }
}
