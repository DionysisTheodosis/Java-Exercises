
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
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        int t=0;
        
        g.drawRect(0, t,a*10, t+=20);
        g.drawRect(0, t+=1,b*10,20);
        g.drawRect(0, t+=21,c*10, 20);
        g.drawRect(0, t+=21,d*10, 20);
        g.drawRect(0, t+=21,e*10, 20);
       
    }
}
