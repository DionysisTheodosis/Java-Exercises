/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.SwingUtilities;

/**
 *
 * @author dionysis
 */
public   class Game {
    private static   MyFrame frame;
    private Cell charCell;
    private static Cell prevLet;
    private static File wordsFile,file;
    private static ArrayList<String> allWords;
    private static ArrayList<Cell> contWords,wordToSearch;
    private ArrayList<Cell> charPoints;
    private ArrayList<String> findWords;
    private int totalScore;
    private int wordScore;
    private final int CHARLENGTH;
    private final Dimension tableDim = new Dimension(8,8);
    private static String username;
    private String fileUrl;
    private static  boolean fileChange,usernameChange;
   /* 
    
    public  Game(){
      
        CHARLENGTH = (int)tableDim.getHeight()*(int)tableDim.getWidth();
        charPoints = new ArrayList<>();
        allWords = new ArrayList<>();
        contWords = new ArrayList<>();
        findWords   = new ArrayList<>();
        score = 0;
        charPoints();
      
        addWords();
        makeTable();
    }*/
  
    public  Game(){
        if(!Game.fileChange){
            Game.username = HomePage.getUsername();
            Game.file = HomePage.getFile(); 
        }
        prevLet=null;
        //this.username = username;
        //this.file= file;
        CHARLENGTH = (int)tableDim.getHeight()*(int)tableDim.getWidth();
        charPoints = new ArrayList<>();
        allWords = new ArrayList<>();
        contWords = new ArrayList<>();
        findWords   = new ArrayList<>();
        totalScore=0;
        wordScore=0;
        wordToSearch = new ArrayList<>();
       
        charPoints();
        addWords();
        makeTable();
    }
  
    private void charPoints(){
        
        charPoints.add(new Cell('Α',1));
        charPoints.add(new Cell('Β',8));
        charPoints.add(new Cell('Γ',4));
        charPoints.add(new Cell('Δ',4));
        charPoints.add(new Cell('Ε',1));
        charPoints.add(new Cell('Ζ',8));
        charPoints.add(new Cell('Η',1));
        charPoints.add(new Cell('Θ',8));
        charPoints.add(new Cell('Ι',1));
        charPoints.add(new Cell('Κ',2));
        charPoints.add(new Cell('Λ',3));
        charPoints.add(new Cell('Μ',3));
        charPoints.add(new Cell('Ν',1));
        charPoints.add(new Cell('Ξ',10));
        charPoints.add(new Cell('Ο',1));
        charPoints.add(new Cell('Π',2));
        charPoints.add(new Cell('Ρ',2));
        charPoints.add(new Cell('Σ',1));
        charPoints.add(new Cell('Τ',1));
        charPoints.add(new Cell('Υ',2));
        charPoints.add(new Cell('Φ',8));
        charPoints.add(new Cell('Χ',10));
        charPoints.add(new Cell('Ψ',10));
        charPoints.add(new Cell('Ω',3));
        charPoints.add(new Cell('?',111));
        
    }
    private ArrayList<String> readFile(){
        ArrayList<String> fileWords = new ArrayList<>();
        try {
           File fila = new File(this.file.getAbsolutePath());
            Scanner scanner = new Scanner(fila);
            while (scanner.hasNext()) {
                String c =scanner.next();
               
                    fileWords.add(c);
                 
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileWords;
    }
    
    private void addWords(){  
        
        ArrayList<String> fileWords = new ArrayList<>();
        TreeSet<String> tempW = new TreeSet<>(); 
        fileWords= readFile();
        
        int charLength=0;
        Random rand = new Random();
        while(charLength<=CHARLENGTH){
            int input = rand.nextInt(fileWords.size());
            if((fileWords.get(input).length()+charLength)<CHARLENGTH){
                tempW.add(fileWords.get(input));
                charLength +=  fileWords.get(input).length();
            }
            else{
                break;
            }
        }
        for(String i: tempW){
            allWords.add(i);
        }
        
        
        for(int i=0;i<allWords.size();i++){
            System.out.print("allwords:"+allWords.get(i)+",");
        }
        
        
    }
    private void makeTable(){
        int charLength=0;
        char[] temp = new char[CHARLENGTH]; 
        int tempIndex = 0;
        System.out.print(allWords.size());
        
        for(int i=0;i<allWords.size();i++){
            char[] temp1 = allWords.get(i).toCharArray();
            for(int j=0;j<temp1.length;j++){
                    temp[tempIndex] = temp1[j];
                    
                    tempIndex+=1;
                    charLength += allWords.get(i).length();
            }
        }
             
        Random randomIn = new Random();
        int spCounter = 0;
        char sp='?';
        while(tempIndex<CHARLENGTH){
            int randomNumber = 913 + randomIn.nextInt(24);
            int randBal = randomIn.nextInt(2);
            if((randBal == 0 )&& spCounter<4){
                temp[tempIndex] = sp;
                spCounter+=1;
                tempIndex+=1;
            }
            else{
                temp[tempIndex] = (char) randomNumber;
                tempIndex+=1;
            }
            
            
        }
       int count=0;
    
         for(int i=0;i<CHARLENGTH;i++){
            for(int j=0;j<charPoints.size();j++){ 
                
                  if(temp[i]==charPoints.get(j).getWord()){
                    contWords.add(new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),count++,CHARLENGTH));
                 }
                 
            }
        }
      
           
       
       
        Collections.shuffle(contWords); 
        for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
        giveColor();
    }
    private void  giveColor(){
        Random random = new Random();
        int colorizeBlue = 1 + random.nextInt(3);
        int colorizeRed = 1 + random.nextInt(2);
        
        for(int i=0;i<colorizeBlue;i++){
             int randBlue = random.nextInt(CHARLENGTH);
             contWords.get(randBlue).setColor(Color.BLUE);
        }
        for(int i=0;i<colorizeRed;i++){
             int randRed = random.nextInt(CHARLENGTH);
             contWords.get(randRed).setColor(Color.RED);
        }
          
    }
    public ArrayList<Cell> getWords(){
        return contWords;
    }

