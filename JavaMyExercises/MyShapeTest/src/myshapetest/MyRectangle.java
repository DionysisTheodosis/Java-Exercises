
package myshapetest;

import java.awt.Color;
import java.awt.Graphics;


public class MyRectangle extends MyShape {
    private boolean fill;
    
    public MyRectangle(){
        super();
        fill=false;
    }
    public MyRectangle(int x1,int y1,int x2,int y2,Color color,boolean fill){
        super(x1,y1,x2,y2,color);
        this.fill=fill;
    }
    public void setFill(boolean fill){
        this.fill=fill;
    }
    public boolean getFill(){
        return fill;
    }
    
    private int getWidth(){
       int width = getX2()-getX1();
       return Math.abs(width);
    }
    private int getHeight(){
       int  height = getY2()-getY1();
       return Math.abs(height);
    }
    @Override
    public  void draw(Graphics g){
        g.setColor(getColor());
        if(getFill()){
            g.fillRect(getX1(), getY1(),getWidth(), getHeight());
        }
        else{
            g.drawRect(getX1(), getY1(),getWidth(), getHeight());
        } 
    }

}
