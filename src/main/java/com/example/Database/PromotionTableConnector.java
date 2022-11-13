package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    int createDraftPromotion(String dateStart, String dateEnd, int percentOff)
    {
        if(!(verifyDate(dateEnd))) return -1;
        if(!verifyDate(dateStart)) return -2;
        if((percentOff < 100)&&(percentOff>0)) return -3;

        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Promotions VALUES ('"+dateStart+"','"+dateEnd+"',"+percentOff+","+false+")";
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
     * @param startDate start date of promotion
     * @param endDate end date of promotion
     * @return true if a draft
     */
    boolean isDraftPromotion(String startDate,String endDate)
    {
        int id = getComboKey(startDate,endDate,"Promotions","Date Start","Date End","Promotion ID");
        return !(boolean)(get(id,"Promotions","Promotion ID","isActive"));
    }

    /**
     * Sets a promtion to active. Irreversable
     * @param startDate start date of promotion
     * @param endDate end date of promotion
     */
    void activatePromotion(String startDate,String endDate)
    {
        int id = getComboKey(startDate,endDate,"Promotions","Date Start","Date End","Promotion ID");
        update(id,"Promotions","Promotion ID","isActive",true);
    }

    /**
     * Promotions have a combination-key, start and end date
     * @return string array. [i][i] will refer to one date
     */
    String[][] getAllStartEndDates()
    {
        String [] starts = getAll("Promotions","Date Start");
        String [] ends = getAll("Promotions","Date End");

        String [][] ret = new String [starts.length][2];

        for (int i = 1; i < starts.length;i++)
        {
            ret [i][0] = starts[i];
            ret [i][1] = ends[i];
        }

        return ret;
    }

    /**
     * Returns the percentage off of a promotion
     * @param startDate start date of promotion
     * @param endDate end date of promotion
     * @return the percentage off, as an int 0 - 100
     */
    int getPercentOff (String startDate, String endDate)
    {
        return getComboKey(startDate,endDate,"Promotions","Date Start","Date End","Percent Off");
    }
    boolean changePercentOff (String startDate, String endDate, int percentOff)
    {
        if(getComboKey(startDate,endDate,"Promotions","Date Start","Date End","isActive"))
        {
            return false;
        }

        if(percentOff < 0 || percentOff > 100)
        {
            return false;
        }

        return updateComboKey(startDate,endDate,"Promotions","Date Start","Date End",
                "Percent Off",percentOff);
    }

    /**
     * 
     * @param oldStartDate
     * @param endDate
     * @param newStartDate
     * @return
     */
    boolean changeStartDate(String oldStartDate, String endDate, String newStartDate)
    {
        if(getComboKey(oldStartDate,endDate,"Promotions","Date Start","Date End","isActive"))
        {
            return false;
        }

        if(!verifyDate(newStartDate))
        {
            return false;
        }

        return updateComboKey(oldStartDate,endDate,"Promotions","Date Start","Date End",
                "Date Start",newStartDate);
    }

    /**
     * Changes the end date of a draft promotion
     * @param startDate start date of promotion
     * @param oldEndDate old end date of promotion
     * @param newEndDate new end date of promotion
     * @return true if it worked
     */
    boolean changeEndDate(String startDate, String oldEndDate, String newEndDate)
    {
        if(getComboKey(startDate,oldEndDate,"Promotions","Date Start","Date End","isActive"))
        {
            return false;
        }

        if(!verifyDate(newEndDate))
        {
            return false;
        }

        return updateComboKey(startDate,oldEndDate,"Promotions","Date Start","Date End",
                "Date Start",newEndDate);
    }
}
