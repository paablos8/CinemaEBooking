package com.example.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SQL_GetSet
{
    private Connection conn;

    SQL_GetSet(Connection conn) {this.conn = conn;}

    <T> T get(int id,String table,String idField, String eField)
    {
        T ret = null;
        ResultSet rs;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT ["+idField+"] , ["+eField+"] FROM "+table);

            while (rs.next()) {
                if (id == rs.getInt(idField)) {
                    ret = (T) rs.getString(eField);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    <T> boolean update(int id,String table, String idField, String eField, T entry)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT ["+idField+"] ,["+eField+"] FROM "+table);

            while(rs.next())
            {
                if(id == rs.getInt(idField))
                {
                    rs.updateString(eField, (String) entry);
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
}
