/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;


//KLASH GIA THN DHMIOURGEIA POPUP PANEL GIA THN EPILOGH THS HMEROMHNIAS SAN HMEROLOGIO
public class CalendarPopUp  {
    //METAVLITES KLASHS
    private JPanel mainPanel; //METAVLITI GIA TO MAINFRAME 
    private static JPanel popUpPanel,dayPanel; 
    private static JButton[] day;//METAVLITI GIA TA KOUMPIA TWN HMERWN
    private static JLabel monthYear;//METAVLITI GIA TON MHNA KAI ETOS
    private int month; 
    private int year;
    private Calendar a;//GIA TO HMEROLOGIO
    private int[] daysOfBtn;//DHMIOURGEIA PINAKA GIA THN TIMH POU THA EMFANIZETE
    private Calendar displayDate; 
    private JButton el; //METAVLITI GIA TO TEXTFIELD POU EMFANIZETAI H HMEROMHNIA
    private String stringDate; //METAVLITH POU THA KRATAEI SWSTA MOPRFOPOIHMENH THN HMEROMHNIA
    private int k=0,c=1;
    private boolean selected=false; //METAVLITH GIA NA DIXNEI AN EXEI EPILEXTHEI KAPOIA MERA
    private JButton prevSel; //GIA TO PROHGOUMENO PLHKTRO POU PATITHIKE
    private PopupFactory popF;
    private static Popup p;//GIA TO POPUP
    private static boolean isActive;//NA MAS DEIXNEI AN EINAI ENERGO TO POPUP    
    private Point cellPossition;//METAVLITI GIA NA PAREI TIS SYTETAGMENES TOU PANEL POU TO KALESE
    private Date pickedDate; //H HMERA POU EPELEXE
    private Date firstDate; //H HMERA POU XEKINAEI
  
    //COSTRUCTOR O OPOIOS DEXETAI TO PANEL STO OPOIO THA VRISKETE ,TO PANEL THS HMEROMHNIAS WSTE NA EMFANISEI KONTA TO POPUP,KAI THN PRWTH MERA POUXEKINAEI H EPILOGH
      public CalendarPopUp(JPanel mainPanel,JButton el,Date firstDate){
        this.firstDate= firstDate; 
        this.pickedDate=firstDate;
        this.el=el;
        this.mainPanel = mainPanel;
        cellPossition = el.getLocationOnScreen();//APOTHIKEUH THN TOPOTHESIA TOU KELIOU
        isActive=true;//THETH THN ENDEIXH OTI TO POP UP EINAI ACTIVE
        popF = new PopupFactory();
        initComponents();
        setDate();
    }
    
