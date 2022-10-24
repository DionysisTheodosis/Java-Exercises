/*Dionysios Theodosis 
A.M 321/2015066
4h Askisi*/
package carcompanies;
public class Car {//h klash gia to autokinito
    private String company;//dilwsh metavlitis gia thn etairia
    private String model;//dilwsh metavlitis gia to montelo
    private double price;//dilwsh metavlitis gia thn timi
    
   public Car(){//constructor gia na gemisei arxika otan den tha exei parametrous me 0
       company="0";
       model="0";
       price=0.0;
   }
   public Car(String company,String model,double price){//constructor otan tha pernei tis parametrous
       this.company=company;//edw me thn this. den tha mperdeutei
       this.model=model;
       this.price=price;
   }
   public String getCompany(){//methodos gia na epistrefoume thn metavliti gia etairia
       return company;
   }
   public String getModel(){//methodos gia na epistrefoume thn metavliti gia to montelo
       return model; 
   }
   public double getPrice(){//methodos gia na epistrefoume thn metavliti gia thn timi
       return price;
   }
   public String toString(){//methodos gia thn ektypwsh twn stoixeiwn tou autokinitou
       return "Etairia: "+company+" Montelo: "+model+" Timi: "+price;
   }
  
}
