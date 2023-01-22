/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author dionysis
 */
public   class Game{

    private static Cell prevLet,wildCard;
    private static File file;
    private static ArrayList<String> allWords;
    private static ArrayList<Cell> contLetters,wordToSearch;
    private static ArrayList<Cell> charPoints;
    private static int totalScore;
    private static int wordScore,goal;
    private static int countWords;
    private final int CHARLENGTH;
    private final Dimension tableDim = new Dimension(8,8);
    private static String username;
    private String fileUrl;
    private static String word;
    private static  boolean fileChange,usernameChange,findWord;
  
  
    public  Game(){
        if(!Game.fileChange){
            Game.username = HomePage.getUsername();
            Game.file = HomePage.getFile(); 
        }
        prevLet=null;
       
        CHARLENGTH = (int)tableDim.getHeight()*(int)tableDim.getWidth();
        charPoints = new ArrayList<>();
        allWords = new ArrayList<>();
        contLetters = new ArrayList<>();
        countWords=0;
        totalScore=0;
        wordScore=0;
        wordToSearch = new ArrayList<>();
        word=null;
        
        charPoints();
        addWords();
        makeTable();
        setGoal();
        
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
           File myFile = new File(this.file.getAbsolutePath());
            Scanner scanner = new Scanner(myFile);
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
        goal=0;
        
        
        
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
            if(randomNumber==930){
                randomNumber++;//dioti yparxei allos xarakthras
            }
            int randWildCard = randomIn.nextInt(2);
            if((randWildCard == 0 )&& spCounter<4){
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
                        //METRAEI TOYS PONTOUS
                        goal+=charPoints.get(j).getNumber();          

                    contLetters.add(new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),count++,CHARLENGTH));
                 }
                 
            }
        }
      
           
       
       
        Collections.shuffle(contLetters); 
        setNeighboors();
        giveColor();
    }
    private void setNeighboors(){
        for(int i =0;i<contLetters.size();i++){
            contLetters.get(i).setNeighbours(i);
        }
    }
    private void setGoal(){
        goal = goal/4+20; 
        
    }
    public static int getGoal(){
        return goal;
    }
    private void  giveColor(){
        Random random = new Random();
        int colorizeBlue = 1 + random.nextInt(3);
        int colorizeRed = 1 + random.nextInt(2);
        
        for(int i=0;i<colorizeBlue;i++){
             int randBlue = random.nextInt(CHARLENGTH);
             contLetters.get(randBlue).setColor(Color.BLUE);
        }
        for(int i=0;i<colorizeRed;i++){
             int randRed = random.nextInt(CHARLENGTH);
             contLetters.get(randRed).setColor(Color.RED);
        }
          
    }
    public ArrayList<Cell> getWords(){
        return contLetters;
    }

    public void newGame(){
            addWords();
            makeTable();
    }
    public void shuffleWords(){
        Collections.shuffle(contLetters); 
        setNeighboors();
    }
    
    public void shuffleCol(int col){
        int lines;
        lines =(int)Math.sqrt(CHARLENGTH);
        col--;
        int count = col;
        ArrayList<Cell> temp = new ArrayList<>();
        for(int i=col;i<((CHARLENGTH-lines)+col);i=i+lines){
            temp.add(contLetters.get(i));
        }
        Collections.shuffle(temp);
        int t=0,j=lines;
        for(int i=col;i<(CHARLENGTH-lines);i=i+lines){
            contLetters.set(i,temp.get(t++));
        }   
        setNeighboors();
    }
    public void shuffleLine(int line){
        int columns;
        columns =(int)Math.sqrt(CHARLENGTH);
        line = ((line-1)*columns);
        ArrayList<Cell> temp = new ArrayList<>();
        for(int i=line;i<line+columns;i++){
            temp.add(contLetters.get(i));
           
        }
        Collections.shuffle(temp);
        int t=0;
        for(int i=line;i<line+columns;i++){
            contLetters.set(i,temp.get(t++));
        }
        setNeighboors();
    }
    public void delLine(int line){
        int columns;
        columns =(int)Math.sqrt(CHARLENGTH);//vriskw thn grammh vash tou
        line = ((line-1)*columns);
        Random randomIn = new Random();
        int countBlue=0;
        int countRed=0;
        int countWildCards=0;
        char[] temp = new char[columns]; 
        int[] indexArr = new int[columns];
        int tempIndex = 0;
        
        for(Cell i : contLetters){
            
            //metraei ta mple kelia
            if(i.getColor()==Color.BLUE){
                countBlue++;
            }
            //metraei ta kokkina kelia
            if(i.getColor()==Color.RED){
                countRed++;
            }
            //metraei ta  mpalanter
            if(i.getWord()=='?'){
                countWildCards++;
            }          
        }
        
        while(tempIndex<columns){
               if(contLetters.get(tempIndex).getColor()==Color.BLUE){
                    countBlue--;
                }
                else if(contLetters.get(tempIndex).getColor()==Color.RED){
                    countRed--;
                }
            
            
            int randomNumber = 913 + randomIn.nextInt(24);
             if(randomNumber==930){
                randomNumber++;//dioti yparxei allos xarakthras
            }
            int randWildCard = randomIn.nextInt(2);
            
            if((randWildCard == 0 )&& countWildCards<4){
                temp[tempIndex] = '?';
                countWildCards+=1;
                tempIndex+=1;
            }
            else{
                temp[tempIndex] = (char) randomNumber;
                tempIndex+=1;
            }
            
            
        }
            
        for(int i=0;i<columns;i++){
               
            for(int j=0;j<charPoints.size();j++){
                //Afairesh apo to geniko ta xrwmata gia epanaupologismo
               
                if(temp[i]==charPoints.get(j).getWord()){
                    contLetters.set(line,new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),line,CHARLENGTH));
                    line++;
                }
            }
        }
            Random random = new Random();
          
            if(countBlue<3){
                int colorizeBlue = 1 + random.nextInt((3-countBlue));
                int randBlue = 0+ random.nextInt(indexArr.length);
                for(int i=0;i<colorizeBlue;i++){
                    contLetters.get(indexArr[randBlue]).setColor(Color.BLUE);
                    
                }
            }
            if(countRed<2){
                int colorizeRed = 1 + random.nextInt((2-countRed));
                int randRed = random.nextInt(indexArr.length);
                for(int i=0;i<colorizeRed;i++){
                    contLetters.get(indexArr[randRed]).setColor(Color.RED);
                    
                }  
            }
            
            //epanaypologysmos twn geitw
        setNeighboors();
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
        word="";
        for(int i=0;i<wordToSearch.size();i++){
            word +=wordToSearch.get(i).getWord();
        }
        if(allWords.contains(word)){
           findWord=true;
           wordScore=0;
           countWords++;
           allWords.remove(word);
           Random randomIn = new Random();
           int countBlue=0;
           int countRed=0;
           int countWildCards=0;
           int tempIndex =0;
           char[] temp = new char[wordToSearch.size()]; 
        //metraei ta mple kelia
           for(Cell i : contLetters){
                if(i.getColor()==Color.BLUE){
                countBlue++;
                }
            }
            //metraei ta kokkina kelia
            for(Cell i : contLetters){
                if(i.getColor()==Color.RED){
                    countRed++;
                }
            }
            //metraei ta  mpalanter
            for(Cell i : contLetters){
                if(i.getWord()=='?'){
                    countWildCards++;
                }          
            }
            int[] indexArr = new int[wordToSearch.size()];
            int arrCount=0;
            while(tempIndex<wordToSearch.size()){
               
                
                int randomNumber = 913 + randomIn.nextInt(24);
                int randWildCard = randomIn.nextInt(2);
            
                if((randWildCard == 0 )&& countWildCards<4){
                    temp[tempIndex] = '?';
                    countWildCards+=1;
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
                        indexArr[arrCount++] = contLetters.indexOf(wordToSearch.get(i));
                        contLetters.set(contLetters.indexOf(wordToSearch.get(i)),new Cell(charPoints.get(j).getWord(),charPoints.get(j).getNumber(),contLetters.indexOf(wordToSearch.get(i)),CHARLENGTH));
                        //meiwei ta prohgoumea xrwmata
                      
                    }
                }
            }
            //prosthiki xrwmatos sta nea grammata
            Random random = new Random();
            if(countBlue<3){
                int colorizeBlue = 1 + random.nextInt((3-countBlue));
                int randBlue = 0+ random.nextInt(indexArr.length);
                for(int i=0;i<colorizeBlue;i++){
                    contLetters.get(indexArr[randBlue]).setColor(Color.BLUE);
                    
                }
            }
            if(countRed<2){
                int colorizeRed = 1 + random.nextInt((2-countRed));
                int randRed = random.nextInt(indexArr.length);
                for(int i=0;i<colorizeRed;i++){
                    
                    contLetters.get(indexArr[randRed]).setColor(Color.RED);
                    
                }  
            }
            
            //epanaypologysmos twn geitwnwn
            setNeighboors();
            if(flagBlue){
                wordScore*=2;
            }
            totalScore+=wordScore;
        }
  
        
        wordToSearch.clear();
       
        prevLet = new Cell();
    }
    public static int getTotalScore(){
        return totalScore;
    }
    public static int getWordPoints(){
        return wordScore;
    }
    public static boolean findWord(){
        if(findWord){
            findWord=false;
            return true;
        }
        else{
            return false;
        }
    }
    public static String getFndWord(){
        if(!findWord&&word==null){
           word="";
        }
        else if(!findWord&&word.equals("")){
            word = "Η Λέξη Δεν Υπάρχει: ";
        }
       
        return word;
    }
    public static int getNwords(){
        return countWords;
    }
    
    public static void setWord(Cell letter){
        
       if((wordToSearch==null||wordToSearch.isEmpty())){
           wordToSearch.add(letter);
           setPrevClicked(letter);
                   
       }
       else if(prevLet.getNeighbours().contains(contLetters.indexOf(letter))){
           
            wordToSearch.add(letter);
            setPrevClicked(letter);
       }
       else{
           
       }
    }
    public static void removeWord(){
        wordToSearch.clear();
        prevLet=null;       
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
        if(prevLet==null||(wordToSearch==null || wordToSearch.isEmpty() )||(prevLet.getNeighbours().contains(contLetters.indexOf(letter)))&&Collections.frequency(wordToSearch, letter)!=2){
            return true;
        }
        else{
            return false;
        }
    }
    public static void setPrevClicked(Cell letter){
        prevLet = new Cell();
        prevLet = letter;
        System.out.println("\nto prvLet eiai"+prevLet.getWord());
    }
    public static Cell getPrevClicked(){
        return prevLet;
    }
    public static boolean lettersClicked(){
        if(wordToSearch.size()>2){
            return true;
        }
        else{
            return false;
        }
    }
    public static int swapWords(){
        if(wordToSearch.size() == 2){
            Collections.swap(contLetters,contLetters.indexOf( wordToSearch.get(0)),contLetters.indexOf( wordToSearch.get(1)));
            for(int i =0;i<contLetters.size();i++){
                contLetters.get(i).setNeighbours(i);
            }
            wordToSearch.clear();
            return 2;
        }
        else if(wordToSearch.size()==1){
            return 1;
        }
        else{
            return 0;
        }
    }
    public  void setWildCard(char wildCardt,Cell keli){
       for(int i =0;i<charPoints.size();i++){
           if(wildCardt==charPoints.get(i).getWord()){
               keli.setWord(wildCardt);
               keli.setNumber(charPoints.get(i).getNumber());
           }
       }
    }
    public static boolean winGame(){
        if(totalScore>=goal){
            return true;
        }
        else{
            return false;
        }
        
    }
}
