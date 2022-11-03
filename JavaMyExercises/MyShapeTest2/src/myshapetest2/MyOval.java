package myshapetest2;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {
    
    public MyOval(){
        super();
    }
    
    public MyOval(int x1,int y1,int x2,int y2,Color color,boolean fill){
        super(x1,y1,x2,y2,color,fill);
    }
    
    @Override
    public  void draw(Graphics g){
        g.setColor(getColor());
        if(getFill()){
            g.fillOval(getX1(), getY1(),getWidth(), getHeight());
        }
        else{
            g.drawOval(getX1(), getY1(),getWidth(), getHeight());
        } 
    }
}

