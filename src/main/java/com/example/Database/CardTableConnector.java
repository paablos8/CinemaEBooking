package com.example.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
     * Given a user id, returns an array of their card numbers
     * @param userID user's id
     * @return long array of user's card numbers
     */
    public long[] getCard(int userID)
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
}
