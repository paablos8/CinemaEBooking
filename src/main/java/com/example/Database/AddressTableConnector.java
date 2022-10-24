package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  These are the functions to access the Address Table
 */
public class AddressTableConnector extends SQL_GetSet
{
    private Connection conn;
    /**
     * Creates Address Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    public AddressTableConnector(Connection conn) {super(conn);this.conn = conn;}

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

    /**
     * Returns the user's street address given their id
     * @param userID user's ID
     * @return street address
     */
    public String getStreetAddress(int userID)
    {return get(userID,"Addresses","User ID","Street Address");}

    /**
     * Returns the user's city or county given their id
     * @param userID user's ID
     * @return city or county name
     */
    public String getCityCounty(int userID){return get(userID,"Addresses","User ID","City/County");}

    /**
     * Returns the user's state or region given their id
     * @param userID user's ID
     * @return state or region name
     */
    public String getStateRegion(int userID){return get(userID,"Addresses","User ID","State/Region");}

    /**
     * Returns the user's country given their id
     * @param userID user's ID
     * @return country
     */
    public String getCountry(int userID){return get(userID,"Addresses","User ID","Country");}

    /**
     * Returns the user's zip code given their id
     * @param userID user's ID
     * @return zip code
     */
    public int getZipCode(int userID){return get(userID,"Addresses","User ID","Zip Code");}

    /**
     * Updates the user's street address given a user id
     * @param userID user's ID
     * @param stAdd user's new street address
     * @return true if successful
     */
    public boolean changeStreetAddress(int userID,String stAdd)
    {return update(userID,"Addresses","User ID","Street Address",stAdd);}

    /**
     * Updates the user's city or county given a user id
     * @param userID user's ID
     * @param city user's new city or county
     * @return true if successful
     */
    public boolean changeCityCounty(int userID,String city)
    {return update(userID,"Addresses","User ID","City/County",city);}

    /**
     * Updates the user's state or region
     * @param userID user's ID
     * @param state user's new state or region
     * @return true if successful
     */
    public boolean changeStateRegion(int userID,String state)
    {return update(userID,"Addresses","User ID","State/Region",state);}

    /**
     * Updates the user's country
     * @param userID user's ID
     * @param country user's new country
     * @return true if successful
     */
    public boolean changeCountry(int userID,String country)
    {return update(userID,"Addresses","User ID","Country",country);}

    /**
     * Updates the user's zip code
     * @param userID user's ID
     * @param zip user's new zip code
     * @return true if successful
     */
    public boolean changeZipCode(int userID,int zip)
    {return update(userID,"Addresses","User ID","Zip Code",zip);}
}
