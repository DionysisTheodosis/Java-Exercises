
package testdraw;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
public class MyRectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private boolean fill;
    
    public MyRectangle(){
        x1=0;
        y1=0;
        x2=0;
        y2=0;
        color=Color.BLACK;
        fill=false;
    }
    public void setX1(int x1){
        this.x1=(0<=x1?x1:0);
    }
    public void setY1(int y1){
        this.y1=(0<=y1?y1:0);
    }
    public void setX2(int x2){
        this.x2=(0<=x2?x2:0);
    }
    public void setY2(int y2){
        this.y2=(0<=y2?y2:0);
    }
    public void setFill(boolean fill){
        this.fill=fill;
    }
    public void setColor(Color color){
        this.color=color;
    }
     public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public boolean getFill(){
        return fill;
    }
    public Color getColor(){
        return color;
    }
    public int getUpperLeftX(){
        
        return x1<x2?x1:x2;
        
    }
    public int getUpperLeftY(){
        return y1<y2?y1:y2;
    }
    public int getWidth(){
       int width = x2-x1;
       return Math.abs(width);
    }
    public int getHeight(){
       int height = y2-y1;
       return Math.abs(height);
    }
  public void draw(Graphics g){
        g.setColor(getColor());
        if(getFill()){
            g.fillRect(getX1(), getY1(),getWidth(), getHeight());
        }
        else{
            g.drawRect(getX1(), getY1(),getWidth(), getHeight());
        } 
    }
}
