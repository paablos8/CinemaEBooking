package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class TicketTableConnector extends SQL_GetSet
{
    private Connection conn;
    TicketTableConnector (Connection conn){super(conn);this.conn = conn;}

    public int createNewTicket (String seatID, String datePurchased, String ticketType, int bookingID)
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

    public int[] getAllTicketIDs(int bookingID)
    {
        Object temp [] = getMany(bookingID,"Tickets","Booking ID","Ticket ID");
        Integer [] i =  Arrays.copyOf(temp,temp.length,Integer[].class);
        return Arrays.stream(i).mapToInt(Integer::intValue).toArray();
    }

    public String getSeatID (int ticketID) {return get(ticketID,"Tickets","Ticket ID","Seat ID");}
    public String getDatePurchased (int ticketID){return get(ticketID,"Tickets","Ticket ID","Date Purchased");}
    public String getTicketType (int ticketID)
    {
        int typeID = get(ticketID,"Ticket","Ticket ID","Ticket Type ID");
        return get(typeID,"Ticket Types","Ticket Type ID","Ticket Description");
    }

    //public boolean[][] getSeatAvaliability (int showtimeID)
}
