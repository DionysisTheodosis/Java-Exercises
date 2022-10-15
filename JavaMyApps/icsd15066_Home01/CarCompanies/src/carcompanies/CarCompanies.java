/*Dionysios Theodosis 
A.M 321/2015066
4h Askisi*/

package carcompanies;

import java.util.*;//eisagei tis aparaithtes vivliothikes pou tha xrhsimopoihsoume
import java.util.Map.Entry;//eisagwgh ths entry giati tha thn xrhsimopoihsoume gia na vroume to key vash ths timis
import javax.swing.JOptionPane;//eisagwgh gia na mporesoume na ektypwsoume to parathyro dialogou
public class CarCompanies {
 
    public static void main(String[] args) {
        ArrayList<Car>cars=new ArrayList<>();//arxikopoihsh arraylist gia ta autokinita pou tha exoume ws dedomena typou klash Car
        //eisagwgh antikeimenwn sthn lista cars
        cars.add(new Car("Toyota","Yaris",14000));
        cars.add(new Car("Opel","Corsa",16000));
        cars.add(new Car("Toyota","Aygo",11000));
        cars.add(new Car("Toyota","Corolla",17000));
        cars.add(new Car("Fiat","Panda",12000));
        cars.add(new Car("Opel","Corsa",15500));
        cars.add(new Car("Toyota","Yaris",17000));
        cars.add(new Car("Opel","Astra",19000));
        cars.add(new Car("Fiat","Tipo",12000));
       
        HashMap<String, String> hashMapLista = new HashMap<>();//dilwsh hashmap gia thn sysxetisi tou montelou me thn marka tou autokinitou
        for(int i=0;i<cars.size();i++){//loop gia thn eisagwgh twn dedomenwn sthn hashmaplista
           hashMapLista.put(cars.get(i).getModel(),cars.get(i).getCompany());//eisagwgh twn dedomenwn sthn hashmaplista
          
        }
        TreeSet<String>company=new TreeSet<>();//dilwsh lista Treeset h opoia tha exei tis markes twn autokiniton,xrhsimopoihsh ths giati den pernei diplotypa kai ta taxinomei auomata 
       for(int i=0;i<cars.size();i++){//loop gia thn eisagwgh twn dedomenwn
            company.add(cars.get(i).getCompany());//eisagei thn etaira sthn treeset company
        }
        Iterator<String>Itcompany=company.iterator();//dilwsh iterator,o opoios tha mas voithisei gia na diasxisoume thn lista me tis etairies
        HashSet<String>models1=new HashSet<>();//dilwsh hashset gia thn dimiourgia listas pou tha krataei ta montela
        String lista="";//dilwsh sumvoloseiras pou tha krataei oles tis etairies me tis emfaniseis kai ta montela kai arxikopoihsh ths me keno
        while(Itcompany.hasNext()){//epanalipsi gia kathe etairia
            int count=0;//dilwsh metrith kai arxikopoihsh tou me 0 gia na mas dixnei posa montela exei kathe eteria
            String value=Itcompany.next();//dilwsh metavlitis value pou tha krataei thn etairia gt tha thn xrhsimopoihsoume polles fore sthn epomenh loop ara den ginete me ton iterator
            for (Entry<String, String> entry : hashMapLista.entrySet()) {//loop gua thn euresh twn montelwn kathe etereias me thn xrhsh ths entry giati alliws den mporoume na xrhshmopoihsoume iterator.entryset kai theloume to key k to value 
                if (entry.getValue().equals(value)==true) {//elegxos an einai h idia etairia
                    models1.add(entry.getKey());//eisagwgei tou montelou sthn hashet models1
                    count++;//auxisei tou metriti
                }
            }
            lista+=value+": "+String.valueOf(count)+models1+"\n";//eisagwgh twn stoixeiwn sthn string kai vazoume to"\n" wste na emfanizete h allagh grammhs sto grafiko perivallon
            models1.clear();//edw kanoume clear diagrafoume ta stoixeia ths hashset gt theloume na thn xanaxrhsimopoihsoume
            }
        JOptionPane.showMessageDialog(null,lista);//kai edw ektypwnoume me grafiko tropo thn lista
    }
}
