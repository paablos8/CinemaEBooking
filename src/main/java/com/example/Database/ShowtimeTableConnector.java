package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ShowtimeTableConnector extends SQL_GetSet
{
    private Connection conn;
    public ShowtimeTableConnector(Connection conn){super(conn);this.conn = conn;}

    /**
     * Creates a new showtime
     * @param movieTitle movie's title
     * @param showroomID showroom id
     * @param showDate show date
     * @param showTime show time
     * @return -1 if malformed date, -2 if malformed time, -3 if invalid showroom, -4 if movie DNE, -5 if
     * room is unavailable at that time, 0 if added
     */
    int createNewShowtime(String movieTitle,int showroomID, String showDate, String showTime)
    {
        if(!verifyDate(showDate)){return -1;}
        else if(!verifyTime(showTime)) {return -2;}
        else if (showroomID < 1 || showroomID > 3) return -3;
        else if (!exists(movieTitle,"Movie Titles","Title")) return -4;
        else if (existsCombo(showroomID,showDate,showTime,"Showtimes","Showroom ID","Show Date"
        ,"Show Time"))
        {
            return -5;
        }

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

    /**
     * Returns integer array of all showtime ids
     * @return all showtime ids
     */
    int[] getAllShowtimeIDs()
    {
        Object[] temp = getAll("Showtimes","ShowtimeID");
        Integer [] i =  Arrays.copyOf(temp,temp.length,Integer[].class);
        return Arrays.stream(i).mapToInt(Integer::intValue).toArray();
    }

    /**
     * Returns title given a showtime ID
     * @param showtimeID showtime ID
     * @return movie title
     */
    String getShowTitle(int showtimeID)
    {
        int movieID =  get(showtimeID,"Showtimes","Showtime ID","Movie ID");
        return get(movieID,"Movie Titles","Movie ID","Movie Title");
    }

    /**
     * Returns show date given a showtime ID
     * @param showtimeID showtime ID
     * @return date of show
     */
    String getShowDate (int showtimeID)
    {
        return get(showtimeID,"Showtimes","Showtime ID","Show Date");
    }

    /**
     * Returns show time given a showtime ID
     * @param showtimeID showtime ID
     * @return show time
     */
    String getShowTime (int showtimeID)
    {
        return get(showtimeID,"Showtimes","Showtime ID","Show Time");
    }

    /**
     * Used to standardize time for this database
     * @param time string to verify
     * @return true if valid
     */
    private boolean verifyTime(String time)
    {
        /*
        There were some really weird errors going on with java.util.Date and java.sql.Date
        So we bypassed that with this
         */
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
