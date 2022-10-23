
package heartratecalculator;

import java.util.*;
import javax.swing.JOptionPane;

public class HeartRateCalculator {

    public static void main(String[] args) {
       String name = JOptionPane.showInputDialog("Enter Your Name: ");
       String surname = JOptionPane.showInputDialog("Enter Your Surname: ");
       int day = Integer.valueOf(JOptionPane.showInputDialog("Enter The Day Of Your Birth: "));
       int month = Integer.valueOf(JOptionPane.showInputDialog("Enter The Month Of Your Birth: "));
       int year = Integer.valueOf(JOptionPane.showInputDialog("Enter The Year Of Your Birth: "));
   
       HeartRates first = new HeartRates(name,surname,month,day,year);
       JOptionPane.showMessageDialog(null, "Name: "+first.getName()+"\nSurnmame: "+ first.getSurname()+
               "\nBirthday: "+ first.getBirthday()+
               "\nAge: "+ first.getAge()+
               "\nYour Max Heart Rate Must Be : " + first.maxHeartRate()+" PPS.\n"+
               "Your Heart Rate Must Be Between : " +first.heartRateRange()+" PPS.");
      }
    
}
