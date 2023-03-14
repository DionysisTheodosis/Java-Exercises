package exercise01;
import java.io.Serializable;

//KLASH H OPOIA YLOPOIH TON TYPO TOU DWMATIOU  PAREXONTAS KAI TO KOSTOS GIA KATHE TYPO
public class Room implements Serializable{//KANOUME IMPLEMNT THN SERIALIZABLE DIOTI THELOUME NA APOTHYKEUETE SE ARXEIO
    //DILWSH METAVLITWN
    private int numberOfBeds;//H EPILOGH TOU TYPOU
    private double cost;//TO KOSTOS GIA TON TYPO
    //CONSTRUCTOR THS KLASHS
    public Room(int choice){//DEXETE THN EPILOGH
        switch(choice){//ANALOGOS THN EPILOGH DINEI THN TIMH
            case 1://GIA MONOKLINO
                this.numberOfBeds = 1;
                cost = 50;
                break;
            case 2://GIA DIKLINO
                this.numberOfBeds = 2;
                cost = 65;
                break;
            case 3://GIA TRIKLINO
                this.numberOfBeds = 3;
                cost = 70;
                
        }
    }
    //METHODOS POU EPISTREFEI TON TYPO
    public int getNumberOfBeds(){
        return numberOfBeds;
    }
    //METHODOS POU EPISTREFEI TO KOSTOS
    public double getCost(){
        return cost;
    }
}
