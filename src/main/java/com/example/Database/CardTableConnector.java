package com.example.Database;

import com.example.CinemaEBooking.entities.PaymentCard;

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
    public int createNewCard(String date, int cvv, long cardNum, String nameOnCard, int userID,
                                 String streetAddress, String cityCounty, String stateRegion, int zip)
    {
        if (!verifyString(nameOnCard)) return -2;
        if (!verifyString(streetAddress)) return -3;
        if (!verifyString(cityCounty)) return -4;
        if (!verifyString(stateRegion)) return -5;
        if (zip<501) return -6;
        if (cardNum>999999999999999L&&cardNum<9999999999999999L) return -7;

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
        return 0;
    }

    /**
     * Creates an array of a user's card objects
     * @param userID the user's id
     * @return the cards they hold
     */
    PaymentCard [] createCardObjects(int userID)
    {
        long [] cardNums = getCardNumbers(userID);
        String [] cardNames = getCardNames(userID);
        int [] cardCVVs = getCardZipCodes(userID);
        String [] expDates = getCardExpDates(userID);
        String [] streets = getCardStreetAddress(userID);
        String [] counties = getCardCityCounty(userID);
        String [] states = getCardStateRegion(userID);
        int [] zip = getCardZipCodes(userID);

        PaymentCard [] cards = new PaymentCard[cardNums.length];

        for (int i = 0; i < cardNums.length; i ++)
        {
            cards[i] = new PaymentCard();
            cards[i].setCardNumber(cardNums[i]);
            cards[i].setNameOnCard(cardNames[i]);
            cards[i].setZip(zip[i]);
            cards[i].setCvv(cardCVVs[i]);
            cards[i].setExpirationDate(expDates[i]);
            cards[i].setStreet(streets[i]);
            cards[i].setCity(counties[i]);
            cards[i].setState(states[i]);
        }

        return cards;
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
     * Given a user id, returns an array of their card cvvs
     * @param userID user's id
     * @return int array of user's card cvvs
     */
    public int[] getCardCVVs(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int[] cardCVVs = new int[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            String temp = get(cardIDS[i],"Cards","Card ID","CVV");
            cardCVVs[i] = Integer.parseInt(temp);
        }

        return cardCVVs;
    }

    /**
     * Given a user id, returns an array of their expiration dates
     * @param userID user's id
     * @return String array of user's card expiration dates
     */
    public String[] getCardExpDates(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        String[] cardDates = new String[numOfCards];
        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardDates[i] = get(cardIDS[i],"Cards","Card ID","Expiration Date");
        }

        return cardDates;
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
     * Given a user id, returns an array of street addresses for their cards
     * @param userID user's id
     * @return int array of the zip codes for the user's cards
     */
    public String[] getCardStreetAddress(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int [] cardAddIDs = new int[numOfCards];
        String[] cardSts = new String[numOfCards];

        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardAddIDs[i] = get(cardIDS[i],"Cards","Card ID","Address ID");
            cardSts[i] = get(cardAddIDs[i],"Addresses","Address ID","Street Address");
        }

        return cardSts;
    }

    /**
     * Given a user id, returns an array of cities or counties for their cards
     * @param userID user's id
     * @return int array of the zip codes for the user's cards
     */
    public String[] getCardCityCounty(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int [] cardAddIDs = new int[numOfCards];
        String[] cardCounties = new String[numOfCards];

        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardAddIDs[i] = get(cardIDS[i],"Cards","Card ID","Address ID");
            cardCounties[i] = get(cardAddIDs[i],"Addresses","Address ID","City/County");
        }

        return cardCounties;
    }

    /**
     * Given a user id, returns an array of states or regions for their cards
     * @param userID user's id
     * @return int array of states or regions for the user's cards
     */
    public String[] getCardStateRegion(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int [] cardAddIDs = new int[numOfCards];
        String[] cardSts = new String[numOfCards];

        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardAddIDs[i] = get(cardIDS[i],"Cards","Card ID","Address ID");
            cardSts[i] = get(cardAddIDs[i],"Addresses","Address ID","State/Region");
        }

        return cardSts;
    }

    /**
     * Given a user id, returns an array of zip codes for their cards
     * @param userID user's id
     * @return int array of zip codes for the user's cards
     */
    public int[] getCardZipCodes(int userID)
    {
        int numOfCards = getNumOf(userID,"User Cards","User ID");
        int [] cardAddIDs = new int[numOfCards];
        int[] cardZips = new int[numOfCards];

        Object[] cardIDS = getMany(userID,"User Cards","User ID","Card ID");

        for(int i = 0; i < numOfCards; i++)
        {
            cardAddIDs[i] = get((int)cardIDS[i],"Cards","Card ID","Address ID");
            cardZips[i] = get(cardAddIDs[i],"Addresses","Address ID","Zip Code");
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
        return update(oldCardNum,"Cards","Card Number","Card Number",newCardNum);
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
        return update(cardNum,"Cards","Card Number","Expiration Date",expDate);
    }

    /**
     * Replaces the name for a card given the card number
     * @param cardNum the card number
     * @param name the new card name
     * @return true if it worked
     */
    public boolean changeCardName(long cardNum, String name)
    {
        return update(cardNum,"Cards","Card Number","Name on Card",name);
    }

    /**
     * Replaces the security code for a card given the card number
     * @param cardNum the card number
     * @param cvv the new card security code
     * @return true if it worked
     */
    public boolean changeCardCVV(long cardNum, int cvv)
    {
        return update(cardNum,"Cards","Card Number","CVV",cvv);
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
