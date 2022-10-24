package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  These are the functions to access the Address Table
 */
public class AddressTableConnector
{
    private Connection conn;
    /**
     * Creates Address Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    public AddressTableConnector(Connection conn) {this.conn = conn;}

    /**
     * Returns the user's address given their ID.
     * @param userID user's ID
     * @return first name
     */
    public String getStreetAddress(int userID)
    {
        String stAdd = "";
        ResultSet rs;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [Street Address] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    stAdd = rs.getString("Street Address");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return stAdd;
    }

    /**
     * Updates the user's street address
     * @param userID user's ID
     * @param stAdd user's new street address
     * @return true if successful
     */
    public boolean changeStreetAddress(int userID,String stAdd)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [Street Address] FROM Addresses");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Street Address", stAdd);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Updates the user's city or county
     * @param userID user's ID
     * @param city user's new city or county
     * @return true if successful
     */
    public boolean changeCityCounty(int userID,String city)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [City/County] FROM Addresses");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Street Address", city);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Updates the user's state or region
     * @param userID user's ID
     * @param state user's new state or region
     * @return true if successful
     */
    public boolean changeStateRegion(int userID,String state)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [State/Region] FROM Addresses");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Street Address", state);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Updates the user's country
     * @param userID user's ID
     * @param country user's new country
     * @return true if successful
     */
    public boolean changeCountry(int userID,String country)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , Country FROM Addresses");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Country", country);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Updates the user's zip code
     * @param userID user's ID
     * @param zip user's new zip code
     * @return true if successful
     */
    public boolean changeZipCode(int userID,int zip)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [Zip Code] FROM Addresses");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateInt("Zip Code", zip);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean createNewAddress(int userID, String stAdd, String city,
                                    String state, String country, int zip)
    {
        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Addresses VALUES ("+userID+",'"
                    +stAdd+"','"+city+"','"+state+"','"+country+"',"+zip+")";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
