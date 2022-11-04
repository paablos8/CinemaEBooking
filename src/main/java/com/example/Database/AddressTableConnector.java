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
        if(!(verifyString(stAdd) && verifyString(city) && verifyString(state) && verifyString(country) && zip >= 500))
        {return false;}

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Addresses VALUES ("
                    +stAdd+"','"+city+"','"+state+"','"+country+"',"+zip+")";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        int addID = getComboKey(stAdd,city,"Addresses","Street Address","City/County","Address ID");

        update(userID,"Users","User ID","Address ID",addID);

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
    public boolean changeUserStreetAddress(int userID,String stAdd)
    {
        if(!verifyString(stAdd)) {return false;}
        int addid = get(userID,"Users","User ID","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Street Address",stAdd);
    }

    /**
     * Updates the user's city or county given a user id
     * @param userID user's ID
     * @param city user's new city or county
     * @return true if successful
     */
    public boolean changeUserCityCounty(int userID,String city)
    {
        if(!verifyString(city)) {return false;}
        int addid = get(userID,"Users","User ID","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","City/County",city);
    }

    /**
     * Updates the user's state or region
     * @param userID user's ID
     * @param state user's new state or region
     * @return true if successful
     */
    public boolean changeUserStateRegion(int userID,String state)
    {
        if(!verifyString(state)) {return false;}
        int addid = get(userID,"Users","User ID","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","State/Region",state);
    }

    /**
     * Updates the user's country
     * @param userID user's ID
     * @param country user's new country
     * @return true if successful
     */
    public boolean changeUserCountry(int userID,String country)
    {
        if(!verifyString(country)) {return false;}
        int addid = get(userID,"Users","User ID","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Country",country);
    }

    /**
     * Updates the user's zip code
     * @param userID user's ID
     * @param zip user's new zip code
     * @return true if successful
     */
    public boolean changeUserZipCode(int userID,int zip)
    {
        if(zip < 500) {return false;}
        int addid = get(userID,"Users","User ID","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Zip Code",zip);}
}
