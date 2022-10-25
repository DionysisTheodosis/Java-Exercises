//class to check the right user input from keyboard with JOptionPane 
package deitel7_1;

import javax.swing.JOptionPane;
public class InputChecker {
    public static int checker(String question,String userInput,int... rightInputs){
        int choice=0,flag,visit=0;
        String newUserInput;
        boolean ErrorFlag;
        do{
            ErrorFlag=false;
            flag=1;
            try {
                do{
                   
                    if(visit == 0){
                        //CHECKING IF USER HAVE PRESS CANCEL OR OK BUTTON AND ASKS AGAIN FOR THE RIGHT INPUT
                        while(userInput == null || userInput.isEmpty()){
                            userInput = JOptionPane.showInputDialog(question); 
                        }
                        
                        choice = Integer.parseInt(userInput);
                        for(int i: rightInputs){
                            if(choice==i){
                                flag=0;
                            }
                        }
                        visit=1;
                    }
                    else if(visit == 1 ){
                        //CHECKING IF USER HAVE PRESS CANCEL OR OK BUTTON AND ASKS AGAIN FOR THE RIGHT INPUT
                        do{
                            newUserInput = JOptionPane.showInputDialog(question);     
                        }
                        while(newUserInput== null || newUserInput.isEmpty());
                        choice = Integer.parseInt(newUserInput);
                        for(int i: rightInputs){                              
                            if(choice == i){
                                flag=0; 
                            }
                        }        
                    }
                }
                while(flag==1);
            }
            catch (NumberFormatException e) //IN CASE OF USER HAVE PRESS ANY OTHER CHARACTER FOR TO NOT CLOSE PROGRAM
            {
                JOptionPane.showMessageDialog(null,e);
                JOptionPane.showMessageDialog(null,"Please Press The Right Choice");
                ErrorFlag=true;
            }
            visit=1;
        }
        while(ErrorFlag==true);
        
        return choice;
    }
}
