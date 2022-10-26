package poll;
import javax.swing.JOptionPane;

public class Poll {
    
    public static void main(String[] args) {
        final String[] topics = {"Politika","Oikonomika","Ygeias","Texnologia","Psyxagwgia"};
        int [][] responses;
        
        double totalCounter=1.0;
        String userInput;
        responses = new int[5][10];
        String [] numbers = new String[10];
       
        for(int i=0;i<numbers.length;i++){
            numbers[i] = String.valueOf(i+1);
        }
        
        String menu = "Rate The Follow Topics From 1-10";
        int j;
        String[] f =new String[5];
        String temp;
        f[0] = String.format("Politika%16s",":");
        f[1] = String.format("Oikonomika%7s",":");
        f[2] = String.format("Ygeias%17s",":");
        f[3] = String.format("Texnologia%9s",":");
        f[4] = String.format("Psyxagwgia%7s",":");
        
        while(true){
            JOptionPane.showMessageDialog(null, menu);
            for(int i=0;i<topics.length;i++){
                do{
                   userInput=  (String) JOptionPane.showInputDialog(null, "Epelexe Poso Se Endiaferei Apo to 1-10", topics[i],JOptionPane.QUESTION_MESSAGE, null,numbers, "1");
                }
                while(userInput==null || userInput.isEmpty());
                 j = Integer.parseInt(userInput);
            
                ++responses[i][j-1];
            }
            temp = String.format("%10s%18d%5d%5d%5d%5d%5d%5d%5d%5d%5d%5s\n\n","Topics",1,2,3,4,5,6,7,8,9,10,"M.O");
           
            
           int[] ratingOfTopic = new int[5];
            for(int i=0;i<topics.length;i++){
                temp += f[i]; 
                
                for(int k=0;k<10;k++){
                    if(responses[i][k]!=0){
                        ratingOfTopic[i]+=k+1;
                    }
                    temp+= String.format("%5d", responses[i][k]);
                   
                }
                temp+=String.format("%7.1f",ratingOfTopic[i]/totalCounter);
                temp+="\n";
                System.out.println("");
            }
            int min=ratingOfTopic[0],minI=0;
            int max =ratingOfTopic[0],maxI=0;
            for(int i=0;i<ratingOfTopic.length;i++){
                if(ratingOfTopic[i]<min){
                    min = ratingOfTopic[i];
                    minI=i;
                }
                if(ratingOfTopic[i]>max){
                    max = ratingOfTopic[i];
                    maxI=i;
                }
            }
            
            ++totalCounter;
            
            String minimum = f[minI]+String.valueOf(ratingOfTopic[minI]);
            String maximum = f[maxI]+String.valueOf(ratingOfTopic[maxI]);
            JOptionPane.showMessageDialog(null, temp);
            JOptionPane.showMessageDialog(null, maximum, "To Thema Me Tous Perissoterous Vathmous",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, minimum,"To Thema Me Tous Ligoterous Vathmous" ,JOptionPane.INFORMATION_MESSAGE);
            if(JOptionPane.showConfirmDialog(null,"Theleis Na Synexiseis?")==1) break;
                
           
        }
    }
    
}
