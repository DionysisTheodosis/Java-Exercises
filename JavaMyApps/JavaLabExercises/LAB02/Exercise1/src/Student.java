
public class Student {
    private String name;
    private String surname;
    private  int  am;
    
    public void setName(String name){
        this.name=name;
}
    public void setSurname(String surname){
        this.surname =surname;
    }
    public void setAm(int am){
        this.am = am;
    }
    @Override
    public String toString(){
        return name + " " + surname + " "+ am;
    }
}
