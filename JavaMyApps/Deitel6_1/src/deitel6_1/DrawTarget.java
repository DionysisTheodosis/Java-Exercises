package deitel6_1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class DrawTarget extends JPanel{
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        SecureRandom randomNumbers = new SecureRandom();
         int red1 = randomNumbers.nextInt(250);
         int blue1 = randomNumbers.nextInt(250);
         int green1 = randomNumbers.nextInt(250);
         int red2 = randomNumbers.nextInt(250);
         int blue2 = randomNumbers.nextInt(250);
         int green2 = randomNumbers.nextInt(250);
       
        int temp_width = 30;
        int width = getWidth();
        int height = getHeight();
        int temp_height = 30;
        int x= (width/2);                        ;
        int y = (height/2);
       final Color firstColor = new Color(red1,green1,blue1);
        
       final Color secondColor = new Color(red2,green2,blue2);
        
        for(int i=0;i<5;i++){
            if(i%2==1){
                 g.setColor(firstColor);
                 System.out.println(firstColor);
            }
            else{
                g.setColor(secondColor);
                 System.out.println(secondColor);
            }
          g.fillOval(temp_width*i,temp_height*i,(x-(temp_width*i))*2,(y-(temp_height*i))*2);
        }
        
 

      
    }
}
