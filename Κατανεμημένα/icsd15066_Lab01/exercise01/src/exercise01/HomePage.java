package exercise01;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//KLASH GIA THN DHMIOURGEIA TOU PANEL THS ARXIKHS SELIDAS
public class HomePage extends javax.swing.JPanel {
    //DILWSH TWN METAVLITWN
    private JFrame frame; //METAVLITH TYPOU JFRAME GIA NA PERNEI TO MAINFRAME
    private CardLayout cardLayout; //DILWSH METAVLITIS GIA TO CARDLAYOUT 
    private Reservation reservation; //DILWSH METAVLITIS TYPOU KRATHSHS
    private DisplayReservation disP ; //DILWSH METAVLITIS TYPOU EMFANISHS KRATHSEWN
    private NewReservation resP; //DILWSH METAVLITHS TYPOU NEWN KRATHSEWN
    private Toolkit thekit; 
 
    //CONSTRUCTOR GIA THN ARXIKOPOIHSH TWN METAVLITWN KAI DHMIOURGEIA TOU JPANEL POU DEXETAI TO MAINFRAME WS ORISMA
    public HomePage(JFrame frame) {
        resP= new NewReservation(frame); //DIMIOURGEIA ANTIKEIMENOU JPANEL NEASKRATHSHS
        disP= new DisplayReservation(frame); //DHMIOURGEIA ANTIKEIMENOU JPANEL EMFANISHS KRATHSEWN
        thekit=frame.getToolkit();
        Color mycolor = Color.decode("#bf842c"); //DHMIOURGEIA XRWMATOS
        this.frame = frame;
        initComponents();//KWDIKAS ETOIMOS APO TO DESIGN TOU NETBEANS
      
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        newResButtn = new javax.swing.JButton();
        disResButtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(120, 120, 120));
        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Διαχείρηση Κρατήσεων");

        newResButtn.setBackground(new java.awt.Color(204, 204, 204));
        newResButtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newResButtn.setForeground(new java.awt.Color(51, 51, 51));
        newResButtn.setText("Νέα Κράτηση");
        newResButtn.setOpaque(false);
        newResButtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newResButtnActionPerformed(evt);
            }
        });

        disResButtn.setBackground(new java.awt.Color(204, 204, 204));
        disResButtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        disResButtn.setForeground(new java.awt.Color(51, 51, 51));
        disResButtn.setText("Εμφάνιση Κρατήσεων");
        disResButtn.setOpaque(false);
        disResButtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disResButtnActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(null);
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel2.setPreferredSize(new java.awt.Dimension(985, 528));
        ImageIcon icon = new ImageIcon(thekit.getImage("resImage.png"));
        Image image = icon.getImage().getScaledInstance(jLabel2.getPreferredSize().width,jLabel2.getPreferredSize().height,Image.SCALE_SMOOTH);
        jLabel2.setIcon(icon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(newResButtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(disResButtn)
                .addGap(234, 234, 234))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newResButtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disResButtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    //METHODOS GIA TO TI THA GINEI AN PATITHEI TO KOUMPI NEAS KRATHSHS
    private void newResButtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newResButtnActionPerformed
       
        resP=new NewReservation(frame);//DHMIOURGEI TO ANTIKEIMENO
        frame.getContentPane().add(resP,"Card2");//PROSTHETEI TO ANTIKEIMENO STO FRAME KAI ME CARDLAYOUT KAI TO ORIZEI WS CARD2
        cardLayout = (CardLayout) frame.getContentPane().getLayout();//DEXETE TO LAYOUT APO TO FRAME
        cardLayout.show(frame.getContentPane(),"Card2");//KAI META TO EMFANIZEI
        frame.setVisible(true);    //TO THETEI ORATO
    }//GEN-LAST:event_newResButtnActionPerformed
    //METHODOS GIA TO TI THA GINEI AN PATITHEI TO KOUMPI EMFANISH KRATHSEWN
    private void disResButtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disResButtnActionPerformed

        frame.getContentPane().add(disP,"Card3"); //PROSTHETEI STO FRAME TO ANTIKEIMENO TOU JPANEL TYPOU DISPLAYRESERVATION
        cardLayout = (CardLayout) frame.getContentPane().getLayout(); //DEXETE TO LAYOUT APO TO FRAME WS TYPO CARDLAYOUT
        cardLayout.show(frame.getContentPane(),"Card3");//KAI META ALLAZEI TO LAYOUT STO MAINFRAME ETSI WSTE NA DEIXNEI TO PANEL THS EMFANISHS
        frame.setVisible(true);//KANEI ORATO TO FRAME
    }//GEN-LAST:event_disResButtnActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton disResButtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton newResButtn;
    // End of variables declaration//GEN-END:variables
}
