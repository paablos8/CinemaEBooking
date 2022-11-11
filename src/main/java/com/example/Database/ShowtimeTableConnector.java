package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ShowtimeTableConnector extends SQL_GetSet
{
    private Connection conn;
    public ShowtimeTableConnector(Connection conn){super(conn);this.conn = conn;}

    int createNewShowtime(String movieTitle,int showroomID, String showDate, String showTime)
    {
        if(!verifyDate(showDate)){return -1;}
        else if(!verifyTime(showTime)) {return -2;}
        else if (showroomID < 1 || showroomID > 3) return -3;
        else if (!exists(movieTitle,"Movie Titles","Title")) return -4;

        int movieID = get(movieTitle,"Movie Titles","Title","Movie ID");

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Showtimes VALUES ('"+movieID+"','"+showroomID+
                    "','"+showDate+"','"+showTime+"')";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    //title
    int[] getAllShowtimeIDs()
    {
        Object[] temp = getAll("Showtimes","ShowtimeID");
        Integer [] i =  Arrays.copyOf(temp,temp.length,Integer[].class);
        return Arrays.stream(i).mapToInt(Integer::intValue).toArray();
    }

    String getShowTitle(int showtimeID)
    {
        int movieID =  get(showtimeID,"Showtimes","Showtime ID","Movie ID");
        return get(movieID,"Movie Titles","Movie ID","Movie Title");
    }

    //show date
    String getShowDate (int showtimeID)
    {
        return get(showtimeID,"Showtimes","Showtime ID","Show Date");
    }

    //show time
    String getShowTime (int showtimeID)
    {
        return get(showtimeID,"Showtimes","Showtime ID","Show Time");
    }

    private boolean verifyTime(String time)
    {
        if(!verifyString(time)){return false;}

        try
        {
            int i = Integer.parseInt(time.substring(0,time.indexOf(':')));
            if (i < 1 || i > 24) return false;
            int j = Integer.parseInt(time.substring(time.indexOf(':')));
            if(j < 0 || j > 59) return false;
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }

        return true;
    }
}
