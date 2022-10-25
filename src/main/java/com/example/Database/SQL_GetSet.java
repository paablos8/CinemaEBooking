package com.example.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * These are generic methods for SQL calls.
 * Basis for every table connector class.
 */
class SQL_GetSet
{
    private Connection conn;

    SQL_GetSet(Connection conn) {this.conn = conn;}

    <T,S> T get(S id, String table, String idField, String eField)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField + "] , [" + eField + "] FROM " + table);

            while (rs.next())
            {
                if (verifyField(rs,id,idField))
                {
                    ret = getField(rs,eField);
                    break;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ret;
    }

    <T> int getNumOf(T id, String table, String idField)
    {
        int numOf = 0;
        ResultSet rs;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField + "] FROM [" + table + "]");

            while (rs.next())
            {
                if (verifyField(rs,id,idField))
                {
                    numOf++;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return numOf;
    }

    <T, S> T[] getMany(S id, String table, String idField, String eField)
    {
        int numOf = getNumOf(id, table, idField);
        int i = 0;

        ArrayList<T> retAL = new ArrayList<T>(numOf);

        for (int z = 0;z < numOf;z++)
        {
            retAL.add(null);
        }

        T[] ret = (T[]) retAL.toArray();

        ResultSet rs;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField + "] , [" + eField + "] FROM " + table);

            while (rs.next())
            {
                if (verifyField(rs,id,idField))
                {
                    ret[i] = getField(rs,eField);
                    i++;
                    if (i == numOf)
                    {
                        break;
                    }
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return ret;
    }

    <T> boolean update(int id, String table, String idField, String eField, T entry)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [" + idField + "] ,[" + eField + "] FROM " + table);

            while (rs.next())
            {
                if (verifyField(rs,id,idField))
                {
                    updateField(rs,entry,eField);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    private <T> boolean verifyField (ResultSet rs, T id, String idField)
    {
        try
        {
            if (id.equals(rs.getObject(idField)))
            {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private <T> T getField(ResultSet rs, String eField)
    {
        try
        {
            return (T) rs.getObject(eField);
        }
        catch (RuntimeException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private <T> void updateField(ResultSet rs, T entry, String eField)
    {
        try
        {
            rs.updateObject(eField, entry);
        }
        catch (RuntimeException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
