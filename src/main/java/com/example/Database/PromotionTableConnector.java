package com.example.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class PromotionTableConnector extends SQL_GetSet
{
    private Connection conn;
    PromotionTableConnector(Connection conn){super(conn); this.conn = conn;}

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

    boolean isDraftPromotion(String startDate,String endDate)
    {
        int id = getComboKey(startDate,endDate,"Promotions","Date Start","Date End","Promotion ID");
        return !(boolean)(get(id,"Promotions","Promotion ID","isActive"));
    }

    void activatePromotion(String startDate,String endDate)
    {
        int id = getComboKey(startDate,endDate,"Promotions","Date Start","Date End","Promotion ID");
        update(id,"Promotions","Promotion ID","isActive",true);
    }

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
