//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package clientgui;

import shared.FlightService;
import java.rmi.RemoteException;
import shared.FlightBooking;
import javax.swing.JOptionPane;
import static mytools.StringDate.*;

//KLASH GIA TO PANEL THN MONHS PTHSHS
public class OneWayPanel extends javax.swing.JPanel {
    //PARAMETROI KLASHS
    private final FlightBooking flight;           //PARAMETROS GIA TIS KRATHSEIS
    private final FlightService flightService;    //PARAMETROS GIA THN METAVLITI SYNDESHS-INTERFACE
  
    //CONSTRUCTOR KLASHS POU DEXETAI TIS KRATHSEIS KAI THN PARAMETRO TOU INTERFACE SUNDESHS
    public OneWayPanel(FlightBooking flight,FlightService flightService) {
        this.flight=flight;
        this.flightService=flightService;
        initComponents();   //KALEI THN METHODO THS ARXEIKOPOIHSHS TOU PANEL
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        departureRoutePanel = new javax.swing.JPanel();
        departureTitle = new javax.swing.JLabel();
        flightRouteLabel = new javax.swing.JLabel();
        flightCredPanel = new javax.swing.JPanel();
        departurePanel = new javax.swing.JPanel();
        departureTimeLabel = new javax.swing.JLabel();
        departureAirCLabel = new javax.swing.JLabel();
        arrivalPanel = new javax.swing.JPanel();
        arrivalTimeLabel = new javax.swing.JLabel();
        arrivalAirCLabel = new javax.swing.JLabel();
        departureDateLabel = new javax.swing.JLabel();
        availableSeatsPanel = new javax.swing.JPanel();
        availableSeatsTLabel = new javax.swing.JLabel();
        availableSeatsNLabel = new javax.swing.JLabel();
        priceTitleLabel = new javax.swing.JLabel();
        priceNLabel = new javax.swing.JLabel();
        bookingButton = new javax.swing.JButton();

        MainPanel.setBackground(java.awt.Color.lightGray);

        departureRoutePanel.setBackground(java.awt.Color.lightGray);

        departureTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        departureTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        departureTitle.setText("Αναχώρηση:");

        flightRouteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        flightRouteLabel.setText(flight.getOutboundFlight().getOrigin()+"-"+flight.getOutboundFlight().getDestination());

        javax.swing.GroupLayout departureRoutePanelLayout = new javax.swing.GroupLayout(departureRoutePanel);
        departureRoutePanel.setLayout(departureRoutePanelLayout);
        departureRoutePanelLayout.setHorizontalGroup(
            departureRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departureRoutePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(departureTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flightRouteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        departureRoutePanelLayout.setVerticalGroup(
            departureRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departureRoutePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(departureRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departureTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flightRouteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        flightCredPanel.setBackground(new java.awt.Color(255, 255, 255));

        departurePanel.setOpaque(false);

        departureTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        departureTimeLabel.setText(flight.getOutboundFlight().getOriginAirportId());

        departureAirCLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        departureAirCLabel.setText(flight.getOutboundFlight().getDepartureDate().getHour()+":"+flight.getOutboundFlight().getDepartureDate().getMinute());

        javax.swing.GroupLayout departurePanelLayout = new javax.swing.GroupLayout(departurePanel);
        departurePanel.setLayout(departurePanelLayout);
        departurePanelLayout.setHorizontalGroup(
            departurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departurePanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(departureAirCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departureTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        departurePanelLayout.setVerticalGroup(
            departurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departurePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(departurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departureAirCLabel)
                    .addComponent(departureTimeLabel))
                .addContainerGap())
        );

        arrivalPanel.setOpaque(false);

        arrivalTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        arrivalTimeLabel.setText(flight.getOutboundFlight().getDestinationAirportId());

        arrivalAirCLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        arrivalAirCLabel.setText(flight.getOutboundFlight().getArrivalDate().toLocalTime().getHour()+":"+flight.getOutboundFlight().getArrivalDate().toLocalTime().getMinute());

        javax.swing.GroupLayout arrivalPanelLayout = new javax.swing.GroupLayout(arrivalPanel);
        arrivalPanel.setLayout(arrivalPanelLayout);
        arrivalPanelLayout.setHorizontalGroup(
            arrivalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arrivalPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrivalAirCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arrivalTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        arrivalPanelLayout.setVerticalGroup(
            arrivalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arrivalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(arrivalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalAirCLabel)
                    .addComponent(arrivalTimeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        departureDateLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        departureDateLabel.setText(formatDate(flight.getOutboundFlight().getDepartureDate().toLocalDate()));

        availableSeatsPanel.setOpaque(false);

        availableSeatsTLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        availableSeatsTLabel.setText("Θέσεις:");

        availableSeatsNLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        availableSeatsNLabel.setText(String.valueOf(flight.getOutboundFlight().getAvailableSeats()));

        javax.swing.GroupLayout availableSeatsPanelLayout = new javax.swing.GroupLayout(availableSeatsPanel);
        availableSeatsPanel.setLayout(availableSeatsPanelLayout);
        availableSeatsPanelLayout.setHorizontalGroup(
            availableSeatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableSeatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(availableSeatsTLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableSeatsNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        availableSeatsPanelLayout.setVerticalGroup(
            availableSeatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(availableSeatsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(availableSeatsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableSeatsTLabel)
                    .addComponent(availableSeatsNLabel)))
        );

        javax.swing.GroupLayout flightCredPanelLayout = new javax.swing.GroupLayout(flightCredPanel);
        flightCredPanel.setLayout(flightCredPanelLayout);
        flightCredPanelLayout.setHorizontalGroup(
            flightCredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightCredPanelLayout.createSequentialGroup()
                .addGroup(flightCredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightCredPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(departurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(arrivalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(availableSeatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightCredPanelLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(departureDateLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        flightCredPanelLayout.setVerticalGroup(
            flightCredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flightCredPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(departureDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(flightCredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arrivalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(departurePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(flightCredPanelLayout.createSequentialGroup()
                        .addComponent(availableSeatsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        priceTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priceTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        priceTitleLabel.setText("Τιμή:");

        priceNLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        priceNLabel.setText(Double.toString(flight.getPrice())+"€");
        priceNLabel.setToolTipText("");

        bookingButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bookingButton.setText("Κάνε Κράτηση");
        bookingButton.setFocusable(false);
        bookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departureRoutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(flightCredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(bookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(priceTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(priceNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(departureRoutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flightCredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTitleLabel)
                    .addComponent(priceNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(bookingButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents
    //METHODOS GIA TO OTAN PATITHEI TO KOUMPI THS KRATHSHS
    private void bookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingButtonActionPerformed
        try {
            String answer = flightService.bookFlight(flight);   //KANEI KLHSH STON SERVER1 GIA DWSEI THN KRATHSH KAI NA PAREI WS APANTHSH AN EGINE H OXI
            if(answer.contains("Cannot invoke \"java.io.ObjectOutputStream.close()\" because \"this.output\" is null")){
                JOptionPane.showMessageDialog(null, "Η σύνδεση με τον server βάσης χάθηκε\nΑποτυχία κράτησης",null,JOptionPane.ERROR_MESSAGE);
            }
            else{
               JOptionPane.showMessageDialog(bookingButton.getRootPane(), answer, "Ενημέρωση Κράτησης", JOptionPane.INFORMATION_MESSAGE); 
           }
        } catch (RemoteException ex) {  //AN YPARXH KAPOIO EXCEPTION POU SXETIZETAI ME THN SYNDESH H ME TO AN DEN VRETHIKAN
            //GIA THN PERIPTWSH POU EGINE KAPOIO PROVLHMA STHN SYNDESH
            if (ex.getMessage() != null && (ex.getMessage().contains("Connection refused") || ex.getMessage().contains("No route to host"))) {
                JOptionPane.showMessageDialog(null, "Η σύνδεση με τον server χάθηκε το πρόγραμμα θα τερματιστεί",null,JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            else{//GIA TO AN DEN EGINE H KRATHSH LOGO OTI DEN UPHRXAN THESEIS
                JOptionPane.showMessageDialog(bookingButton.getRootPane(), "Αποτυχία κράτησης\nΔεν υπάρχουν διαθέσιμες θέσεις", "Ενημέρωση Κράτησης", JOptionPane.ERROR_MESSAGE);
            }  
        }
        //KAI TA PARAKATW GIA NA DIAGRAPSOUN TO PANEL THS KRATHSHS
        this.removeAll();
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_bookingButtonActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel arrivalAirCLabel;
    private javax.swing.JPanel arrivalPanel;
    private javax.swing.JLabel arrivalTimeLabel;
    private javax.swing.JLabel availableSeatsNLabel;
    private javax.swing.JPanel availableSeatsPanel;
    private javax.swing.JLabel availableSeatsTLabel;
    private javax.swing.JButton bookingButton;
    private javax.swing.JLabel departureAirCLabel;
    private javax.swing.JLabel departureDateLabel;
    private javax.swing.JPanel departurePanel;
    private javax.swing.JPanel departureRoutePanel;
    private javax.swing.JLabel departureTimeLabel;
    private javax.swing.JLabel departureTitle;
    private javax.swing.JPanel flightCredPanel;
    private javax.swing.JLabel flightRouteLabel;
    private javax.swing.JLabel priceNLabel;
    private javax.swing.JLabel priceTitleLabel;
    // End of variables declaration//GEN-END:variables
}
