/*Dionysis Theodosis A.m:321/2015066
Askhsh 3*/
package Main;


public class Erwtisi {  
    private String erotisi; //arxikopoihsh metavliths erotisi tupou string
    private String apantisi;//arxikopoihsh metavliths apantisi tupou string
    private int poso;//arxikopoihsh metavliths poso tupou int
  
    public Erwtisi(){   //constructor wste na mporoume na dimiourgoume antikeimena ths klashs
    }
    public Erwtisi(String erw,String apa,int pontoi){ //constructor gia arxikopoihsh twn metavlitwn tis klashs gia thn dimiourgia erwtisewn
        erotisi=erw;    //ekxwrish twn stoixeiwn pou pernei sths metavlites
        apantisi=apa;
        poso=pontoi;
    }
    public String getErwtisi(){ //synartisei gia na epistrefei thn metavlith erwtisi tupou string
        return erotisi;
    }
    public String getApantisi(){//synartisei gia na epistrefei thn metavlith apantisi tupou string
        return apantisi;
    }
    public int getPoso(){//synartisei gia na epistrefei thn metavlith poso typou int
        return poso;
    }
}
