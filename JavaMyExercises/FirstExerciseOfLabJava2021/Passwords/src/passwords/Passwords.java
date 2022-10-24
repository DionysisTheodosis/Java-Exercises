/*Dionysios Theodosis
  A.M:321/2015066
  Askisi 3
*/
package passwords;
import javax.swing.JOptionPane;//eisagwgh ths vivliothikis gia thn grafiki ekxwrisi- ektypwsh
public class Passwords {
    public static void main(String[] args) {
       int a=Integer.parseInt(JOptionPane.showInputDialog("Dwse to arithmo twn kwdikown pou theleis na paraxthoun"));//arxikopoihsh kai dilwsh metavlitis a:arithmmo kwdikwn gia thn eisodo apo ton xrsth ,kai epidi einai typou string thn allazoume se int thn timh
       int b=Integer.parseInt(JOptionPane.showInputDialog("Dwse plithos xarakthrwnpou tha periexontai ston kwdiko megalutero h iso me 4"));//arxikopoihsh kai dilwsh metavlitis b:arithmo xarakthrwn gia thn eisodo apo ton xrsth ,kai epidi einai typou string thn allazoume se int thn timh
       PasBuilder kwdikoi=new PasBuilder(a,b);//dimiourgeia kai arxikopoihsh tou antikeimenou kwdikoi
       kwdikoi.build();//dhmiourgeia twn kwdikwn
       kwdikoi.display();//emfanisi kwdikwn
    }
    
}
