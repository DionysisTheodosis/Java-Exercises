/*Dionysis Theodosis 
  A.M:321/2015066
  Askisi 1
*/
package vivliopolio;


public class Vivliopolio {

    
    public static void main(String[] args) {
        //Arxikopoihsh kai dhmiourgeia antikeimenou klashs proion,gia ektelsh automatos apo main xwris xrhsh tou katasthmatos
        Proion c=new Proion("vivlio",true,12.5,"istoriko");
        //entoles apo thn main gia thn klash proion 
        c.check();//emfanish diathesimothtas tou proiontos
        c.notAvailable();//xarakthrismos proiontos ws mh diathesimo
        c.check();//emfanish diathesimothtas tou proiontos
        c.available();//xarakthrismos proiontos ws diathesimo
        c.check();//emfanish diathesimothtas tou proiontos
        System.out.println(c);//emfanish twn idiothtwn tou proiontos
        //Arxikopoihsh kai dhmiourgia antikimenwn gia thn klash katasthma
        Ekatasthma ena=new Ekatasthma("www.ena.com","2107754585","ena@hotmail.com");//arxikopoihsh kai dhmiourgia antikeimenou gia thn klash katasthma kai parametropoihsh tou
        //edw xrhsimopoioume mono ena antikeimeno epeish i lista twn proiontwn tha einai sto katasthma apla ta exoume ws dedomena gia thn ektelesh 
        ena.newProduct("vivlia",14.94,"Sygxronh logotexnia");//prosthiki proiontos
        ena.newProduct("vivlia",17.91,"istoriko mythistorima dokimio");
        ena.newProduct("vivlia",15.93,"astynomiko");
        ena.newProduct("vasika eidh grafeiou",5.36,"autokoliti taineia grafeiou");
        ena.newProduct("vasika eidh grafeiou",0.90,"autokolites shmeioseis");
        ena.newProduct("psalisi",1.45,"plastiko psalidi grafeiou");
        ena.newProduct("psalidi",2.39,"metallixo psalidi");
        ena.display();//emfanish twn proiontwn
        ena.changeAvailable("vivlia", "9f8a210a-9ae4-4ab2-b311-ea44dc141fc4");//allazei thn katastash tou proiontos me kathgoria kai kwdiko
        System.out.println();//ektypwsh allaghs grammhs
        System.out.println("Emfanish meta apo thn allagh ths diathesimothtas");//ektypwsh mhnimatos
        ena.display();//emfanish twn proiontwn
        System.out.println();//allagh grammhs
        System.out.println("Emfanish gia sygkekrimenh kathgoria");//ektypwsh mhnumatos
        ena.printProductOfCategory("vivlia");//ektypwnh ta proionta gia thn kathgoria vivlia
        System.out.println();//allagh grammhs
        System.out.println("Emfanish gia sygkekrimenh kathgoria kai prooionta mikroterhs timhs");//ektypwsh mhnumatos
        ena.printProductOfCategoryWithMinPriceOf("vivlia", 15);//emfanish twn proiontwn gia thn kathgoria vivlia kai me mikroterh timh tou 15
        System.out.println();//allagh grammhs
        System.out.println("Emfanish diathesimwn proiontwn"); //ektypwsh minimatos
        ena.availableProducts();//emfanish twn diathesimwn proiontwn
        System.out.println();//allagh grammhs
        System.out.println("Ektypwsh oikonomikwn proiontwn ana kathgoria"); //ektypwnei ta proionta me thn xamiloterh timh ana kathgoria 
        System.out.println();//ektypwsh allaghs grammhs
        ena.emfanishEconomyProducts();//emfanizei ta oikono mikotera proionta ana kathgoria 

    }
    
}
