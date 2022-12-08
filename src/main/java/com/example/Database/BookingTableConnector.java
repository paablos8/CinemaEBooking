package com.example.Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BookingTableConnector extends SQL_GetSet
{
    private Connection conn;

    /**
     * Creates Address Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    BookingTableConnector(Connection conn) {super(conn);this.conn = conn;}

    //createNewBooking
    public int createNewBooking(int userID, long cardNum, String promoCode,
                                int showtimeID, int adultTickets,
                                int childTickets, int seniorTickets)
    {
        if(!verifyString(promoCode))
            {System.out.println("Promocode bad");return -1;}
        else if(!exists(userID,"Users","User ID"))
            {System.out.println("No such user");return -2;}
        else if(!exists(encryptLong(cardNum),"Cards","Card Number"))
            {System.out.println("No such card");return -3;}
        else if(!exists(showtimeID,"Showtimes","Showtime ID"))
            {System.out.println("No such showitme");return -4;}
        else if(adultTickets < 0)
            {System.out.println("Negative adult tickets");return -5;}
        else if(childTickets < 0)
            {System.out.println("Negative child tickets");return -6;}
        else if(seniorTickets < 0)
            {System.out.println("Negative senior tickets");return -7;}
        else if(childTickets > 1 && (seniorTickets < 1 || adultTickets < 1))
            {System.out.println("Child cannot be alone");return -8;}

        BigDecimal temp = get("Adult","Ticket Types","Ticket Description","Price");
        double adultPrice = temp.doubleValue();
        temp = get("Child","Ticket Types","Ticket Description","Price");
        double childPrice = temp.doubleValue();
        temp = get("Senior","Ticket Types","Ticket Description","Price");
        double seniorPrice = temp.doubleValue();

        int total = (int)(adultPrice * adultTickets + childPrice * childTickets + seniorPrice * seniorTickets);

        String encCard = encryptLong(cardNum);

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Booking VALUES ("
                    +userID+",'"+encCard+"','"+promoCode+"',"+total+","+showtimeID+
                    ","+adultTickets+","+childTickets+","+seniorTickets+")";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return getComboKey(userID,showtimeID,"Booking","User ID","Showtime ID","Booking ID");
    }

    int [] getBookings (int userID)
    {
        Object [] temp = getMany(userID,"Booking","User ID","Booking ID");
        Integer [] i =  Arrays.copyOf(temp,temp.length,Integer[].class);
        return Arrays.stream(i).mapToInt(Integer::intValue).toArray();
    }

    int getUserID (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","User ID");
    }

    long getCardNum (int bookingID)
    {
        return decryptLong(get(bookingID,"Booking","Booking ID","Card Num"));
    }

    String getPromoCode (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","Promotion Code");
    }

    double getTotal (int bookingID)
    {
        int temp = get(bookingID,"Booking","Booking ID","Total");
        return (double)temp;
    }

    int getShowtimeID (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","Showtime ID");
    }

    int getAdultTickets (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","Adult Tickets");
    }

    int getChildTickets (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","Child Tickets");
    }

    int getSeniorTickets (int bookingID)
    {
        return get(bookingID,"Booking","Booking ID","Senior Tickets");
    }
}
