/*Dionysis Theodosis A.m:321/2015066
Askhsh 4*/
package main;
import java.util.ArrayList; //ergaleio ths java gia xrhsh arraylist
import java.util.HashSet; //ergaleio ths java gia dhmiourgia ousiastika listas pou periexei mono mia emfanish enws stoixeiou
import java.util.Scanner;   //ergaleio ths java gia eisagwgh apo to plhktrologio


public class Play_List {
    private String onoma;   //dilwsh onomatos lista
    private String eidos;   //dilwsh eidos listas
    private int plithos;   //dilwsh plithos tragoudiwn listas
    ArrayList<Tragoudi> playList=new ArrayList<>(); //dimiourgia arraylist me onoma playlist tupou tragoudi
   
    public Play_List(){ //constructor listas
        onoma="Lista1"; //eisagwgh timhs sto onomaths listas
        eidos="Rock";   // eisagwgh tou eidous
    
        //dimiourgia antikeimenw gia thn klash tragoudi kai arxikopoihsh tous 
        Tragoudi song1=new Tragoudi("Moneytalks","AC/DC","The Razors Edge",207);
        Tragoudi song2=new Tragoudi("T.N.T","AC/DC","TNT",209);
        Tragoudi song3=new Tragoudi("Stairway to Heaven","Led Zeppelin","Led Zeppelin IV",480);
        Tragoudi song4=new Tragoudi("Thunderstruck","AC/DC","The Razors Edge",271);
        Tragoudi song5=new Tragoudi("Black Dog","Led Zeppelin","Led Zeppelin IV",273);
        Tragoudi song6=new Tragoudi("Detroit Rock City","Kiss","Destroyer",311);
        Tragoudi song7=new Tragoudi("Sweet Child o'Mine","Guns N' Roses"," Appetite for Destruction",301);
        Tragoudi song8=new Tragoudi("I Don't Believe A Word","Motorhead","Overnight Sensation",268);
        Tragoudi song9=new Tragoudi("Paranoid","Black Sabbath","Paranoid",153);
        Tragoudi song10=new Tragoudi("Ace of Spades","Motorhead","Ace of Spades",153);
        //eisagwgei twn dedomenw twn antikeimenwn sthn lista
        playList.add(song1);
        playList.add(song2);
        playList.add(song3);
        playList.add(song4);
        playList.add(song5);
        playList.add(song6);
        playList.add(song7);
        playList.add(song8);
        playList.add(song9);
        playList.add(song10);
        plithos=playList.size();
    }
    public void printStoixeiaListas(){//sunartish gia thn ektypwsh twn stoixeiwn ths klashs-listas
       System.out.println("Onoma Listas: "+onoma);  
       System.out.println("Eidos Listas: "+eidos);
       System.out.println("Arithmos Tragoudiwn: "+plithos);
       System.out.println();   //ektupwnei mia kenh grammh
    }
    public void printLista(){//ektypwnei ta dedomena ths listas
        for(int i=0;i<playList.size();i++){
           System.out.println("Titlos: "+playList.get(i).getTitlos());  //ektypwsh tou titlou tou tragoudiou
           System.out.println("-- Kallitexnhs: "+playList.get(i).getKallitexnhs());
           System.out.println("-- Album: "+playList.get(i).getAlbum());
           System.out.println("-- Diarkeia: "+playList.get(i).getDiarkeia()+"sec");
           System.out.println();
           System.out.println();
        }
    }
   public void emfanishKallitexnwn(){
        HashSet<String> mySet=new HashSet<>();//dimiourgia hashet antikeimenou tipou string
        for(int i=0;i<playList.size();i++){ //epanalipsh gia na gemisei thn lista hashet me ta dedomena ths playList ths metavliths kallitexnhs
            mySet.add(playList.get(i).getKallitexnhs());   //eisagwgh tou kalitexnh sthn myset lista
        }
        System.out.println("Oi kallitexnes poy symmetexoun einai oi: ");//ektypwsh katallhlou munhmatos
        System.out.println(mySet);//ektypwnh thn lista myset
        System.out.println();    //ektupwnei mia kenh grammh     
        
    }
    public void emfanishAlbum(){    //to idio me thn emfanish kallitexnh
        HashSet<String> mySet=new HashSet<>();
        for(int i=0;i<playList.size();i++){
            mySet.add(playList.get(i).getAlbum());   
        }
        System.out.println("Ta Album pou vriskontai stin lista einai: ");
        System.out.println(mySet);
        System.out.println();         
        
    }
    public void diorthwshlistas(String track){  //synartish gia epexergasia twn stoixeiwn ths playList listas
        Scanner scan=new Scanner(System.in);//dilwsh antikeimenou gia eisagwgh apo plhktrologio
        int epilogh,answer; //dilwsh metavlitwn pou tha xrhsimopoihsoume gia na apothikeusoume tis times pou tha paroume
        char temp;
        String c;
        int index=0;//dilwsh metavliths deikti ton opoio ton xrhsimopoioume gia na pame sthn katallhlh thesh gia thn epexergasia olwn twn stoixeiwn
        for(int i=0;i<playList.size();i++){//epanalhpsh pou psaxnei na vrei se poia thesh ths listas vrisketai to tragoudi pou phre san parametro
            if(playList.get(i).getTitlos().equalsIgnoreCase(track)){//synthikh h opoia an h metavlith pou phre einai hsh xwris xase sensitive tote sto index vazei thn thesh
                index=i;
            }
        }
        do{//epanalipsi mexri na mhn thelei na diorthwsei kati allo sto tragoudi
            //menu epilogwn
            System.out.println("Epelexe ti thes na allaxeis plhktrologwntas ton arithmo apo to menu");
            System.out.println("1) Metanomasia Titlou");
            System.out.println("2) Metanomasia Kallitexnh");
            System.out.println("3 )Metanomasia Album");
            System.out.println("4) Allagh Diarkeias");
            System.out.print("Edw:");
            do{//elgxos gia thn swsth eisagwgh
                epilogh=scan.nextInt();
            }
            while(epilogh<=0 && epilogh>4); 
            scan.nextLine();//gia na diagrapsei tuxon upoloimata
            //switch h opoia analoga me thn apanthsh kanei kai ta parakatw
            switch(epilogh){
                case 1://allagh titlou
                    System.out.println("Dwse ton neo titlo");
                    c=scan.nextLine();                          //eisagwgh apo plhktrologio tou neou tilou tou tragoudiou
                    playList.get(index).setTitlos(c);           //eisagwgh tou sthn lista 
                    break;
                case 2:
                    System.out.println("Dwse ton neo Kallitexnh");
                    c=scan.nextLine();                          //eisagwgh apo plhktrologio tou neou kallitexnh tou tragoudiou
                    playList.get(index).setKallitexnhs(c);      //eisagwgh tou sthn lista 
                    break;
                case 3:
                    System.out.println("Dwse to neo Album");
                    c=scan.nextLine();
                    playList.get(index).setAlbum(c);
                    break;
                case 4:
                    System.out.println("Dwse thn nea diarkeia");
                    answer=scan.nextInt();
                    playList.get(index).setDiarkeia(answer);
                    break;
            }//telos switch
            System.out.println("An thes na allaxeis kai kati allo pata to y alliws pata n gia na vgeis");//emfanish munhmatos gia to an thelei na synexisei o xrhsths
            scan.nextLine(); //diagrafh upoloimatwn
            do{//elegxos eisagwghs
                temp=scan.next().charAt(0);
            }
            while(temp!='y'&&temp!='n');
        }
        while(temp=='y');   //telos diorthwshs      
    } 
    public void anazitisivasikallitexni(String artist){ //synartish gia anazitisi tragoudiwn vash tou kallitexnh
        System.out.println("Ta tragoudia pou emhneuei o kallitexnhs einai: ");
        int count=1; //dilwsh kai arxikopoihsh deikti gia na arithmizei ta tragoudia sthn ektypwsh
        for(int i=0;i<playList.size();i++){ 
            if(playList.get(i).getKallitexnhs().equalsIgnoreCase(artist)){  //synthikh pou an vrei ton kallitexnh xwris case sensitive tote ektupwnei to tragoudi pou ermhneuei
                System.out.println(count+")"+playList.get(i).getTitlos());
                count++;
            }
        }     
    }
    public void anazitisiVasiAlbum(String x){//synartish gia anazitisi tragoudiwn vash tou album idia methodologia opws kai stou kallitexnh
        System.out.println("Ta tragoudia pou yparxoun sto album einai: ");
        int count=1;
        for(int i=0;i<playList.size();i++){
            if(playList.get(i).getAlbum().equalsIgnoreCase(x)){
                System.out.println(count+")"+playList.get(i).getTitlos());
                count++;
            }
        }       
    }
    public void diagrafhTragoudiou(String x){   //synartish gia thn diagrafh tragoudiou apo thn lista
        for(int i=0;i<playList.size();i++){ //epanalipsh gia thn prospelash olwn twn stoixeiwn ths listas
            if(playList.get(i).getTitlos().equalsIgnoreCase(x)){    //an o titlos pou uparxei sthn lista einai isos kai xwris case sensitive tote diagrafh to periexomeno ths listas sthnthesh i
                playList.remove(i); //diagrafh periexomenou pou vriskete sthn thesh i ths listas playList
            }
        }
    }
}