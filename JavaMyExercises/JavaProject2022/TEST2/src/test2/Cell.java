package test2;

import java.awt.Color;
import java.util.ArrayList;

public  class Cell {
    private   char word;
    private  int number;
    private Color color;
    private int id;
    private int Size;
    private ArrayList<Integer> neighbours;
    
    public Cell(){
    }
    
    public Cell(char word,int number,int index,int size){
        this.word=word;
        this.number=number;
        this.color = Color.white;
        this.id = index;
        this.Size = size;
        this.neighbours = new ArrayList<>();
        //setNeighbours(id);
    }
    public Cell(char word,int number){
        this.word=word;
        this.number=number;
        this.color = Color.white;
    }
   
    public char getWord(){
        return word;
    }
    public int getNumber(){
        return number;
    }
    public Color getColor(){
        return color;
    }
     public void setWord(char word){
       this.word=word;
       
    }
    public void setNumber(int number){
      this.number=number;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public  void setNeighbours(int id){
        if(!neighbours.isEmpty()){
            neighbours.clear();
        }
        //Gia to 1o keli kathe grammhs
        int upLeftDiag = id-((int)Math.sqrt(Size)+1);
        int upCenter = id-(int)Math.sqrt(Size);
        int upRightDiag = id-((int)Math.sqrt(Size)-1);
        int left = id-1;
        int right = id+1;
        int downCenter =id+(int) Math.sqrt(Size);
        int downLeftDiag = id+((int)Math.sqrt(Size)-1);
        int downRightDiag =id +((int)Math.sqrt(Size)+1);
        
        if(id%Math.sqrt(Size)==0){
            if(right<Size){
              neighbours.add(right);
            }
            if(upCenter>=0){
                neighbours.add(upCenter);
            }
            if(upRightDiag>=0){
                neighbours.add(upRightDiag);
            }
            if(downCenter<Size){
                neighbours.add(downCenter);
            }
            if(downRightDiag<Size){
                neighbours.add(downRightDiag);
            }
            
        }
        //gia to teleutaio keli kathe grammhs
        else if(id%Math.sqrt(Size)==Math.sqrt(Size)-1){
            if(left>=0){
                neighbours.add(left);
            }
            if(downLeftDiag<Size){
                neighbours.add(downLeftDiag);
            }
            if(upCenter>=0){
                neighbours.add(upCenter);
            }
            if(downCenter<Size){
                neighbours.add(downCenter);
            }
            if(upLeftDiag>=0){
                neighbours.add(upLeftDiag);
            }
            
        }
        //gia ta ediamesa
        else{
            if(left>=0){
                neighbours.add(left);
            }
            if(downLeftDiag<Size){
                neighbours.add(downLeftDiag);
            }
            if(upCenter>=0){
                neighbours.add(upCenter);
            }
            if(downCenter<Size){
                neighbours.add(downCenter);
            }
            if(upLeftDiag>=0){
                neighbours.add(upLeftDiag);
            }
             if(right<Size){
              neighbours.add(right);
            }
         
            if(upRightDiag>=0){
                neighbours.add(upRightDiag);
            }
           
            if(downRightDiag<Size){
                neighbours.add(downRightDiag);
            }
        }
       
       
       
        
    }
    public ArrayList<Integer> getNeighbours(){
       return neighbours;
       
    }
    public int getIndex(){
        return id;
    }
}
