package exercise3;
import java.util.*;
import javax.swing.JOptionPane;

public class StrManipulation {
    private Scanner input; 
    private HashMap<Character,HashSet> charMap2 = new HashMap<>();
    
    public StrManipulation(){
        input = new Scanner(System.in);
    }
    //the best way
    public void pr1(){
        System.out.print("Ekxwrise Mia Symvoloseira: ");
        String g = input.nextLine(); //JOptionPane.showInputDialog(null,"give a string");
        TreeSet<Character> ch = new TreeSet<>();
        HashSet<Integer> values;
        for(int i=0;i<g.length();i++){
           if(!Character.isSpaceChar(g.charAt(i))){
               ch.add(g.charAt(i));
            }
        }
        for(Character s : ch){
            values = new HashSet<>(); 
            for(int i=0;i<g.length();i++){
                if(s.equals(g.charAt(i))){
                   values.add(i);
             
                    }
            }
            charMap2.put(s,values);
       }
         System.out.print("[");
        for(Character r: ch){
            System.out.print(r+": { ");
            for(Map.Entry<Character,HashSet> entry : charMap2.entrySet()) {
                Iterator val = entry.getValue().iterator();
                if (Objects.equals(entry.getKey(),r)) {
                    while (val.hasNext()) {
                        System.out.print(val.next()+" ");
                    }
                    System.out.print("} ");
                }
                
            }
            
        }  
        System.out.println("]");
    }
    //best way to method 2
    public void makeStr(){
        boolean x= true;
        char[] strb;
        int max=0;
        for(Map.Entry<Character,HashSet> entry : charMap2.entrySet()) {
            if(max < (int) Collections.max(entry.getValue())){
                max=(int) Collections.max(entry.getValue());
            }
        }
        strb = new char[max+1];
        Arrays.fill(strb, 0, max,' ');
        for(Map.Entry<Character,HashSet> entry : charMap2.entrySet()) {
            char key1 = entry.getKey();
            HashSet<Integer> val = entry.getValue();
            Iterator hasIt = val.iterator();
            while (hasIt.hasNext()) {
                int a = (int) hasIt.next();
                strb[a]= key1;
            }
        }
        String strs = String.valueOf(strb,0,strb.length);
        System.out.println("To String einai: "+strs);
            
    }
    
    public void freqterd(){
       HashSet<Character> we;
       HashMap<Integer ,HashSet> frequenMap2 = new HashMap<>();
       for(Map.Entry<Character,HashSet> entry : charMap2.entrySet()) {
            Integer numberOfChar = entry.getValue().size();
            HashSet<Integer> re = entry.getValue();
            Iterator hasIy = re.iterator();
            while (hasIy.hasNext()) {
                hasIy.next();
                if(!frequenMap2.containsKey(numberOfChar)){
                    we = new HashSet<> ();
                    we.add(entry.getKey());
                    frequenMap2.put(numberOfChar,we);
                }
                else{
                    for(Map.Entry<Integer ,HashSet> entry2 : frequenMap2.entrySet()){
                        HashSet<Character> el = entry2.getValue();
                        Iterator hasIp = el.iterator();
                        if(numberOfChar == entry2.getKey()){
                            el.add(entry.getKey());
                        }
                    }
                }     
            }   
        }
        int min = Collections.min(frequenMap2.keySet());
        int max = Collections.max(frequenMap2.keySet()); 
        for(Map.Entry<Integer ,HashSet> entry : frequenMap2.entrySet()) {
            HashSet<Character> re = entry.getValue();
            Iterator hasIy = re.iterator();
            if(entry.getKey()==min){
                if(entry.getValue().size()==1){
                    System.out.print("O Xarakthras Me Tis Ligoteres Emfaniseis Einai O :[");
                }
                else{
                    System.out.print("Oi Xarakthres Me Tis Ligoteres Emfaniseis Einai Oi :[");
                }
                while (hasIy.hasNext()) {
                    System.out.print(" "+hasIy.next()+" ");
                }
                System.out.println("]");
            }
            if(entry.getKey()==max){
                if(entry.getValue().size()==1){
                    System.out.print("O Xarakthras Me Tis Perissoteres Emfaniseis Einai O :[");
                }
                else{
                    System.out.print("Oi Xarakthres Me Tis Perissoteres Emfaniseis Einai Oi :[");
                }
                while (hasIy.hasNext()) {
                    System.out.print(" "+hasIy.next()+" ");
                }
                System.out.println("]");
            }
        }
    }     
}
    
    

