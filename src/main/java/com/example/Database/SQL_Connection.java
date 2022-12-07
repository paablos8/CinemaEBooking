package com.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Connection
{
    private static Connection conn;

    private static void actuallyConnect (String dbURL)
    {
        try
        {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    static Connection connect (String dbUrl)
    {
        if (conn == null)
        {
            actuallyConnect(dbUrl);
        }
        return conn;
    }
}