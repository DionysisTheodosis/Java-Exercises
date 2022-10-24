/*Dionysis Theodosis A.m:321/2015066
skhsh 4*/
package main;

//klash tragoudi 
public class Tragoudi { 
    private  String titlos; //dilwsh metavlitis string gia ton titlo tou tragoudiou
    private  String kallitexnhs;//dilwsh metavlitis string gia to onoma tou kallitexni tou tragoudiou
    private  String album;//dilwsh metavlitis string gia to album tou tragoudiou
    private  int diarkeia;//dilwsh metavlitis string gia thn diarkeia tou tragoudiou
   
    public Tragoudi(){  //constructor gia thn dimiourgia antikeimenwn klashs
    }
    public Tragoudi(String onomatr,String onomakal,String almpoum,int xronos){  //2os constructor gia thn arxikopoihsh twn metavlitwn 
        titlos=onomatr; //eisagei to onoma pou pernei sthn metavlith onoma ths klashs
        kallitexnhs=onomakal;
        album=almpoum;
        diarkeia=xronos;
    }
    public String getTitlos(){//synartish gia na epistrefei ton titlo tou tragoudiou
        return titlos;
    }
    public String getKallitexnhs(){//synartish gia na epistrefei ton kallitexnh tou tragoudiou
        return kallitexnhs;
    }
    public String getAlbum(){//synartish gia na epistrefei to album
        return album;
    }
    public int getDiarkeia(){//synarthsh gia na epistrefei thn diarkeia
        return diarkeia;
    }
    public void setTitlos(String onomatr){ //synartish h opoia pernei timh gia to onoma tou tragoudiou wste na to allaxei
        titlos=onomatr;
    }
    public void setKallitexnhs(String kali){//synartish h opoia pernei timh gia to onoma tou kallitexnh tou tragoudiou wste na to allaxei
        kallitexnhs=kali;
    }
    public void setAlbum(String almpoum){//synartish h opoia pernei timh gia to album tou tragoudiou wste na to allaxei
        album=almpoum;}
    public void setDiarkeia(int xronos){ //synartish h opoia pernei timh gia thn diarkeia tou tragoudiou wste na thn allaxei
        diarkeia=xronos;
    }
    public void print(){ //synarthsh h opoia ektypwnei ths metavlhtes ths klashs
        System.out.println(titlos+kallitexnhs+album+diarkeia);
    }
}