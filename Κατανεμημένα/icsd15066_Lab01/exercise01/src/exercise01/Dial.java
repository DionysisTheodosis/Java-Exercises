
package exercise01;

import javax.swing.JDialog;
import javax.swing.JFrame;

//KLASH H OPOIA THA EINAI GIA THN DHMIOURGEIA ENOS PARATHYROU DIALOGOU GIA THN ANAZHTHSH ME KRITHRIO
public class Dial extends JDialog{
    //DILWSH METAVLITWN
    private JFrame frame;//METAVLITI H OPOIA THA KRATAEI TO MAINFRAME 
    private static JDialog c; // METAVLITH GIA NA APOTHYKEUH THN ANAFORA TOU DIALOGOU
    
    //CONSTRUCTOR POU DEXETAI WS ORISMA TO MAINFRAME
    public Dial(JFrame frame){
        this.frame = frame;
        SearchPanel a = new SearchPanel();//DHMIOURGEIA ANTIKEIMENOU SEARCHPANEL
        add(a);    //PROSTHIKEI TOU PANEL STON JDIALOG
        c = this; 
        
        this.setAutoRequestFocus(true);
        this.setModalityType(ModalityType.TOOLKIT_MODAL);//TO THETEI NA EINAI MPROSTA WSTE NA MHN AFINEI THN EPILOGH KATI ALLOU
        this.setAlwaysOnTop(true);   
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(frame);
        setVisible(true);
    }
    //METHODOS GIA NA KLEINEI TO PARATHYRO AN XREIASTEI XWRIS NA KLEISEI APO TO X
    public static void closeDialog(){
        c.dispose();
    }
    
}
