package deitel6_2;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;
        
public class DrawShapes extends JPanel{
   
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Setting the max Width and Height From the width and height of panel
        int width = getWidth()/2;
        int height = getHeight()/2;
        SecureRandom randomNumbers = new SecureRandom();
        final int OVAL = 0;
        final int RECTANGLE =1;
        
        
        for(int i=0;i<10;i++){
           
            //Random Shape
            int shape = randomNumbers.nextInt(2);
            //Random Colors
            int red = randomNumbers.nextInt(251);
            int green = randomNumbers.nextInt(251);
            int blue = randomNumbers.nextInt(251);
            Color shapeColor = new Color(red, green,blue);
            g.setColor(shapeColor);
            
            //Random Position
            int x = randomNumbers.nextInt(getWidth());
            int y = randomNumbers.nextInt(getHeight());
            
            //Random Size
            int widthOfShape = 1+randomNumbers.nextInt(width);
            int heightOfShape =  1+randomNumbers.nextInt(height);
            //Choosing The Right Shape
            switch(shape){
                case OVAL:
                    g.fillOval(x, y, widthOfShape , heightOfShape);
                    break;                                                   
                case RECTANGLE:
                    g.fillRect(x, y, widthOfShape, heightOfShape);
                    break;
                    
                default:
                    break;
                
            }                  
        }
        
    }
}
