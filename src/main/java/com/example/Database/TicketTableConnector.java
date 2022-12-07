package com.example.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class TicketTableConnector extends SQL_GetSet
{
    private Connection conn;
    TicketTableConnector (Connection conn){super(conn);this.conn = conn;}

    int createNewTicket (String seatID, String datePurchased, String ticketType, int bookingID)
    {
        if (seatID.length() != 2) return -1;
        if (Integer.parseInt(seatID) < 0 || Integer.parseInt(seatID)> 12) return -2;
        if (!exists(ticketType,"Ticket Types","Ticket Description")) return -3;
        if (!exists(bookingID,"Booking","Booking ID")) return -4;

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Tickets VALUES ('"+seatID+"','"+datePurchased+"','"+ticketType+"',"+bookingID+")";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    int[] getAllTicketIDs(int bookingID)
    {
        Object temp [] = getMany(bookingID,"Tickets","Booking ID","Ticket ID");
        Integer [] i =  Arrays.copyOf(temp,temp.length,Integer[].class);
        return Arrays.stream(i).mapToInt(Integer::intValue).toArray();
    }

    String getSeatID (int ticketID) {return get(ticketID,"Tickets","Ticket ID","Seat ID");}
    String getDatePurchased (int ticketID){return get(ticketID,"Tickets","Ticket ID","Date Purchased");}
    String getTicketType (int ticketID)
    {
        int typeID = get(ticketID,"Ticket","Ticket ID","Ticket Type ID");
        return get(typeID,"Ticket Types","Ticket Type ID","Ticket Description");
    }

    boolean[][] getSeatAvailability (int showtimeID)
    {
        boolean [][] seats = new boolean[12][10];

        for (int i = 1; i < 13; i ++)
        {
            for (int j = 1; j < 11; j ++)
            {
                String seatID = i + getSeatLetter(j);
                System.out.println(seatID);
                seats[i-1][j-1] = get(showtimeID,"Showroom 1 Seat Availabilities","Showtime ID",seatID);
            }
        }

        return seats;
    }

    private String getSeatLetter(int i)
    {
        switch(i)
        {
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            case 5: return "E";
            case 6: return "F";
            case 7: return "G";
            case 8: return "H";
            case 9: return "I";
            default: return "J";
        }
    }
}
