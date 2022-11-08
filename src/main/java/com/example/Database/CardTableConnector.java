package com.example.Database;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
     * @param userID user's id
     * @return true if it worked
     */
    public boolean createNewCard(String date, int cvv, long cardNum, String nameOnCard, int userID,
                                 String streetAddress, String cityCounty, String stateRegion, int zip)
    {
        if(!(verifyDate(date)&&verifyString(nameOnCard)&&verifyString(streetAddress)&&verifyString(cityCounty)
        &&verifyString(stateRegion)&&zip>500&&cardNum>999999999999999L&&cardNum<9999999999999999L)) return false;

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO [Addresses] VALUES ('"+streetAddress+"','"+cityCounty+"','"+stateRegion+
                    "','Zimbabwe',"+zip+")";
            stmt.executeUpdate(SQL);
            int addID = getComboKey(streetAddress,cityCounty,"Addresses","Street Address",
                    "City/County","Address ID");
            SQL = "INSERT INTO Cards VALUES ('"+date+"',"+cvv+","+cardNum+",'"+nameOnCard+"',"+addID+")";
            stmt.executeUpdate(SQL);

            SQL = "INSERT INTO [User Cards] VALUES ('"+userID+"')";
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
            String temp = get(cardIDS[i],"Cards","Card ID","Card Number");
            cardNums[i] = Long.parseLong(temp);
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
        if(!verifyDate(newDate))return false;
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

    /**
     * Updates a card's street address given a card number
     * @param cardNum card number
     * @param stAdd card's new street address
     * @return true if successful
     */
    public boolean changeCardStreetAddress(long cardNum,String stAdd)
    {
        if(!verifyString(stAdd)) {return false;}
        int addid = get(cardNum,"Cards","Card Number","Address ID");
        if (addid == 0)
        {
            System.out.println("This doesn't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Street Address",stAdd);
    }

    /**
     * Updates a card's street address given a card number
     * @param cardNum card number
     * @param city card's new street address
     * @return true if successful
     */
    public boolean changeCardCityCounty(long cardNum,String city)
    {
        if(!verifyString(city)) {return false;}
        int addid = get(cardNum,"Cards","Card Number","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","City/County",city);
    }

    /**
     * Updates a card's street address given a card number
     * @param cardNum card number
     * @param state card's new street address
     * @return true if successful
     */
    public boolean changeCardStateRegion(long cardNum,String state)
    {
        if(!verifyString(state)) {return false;}
        int addid = get(cardNum,"Cards","Card Number","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","State/Region",state);
    }

    /**
     * Updates a card's street address given a card number
     * @param cardNum card number
     * @param country card's new street address
     * @return true if successful
     */
    public boolean changeCardCountry(long cardNum,String country)
    {
        if(!verifyString(country)) {return false;}
        int addid = get(cardNum,"Cards","Card Number","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Country",country);
    }

    /**
     * Updates a card's street address given a card number
     * @param cardNum card number
     * @param zip card's new street address
     * @return true if successful
     */
    public boolean changeCardZipCode(long cardNum,int zip)
    {
        if(zip < 500) {return false;}
        int addid = get(cardNum,"Cards","Card Number","Address ID");
        if (addid == 0)
        {
            System.out.println("You don't have an address yet.");
            return false;
        }
        return update(addid,"Addresses","Address ID","Zip Code",zip);}

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
