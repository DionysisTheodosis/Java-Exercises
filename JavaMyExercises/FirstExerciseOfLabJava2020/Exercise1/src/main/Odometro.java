/*Dionysis Theodosis A.m:321/2015066*
Askhsh1*/
package Main;

/*Orismos klashs odometro*/
public class Odometro {
    private float mikroKonter; //to konter pou tha mhsenizei kai tha vlepoume thn katanalwsh
    private float megaloKonter;//ta synolika xiliometra
    private float katanalwsh;//metavlith gia thn katanalwsh
    
    public Odometro(){ //constructor gia thn arxikopoihsh twn metavlitwn
        megaloKonter=12200;
        mikroKonter=12200;
        katanalwsh=0;
}
    public void Xiliometra(float x){    //synartisi xiliometra gia thn auxish twn xiliometrwn
        mikroKonter+=x;     //auxanei ta xiliometra me to poso ths metavliths x + ta prohgoumena
        megaloKonter+=x;
    }
    public void Katanalwsh(float y){    //sunarthsh pou ekxwrei thn katanalwsh pou tha parei apo exw
        katanalwsh=y;
}
    public void MidenismosMikrou(){ //synartish gia ton midenismo tou mikrou konter
        mikroKonter=0;
    }
    public float Apwleia(){ //synarthsh pou mas deixnei poso ekapse
        float kaush;
        kaush=(mikroKonter/100)*katanalwsh;
        return kaush;   //epistreufei ti ekapse
    }
    public void print(){    //synartish pou ektypwnei to mikro kai to megalo konter
        System.out.println("MEgalo Konter: "+megaloKonter);
        System.out.println("Mikro Konter: "+mikroKonter);
    }
    
}
