//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package mytools;

import java.awt.Component;
import javax.swing.JComponent;

//KLASH GIA THN DIAGRAFH COMPONENTS
public class  RemoveComponents {  
    //METHODOS GIA THN DIAGRAFH OLWN COMPONENT MESA SE ENA ALLO EKTOS ENOS SYGKEKRIMENOY KAI ANANEWSH TOU PANEL
    private RemoveComponents(){
        
    }
    //METHODOS GIA THN DIAGRAFH OLWN TON COMPONENT EKTOS APO ENA SUGKEKRIMENO
    public static void removeAndKeep(JComponent parentComponent,JComponent componentTokeep){
        Component[] components = parentComponent.getComponents();//DHMIOURGEI MIA LISTA APO COMPONENTS POU PERIEXEI O GONEAS COMPONENT
        for (Component component : components) {//PROSPELNAEI OLA TA COMPONENTS
            if (component != componentTokeep) {//AN DEN VREI TO COMPONENT POU THELOUME NA KRATHSEI
                parentComponent.remove(component);  //DIAGRAFEI TO COMPONENT
                parentComponent.getRootPane().revalidate(); //KANEI VALIDATE TO ARXIKO PANE
                parentComponent.getRootPane().repaint(); //TO KANEI UPDATE
            }
        }
    }
    //METHODOS GIA THN DIAGRAFH OLWN TWN COMPONENT MESA SE ENA ALLO KAI ANANEWSH TOU PANEL
    public static void removeAll(JComponent parentComponent){
                parentComponent.removeAll(); //DIAGRAFEI OLA TA COMPONENTS
                parentComponent.getRootPane().revalidate();  //KANEI VALIDATE TO ARXIKO PANE
                parentComponent.getRootPane().repaint(); //TO KANEI UPDATE
    }
    //METHODOS GIA THN DIAGRAFH SYGKEKRIMENOU COMPONENT MESA SE ENA ALLO KAI ANANEWSH TOU PANEL
    public static void removeSpecific(JComponent parentComponent,JComponent ComponentToRemove){
                parentComponent.remove(ComponentToRemove); //DIAGRAFEI TO SYGKEKRIMENO COMPONENT POU PERIEXETE MESA STON GONEA
                parentComponent.getRootPane().revalidate();  //KANEI VALIDATE TO ARXIKO PANE
                parentComponent.getRootPane().repaint();  //TO KANEI UPDATE
    }
}