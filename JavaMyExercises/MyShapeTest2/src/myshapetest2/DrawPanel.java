package myshapetest2;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
    private SecureRandom randomNumbers = new SecureRandom();
    private MyShape[] shapes;
    private int numberOfShapes;
    private static final int LINE=1;
    private static final int OVAL=2;
    private static final int RECTANGLE=3;
    
    public DrawPanel(int numberOfShapes){
        this.numberOfShapes=numberOfShapes;
        shapes = new MyShape[numberOfShapes];
        for(int i=0;i<numberOfShapes;i++){
            int randomShape = 1+randomNumbers.nextInt(3);
            int x1 = randomNumbers.nextInt(300);
            int y1 = randomNumbers.nextInt(300);
            int x2 = randomNumbers.nextInt(300);
            int y2 = randomNumbers.nextInt(300);
            Color color = new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),randomNumbers.nextInt(256));
            boolean fill = randomNumbers.nextBoolean();
            
            switch(randomShape){
                case LINE:
                    shapes[i] = new MyLine(x1,y1,x2,y2,color);
                    break;
                case OVAL:
                    shapes[i] = new MyOval(x1,y1,x2,y2,color,fill);
                    break;
                case RECTANGLE:
                    shapes[i] = new MyRectangle(x1,y1,x2,y2,color,fill);
                    break;
            }
        }
    }
    public String getLabel(){
        int lines=0 ;
        int ovals=0 ;
        int rectangles=0 ;
         for(int i=0;i<shapes.length;i++){
             if(shapes[i].getClass().getName().contentEquals("myshapetest2.MyLine")){
                 lines++;
             }
             else if (shapes[i].getClass().getName().contentEquals("myshapetest2.MyOval")){
                 ovals++;
             }
             else{
                 System.out.println(shapes[i].getClass().getName());
                 rectangles++;
             }
         
         }
        return "Lines: "+ lines+", "+"Ovals: "+ovals+", Rectangles: "+rectangles;
    }
    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.WHITE);
        super.paintComponent(g);
         for(MyShape shape : shapes){
             shape.draw(g);
         }
    }
}
