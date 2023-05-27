//DIONYSIOS THEODOSIS AM:321/2015066 2H OMADIKH KATANEMHMENA
package server2;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared.Flight;
import shared.FlightBooking;
import shared.FlightSearchCrit;


//KLASH H OPOIA YLOPIEI THN SYNDESH ME THN VASH KATHWS KAI TA ERWTHMATA
public class DatabaseManager {
    //DILWSH PARAMETRWN KLASHS
    private Connection connection;          //PARAMETROS GIA THN SYNDESH ME THN VASH
    private final String databaseUrl;       //METAVLITH GIA TO URL THS VASHS
    
    //CONSTRUCTOR THS KLASHS POU PERNEI WS ORISMA TO URL
    public DatabaseManager(String databaseUrl) {
        this.databaseUrl=databaseUrl;
    }
    
    //METHODOS THS VASHS GIA THN SYNDESH
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(databaseUrl);   
    }
    
    //METHODOS GIA THN APOSYNDESH APO THN VASH
    public void disconnect() throws SQLException {
        if (connection != null) {   //ELEGXEI AN YPARXEI SYNDESH 
            connection.close();     //KLEINEI THN SYNDESH
        }
    }
    
    //METHODOS GIA THN EISAGWGH EGGRAFHS STHN VASH KAI DEXETAI WS ORISMA ENA ANTIKEIMENO POU PERIEXEI TIS MATAVLITES GIA THN KRATHSH
    public String insertData(FlightBooking bookedCred) throws SQLException {
        //FTIAXNOUME TO STRING GIA TO SQL QUERY
        String sql = "INSERT INTO BookedFlights (outbound_flight_id, return_flight_id, price, passengers) VALUES (?, ?, ?, ?)";
        int generatedId = -1;  //THETOUME MIA DEFAULT METAVLITH SE PERIPTWSH POU DEN GINEI H EGGRAFH KAI DEN VRETHEI KLIDI
        //FTIAXNOUME TO PREPAREDSTATEMENT
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            //KANOUME ELEGXO AN EINAI TAXIDI XWRIS EPISTROFH KAI AN EINAI KANOUME THN KRATHSH GIA TO TAXIDI ME APLH PTHSH
            if (bookedCred.getReturnFlight() == null) {
                //ELEGXOUME AN YPARXOUN DIATHESIMES THESEIS GIA THN PRWTH PTHSH
                int availableSeats = getAvailableSeats(bookedCred.getOutboundFlight().getFlightId());  //PERNOUME TON ARITHMO TWN DIATHESIMWN THESEWN
                if (bookedCred.getPassengers() <= availableSeats) { //EXETAZOUME AN OI EPIVATES EINAI LIGOTEROI H ISOI APO TIS DIATHESIMES THESEIS
                    //THETOUME TIS TIMES STO PREPARED STATEMENT
                    stmt.setInt(1, bookedCred.getOutboundFlight().getFlightId());     //TO ID THS PTHSHS
                    stmt.setNull(2, Types.INTEGER);                                  //THETOUME WS NULL TO ID THS PTHSHS EPISTROFHS
                    stmt.setDouble(3, bookedCred.getPrice());                        //THETOUME THN TIMH
                    stmt.setInt(4, bookedCred.getPassengers());                     //THETOUME TOUS EPIVATES
                
                    //TREXOUME TO STATEMENT KAI PERNOUME NA DOUME AN EPIREASTIKAN OI GRAMMES
                    int rowsAffected = stmt.executeUpdate();
                
                    if (rowsAffected == 1) {  //EDW TSEKAROUME AN EPIREASTIKAN
                        //VRYSKOUME TO ID THS PTHSHS
                        ResultSet generatedKeys = stmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            generatedId = generatedKeys.getInt(1);
                        }
                    }
                
                    return ("Η κράτηση έγινε επιτυχώς\nΚωδικός κράτησης : " + generatedId);//EPISTREFOUME TO MINIMA 
                } else {
                    return ("Δεν υπάρχουν διαθέσιμες θέσεις για την πτήση.");//EPISTREFOUME TO MINIMA 
                }
            } else { //GIA THN PERIPTWSH POU EINAI ME EPISTROFH
                
                // PERNOUME TIS DIATHESIMES THESEIS GIA THN PTHSH THS ANAXWRHSHS
                int availableOutboundSeats = getAvailableSeats(bookedCred.getOutboundFlight().getFlightId());
                //PERNOUME TIS DIATHESIMES THESEIS GIA THN PTHSH THS EPISTREOFHS
                int availableReturnSeats = getAvailableSeats(bookedCred.getReturnFlight().getFlightId());
                //ELEGXOUME AN YPARXOUN DIATHESIMES THESEIS KAI GIA TIS 2 PTHSEIS
                if (bookedCred.getPassengers() <= availableOutboundSeats && bookedCred.getPassengers() <= availableReturnSeats) {
                    //THETOUME TIS TIMES GIA TO PREPAREDSTATEMENT
                    stmt.setInt(1, bookedCred.getOutboundFlight().getFlightId());   //TO ID TIS PTHSHS ANAXWRHSHS
                    stmt.setInt(2, bookedCred.getReturnFlight().getFlightId());     //TO ID THS PTHSHS THS EPISTROFHS
                    stmt.setDouble(3, bookedCred.getPrice());                       //THN TIMH THS KRATHSHS
                    stmt.setInt(4, bookedCred.getPassengers());                    //TON ARITHMO TWN EPIVATWN
                
                    //TREXOUME TO STATEMENT KAI APOTHYKEUOUME TIS EPIREASMENES GRAMMES
                    int rowsAffected = stmt.executeUpdate();
                    //ELEGXOUME AN EPHREASTHKE KAPOIA GRAMMH GIA NA DOUME AN EGINE H EISAGWGH
                    if (rowsAffected == 1) {
                        //PERNOUME TO ID THS PTHSHS
                        ResultSet generatedKeys = stmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            generatedId = generatedKeys.getInt(1);
                        }
                    }
                    return ("Η κράτηση έγινε επιτυχώς\nΚωδικός κράτησης : " + generatedId); //TO MINIMA AN EGINE H KRATHSH
                } else {
                    return ("Δεν υπάρχουν διαθέσιμες θέσεις για τις πτήσεις.");             //TO MHNIMA AN DEN YPIRXAN DIATHESIMES THESEIS
                }
            }
        } catch (SQLException e) {
            return ("Error inserting booking: " + e.getMessage());                         //MINIMA AN PHGE KATI STRAVA KATA THN DIARKEIA THS EISAGWGHS STHN VASH
        }
    }
    
    //METHODOS GIA NA PAIRNOUME TIS DIATHESIME PTHSEIS APO TON PINAKA TWN DIATHESIMWN PTHSEWN VASH ENOS ID PTHSHS
    private int getAvailableSeats(int flightId) throws SQLException {
        
        //DILWNOUME KAI ARXIKOPOIOUME TO SQL QUERY
        String sql = "SELECT available_seats FROM available_flights WHERE flight_id = ?";
        //DHMIOURGOUME TO PREPAREDSTATEMENT
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            //THETOUME THN TIMH GIA TO STATEMENT
            stmt.setInt(1, flightId);
            try (ResultSet rs = stmt.executeQuery()) {            //TREXOUME TO STATEMENT
                if (rs.next()) {                                 //KAI AN VREI THN PTHSH
                    return rs.getInt("available_seats");  //EPISTREFOUME TON ARITHMO TWN DIATHESIMWN THESEWN
                }
            }
        }
        return 0; //ALLIWS EPISTREFOUME 0
    }
    
    
 
    //METHODOS GIA THN ANAZHTHSH DIATHESEWN THESEWN KAI DEXETAI WS ORISMA ENA ANTIKEIMENO POU PERIEXEI TIS MATAVLITES GIA THN ANAZHTHSH
    public List<FlightBooking> searchData(FlightSearchCrit criteria) throws SQLException {
        List<FlightBooking> availableFlights = new ArrayList<>();   //LISTA POU THA PERIEXEI OLES TIS DIATHESIMES PTHSEIS
        List<Flight> departureFlights = new ArrayList<>();          //LISTA GIA TIS PTHSEIS POU ANAXWROUN
        List<Flight> returnFlights = new ArrayList<>();             //LISTA GIA TIS PTHSEIS TWN AFHXEWN
        //DILWNOUME KAI ARXIKOPOIOUME TO SQL QUERY TO OPOIO THA EINAI MONO GIA TIS MONES PTHSEIS H GIA TIS PTHSEIS TWN ANAXWRISEWN
        String sql = "SELECT * FROM available_flights WHERE origin = ? AND destination = ? AND departure_date = ? AND available_seats >= ?";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  //DILWNOUME ENA ANTIKEIMENO GIA NA FTIAXNEI TO FORMAT ETSI WSTE NA MPOROUME NA GINEI SWSTA H ANAZHTHSH KAI H APOTHYKEYSH
        //DHMIOURGOUME TO PREPAREDSTATEMENT 
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, criteria.getOrigin());                     //THETOUME THN TIMH GIA THN TOPOTHESIA ANAXWRISIS
        statement.setString(2, criteria.getDestination());                //THETOUME THN TIMH GIA THN TOPOTHESIA AFIXHS
        statement.setString(3, criteria.getDepartureDate().toString());   //THETOUME THN TIMH GIA THN HMEROMHNIA ANAXWRISIS
        statement.setInt(4, criteria.getPassengers());                       //THETOUME THN TIMH GIA TON ARITHMO TWN EPIVATWN
            
        //TREXOUME TO QUERY
        ResultSet resultSet = statement.executeQuery();
                
        //EPANALIPSH GIA OLA TA APOTELESMATA
        while (resultSet.next()) {
                    
            //DILWSH METAVLITWN GIA THN KATAXWRHSH TWN APOTELESMATWN APO THN VASH
            int departureFlightId = resultSet.getInt("flight_id");                          //GIA TON KWDIKO THS PTHSHS ANAXWRHSHS
            String origin = resultSet.getString("origin");                                  //H TOPOTHESIA ANAXWRHSHS
            String destination = resultSet.getString("destination");                        //H TOPOTHESIA PROORISMOU
            String departureDateStr = resultSet.getString("departure_date");                //H HMEROMHNIA ANAXWRISHS
            String departureTimeStr = resultSet.getString("departure_time");                //H WRA ANAXWRHSHS
            String arrivalDateStr = resultSet.getString("arrival_date");                    //H HMEROMHNIA AFIXHS
            String arrivalTimeStr = resultSet.getString("arrival_time");                    //H WRA AFIXHS
            int availableSeats = resultSet.getInt("available_seats");                       //GIA TIS DIATHESIMES THESEIS
            double price = resultSet.getDouble("price");                                    //GIA THN TIMH
            String originAirportId = resultSet.getString(8);                                    //GIA TON KWDIKO AERODROMIOU ANAXWRHSHS
            String destinationAirportId = resultSet.getString(9);                               //GIA TON KWDIKO AERODROMIOU AFIXHS
                    
            //DHMIOURGIA ANTIKEIMENOU LOCALDATETIME WSTE NA SYNDIASOUME TON XRONO KAI THN HMEROMHNIA SE MIA METAVLITH
            String departureDateTimeStr = departureDateStr + " " + departureTimeStr;                        //FTIAXNOUME ENA STRING ME THN MERA ANAXWRHSHS KAI ME THN WRA        
            String arrivalDateTimeStr = arrivalDateStr + " " + arrivalTimeStr;                              //FTIAXNOUME ENA STRING ME THN MERA AFIXHS KAI ME THN WRA 
            LocalDateTime departureDateTime = LocalDateTime.parse(departureDateTimeStr, formatter);    //DHMIOURGOUME TO ANTIKEIMENO GIA THN HMERA ANAXWRHSHS
            LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeStr, formatter);        //DHMIOURGOUME TO ANTIKEIMENO GIA THN HMERA AFIXHS
                    
            //DHMIOURGOUME ANTIKEIMENO GIA THN PTHSH KAI TO ARXIKOPOIOUME ME TA APOTELESMATA
            Flight departureFlight = new Flight(departureFlightId, origin, destination, departureDateTime, arrivalDateTime, availableSeats, price, originAirportId, destinationAirportId);
                    
            //EISAGOUME THN PTHSH STIS PTHSEIS ANAXWRHSEWN
            departureFlights.add(departureFlight);  
                
            
        } 
        if (criteria.isIsRoundTrip()) {//AN H PTHSH EINAI ME EPISTROFH TOTE ANAZHTAEI KAI GIA TIS PTHSEIS POU YPARXOUN VASH TWN STOIXEIWN THS EPISTROFHS
            
            //DHMIOURGIA KAI DILWSH TOU SQL QUERY  
            String returnSql = "SELECT * FROM available_flights WHERE origin = ? AND destination = ? AND departure_date = ? AND available_seats >= ?";
            //DHMIOURGIA TOU  PREPAREDSTATEMENT
            PreparedStatement returnStatement = connection.prepareStatement(returnSql);
            //THE TOUME TA STATEMENT
            returnStatement.setString(1, criteria.getDestination());                        //GIA THN TOPOTHESIA ANAXWRHSHS THS EPISTROFHS
            returnStatement.setString(2, criteria.getOrigin());                             //GIA THN TOPOTHESIA AFIXHS THS EPISTROFHS
            returnStatement.setString(3, criteria.getReturnDate().toString());              //GIA THN HMERA ANAXWRHSHS THS EPISTROFHS
            returnStatement.setInt(4, criteria.getPassengers());                               //GIA TON ARXITHMO TWN EPIVATWN THS EPISTROFHS
            
            //TREXOUME TO ERWTHMA KAI APOTHYKEUOUME TA RESULT
            ResultSet returnResultSet = returnStatement.executeQuery();
            //EPANALIPSI GIA OLA TA APOTELESMATA
            while (returnResultSet.next()) {    
                //DILWSH METAVLITWN GIA THN KATAXWRHSH TWN APOTELESMATWN APO THN VASH
                int returnFlightId = returnResultSet.getInt("flight_id");                       //GIA TON KWDIKO THS PTHSHS EPISTROFHS
                String returnOrigin = returnResultSet.getString("origin");                      //GIA THN TOPOTHESIA ANAXWRHSHS THS EPISTROFHS 
                String returnDestination = returnResultSet.getString("destination");            //GIA THN TOPOTHESIA AFIXHS THS EPISTROFHS
                String returnDepartureDateStr = returnResultSet.getString("departure_date");    //GIA THN HMERA ANAXWRHSHS THS EPISTROFHS
                String returnDepartureTimeStr = returnResultSet.getString("departure_time");    //GIA THN WRA ANAXWRHSHS THS EPISTROFHS
                String returnArrivalDateStr = returnResultSet.getString("arrival_date");        //GIA THN HMERA AFIXHS THS EPISTROFHS
                String returnArrivalTimeStr = returnResultSet.getString("arrival_time");        //GIA THN WRA AFIXHS THS EPISTROFHS
                int returnAvailableSeats = returnResultSet.getInt("available_seats");           //GIA TIS DIATHESIMES THESEIS THS EPISTROFHS
                double returnPrice = returnResultSet.getDouble("price");                        //GIA THN TIMH THS EPISTROFHS
                String returnOriginAirportId = returnResultSet.getString(8);                        //GIA TON KWDIKO AERODROMIOU ANAXWRHSHS THS EPISTROFHS
                String returnDestinationAirportId = returnResultSet.getString(9);                   //GIA TON KWDIKO AERODROMIOU AFIXHS THS EPISTROFHS
                
                //DHMIOURGIA ANTIKEIMENOU LOCALDATETIME WSTE NA SYNDIASOUME TON XRONO KAI THN HMEROMHNIA SE MIA METAVLITH
                String returnDepartureDateTimeStr = returnDepartureDateStr + " " + returnDepartureTimeStr;                       //FTIAXNOUME ENA STRING ME THN MERA ANAXWRHSHS KAI ME THN WRA  
                String returnArrivalDateTimeStr = returnArrivalDateStr + " " + returnArrivalTimeStr;                             //FTIAXNOUME ENA STRING ME THN MERA AFIXHS KAI ME THN WRA 
                LocalDateTime returnDepartureDateTime = LocalDateTime.parse(returnDepartureDateTimeStr, formatter);         //DHMIOURGOUME TO ANTIKEIMENO GIA THN HMERA ANAXWRHSHS
                LocalDateTime returnArrivalDateTime = LocalDateTime.parse(returnArrivalDateTimeStr, formatter);             //DHMIOURGOUME TO ANTIKEIMENO GIA THN HMERA AFIXHS
                
                //DHMIOURGOUME ANTIKEIMENO GIA THN PTHSH KAI TO ARXIKOPOIOUME ME TA APOTELESMATA
                Flight returnFlight = new Flight(returnFlightId, returnOrigin, returnDestination, returnDepartureDateTime, returnArrivalDateTime, returnAvailableSeats, returnPrice, returnOriginAirportId, returnDestinationAirportId);
                
                //EISAGOUME THN PTHSH STIS PTHSEIS EPISTROFWN
                returnFlights.add(returnFlight);
            }
              
            //DIATREXOUME TIS LISTES TWN ANAXWRHSEWN KAI TWN EPISTROFWN WSTE NA APOTHYKEUSOUME OLOUS TOU SYNDIASMOUS STIS DIATHESIMES PTHSEIS
            for (Flight outboundFlight : departureFlights) {                        //EPANALIPSI GIA OLES TIS PTHSEIS TWN ANAXWRHSEWN
                for (Flight returnFlight : returnFlights) {                         //EPANALIPSI GIA OLES TIS PTHSEIS TWN EPISTROFWN
                    //ELEGXOUME AN H WRA THS AFIXHS THS PTHSHS ANAXWRHSHS EINAI PIO PRIN TOULAXISTON 15 LEPTA APO THN WRA ANAXWRHSHS THS EPISTROFHS KAI TOTE FTIAXNOUME THN PTHSH KAI THN EISAGOUME STHNLISTA
                    if(returnFlight.getDepartureDate().toLocalTime().isAfter(outboundFlight.getArrivalDate().toLocalTime().plusMinutes(15))){ 
                        availableFlights.add(new FlightBooking(outboundFlight,returnFlight,criteria.getPassengers()));
                    }
                } 
            }
        } 
        else{ //ALLIWS AN EINAI MONH PTHSH
            for(Flight i:departureFlights){ //KANH EPANALHPSH GIA OLES TIS PTHSEIS
                availableFlights.add(new FlightBooking(i,criteria.getPassengers())); //EISAGEI MIA NEA PTHSH ME MONO THN MONH PTHSH KAI TOUS EPIVATES KAI THN EISAGEI STIS DIATHESIMES
            }
        }
        return availableFlights;//EPISTREFEI TIS DIATHESIMES PTHSEIS
    }
    
    //METHODOS GIA THN ANAZHTHSH STHN VASH GIA TIS POLEIS TWN PTHSEWN
    public String[] searchData() throws SQLException {
        //DILWSH KAI ARXIKOPOIHSH TOU SQL QUERY
        String sql = "SELECT DISTINCT location FROM airports";
        String[] locations;                                                             //DILWSH ENOS PINAKA STRING GIA TIS TOPOTHESIES
        StringBuilder strB = new StringBuilder();                                       //DILWSH ENOS STRINGBUILDER GIA NA PROSTHETEI TIS TOPOTHESIES
        //DIMIOURGEIA TOU PREPARED STATEMENT
        try (Statement statement = connection.createStatement();
            //TREXIMO TOU STATEMENT
            ResultSet resultSet = statement.executeQuery(sql)) {
            //EPEXERGASIA TWN APOTELESMATWN
            while (resultSet.next()) {
                //PERNOUME THN TOPOTHESIA KAI THN EISAGOUME STHN STRINGBUILDER METAVLITH ME ,
                strB.append(resultSet.getString("location")).append(",");
            }
            String str = strB.toString();       //METATREPOUME TON STRINGBUILDER SE STRING
            locations = str.split(",");    //APOTHYKEUOUME TIS POLEIS DIAXWRIZONTAS ME , STON PINAKA
            Arrays.sort(locations);           //SORTAROUME TON PINAKA KATA AUXOUSA SEIRA
        }
         return(locations);                     //EPISTREFOUME TWN PINAKA POU EXEI TIS POLEIS
    }

}