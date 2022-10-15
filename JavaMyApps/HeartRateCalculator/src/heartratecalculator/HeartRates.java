package heartratecalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class HeartRates {
    
    private String name;
    private String surname;
    private String birthday;
    
    public HeartRates(String name,String surname,int month,int day,int year){
        this.name=name;
        this.surname=surname;
        birthday= String.format("%d-%d-%d",day,month,year);
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setSurname(String surname){
        this.surname= surname;
    }
    
    public void setBirthday(int month,int day,int year){
        birthday= String.format("%d-%d-%d",day,month,year);
    }
    public String getBirthday(){
        return birthday;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public int getAge(){
        LocalDate dt =  LocalDate.now();
        int a = dt.getYear();
        int year= 0 ;
        Pattern p = Pattern.compile("\\d{4}");
        Matcher matcher = p.matcher(birthday);
        while(matcher.find()){
            year = Integer.valueOf(matcher.group());
        }
        return (a - year);
    }
    
    public int maxHeartRate(){
        int maxHeartRateVar = 220 - getAge();
        return maxHeartRateVar;
    }
    
    public String heartRateRange(){
        double min_heartRateRangeVar = (0.5)*(maxHeartRate());
        double max_heartRateRangeVar = (0.85)* maxHeartRate();
        return (String.format("[%.0f-%.0f]",min_heartRateRangeVar,max_heartRateRangeVar));
                
    }
    
}
