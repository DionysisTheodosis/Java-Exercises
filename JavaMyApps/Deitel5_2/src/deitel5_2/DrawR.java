
package deitel5_2;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawR extends JPanel{
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    
    public DrawR(int a ,int b,int c,int d,int e ){
        

        this.a = a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e; 
    }
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        int t_height = HEIGHT/4,temp_height=HEIGHT;
        g.drawRect(0, 0,a*20,t_height-20);
        g.drawRect(0, t_height,b*20, t_height+20);
        g.drawRect(0, 2*t_height,c*20, t_height);
        g.drawRect(0, 3*t_height,d*20, t_height);
        g.drawRect(0, 4*t_height,e*20, t_height);
       
    }
}
