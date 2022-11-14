package exercise2;
//KLASH Team H OPOIA KATHORIZEI TA STOIXEIA POU THA EXEI KATHE OMADA
public class Team {
    //METAVLITES KLASHS
    private final String name;//ONOMA OMADAS
    private final String country;//ONOMA XWRAS
    private int points;//PONTOI
    //CONSTRUCTOR O OPOIOS THA ARXIKOPOIOI TOUS PONTOUS ME 0 AN DEN ORISTOUN
    public Team(String name,String country){
        this(name,country,0);
    }
    //CONSTRUCTOR GIA THN ARXIKOPOIHSH TWN METAVLITWN THS OMADAS
    public Team(String name,String country,int points){
        this.name = name;
        this.country = country;
        this.points = points;
    }
   //METHODOI THS KLASHS
    //METHODOS GIA NA ORISEI PONTOUS
    public void setPoints(int points){
        this.points = points;
    }
    //METHODOS GIA NA PAREI TO ONOMA
    public String getName(){
        return name;
    }
    //METHODOS GIA NA PAREI THN XWRA
    public String getCountry(){
        return country;
    }
    //METHODOS GIA NA PAREI TOUS PONTOUS
    public int getPoints(){
        return points;
    }
    
    //METHODOS GIA NA EPISTREPSEI WS STRING OLA TA STOIXEIA KEPIKALYPTODAS TO ONOMA TOU ANTIKEIMENOU
    @Override
    public String toString(){
        return name+" "+points+" "+country;
    }
}
