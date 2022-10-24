package Database;

import java.sql.Connection;

/**
 *  These are the functions to access the Card Table
 */
public class CardTableConnector
{
    private Connection conn;

    /**
     * Creates Card Table Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    public CardTableConnector(Connection conn) {this.conn = conn;}

}
