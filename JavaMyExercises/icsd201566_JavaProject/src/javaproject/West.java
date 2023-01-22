
package javaproject;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

//KLASH GIA TO ARISTERO PANEL GIA THN DIATAXH STO FRAME
public class West extends JPanel{
    private  PinakasJPanel table; //ANTIKEIMENO TOU PANEL TOU PINAKA
    private final SearchJP search; // ANTIKEIMENO TOU PANEL TOU KOMPIOU ANAZHTHSHS
    
    //CONSTRUCTOR THS KLASHS POU PAIRNEI TO FRAME KAI TON PINAKA TWN XARAKTHRWN
    public West(ArrayList<Cell> arr,MyFrame frame){
       setLayout(new BorderLayout());//VAZEI THN DIATAXH
       table = new PinakasJPanel(arr,frame);
       search = new SearchJP(frame);
       //TA EISAGEI STO PANEL
       this.add(table,BorderLayout.NORTH);
       this.add(search,BorderLayout.CENTER);
    }
    //EPISTREFEI TO PANEL TOU PINAKA
    public PinakasJPanel getPinakasJPanel(){
        return table;
    }
   
}
