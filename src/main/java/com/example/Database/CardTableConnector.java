package com.example.Database;

import java.sql.*;

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
     * @param month month card expires
     * @param year year card expires
     * @param cvv security code
     * @param cardNum card number (16 digits)
     * @param cardType visa, mastercard, etc
     * @param userID user's id
     * @return true if it worked
     */
    public boolean createNewCard(int month, int year, int cvv, long cardNum,String cardType, int userID)
    {
        String str = ""+year+"-"+month+"-"+"28";
        Date expDate = Date.valueOf(str);
        // convert month,year to Date
        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Cards VALUES ("
                    +expDate+","+cvv+","+cardNum+",'"+cardType+"')";
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
            cardNums[i] = (long) get(cardIDS[i],"Cards","Card ID","Card Number");
        }

        return cardNums;
    }

    /**
     * Given a user id, returns an array of their expiration dates
     * @param userID user's id
     * @return long array of user's card numbers
     */
    public String[] getCardExpDates(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        String[] cardDates = new String[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardDates[i] = (String) get(cardIDS[i],"Cards","Card ID","Card Number");
        }

        return cardDates;
    }

    public boolean deleteCard(long cardNum)
    {
        int cardID = get(cardNum,"Cards","Card Number","Card ID");
        deleteRecord(cardNum,"Cards","Card Number");
        deleteRecord(cardID,"User Cards","Card ID");
        return true;
    }
}
