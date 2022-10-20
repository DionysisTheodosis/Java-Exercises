
package deitel5_2;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Deitel5_2 {

  
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("Dwse enan Arithmo");
        String b = JOptionPane.showInputDialog("Dwse enan Arithmo");
        String c = JOptionPane.showInputDialog("Dwse enan Arithmo");
        String d = JOptionPane.showInputDialog("Dwse enan Arithmo");
        String e = JOptionPane.showInputDialog("Dwse enan Arithmo");
        for(int i =0;i<Integer.parseInt(a);i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i =0;i<Integer.parseInt(b);i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i =0;i<Integer.parseInt(c);i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i =0;i<Integer.parseInt(d);i++){
            System.out.print("*");
        }
        System.out.print("\n");
        for(int i =0;i<Integer.parseInt(e);i++){
            System.out.print("*");
        }
        DrawR panel = new DrawR(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c),Integer.parseInt(d),Integer.parseInt(e));  
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300,300);
        application.setVisible(true);
    }
    
}
