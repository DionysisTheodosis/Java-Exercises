
public class CarInsurancePolicy {
    private int policyNumber; 
    private int paymentsNumber; 
    private String residentCity;
    
    public CarInsurancePolicy(int number, int payments, String city) {
        policyNumber = number;
        paymentsNumber = payments;
        residentCity = city;
    }
    public CarInsurancePolicy(int number, int payments) {
        this(number,payments,"Αθήνα");
    }
    public CarInsurancePolicy(int number) {
        this(number,2,"Αθήνα");
    }
    public void display(){
        System.out.println("Policy Number: "+policyNumber+
                "\nPayment Number: "+ paymentsNumber+
                "\nResidents City: " + residentCity+"\n");
    }   

}
