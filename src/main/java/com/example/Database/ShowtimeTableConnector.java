package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ShowtimeTableConnector extends SQL_GetSet
{
    private Connection conn;
    ShowtimeTableConnector(Connection conn){super(conn);this.conn = conn;}

    /**
     * Creates a new showtime
     * @param movieTitle movie's title
     * @param showroomID showroom id
     * @param showDateAndTime show date and time
     * @return -1 if malformed date, -3 if invalid showroom, -4 if movie DNE, -5 if
     * room is unavailable at that time, 0 if added
     */
    int createNewShowtime(String movieTitle,int showroomID, String showDateAndTime)
    {
        if (showroomID < 1 || showroomID > 3) return -3;
        else if (!exists(movieTitle,"Movie Titles","Title")) return -4;
        else if (existsComboKey(showroomID,showDateAndTime,"Showtimes","Showroom ID","Show Date"
        ))
        {
            return -5;
        }

        int movieID = get(movieTitle,"Movie Titles","Title","Movie ID");

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Showtimes VALUES ('"+movieID+"','"+showroomID+"','"+showDateAndTime+"')";
            stmt.executeUpdate(SQL);

            int showtimeID = getComboKey(movieID,showDateAndTime,"Showtimes","Movie ID","Show Date","Showtime ID");

            SQL = "INSERT INTO [Showroom 1 Seat Availabilities] VALUES ("+showtimeID+","+true+","+true+","+true+","+true+
                    ","+true+","+true+","+true+","+true+","+true+","+true+","+true+","+true+","+true+","+true+","+true+
                    ","+true+","+true+","+true+","+true+","+true+")";
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
        Object[] temp = getAll("Showtimes","Showtime ID");
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
        int movieID = get(showtimeID,"Showtimes","Showtime ID","Movie ID");
        return get(movieID,"Movie Titles","Movie ID","Title");
    }

    /**
     * Returns show date given a showtime ID
     * @param showtimeID showtime ID
     * @return date of show
     */
    String getShowDateAndTime (int showtimeID)
    {
        return get(showtimeID,"Showtimes","Showtime ID","Show Date");
    }
}
