package com.example.Database;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *  These are the functions to access the Card Table
 */
public class CardTableConnector extends SQL_GetSet
{
    private Connection conn;

    /**
     * Creates Card Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    public CardTableConnector(Connection conn) {super(conn);this.conn = conn;}

    /**
     * Creates a new card entry.
     * @param date the expiration date
     * @param cvv security code
     * @param cardNum card number (16 digits)
     * @param cardType visa, mastercard, etc
     * @param userID user's id
     * @return true if it worked
     */
    public boolean createNewCard(String date, int cvv, long cardNum,String cardType,
               int userID,String streetAddress,String cityCounty,String stateRegion,String country,int zip)
    {
        Date expDate = Date.valueOf(date);
        // convert month,year to Date
        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Cards VALUES ("
                    +expDate+","+cvv+","+cardNum+",'"+cardType+"')";
            stmt.executeUpdate(SQL);
            SQL = "INSERT INTO [User Cards] VALUES ('"+userID+"')";
            stmt.executeUpdate(SQL);
            int id = get(cardNum,"Cards","Card Number","Card ID");
            id += 1000;
            SQL = "INSERT INTO [Addresses] VALUES ("+id+",'"+streetAddress+"','"+cityCounty+"','"+stateRegion+
                    "','"+country+"',"+zip;
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
     * Given a user id, returns an array of their card numbers
     * @param userID user's id
     * @return long array of user's card numbers
     */
    public long[] getCardNumbers(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        long[] cardNums = new long[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardNums[i] = get(cardIDS[i],"Cards","Card ID","Card Number");
        }

        return cardNums;
    }

    /**
     * Given a user id, returns an array of their expiration dates
     * @param userID user's id
     * @return String array of user's card expiration dates
     */
    public String[] getCardExpDates(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        String[] toRet = new String[numOfCards];
        Date[] cardDates = new Date[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardDates[i] = get(cardIDS[i],"Cards","Card ID","Expiration Date");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            toRet[i] = dateFormat.format(cardDates[i]);
        }

        return toRet;
    }

    /**
     * Given a user id, returns an array of the names for their cards
     * @param userID user's id
     * @return String array of the names on the user's cards
     */
    public String[] getCardNames(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        String[] cardNames = new String[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardNames[i] = get(cardIDS[i],"Cards","Card ID","Name On Card");
        }

        return cardNames;
    }

    /**
     * Given a user id, returns an array of the zip codes for their cards
     * @param userID user's id
     * @return int array of the zip codes for the user's cards
     */
    public int[] getCardZips(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int[] cardZips = new int[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardZips[i] = get(cardIDS[i],"Cards","Card ID","Zip Code");
        }

        return cardZips;
    }

    /**
     * Replaces a card number with a new one
     * @param oldCardNum the old card number
     * @param newCardNum the new card number
     * @return true if it worked
     */
    public boolean changeCardNumber(long oldCardNum, long newCardNum)
    {
        return update(oldCardNum,"Users","Card Number","Card Number",newCardNum);
    }

    /**
     * Replaces the expiration date given a card number
     * @param cardNum the card number
     * @param newDate the new card date
     * @return true if it worked
     */
    public boolean changeCardExpDate(long cardNum, String newDate)
    {
        Date expDate = Date.valueOf(newDate);
        return update(cardNum,"Users","Card Number","Expiration Date",expDate);
    }

    /**
     * Replaces the name for a card given the card number
     * @param cardNum the card number
     * @param name the new card name
     * @return true if it worked
     */
    public boolean changeCardName(long cardNum, String name)
    {
        return update(cardNum,"Users","Card Number","Name on Card",name);
    }

    /**
     * Replaces the security code for a card given the card number
     * @param cardNum the card number
     * @param cvv the new card security code
     * @return true if it worked
     */
    public boolean changeCardCVV(long cardNum, int cvv)
    {
        return update(cardNum,"Users","Card Number","CVV",cvv);
    }

    public boolean changeStreetAddress(long cardNum, String streetAddress)
    {
        int id = get(cardNum,"Cards","Card Number","Card ID");
        id += 1000;
        return update(id,"Addresses","UserID","Street Address",streetAddress);
    }
    public boolean changeCityCounty(long cardNum, String cityCounty)
    {
        int id = get(cardNum,"Cards","Card Number","Card ID");
        id += 1000;
        return update(id,"Addresses","UserID","City/County",cityCounty);
    }
    public boolean changeStateRegion(long cardNum, String stateRegion)
    {
        int id = get(cardNum,"Cards","Card Number","Card ID");
        id += 1000;
        return update(id,"Addresses","UserID","State/Region",stateRegion);
    }
    public boolean changeCountry(long cardNum, String country)
    {
        int id = get(cardNum,"Cards","Card Number","Card ID");
        id += 1000;
        return update(id,"Addresses","UserID","Country",country);
    }
    public boolean changeZipCode(long cardNum, int zipCode)
    {
        int id = get(cardNum,"Cards","Card Number","Card ID");
        id += 1000;
        return update(id,"Addresses","UserID","Zip Code",zipCode);
    }

    /**
     * Deletes a card from the database given the card number
     * @param cardNum the card number
     * @return true if it worked
     */
    public boolean deleteCard(long cardNum)
    {
        int cardID = get(cardNum,"Cards","Card Number","Card ID");
        deleteRecord(cardNum,"Cards","Card Number");
        deleteRecord(cardID,"User Cards","Card ID");
        return true;
    }
}
