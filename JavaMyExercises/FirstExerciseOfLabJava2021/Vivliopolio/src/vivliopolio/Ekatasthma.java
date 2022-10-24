/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package vivliopolio;
//eisagwgh twn katalhlwn vivliothikwn ths java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ekatasthma {
    private String webPage;//dilwsh ths metavlitis gia thn istoselida
    private String phone;//dilwsh ths metavlitis gia to thlefwno
    private String email;//dilwsh ths metavlitis gia to email
    ArrayList<Proion>product=new ArrayList<Proion>();//dilwsh arraylist gia thn dimourgia listas twn proiontwn pou tha diaxeirizete to katasthma
    HashSet<String> category = new HashSet<String>();//dilwsh hashet gia thn dimiourgia ths category h opoia tha mas voithisei gia thn apofygh twn diplotypwn 
    ArrayList<Proion>product2=new ArrayList<Proion>();//dilwsh arraylist gia thn thn voithia sto na emfanisoume to proion ana kathgoria me mikroterh timh
    public Ekatasthma(String webPage,String phone,String email){//o constructor gia to katasthma
        this.webPage=webPage;//xrhsimopoioume thn this. gia na ginei swsta h eisagwgh 
        this.phone=phone;
        this.email=email;
    }
    public String toString(){ //me auto ton tropo tha emfanizoume tis idiothtes tou katasthmatos
        return "Istoselida: "+webPage+" Thlefwno: "+phone+" email: "+email;
    }
    public void newProduct(String category,double price,String description){//synartish gia thn prosthiki enos neou proiontos
        Proion a=new Proion(category,true,price,description);//prosthiki tou prointos me dimiourgia antikeimenou
        product.add(a); //prosthiki tou antikeimenou sthn lista proiontwn
    }
 
   public void changeAvailable(String a,String productNumber){//synartisi gia thn allagh ths katastash
       int temp=0; //dilwsh kai arxikopoihsh metavlitis temp
        for(int i=0;i<product.size();i++){ //epanalipsi gia thn prospelash olwn twn proiontwn
            if(product.get(i).getProductNumber().equals(productNumber)){//elgxei gia na vrei to proion me auto ton kwdiko proiontos
                    temp=i;//vazei sthn temp thn thesh pou vriskete to proion sthn lista
        }
        }
        if(a=="n"){ //elgexgei an auto pou edwse o xrhsths einai oxi
            product.get(temp).notAvailable();//tote allazei to proion se mh diathesimo kallontas ths synartish
        }
        else
        {
           product.get(temp).available();//alliws to allazei se diathesimo
        }
   }
   public void printProductOfCategory(String category){//synartisi gia thn ektypwsh proiontos sygkekrimenhs kathgorias
       for(int i=0;i<product.size();i++){ //loop gia na prospelash ola ta proionta ths listas
        if(product.get(i).getCategory().equals(category)){ //an h kathgoria pou exei dwsei isoute me thn kathgoria tou proiontos
            System.out.println(product.get(i));//ektypwnh to proion sthn thesh pou vethike
        }
   }}
   public void printProductOfCategoryWithMinPriceOf(String category,int price){//synartisi gia thn ektypwsh proiontos syskekrimenhs kathgoria me timh mikroterh ths dosmenhs
       for(int i=0;i<product.size();i++){//prospelash olwn twn stoixeiwn ths listas
           if((product.get(i).getCategory().equals(category))&&(product.get(i).getPrice()<price)){//an h kathgoria einai idia kai th timi mikroterh apo auth pou exei dwsei
               System.out.println(product.get(i));//ektypwnei to proion pou vriskete sthn thesh ths listas i
           }
       }
   }
   public void availableProducts(){ //synartisi gia thn ektypwsh olwn twn diathesimwn proiontwn
       for(int i=0;i<product.size();i++){//loop gia thn prospelash olwn twn proiontwn ths listas
           if(product.get(i).getAvailable()==true){ //elegxei an to proion einai available
               System.out.println(product.get(i));//tote ektypwnh to proion pou vriskete sthn thesh i ths listas product
           }
       }
   }
    public void emfanishEconomyProducts(){ //sunartish gia thn emafanish twn oikonomikwn proiontwn ana kathgoria
       
        category.add(product.get(0).getCategory());        //vazoume sthn prwth thesh ths category pou einai typou hashset thn kathgoria tou proiontos pou vriskete sthn prwth thesh ths listas product,etsi wste na exoume oles tis kathgories apo  mia fora gia auto xrhsimopoioume thn category 
          for(int i=0;i<product.size();i++){//gemizoume thn category me tis katigories twn proiontwn
                    category.add((product.get(i).getCategory()));    
                }         
        int t=0;//arxikopoihsh metavlitis t pou tha mas dinei thn thesh tou proiontws gia thn ektypwsh tou
          for(String j:category){//loop gia thn prospelash olwn twn kathgoriwn
            for(int i=0;i<product.size();i++){//loop gia thn prospelash olwn twn proiontwn,thn xrhsimopoioume gia na dhmiourgisoume ena neo array list typou proion wste na apothikeuoume ta proionta idias kathgorias wste na epilexoume meta auta me thn mikroterh timh
                   if((product.get(i).getCategory().equals(j))==true){//edw vlepoume an h kathgoria einai idia me thn kathgoria tou proiontos sthn thesh ths listas i
                        product2.add(product.get(i));//tote prosthetoume to proion sthn product 2
                    }
            }
            for(int i=0;i<product2.size()-1;i++){ //loop gia thn epilogh ths elaxisths timis,kai epidh tha kanoume gia i+1 gia na trexei dilwnoume size-1
                if(product2.get(i).getPrice()<product2.get(i+1).getPrice()){//elegxos gia to ean h timh tou proiontos sthn thesh i einai mikroterh tou epomenou
                    t=i;//tote sto t vazoume to i
                }
            }
              if(product2.size()==1){//edw elegxoume an yparxei ena proion me auth thn kathgoria tote
                    t=0; // to t ginete 0 gia na emfanisthei swsta h thesh
                }
          System.out.println("Giathn kathgoria: "+j+"  To oinomikotero proion einai to:");//ektypwsh ths kathgoria pou einai to j
          System.out.println(product2.get(t));//ektypwsh tou proiontos
          product2.clear();//edw kanoume mhdenizoume thn arraylist gia na thn xrhsimopoihsoume meta me ton idio tropo alliws tha eixe kai ta lla dedomena ths allhs listas
          }
            System.out.println();//ektypwnoume ena keno xarakthra
    }
   public void display(){//synartish gia thn emfanish twn proiontwn
       System.out.println(product);
   }
}
