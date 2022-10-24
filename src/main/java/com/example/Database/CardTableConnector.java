package com.example.Database;

import java.sql.Connection;

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

}
