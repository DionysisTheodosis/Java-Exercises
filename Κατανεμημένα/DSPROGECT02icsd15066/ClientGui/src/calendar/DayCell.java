/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calendar;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;

//KLASH GIA THN DHMIOURGEIA KOUMPIOU GIA THN MERA
public class DayCell extends JButton {
    //DILWSH METAVLITWN KLASHS
    private Date date; //HMERA
    private boolean isToDay; //AN EINAI H SHMERINH
  
    public DayCell(JButton el) {
        setContentAreaFilled(false);
    }

    //METHODOS GIA THN EISAGWGH THS HMERAS
    public void setDate(Date date) {
        this.date = date;

         
    }
    //METHODOS GIA NA EPISTREPSEI THN HMERA
    public Date getDate() {
        return date;
  
    }
    //METHODOS GIA NA ELEGXEI AN EINAI STON SHMERINO MHNA KAI NA VAZEI ANALOGOS TO PAIDIO TO XRWMA
    public void currentMonth(boolean act) {
        if (act) {
            Calendar al = Calendar.getInstance();
            al.setTime(date);
            //AN EINAI H IDIA HMERA ME SHMERA VAZEI MPLE
            if(Calendar.getInstance().get(Calendar.DATE)== al.get(Calendar.DATE)&&Calendar.getInstance().get(Calendar.MONTH)== al.get(Calendar.MONTH)&&Calendar.getInstance().get(Calendar.YEAR)== al.get(Calendar.YEAR)){
                 setForeground(Color.BLUE);
              
            }
            else{
                 setForeground(new Color(68, 68, 68));//ALLIWS AN EINAI ALLH MERA TOU IDIOU MHNA
            }
           
        } 
        else{//ALLIWS AN DEN EINAI STO SYUGKEKRIMENO MHNA
          setForeground(new Color(169, 169, 169));
        }
    }
    //METHODOS GIA NA THESEI THN MERA WS SHMERA
    public void setAsToDay() {
        isToDay = true; 
        Calendar al = Calendar.getInstance();
        al.setTime(date);
        
        if(Calendar.getInstance().get(Calendar.DATE)== al.get(Calendar.DATE)&&Calendar.getInstance().get(Calendar.MONTH)== al.get(Calendar.MONTH)&&Calendar.getInstance().get(Calendar.YEAR)== al.get(Calendar.YEAR)){
            setForeground(Color.BLUE);//AN EINAI IDIA HMERA ME THN PRAGMATIKH SHMERINH VAZEI MPLE
              
        }
        else{//ALLIWS VAZEI PRASINO PX GIA NA DIXEI TO CHECKIN
             setForeground(Color.GREEN);
        }
        
       
    }

}