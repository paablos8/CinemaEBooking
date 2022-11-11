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
class SQL_GetSet extends Encryptor
{
    private Connection conn;

    SQL_GetSet(Connection conn) {this.conn = conn;}

    <T,S> T get(S id, String table, String idField, String eField)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField + "] , [" + eField + "] FROM [" + table+"]");

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

    <T,S> boolean exists(S id, String table, String idField)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField + "] FROM [" + table+"]");

            while (rs.next())
            {
                if (verifyField(rs,id,idField))
                {
                    return true;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
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

    <T> int getNumOf(String table)
    {
        int numOf = 0;
        ResultSet rs;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM [" + table + "]");

            while (rs.next())
            {
                    numOf++;
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
            rs = stmt.executeQuery("SELECT [" + idField + "] , [" + eField + "] FROM [" + table+"]");

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

    <T> T[] getAll(String table, String eField)
    {
        int numOf = getNumOf(table);
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
            rs = stmt.executeQuery("SELECT * FROM [" + table+"]");

            while (rs.next())
            {
                ret[i] = getField(rs,eField);
                i++;
                if (i == numOf)
                {
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

    <T,S,G> T getComboKey(S id1, G id2, String table, String idField1, String idField2, String eField)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField1 + "],["+idField2+"] , [" + eField + "] FROM " + table);

            while (rs.next())
            {
                if (verifyField(rs,id1,idField1) && verifyField(rs,id2,idField2))
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

    <T,S> boolean update(S id, String table, String idField, String eField, T entry)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [" + idField + "] ,[" + eField + "] FROM [" + table+"]");

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

    <T,S,G> boolean updateComboKey(S id1, G id2, String table, String idField1, String idField2, String eField, T entry)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [" + idField1 + "],["+idField2+"],[" + eField + "] FROM [" + table+"]");

            while (rs.next())
            {
                if (verifyField(rs,id1,idField1) && verifyField(rs,id2,idField2))
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

    <T> void deleteRecord(T id, String table, String idField)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("DELETE FROM ["+table+"] WHERE ("+idField+") = "+id);
        }
        catch (SQLException e)
        {

        }
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

    boolean verifyString(String str)
    {
        try{
        return str.length() >= 1;}
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    boolean verifyDate(String date)
    {
        if(!verifyString(date))return false;
        if(date.charAt(1) != '/' || date.charAt(2) != '/') return false;
        if(date.charAt(5) != '/' || date.charAt(4) != '/' || date.charAt(3) != '/') return false;
        if(date.length() < 7) return false;

        try
        {
            int month = Integer.parseInt(date.substring(0,date.indexOf('/')));
            if (month > 12 || month < 1)return false;
            int day = Integer.parseInt(date.substring(3,date.substring(3).indexOf('/')));
            if (day > 31 || day < 1)return false;
            int year = Integer.parseInt(date.substring(date.substring(3).indexOf('/')));
            if (year < 2022) return false;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
