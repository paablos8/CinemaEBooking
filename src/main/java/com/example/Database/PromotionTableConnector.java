package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

class PromotionTableConnector extends SQL_GetSet
{
    private Connection conn;
    PromotionTableConnector(Connection conn){super(conn); this.conn = conn;}

    /**
     * Creates a new promotion. Always created as a draft
     * @param dateStart start date
     * @param dateEnd end date
     * @param percentOff percentage off, as an int 0 - 100
     * @return -1 if start date invalid, -2 if end date invalid
     * -3 if percentage invalid, 0 if it worked
     */
    int createDraftPromotion(String dateStart, String dateEnd, int percentOff, String code)
    {
        if((percentOff < 100)&&(percentOff>0)) return -3;
        if(!verifyString(code)) return -4;

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Promotions VALUES ('"+dateStart+"','"+
                    dateEnd+"',"+percentOff+","+false+",'"+code+"')";
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
     * Returns true if the promotion is still a draft
     * @param code code for promotion
     * @return true if a draft
     */
    boolean isDraftPromotion(String code)
    {
        return !(boolean)(get(code,"Promotions","Code","isActive"));
    }

    /**
     * Sets a promtion to active. Irreversable
     * @param code start date of promotion
     */
    void activatePromotion(String code)
    {
        update(code,"Promotions","Code","isActive",true);
    }

    /**
     * Promotion codes are a primary key
     * @return string array of codes
     */
    String[] getAllPromotionCodes()
    {
        Object [] temp = getAll("Promotions","Code");
        Object [] tempSubset = new Object[temp.length -1];
        for (int i = 1; i < temp.length; i++)
        {
            tempSubset[i-1] = temp[i];
        }
        return Arrays.copyOf(tempSubset,tempSubset.length,String[].class);
    }

    /**
     * Returns the percentage off of a promotion
     * @param code code for promotion
     * @return the percentage off, as an int 0 - 100
     */
    int getPercentOff (String code)
    {
        return get(code,"Promotions","Code","Percent Off");
    }

    /**
     * Returns the start date of a promotion
     * @param code code for promotion
     * @return the start date
     */
    String getDateStart (String code) {return get(code,"Promotions","Code","Date Start");}

    /**
     * Returns the end date of a promotion
     * @param code code for promotion
     * @return the end date
     */
    String getDateEnd (String code) {return get(code,"Promotions","Code","Date End");}

    /**
     * Changes percent off
     * @param code code for promotion
     * @param percentOff new percent off
     * @return true if it worked
     */
    boolean changePercentOff (String code, int percentOff)
    {
        if(get(code,"Promotions","Code","isActive"))
        {
            return false;
        }

        if(percentOff < 0 || percentOff > 100)
        {
            return false;
        }

        return update(code,"Promotions","Code","Percent Off",percentOff);
    }

    /**
     * Changes Start Date
     * @param code code for promotion
     * @param newStartDate new start date
     * @return true if it worked
     */
    boolean changeStartDate(String code, String newStartDate)
    {
        if(get(code,"Promotions","Code","isActive"))
        {
            return false;
        }
        return update(code,"Promotions","Code","Date Start",newStartDate);
    }

    /**
     * Changes the end date of a draft promotion
     * @param code code for promotion
     * @param newEndDate new end date of promotion
     * @return true if it worked
     */
    boolean changeEndDate(String code, String newEndDate)
    {
        if(get(code,"Promotions","Code","isActive"))
        {
            return false;
        }

        return update(code,"Promotions","Code","Date Start",newEndDate);
    }

    /**
     * Changes the code of a draft promotion
     * @param oldCode old code for promotion
     * @param newCode new code of promotion
     * @return true if it worked
     */
    boolean changeCode(String oldCode, String newCode)
    {
        if(get(oldCode,"Promotions","Code","isActive"))
        {
            return false;
        }

        if(!verifyString(newCode))
        {
            return false;
        }

        return update(oldCode,"Promotions","Code","Code",newCode);
    }
}
