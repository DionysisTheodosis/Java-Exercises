
package exercise01;

import java.io.Serializable;

//KLASH GIA TA PROSWPIKA STOIXEIA TOU ATOMOU
public class Person implements Serializable {//KANOUME IMPLEMENT THN SERIALIZABLE GIATI THELOUME NA MPOROUME NA TO GRAPSOUME SE ARXEIO
    //DILWSH METAVLITWN KLASHS
    private final String name; //ONOMA
    private final String lastName;//EPWNUMO
    private final String tel;//THLEFWNO
    
    //CONSTUCTOR KAI DEXETE TO ONOMA TO EPITHETO KAI TO THLEFWNO
    public Person(String name,String lastName,String tel){
        //ARXIKOPOIHSH TWN METAVLITWN
        this.name= name;
        this.lastName= lastName;
        this.tel = tel;
    }
    
    //METHODOS GIA THN EPISTROFH TOU ONOMATOS
    public String getName(){
        return name;
    }
    //METHODOS GIA THN EPISTROFH TOU EPWNUMOU
    public String getLastName(){
        return lastName;
    }
    //METHODOS GIA THN EPISTROFH TOU THLEFWNOUI
    public String getTel(){
        return tel;
    }
    
    //METHODOS TOSTRING GIA THN EPISTROFH WS SYMVOLOSEIRA TO ONOMA,EPWNYMO,THL
    @Override
    public String toString(){
        return name+" "+lastName+" "+tel;
    }
}