    private void initComponents(){
        //DIMIOURGEI TO PANEL TOU POPUP
        popUpPanel = new JPanel();
        popUpPanel.setBackground(Color.LIGHT_GRAY);
        popUpPanel.setLayout(new BorderLayout());
        //DIMIOURGEI TO PANEL TOU KOUMPIOU
        dayPanel = new JPanel();
        dayPanel.setBackground(Color.GRAY);
        //THETH THN DIATAXH TWN KOUMPIWN ANALOGA 
        dayPanel.setLayout(new GridLayout(7,7,0,0));
    
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("M yyyy");//DHMIOURGEI ANTIKEIMENO GIA THN SWSTH EMFANISH THS HMEROMHNIA GIA TON MHNA KAI TO ETOS
        JLabel sunday = new JLabel("Κυ",JLabel.CENTER);//DHMIOURGIA GIA  THN KURIAKH
        sunday.setForeground(Color.red);//VAZEI XRWMA KOKKIONO
        dayPanel.add(sunday); //TO PROSTHETH STO PANEL TOU POPUOP
        dayPanel.setFocusable(false);
        dayPanel.add(new JLabel("Δε",JLabel.CENTER));
        dayPanel.add(new JLabel("Τρ",JLabel.CENTER));
        dayPanel.add(new JLabel("Τε",JLabel.CENTER));
        dayPanel.add(new JLabel("Πε",JLabel.CENTER));
        dayPanel.add(new JLabel("Πα",JLabel.CENTER));
        dayPanel.add(new JLabel("Σα",JLabel.CENTER));
        thisMonth();//SYNARTISI GIA NA THESH TON MHNA
        daysOfBtn = new int[42];//FTIAXNEI ENAN PINAKA GIA TO NOUMERO POU THA EXEI H HMERA
        day = new JButton[42];//DIMIOURGEI TON PINAKS KOUMPIRWN
        //PROSPELASH GIA THN DHMIOURGIA TWN 42 KOUMPIWN
        for(int i=0;i<42;i++){
            k=i;
            day[i] = new DayCell(el);//DHMIOURGEIA NEAS MERAS K PROSTHIKI STO KOUMPI
            //PROSTHETH TO KOUMPI STO PANEL TWN KOUMPIWN     
            dayPanel.add(day[i]);//THN EISAGEI STO PANEL
            dayPanel.setPreferredSize(new Dimension(350,250));
            dayPanel.setVisible(true);
        }  
        JPanel pan = new JPanel(); //DHMIOURGEI TO PANEL POU THA EXEI KAI TON XRONO MHNA KAI TA ONOMATA TWN HMERWN
        pan.setBackground(Color.darkGray);
        displayDate = a;
        monthYear = new JLabel();//FTIAXNEI TO LABEL POU THA DEIXNEI TON MHNA
        showMonthYear(); //EMFANIZEI TON MHNA
        JButton previous = new JButton("\u2190");//FTIAXNEI KOUMPI KAI VAZEI TO ARISTERO VELAKI SAN TEXT
        previous.setFocusable(false);
        previous.setBackground(new Color(224, 224, 224));
        previous.addActionListener(new ActionListener(){//AN PATITHEI
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month == 1) {//AN O MHNAS EINAI =1 TOTE TON MHNA TON KANEI =12 KAI ALLAZEI XRONO 
                    month = 12;
                    year--;
                } else {//ALLIWS TON MEIWNEI APLA KATA 1
                    month--;
                }
               showMonthYear();//XANAUPOLOGIZEI TON MHNA KAI XRONO GIA SWSTH EMFANISH 
               setDate();//FTIAXNEI TIS MERES
            }           
                 
        });
        pan.add(previous);//PROSTHETH STO PANEL TO KOUMPI 
        pan.add(monthYear);//PROSTHETH TO LABEL POU DEIXNEI MHNA KAI ETOS
        JButton next = new JButton("\u2192"); //DHMIOURGEI KOUMPI GIA NA ALLAZEI STON EPOMENO MHNA KAI VAZEI TO DEXI VELAKI
        next.setBackground(new Color(224, 224, 224));
        next.setFocusable(false);
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
               // slide.show(new PanelDate(month, year));
                showMonthYear();
                setDate();
            }
            
            
        });
        pan.add(next);//TO PROSTHETH STO PANEL TITLOU
        JButton exit = new JButton("close");//DHMIOURGEIA KOUMPIOU EXODOU
        exit.setBackground(new Color(224, 224, 224));
        exit.setFocusable(false);
        pan.add(exit);//PROSTHIKI STO PANEL
        
        exit.addActionListener(new ActionListener(){//AN PATITHEI TOTE KANEI TO POPUP MH EMFANISIMO
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePopUp();
            }
            
        });
        
        popUpPanel.add(pan,BorderLayout.NORTH);//PROSTHETH TO PAN POU PERIEXEI THN HMEROMHNIA TA KOUMPIA DEXIA ARISTERA KAI TO EXIT STO PANEL STO PANW MEROS
        popUpPanel.add(dayPanel,BorderLayout.CENTER);//KAI META PROSTHETEI TA KOUMIA POU THA DEIXNOUN THS MERES STO KENTRO TOU POPUP PANEL
        popUpPanel.setToolTipText("Πάτα 2 φορές σε μία μέρα για επιλογή, αλλίως close για να ακυρώσεις");//GIA NA ENHMERWNEI TON XRHSTH
     
        
        p = popF.getPopup(mainPanel,popUpPanel,cellPossition.x,cellPossition.y);//PROSTHIKI TOU POPUP STHN THESH TOU KELIOU 
       
        p.show();//EMFANISH TOU POPUP
    }
    //METHODOS GIA NA DEIXNEI AN TO POPUP EINAI ENERGO
    public static boolean isActive(){
        return isActive;
    }
    //METHODOS GIA THN ENERGOPOIHSH TOU POPUP
    public  void disablePopUp(){
        if(isActive){
            p.hide();
            isActive = false;
        }
                
    }
    //METHODOS GIA NA EPISTREPSEI TO POPUP PANEL
    public  JPanel getPopUp(){
        return popUpPanel;
    }
    
    //METHODOS GIA THN DHMIOURGEIA TWN KOMPIWN POU THA DEIXNOUN TIS MERES KATHOS KAI GIA THN EPILOGH
    private void setDate() {
        Calendar calendar= Calendar.getInstance();//DHMIOURGEIA HMEROLOGIOU
        calendar.setTime(firstDate);//THETH THN HMEROMHNIA TOU HMEROLOGIOU WS THN FISRTDATE
        ToDay toDay = new ToDay(calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH) + 1,calendar.get(Calendar.YEAR));//DHMIOURGEIA ANTIKEIMENOU TODAY GIA NA ORISEI THN SHMERINH MERA
        calendar.set(Calendar.YEAR, year); //THETEI TON XRONO
        calendar.set(Calendar.MONTH, month - 1);  // THETEI TON MHNA
        calendar.set(Calendar.DATE, 1); //THETH THN MERA
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  THETH TH PRWTH MERA THS EVDOMADAS POU ARXIZEI THN KURIAKH
        calendar.add(Calendar.DATE, -startDay);
        //PROSPELASH OLWN TWN KOUMPIWN GIA THN HMERA
        for (JButton i: day) {
            DayCell cell = (DayCell) i;//DHMIOURGEI TO KOUMPI THS HMERAS KAI TOU PERNAEI THN TIMH TOU IDI FTIAGMENOU
            cell.setText(calendar.get(Calendar.DATE) + "");
            //cell.setFont(new Font("Arial", Font.PLAIN, 9));
            cell.setFocusable(false);
            cell.setDate(calendar.getTime());
            cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
            SimpleDateFormat DateFor = new SimpleDateFormat("EE-d-MM-YYYY");
            Calendar al= Calendar.getInstance();
            al.setTime(firstDate);
            cell.addActionListener(new ActionListener(){//AN PATITHEI H HMERA
                @Override
                public void actionPerformed(ActionEvent e) {//AN PATITHEI KAPOIO GRAMMA APO TO POPUP
                    al.setTime(cell.getDate()); //PERNAEI STO HMEROLOGIO STHN HMEROMHNIA THN HMEROMHNIA TOU KOUMPIOU
                    if(!al.getTime().before(firstDate)){//AN TO KOUMPI EINAI META THS PRWTHS MERA TOTE MPOREI NA PATITHEI
                        stringDate = DateFor.format(al.getTime());//PERNAEI THN HMEROMHNIA TOU KOUMPIOU ME SWSTO FORMAT SE STRING GIA EMFANISH 
                        if(el.getText().equals(stringDate)){//EINAI GIA NA PAREI ME THN DEUTERH FORA POU THA PATITHEI THN TIMH
                            //mainPanel.enableButton();//ENERGOPOIEI TO KOUMPI EPILOGHS GIA THN HMEROMHNIA ANAXWRISIS
                            pickedDate=al.getTime();//THETH THN EPILEGMENH HMEROMHNIA STO PICKEDdATE
                            disablePopUp();//APENERGOPOIEI TO POPUOP
                        }
                        else if(selected){//AN EINAI EPILEGMENO DHLADH EPIL
                            prevSel.setBorder(null);//THETH TO PROHGOUMENO NA MHN EXEI BORDER AUTO GIA OTAN EPILEXOUME ALLO ANTI GIA DEUTERH FORA TO IDIO
                            selected=false;
                        }
                        else{//ALLIWS VAZEI BORDER BLE XRWMATOS STHN EPILEGMENH MERA
                            cell.setBorder(BorderFactory.createLineBorder(Color.blue)); 
                            selected=true;
                            prevSel=cell;//VAZEI STO PROHGOUMENO SELECTED PLHKTO HMERAS TO EPILEGMENO PLHKTRO
                            el.setText(stringDate);//KAI PROSTHETH TO TEXT STO PANEL POU EMFANIZEI THN HMEROMHNIA
                        
                        }                                  
                    }                              
                }
            });  
            //ELEGXEI AN H HMERA EINAI DHMERA KAI AN EINAI TOTE THETEI THN HMERA TOU KOUMPIOU WS SHMERA GIA NA DWSEI TO KATALHLO XRWMA KAI NA GINOUN OI UPOLOGISMOI
            if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                cell.setAsToDay();
            }
            calendar.add(Calendar.DATE, 1); //KATHE FORA AUXANEI KATA 1
        }
    }
        
    //METHODOS GIA THN EISAGWGH TOU MHNA POU EINAI SHMERA    
    private void thisMonth() {
        Calendar calendar = Calendar.getInstance();//DHMIOURGEIA HMEROLOGIOU KAI ARXIKOPOIHSH ME THN SHMERINH HMEROMHNIA
        calendar.setTime(firstDate);//THETH THN HMEROMHNIA ME THN PRWTH
        month = calendar.get(Calendar.MONTH) + 1; //APOTHYKEYEI TON MHNA 
        year = calendar.get(Calendar.YEAR);//APOTHYKEUEI TO XRONO
    }
    
    //METHODOS GIA THN EMFANISH TOU MHNA KAI TOU XRONOU
    private void showMonthYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMM-yyyy");
        monthYear.setForeground(new Color(224, 224, 224));
        monthYear.setFont(new Font("Arial", Font.PLAIN, 14));
        monthYear.setText(df.format(calendar.getTime()));//PROSTHETEI STO TEXTTOU MONTH YEAR 
    }

    //METHODOS GIA THN EPISTROFH THS MERAS POU EXEI EPILEXTHEI
    public Date getDateS(){
        return pickedDate;
    }
    //METHODOS GIA NA ENERGOPOIHSH TO POPUP
    public void enablePopUp(){
        p.show();
    }
}