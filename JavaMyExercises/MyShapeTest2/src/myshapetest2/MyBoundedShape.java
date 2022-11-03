package myshapetest2;

import java.awt.Graphics;
import java.awt.Color;
public abstract class MyBoundedShape extends MyShape{
    private    boolean fill;
    
    public MyBoundedShape(){
        super();
        this.fill = false;
    }
    
    public MyBoundedShape(int x1,int y1,int x2,int y2,Color color,boolean fill){
        super(x1,y1,x2,y2,color);
        this.fill=fill;
    }
    public void setFill(boolean fill){
        this.fill=fill;
    }
    public boolean getFill(){
        return fill;
    }
    public int getWidth(){
       int width = getX2()-getX1();
       return Math.abs(width);
    }
    public int getHeight(){
       int  height = getY2()-getY1();
       return Math.abs(height);
    }
    @Override
    public abstract void draw(Graphics g);
}
