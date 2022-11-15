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

    /**
     * Gets a field value of a record given a primary key
     * @param id primary key
     * @param table table record is in
     * @param idField field of primary key
     * @param eField field of desired value
     * @return value in given filed
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Checks if a record exists with a primary key
     * @param id primary key
     * @param table desired table
     * @param idField field of id
     * @return true if it exists
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Checks if a record exists with a specific combination of values
     * @param id1 identifying field 1
     * @param id2 identifying field 2
     * @param table desired table
     * @param idField1 field of id1
     * @param idField2 field of id2
     * @return true if that record exists already
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     * @param <G> strings, ints, doubles, anything that this table uses
     */
    <T,S,G> boolean existsComboKey(S id1, G id2, String table, String idField1, String idField2)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [" + idField1 + "] FROM [" + table+"]");

            while (rs.next())
            {
                if (verifyField(rs,id1,idField1)&& verifyField(rs,id2,idField2))
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

    /**
     * Returns number of records in a table with a specific value
     * @param id identifying value
     * @param table desired table
     * @param idField field of id
     * @return number of records with that value
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Returns number of entries in a table
     * @param table desired table
     * @return number of records
     */
    int getNumOf(String table)
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

    /**
     * Returns values from multiple records
     * @param id identifying field
     * @param table table records are in
     * @param idField field of id
     * @param eField desired field
     * @return object array of the field's entries
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Returns all values in a field
     * @param table table to get values from
     * @param eField desired field
     * @return object array of entries
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Gets value of a record based on a combination key
     * @param id1 identifying field 1
     * @param id2 identifying field 2
     * @param table table record is in
     * @param idField1 field of id1
     * @param idField2 field of id2
     * @param eField desired field
     * @return value in desired field and record
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     * @param <G> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Updates a record based on a primary key
     * @param id primary key
     * @param table table record is in
     * @param idField field of primary key
     * @param eField field of entry
     * @param entry value to update record with
     * @return true if it worked
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     */
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
            return false;
        }
        return true;
    }

    /**
     * Updates an entry in a field based on a combination key
     * @param id1 identifying field 1
     * @param id2 identifying field 2
     * @param table table record is in
     * @param idField1 field name of id1
     * @param idField2 field name of id2
     * @param eField field of entry
     * @param entry item to update record with
     * @return true if it worked
     * @param <T> strings, ints, doubles, anything that this table uses
     * @param <S> strings, ints, doubles, anything that this table uses
     * @param <G> strings, ints, doubles, anything that this table uses
     */
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
            return false;
        }
        return true;
    }

    /**
     * Used to delete records from a table
     * @param id identifying field of record
     * @param table table record is in
     * @param idField id's field
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Used to check if a field has a specific value
     * @param rs Result set from which to check
     * @param id item to check
     * @param idField identifying field name
     * @return true if the id = the entry in specified field
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Used to execute 'get' SQL calls
     * @param rs result set on which to get
     * @param eField field to get from
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Used to execute 'update' SQL calls
     * @param rs result set on which to update
     * @param entry new entry
     * @param eField field to enter
     * @param <T> strings, ints, doubles, anything that this table uses
     */
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

    /**
     * Verifies that a string is not null
     * @param str string to check
     * @return true if ok
     */
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
}
