/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package exercise01;

import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//KLASH GIA THN DHMIOURGEIA TOU PANEL THS EMFANISHS TWN KRATHSEWN
public class DisplayReservation extends javax.swing.JPanel {
    //DILWSH TWN METAVLITWN
    private JFrame frame; //METAVLITI GIA TO MAINFRAME
    private CardLayout cardLayout; //METAVLITH GIA TO LAYOUT TOU MAINFRAME
    
    //CONSTRUCTOR GIA THN YLOPOIHSH TOU PANEL KAI DEXETAI WS ORISMA TO MAINFRAME
    public DisplayReservation(JFrame frame) {
        this.frame = frame;
        initComponents();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(917, 602));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Κρατήσεις");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Πίσω");
        jButton1.setActionCommand("");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Όνομα", "Επώνυμο", "Τηλέφωνο", "Πρωινό", "Ημέρα Άφιξης", "Ημέρα Αναχώρησης", "Τύπος Δωματίου", "Κόστος"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jTable1.setOpaque(false);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Εμφάνιση με κριτήριο");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Εμφάνιση όλων");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3});

    }// </editor-fold>//GEN-END:initComponents
   //METHODOS GIA THN EISAGWGH TWN STOIXEIWN TWN KRATHSEWN STO JTABLE
    public static void setTable(ArrayList<Reservation> reservation){
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); //DHMIOURGEIA TOU ANTIKEIMENOU POU PERNEI TO MODEL TOU JTABLE
        model.setRowCount(0);//DIAGRAFEI OLA TA STOIXEIA TOU PINAKA
        //EPANALIPSI GIA THN PROSPELASH OLWN TWN KRATHSEWN 
        for(int i=0;i<reservation.size();i++){
            Object[] newRow = new Object[8];//DIMIOURGEIA ENOS NEOU OBJECT GRAMMHS 8 STHLWN
            newRow[0] = reservation.get(i).getPersonData().getName();//PROSTHETEI STHN PRWTH STHLH TO ONOMA
            newRow[1] = reservation.get(i).getPersonData().getLastName(); //PROSTHETEI STHN DEUTERH STHLH TO EPITHETO
            newRow[2] = reservation.get(i).getPersonData().getTel(); //...THLEFWNO
            newRow[3] = (reservation.get(i).getBreakfast())?"ΝΑΙ":"ΟΧΙ";//....PRWINO
            newRow[4] = formatDate(reservation.get(i).getCheckIn());//..HMEROMHNIA AFIXHS
            newRow[5] = formatDate(reservation.get(i).getCheckOut());//..HMEROMHNIA ANAXWRISHS
            newRow[6] = reservation.get(i).getNBeds();//..TUPO DWMATIOU
            newRow[7] = reservation.get(i).getCost();//..KOSTOS KRATHSHS
            model.addRow(newRow); //TA PROSTHETEI
        }
    }
    //METHODOS GIA TO TI THA GINEI AN PATISEI PISW
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cardLayout = (CardLayout) frame.getContentPane().getLayout();//DEXETE TO LAYOUT TOU FRAME
        cardLayout.show(frame.getContentPane(),"Card1");//KAI KANEI NA FANEI H ARXIKH SELIDA
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //AN PATHSEI ANAZHTHSH ME KRITIRIO
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Dial pn = new Dial(frame);//DHMIOURGEIA TOU DIALOG ANAZHTHSH
       
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    //METHODOS GIA TO AN PATISEI EMFANISEI OLWN
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jLabel1.setText("Συνολικές κρατήσεις");//EISAGWGH TOU TITLOU
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] newRow = new Object[8];
        for(int i=0;i<Reservations.getNumber();i++){
            newRow[0]=Reservations.getReservations().get(i).getPersonData().getName();
            newRow[1]=Reservations.getReservations().get(i).getPersonData().getLastName();
            newRow[2]= Reservations.getReservations().get(i).getPersonData().getTel();
            newRow[3]=(Reservations.getReservations().get(i).getBreakfast())?"ΝΑΙ":"ΟΧΙ";
            newRow[4]=formatDate(Reservations.getReservations().get(i).getCheckIn());
            newRow[5]=formatDate(Reservations.getReservations().get(i).getCheckOut());
            newRow[6]=Reservations.getReservations().get(i).getNBeds();
            newRow[7]=Reservations.getReservations().get(i).getCost(); 
            model.addRow(newRow); 
          } 
    }//GEN-LAST:event_jButton3ActionPerformed
   //METHODOS GIA THN MORFOPOIHSH MIAS DOTHISAS HMERAS STHN MORFH POU THELOUME
    private static String formatDate(Date date){
        SimpleDateFormat DateFor = new SimpleDateFormat("EE-d-MM-YYYY");
        Calendar al= Calendar.getInstance();
        al.setTime(date);
        return DateFor.format(al.getTime());
    }
    //METHODOS GIA THN PROSTHIKH TOU TITLOU KAI WS STATIC GT THELOUME NA MPOROUN NA TO FONAXOUN KAI ALLES KLASHS 
    public static void setTitle(String title){
        jLabel1.setText(title);
 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