    public void newGame(){
            addWords();
            makeTable();
    }
    public void shuffleWords(){
        Collections.shuffle(contWords); 
        for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
    }
    public void shuffleCol(int col){
        int lines;
        lines =(int)Math.sqrt(CHARLENGTH);
        col--;
        int count = col;
        ArrayList<Cell> temp = new ArrayList<>();
        for(int i=col;i<((CHARLENGTH-lines)+col);i=i+lines){
            temp.add(contWords.get(i));
        }
        Collections.shuffle(temp);
        int t=0,j=lines;
        for(int i=col;i<(CHARLENGTH-lines);i=i+lines){
            contWords.set(i,temp.get(t++));
        }   
        for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
    }
    public void shuffleLine(int line){
        int columns;
        columns =(int)Math.sqrt(CHARLENGTH);
        line = ((line-1)*columns);
        ArrayList<Cell> temp = new ArrayList<>();
        for(int i=line;i<line+columns;i++){
            temp.add(contWords.get(i));
            //System.out.println(temp.get(i).getWord());
        }
        Collections.shuffle(temp);
        int t=0;
        for(int i=line;i<line+columns;i++){
            contWords.set(i,temp.get(t++));
        }
        for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
    }
    public void delLine(int line){
        int columns;
        columns =(int)Math.sqrt(CHARLENGTH);//vriskw thn grammh vash tou
        line = ((line-1)*columns);
        Random randomIn = new Random();
        int countBlue=0;
        int countRed=0;
        int countBal=0;
        char[] temp = new char[columns]; 
        int tempIndex = 0;
        //metraei ta mple kelia
        for(Cell i : contWords){
            if(i.getColor()==Color.BLUE){
                countBlue++;
            }
        }
        //metraei ta kokkina kelia
        for(Cell i : contWords){
            if(i.getColor()==Color.RED){
                countRed++;
            }
        }
        //metraei ta  mpalanter
        for(Cell i : contWords){
            if(i.getWord()=='?'){
                countBal++;
            }          
        }
        
        while(tempIndex<columns){
            int randomNumber = 913 + randomIn.nextInt(24);
            int randBal = randomIn.nextInt(2);
            
            if((randBal == 0 )&& countBal<4){
                temp[tempIndex] = '?';
                countBal+=1;
                tempIndex+=1;
            }
            else{
                temp[tempIndex] = (char) randomNumber;
                tempIndex+=1;
            }
            
            
        }
        for(int i=0;i<columns;i++){
            for(int j=0;j<charPoints.size();j++){
                if(temp[i]==charPoints.get(j).getWord()){
                    contWords.set(line,new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),line,CHARLENGTH));
                    line++;
                }
            }
        }
         for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
    }
    public static void setUsername(String username){
        Game.username = username;
        Game.usernameChange=true;
    }
    public static String getUsername(){
        return Game.username;
    }
    public static void setFile(File file){
        Game.file = file;
        Game.fileChange=true;
    }
    public static void setChanges(){
        Game.fileChange=false;
        Game.usernameChange=false;
    }
    public  void searchWord(){
        String word="";
        for(int i=0;i<wordToSearch.size();i++){
            word +=wordToSearch.get(i).getWord();
        }
        if(allWords.contains(word)){
           wordScore=0;
           Random randomIn = new Random();
           int countBlue=0;
           int countRed=0;
           int countBal=0;
           int tempIndex =0;
           char[] temp = new char[wordToSearch.size()]; 
        //metraei ta mple kelia
           for(Cell i : contWords){
                if(i.getColor()==Color.BLUE){
                countBlue++;
                }
            }
            //metraei ta kokkina kelia
            for(Cell i : contWords){
                if(i.getColor()==Color.RED){
                    countRed++;
                }
            }
            //metraei ta  mpalanter
            for(Cell i : contWords){
                if(i.getWord()=='?'){
                    countBal++;
                }          
            }
            int[] indexArr = new int[wordToSearch.size()];
            int arrCount=0;
            while(tempIndex<wordToSearch.size()){
                
                
                
                int randomNumber = 913 + randomIn.nextInt(24);
                int randBal = randomIn.nextInt(2);
            
                if((randBal == 0 )&& countBal<4){
                    temp[tempIndex] = '?';
                    countBal+=1;
                    tempIndex+=1;
                }
                else{
                    temp[tempIndex] = (char) randomNumber;
                    tempIndex+=1;
                }
            }
            boolean flagBlue=false;
            for(int i=0;i<wordToSearch.size();i++){
                
                //ypologismos vathmwn
                if(wordToSearch.get(i).getColor().equals(Color.BLUE)){
                    flagBlue=true;
                }
                else if(wordToSearch.get(i).getColor().equals(Color.RED)){
                    wordScore+=(wordToSearch.get(i).getNumber()*2);
                }
                else{
                    wordScore+=wordToSearch.get(i).getNumber();
                }
                
                
                //Afairesh apo to geniko ta xrwmata gia epanaupologismo
                if(wordToSearch.get(i).getColor()==Color.BLUE){
                    countBlue--;
                }
                else if(wordToSearch.get(i).getColor()==Color.RED){
                    countRed--;
                }
                //prosthiki twn new grammatwn
                for(int j=0;j<charPoints.size();j++){
                    if(temp[i]==charPoints.get(j).getWord()){
                        System.out.println("prwto To idex "+contWords.indexOf(wordToSearch.get(i)));
                        indexArr[arrCount++] = contWords.indexOf(wordToSearch.get(i));
                        contWords.set(contWords.indexOf(wordToSearch.get(i)),new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),contWords.indexOf(wordToSearch.get(i)),CHARLENGTH));
                        //meiwei ta prohgoumea xrwmata
                      
                    }
                }
            }
            //prosthiki xrwmatos sta nea grammata
            System.out.println("To count Blue EINAI"+countBlue);
            System.out.println("To count Red EINAI"+countRed);
            Random random = new Random();
            System.out.print("to words"+wordToSearch.toString());
            if(countBlue<3){
                int colorizeBlue = 1 + random.nextInt((3-countBlue));
                System.out.println("To colorize Blue EINAI"+ colorizeBlue);
                int randBlue = 0+ random.nextInt(indexArr.length);
                for(int i=0;i<colorizeBlue;i++){
                    System.out.println("to size einnai "+indexArr.length);
                    
                    System.out.println("To randBlue einai "+randBlue);
                    System.out.println("To idex ble"+indexArr[randBlue]);
                    contWords.get(indexArr[randBlue]).setColor(Color.BLUE);
                    
                }
            }
            if(countRed<2){
                int colorizeRed = 1 + random.nextInt((2-countRed));
                System.out.println("To colorize Red EINAI"+ colorizeRed);
                int randRed = random.nextInt(indexArr.length);
                for(int i=0;i<colorizeRed;i++){
                    System.out.println("To randRed einai "+randRed);
                    System.out.println("To idex "+indexArr[randRed]);
                    contWords.get(indexArr[randRed]).setColor(Color.RED);
                    
                }  
            }
            
            //epanaypologysmos twn geitwnwn
            for(int i =0;i<contWords.size();i++){
                contWords.get(i).setNeighbours(i);
            }
            if(flagBlue){
                wordScore*=2;
            }
            totalScore+=wordScore;
            System.out.println("Συγχαρητηρια Βρηκες Την λεξη:"+word);
            System.out.println("to score ths lexhs:"+wordScore);
            System.out.println("to sunoliko score:"+totalScore);
        }
        System.out.println("H Lexh Einai:"+word);
        wordToSearch.clear();
        
  
        prevLet = new Cell();
    }
    
    
    
    
    public static void setWord(Cell letter){
        System.out.println("\nMphka");
       if(wordToSearch==null||wordToSearch.isEmpty()){
           wordToSearch.add(letter);
           setPrevClicked(letter);
                   
       }
       else if(prevLet.getNeighbours().contains(contWords.indexOf(letter))){
            System.out.println("\nPeriexei"+prevLet.getNeighbours().contains(contWords.indexOf(letter)));
            wordToSearch.add(letter);
            setPrevClicked(letter);
       }
       else{
           
       }
    }
    public static void removeWord(){
        wordToSearch.clear();
       // wordToSearch = new ArrayList();
        prevLet= new Cell();
        //prevLet=null;
        
    }
    public static  void removeLett(Cell letter){
       
        if(prevLet!=null&&!wordToSearch.isEmpty()){ 
            wordToSearch.remove(wordToSearch.size()-1);
            if(!wordToSearch.isEmpty()){
                prevLet = wordToSearch.get(wordToSearch.size()-1);
            }
           
        }
         else{
                prevLet= new Cell();
            }
        
      
    }
    public static boolean isremoveLett(Cell letter){
        if(wordToSearch.get(wordToSearch.size()-1).equals(letter)){
            return true;
        }
        else{
            return false;
        }
        
    }
    public static boolean isClickable(Cell letter){
        if(prevLet==null||(wordToSearch==null || wordToSearch.isEmpty() )||(prevLet.getNeighbours().contains(contWords.indexOf(letter)))&&Collections.frequency(wordToSearch, letter)!=2){
            return true;
        }
       /* if(wordToSearch==null || wordToSearch.isEmpty() ){
            return true;
        }
        if(prevLet.getNeighbours().contains(contWords.indexOf(letter))){
            System.out.println("\nto indext k oi geitonei"+String.valueOf(prevLet.getNeighbours().contains(contWords.indexOf(letter))));
            return true;
        }*/
        else{
            return false;
        }
    }
    public static void setPrevClicked(Cell letter){
        //prevLet = new Cell();
        prevLet = letter;
        System.out.println("\nto prvLet eiai"+prevLet.getWord());
    }
    public static Cell getPrevClicked(){
        return prevLet;
    }
    public static int swapWords(){
        if(wordToSearch.size() == 2){
            Cell tempCell;// =new Cell();
            tempCell =wordToSearch.get(0);
            System.out.println("to temp cell"+tempCell.getWord());
            System.out.println("to letter"+wordToSearch.get(0).getWord());
            contWords.set(contWords.indexOf(wordToSearch.get(0)), wordToSearch.get(1));
            contWords.set(contWords.indexOf(wordToSearch.get(1)), tempCell);
             for(int i =0;i<contWords.size();i++){
            contWords.get(i).setNeighbours(i);
        }
            wordToSearch.clear();
            wordToSearch = new ArrayList();
            //prevLet = new Cell();
            return 2;
        }
        else if(wordToSearch.size()==1){
            return 1;
        }
        else{
            return 0;
        }
    }
    public void setBal(){
        
    }
}
