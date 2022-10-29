
package testdraw;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    private SecureRandom randomNumbers = new SecureRandom();
    private MyLine[] lines;
    private MyOval [] ovals;
    private MyRectangle [] rectangles;
    private static int width;
    private static int height;
    
    public DrawPanel(){
        setBackground(Color.WHITE);
        lines = new MyLine[1 + randomNumbers.nextInt(5)];
        ovals = new MyOval[1 + randomNumbers.nextInt(5)];
        rectangles = new MyRectangle[1 + randomNumbers.nextInt(5)];
        
        for(int count = 0;count<lines.length;count++){
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);
            
            Color color = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));
            lines[count] = new MyLine();
            lines[count].setX1(x1);
            lines[count].setX2(x2);
            lines[count].setY1(y1);
            lines[count].setY2(y2);
            lines[count].setColor(color);
            
        }
        for(int count = 0;count<ovals.length;count++){
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);
            Color color = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));
            boolean fill = randomNumbers.nextBoolean();
            ovals[count]= new MyOval();
            ovals[count].setX1(x1);
            ovals[count].setX2(x2);
            ovals[count].setY1(y1);
            ovals[count].setY2(y2);
            ovals[count].setColor(color);
            ovals[count].setFill(fill);
            
        }
        for(int count = 0;count<rectangles.length;count++){
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);
            Color color = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));
            boolean fill = randomNumbers.nextBoolean();
            rectangles[count]= new MyRectangle();
            rectangles[count].setX1(x1);
            rectangles[count].setX2(x2);
            rectangles[count].setY1(y1);
            rectangles[count].setY2(y2);
            rectangles[count].setColor(color);
            rectangles[count].setFill(fill);
        }
    }
    //For Exercise 9.1
    public String getLabel(){
        return "Lines: "+ lines.length+", "+"Ovals: "+ovals.length+", Rectangles: "+rectangles.length;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(MyLine line : lines){
            line.draw(g);
        }
        for(MyOval oval : ovals){
            oval.draw(g);
        }
         for(MyRectangle rectangle : rectangles){
            rectangle.draw(g);
        }
    }
}
