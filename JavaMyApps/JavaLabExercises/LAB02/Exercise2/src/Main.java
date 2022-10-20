
public class Main {

    
    public static void main(String[] args) {
        CarInsurancePolicy car1 = new  CarInsurancePolicy(265956);
        CarInsurancePolicy car2 = new  CarInsurancePolicy(158659,6);
        CarInsurancePolicy car3 = new  CarInsurancePolicy(986585,9,"Thessaloniki");
        
        car1.display();
        car2.display();
        car3.display();
    }
    
}
