package exercise2;

public class Team {
    private final String name;
    private final String country;
    private int points;
    
    public Team(String name,String country){
        this(name,country,0);
    }
    
    public Team(String name,String country,int points){
        this.name = name;
        this.country = country;
        this.points = points;
    }
    
    public void setPoints(int points){
        this.points = points;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCountry(){
        return country;
    }
    
    public int getPoints(){
        return points;
    }
    
    @Override
    public String toString(){
        return name+" "+points+" "+country;
    }
}
