/*Dionysis Theodosis A.m:321/2015066
Askhsh 4*/
package main;
import java.util.Scanner;//ergaleio ths java gia eisagwgh apo to plhktrologio

public class Main {

    public static void main(String[] args) {
       int answer;  //dilwsh metavliths tupou int pou tha thn xrhsimopoihsoume gia na paroume apanthsh apo to plhktrologio
       char choise;//dilwsh metavliths tupou char pou tha thn xrhsimopoihsoume gia na paroume apanthsh apo to plhktrologio
       String c;//dilwsh metavliths tupou string pou tha thn xrhsimopoihsoume gia na paroume apanthsh apo to plhktrologio
       Play_List a=new Play_List();//dimiourgia antikeimenou ths klashs Play_List
       a.printStoixeiaListas(); //kalesma synarthseis gia ektypwsh twn stoixeiwn ths klashs
      do{ //Epanalipsh oso o xrhsths thelei na epexergazete thn lista
       //menu epilogwn  
       System.out.println("Epelexe ti thes apo to menu grafwntas ton arithmo");
       System.out.println("1) Ta Tragoudia mou");
       System.out.println("2) Kallitexnes");
       System.out.println("3) Album");
       System.out.println("4) Epexergasia Listas");
       System.out.println("5) Anazitish tragoudiou vash kallitexnh:");
       System.out.println("6) Anazitish vash album");
       System.out.println("7) Diagrafh tragoudiou apo lista");
       System.out.print("Edw:");
       Scanner scan=new Scanner(System.in);//dimiourgei antikeimenou gia eisagwgh apo to plhktrologio
       do{//elegxos gia na dwsei swsta ta stoixeia
        answer=scan.nextInt();}
       while(answer<=0 && answer>7);
       scan.nextLine();//gia na vgalei tuxon upoloimata pou den tha mas afhnan sthn epomenh eisagwgh na dwsoume apanthsh
       //swich h opoia analogos thn apanthsh kanei kai auto pou grafoume
       switch(answer){
           case 1://ektypwsh olwn twn tragoudiwn
               a.printLista();
               break;//vgainei apo thn switch
           case 2://emfanish olwn twn kallitexnwn
               a.emfanishKallitexnwn();
               break;
           case 3://emfanish album
               a.emfanishAlbum();
               break;
           case 4://epexergazete to tragoudi
                System.out.println("Dwse ton titlo tou tragoudiou pros epexergasia");//ektupwnei katalhlo munhma
                scan.nextLine();//wste na diagrapsei tuxon upoloimata
                c=scan.nextLine(); //diavazei thn apanthsh
                a.diorthwshlistas(c);//dinei ton titlo tou tragoudiou sthn sunarthsh gia na epexergastei to sugkekrimeno
                break;
           case 5://anazitisi tragoudiwn vash kallitexnh
                System.out.println("Dwse to onoma tou Kallitexnh");
                c=scan.nextLine();
                a.anazitisivasikallitexni(c);
               break;
           case 6://anazitisi tragoudiwn vash to onoma tou album
                System.out.println("Dwse to onoma tou Album");
                c=scan.nextLine();
                a.anazitisiVasiAlbum(c);
               break;
           case 7://diagrafh tragoudiou
                System.out.println("Dwse to onoma tou tragoudiou");
                c=scan.nextLine();
                a.diagrafhTragoudiou(c);
                break;
       }                
       System.out.println("An thes na epilexeis kati akoma pata y alliws pata n gia na vgeis");//katalhlo mynhma gia to an thelei o xrhsths na synexisi
       do{ //elegxos gia swsth apanthsh
         choise=scan.next().charAt(0);}//eisagwgh xarakthra apo to plhktrologio}
       while(choise!='y'&& choise!='n');}
      while(choise =='y');
    }
    
}
