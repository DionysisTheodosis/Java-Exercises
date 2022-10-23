/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package vivliopolio;
import java.util.UUID;//to xrhsimopoioume gia na mas dwsei ena id gia to proion mas
public class Proion { //klash proion
    //dilwnoume ths idiothtes ws private
    private String category; //dilwsh kathgorias 
    private boolean available;//dilwsh ths katastashs ws boolean
    private double price; //dilwsh ths timhs
    private String description;//dilwsh ths perigrafhs
    private  String productNumber;//dilwsh tou kwdikou proiontos
    
    public Proion(){ //1os constructor gia thn arxikopoihsh  xwris parametrous
        category="0"; //vazoume sto category to 0
        available=true; //thn katastash thn kanoume ws true oti exei
        price=0.0;//arxikopiohsh ths timhs
        description="0";//arxikopoihsh ths timhs ws 0
        productNumber="0"; //arxikopoihsh tou kwdikou proiontos ws 0
    }
    public Proion(String category,boolean available,double price,String description){//2os constructor me parametrous kathgoria,katastash ,timh,perigrafh
       //xrhsimopoioume to this. giati alliws oi topikes tha episkiazan tis metavlites ths klashs
        this.available=available;
        this.category=category;
        this.description=description;
        this.price=price;
        productNumber=UUID.randomUUID().toString();//arxikopoihsh tou kwdikou proiontws me ena monadiko id

    }
    public boolean getAvailable(){  //xrhsimopoioume thn get dioth einai monodromos gia to ekatasthma,giati alliws den mporoume na kanoume tis antistoixes  methosous,alliws tha ginotan me klhrhnomikothta
        return available;   //epistrefei thn katastash otan einai true
    }
    public String getCategory(){
        return category; //epistrefei thn kathgoria
    }
    public double getPrice(){
        return price;   //epistrefei thn timh
    }
   public String getDescription(){
        return category; //epistrefei thn perigrafh
    }
   public String getProductNumber(){
        return productNumber; //epistrefei ton kwdiko tou proiontos
    }
    public void available(){
        available=true; //metatrepei thn available san true
    }
    public void notAvailable(){
        available=false; //metatrepei thn available ws false
    }
    public void check(){//emafnizei an to proion einai diathesimo h oxi
        if(available==true){
            System.out.println("To proion einai diathesimo");
        }
        else{
            System.out.println("To proion den einai diathesimo");
        }
    }
    public String toString(){ //ektypwnei to proion
        String a="0";//dilwsh string kai arxikopoihsh tou
        if(available==true){//an h metavliti einai true
            a="yes"; //tote vazoume yes gia na ginei pio swsth h ektypwsh
        }
        else {
            a="no"; //tote vazoume no gia na ginei pio swsth h ektypwsh
        }
        return"Katigoria: "+category+"| Diathesimo: "+a+"| Timi: "+price+"| Perigrafh: "+description+"| Kwdikos Proiontos: "+productNumber;//epistrefei gia thn endexomenh ektupwsh tou proiontos
    }
}
   
  

