//EXERCISE 7.1 FROM BOOK OF DEITEL PAGE 293
package deitel7_1;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Deitel7_1 {
    public static void main(String[] args) {
        int choice;
        final int LineSpiral = 1;
        final int ArcSpiral = 2;
        final String menu= "Choose The kind Of Spiral To Draw:\n Press: 1)For Line Spiral\n Press: 2)For Arc Spiral\n";
        final String tryAgainMessage = "IF You Want To Try Again Press 1 Or Press 0 To Exit";
        String userInput;
    
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        do{
             userInput=JOptionPane.showInputDialog(menu);
             choice = InputChecker.checker(menu,userInput,LineSpiral,ArcSpiral);
           
            switch (choice){
                case ArcSpiral:
                    DrawArcSpiral panelArcSpiral = new DrawArcSpiral();
                    application.add(panelArcSpiral);
                    break;
                    
                case LineSpiral:
                    DrawLineSpiral panelLineSpiral = new DrawLineSpiral();
                    application.add(panelLineSpiral);
                    break;    
            }
            
            application.setSize(150,150);
            application.setVisible(true);
          
        
            userInput= JOptionPane.showInputDialog(tryAgainMessage);
            choice = InputChecker.checker(tryAgainMessage,userInput,1,0);
        }
        while(choice==1);
    }
}
