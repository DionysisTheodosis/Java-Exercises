package javaproject;

import java.awt.Color;
import java.util.ArrayList;

//KLASH GIA THN DHMIOURGIA TOU GRAMMATOS
public  class Cell {
    private   char word;//O XARAKTHRAS
    private  int number;//O ARITHMOS TOU XARAKTHRA
    private Color color; //TO XRWMA TOU
    private int id; //H DIEUTHINSI POU EXEI STON PINAKA
    private int Size; //TO MEGETHOS TOU PINAKA
    private ArrayList<Integer> neighbours;//TA GEITONIKA KELIA
    
    //CONSTRUCTOR XWRIS ORISMATA
    public Cell(){
    }
    
    //CONSTRUCTOR ME OLA ORISMATA 
    public Cell(char word,int number,int index,int size){
        this.word=word;
        this.number=number;
        this.color = Color.white;
        this.id = index;
        this.Size = size;
        this.neighbours = new ArrayList<>();
     
    }
    //CONSTRUCTOR ME 2 ORISMATA POU XRHSIMOPOIEITAI GIA THN ARXH POU DINOUME STATIKA TON ARITHMO ME TO GRAMMA
    public Cell(char word,int number){
        this.word=word;
        this.number=number;
        this.color = Color.white;
    }
   
    //METHODOS GIA THN EPISTROFH TOU XARAKTHRA
    public char getWord(){
        return word;
    }
    //METHODOS GIA THN EPISTROFH TWN PONTWN
    public int getNumber(){
        return number;
    }
    //METHODOS GIA THN EPI
    public Color getColor(){
        return color;
    }
    //METHODOS GIA NA ALLAXEI TON XARAKTHRA
     public void setWord(char word){
       this.word=word;
       
    }
      //METHODOS GIA NA ALLAXEI TOUS PONTOUS
    public void setNumber(int number){
      this.number=number;
    }
    //METHODOS GIA ALLAGH TOU XRWMATOS
    public void setColor(Color color){
        this.color = color;
    }
    //METHODOS GIA YPOLOGISMO TWN GEITONIKWN KELIWN DEXONTAS THN THESH TOU XARAKTHRA
    public  void setNeighbours(int id){
        //ELEGXOS GIA TO AN EIXE PROHGOUMENOS GEITONIKA KELIA SE PERIPTWSH POU EXEI GINEI ALLAGH WSTE NA EPANARXIKOPOIHTHEI
        if(!neighbours.isEmpty()){
            neighbours.clear();
        }
        //ALLAGH TOU ID ME TO KAINOURGIO
        setIndex(id);
        //METAVLITI POU THA VRISKEI THN MIA DIASTASH TOU PINAKA
        int dimensionX = (int)Math.sqrt(Size);
        //METAVLITES GIA NA DWSEI TA GEITONIKA KELIA
        int upLeftDiag = id-(dimensionX+1);
        int upCenter = id-dimensionX;
        int upRightDiag = id-(dimensionX-1);
        int left = id-1;
        int right = id+1;
        int downCenter =id+dimensionX;
        int downLeftDiag = id+(dimensionX-1);
        int downRightDiag =id +(dimensionX+1);
        
        
        if((id%dimensionX)==0){//ELLEGXOS GIA TO AN EINAI STHN PRWTH STHLH
            if((id/dimensionX)==0){//ELEGXOS GIA TO AN VRISKETE STHN 1H GRAMMH
                neighbours.add(right);
                neighbours.add(downCenter);
                neighbours.add(downRightDiag);
               
            }
            else if((id/dimensionX)==(dimensionX-1)){//ELEGXOS GIA TO AN VRISKETAI STHN TELEUTAIA GRAMMH
                neighbours.add(upCenter);
                neighbours.add(upRightDiag);
                neighbours.add(right);
            }
            else{ //ALLIWS GIA TA ENDIAMESA
                neighbours.add(upCenter); 
                neighbours.add(upRightDiag);
                neighbours.add(right);
                neighbours.add(downCenter);
                neighbours.add(downRightDiag);
            }
        }
        //ELEGXOS GIA TO AN VRISKETAI STHN TELEUTAIA STHLH
        else if((id%dimensionX)==(dimensionX-1)){
            if(id/(dimensionX-1)==1){//ELEGXOS GIA TO AN VRISKETAI STHN 1H GRAMMH
                neighbours.add(left);
                neighbours.add(downLeftDiag);
                neighbours.add(downCenter);
               
            }
            else if((id/(dimensionX-1))==((dimensionX-1)+1)){//ELEGXOS GIA TO AN VRISKETAI STHN TELEUTAI GRAMMH
                neighbours.add(upLeftDiag);
                neighbours.add(upCenter);
                neighbours.add(left);
            }
            else{ //ALLIWS GIA TA ENDIAMESA
                neighbours.add(upLeftDiag);
                neighbours.add(upCenter); 
                neighbours.add(left);
                neighbours.add(downLeftDiag);
                neighbours.add(downCenter);
            }
        }
        //ALLIWS GIA TA ENDIAMESA
        else{
            if(id<=dimensionX){//ELEGXOS GIA TO AN VRISKONTAI STHN 1H GRAMMH
                neighbours.add(left);
                neighbours.add(right);
                neighbours.add(downLeftDiag);
                neighbours.add(downCenter);
                neighbours.add(downRightDiag);
                
                
            }
            else if(id>=(Size-dimensionX)){//ELEGXOS GIA TO AN VRISKONTAI STHN TELEUTAIA GRAMMH
                neighbours.add(left);
                neighbours.add(right);
                neighbours.add(upLeftDiag);
                neighbours.add(upCenter);
                neighbours.add(upRightDiag);
            }
            else{//ALLIWS GIA TA ENDIAMESA
                neighbours.add(upLeftDiag);
                neighbours.add(upCenter);
                neighbours.add(upRightDiag);
                neighbours.add(left);
                neighbours.add(right);
                neighbours.add(downLeftDiag);
                neighbours.add(downCenter);
                neighbours.add(downRightDiag);
            }
           
        }
      
        
    }
    //METHODOS GIA THN EPISTROFH TWN GEITONIKWN KELIWN
    public ArrayList<Integer> getNeighbours(){
       return neighbours;
       
    }
    //METHODOS GIA THN EPISTROFH TOU DEIKTI STO KELI
    public int getIndex(){
        return id;
    }
    //METHODOS GIA THN EISAGWGH TOU DEIKTI KELIOU
     public void setIndex(int id){
        this.id=id;
    }
}
