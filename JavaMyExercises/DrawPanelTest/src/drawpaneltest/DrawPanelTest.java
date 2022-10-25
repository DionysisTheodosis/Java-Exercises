//Example of Deitel page 137 and Exercises 4.1 AND 4.2
package drawpaneltest;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import dio.InputChecker;
public class DrawPanelTest {
    public static void main(String[] args) {
        String userInput;
        String menu = "Menu: \n" + 
                "1)Example of book.\n"+
                "2)Exercise 4.1.a .\n"+
                "3)Exercise 4.1.b . \n"+
                "4)Exercise 4.2.a .\n"+
                "5)Exercise 4.2.b . \n"+
                "Dwse Epilogh Apo To 1 Mexri To 5";
        int choice;
        userInput = JOptionPane.showInputDialog(menu);
        choice = InputChecker.checker(menu, userInput, 1,2,3,4,5);
       
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        switch(choice){
           case 1:
               DrawPanel panel = new DrawPanel();
               application.add(panel);
               break;
           case 2:
               DrawPanel4_1_a panel2 = new DrawPanel4_1_a();
               application.add(panel2);
               break;
           case 3:
               DrawPanle4_1_b panel3 = new DrawPanle4_1_b();
               application.add(panel3);
               break;
           case 4:
               DrawPanel4_2_a panel4 = new DrawPanel4_2_a();
               application.add(panel4);
               break;
           case 5:
               DrawPanel_4_2_b panel5 = new DrawPanel_4_2_b();
               application.add(panel5);
               break;
        }
       
       application.setSize(250,250);
       application.setVisible(true);
    }
    
}
