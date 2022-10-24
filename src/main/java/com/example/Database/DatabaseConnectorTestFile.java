package com.example.Database;

/**
 * This is used to test the Database Connection.
 */
public class DatabaseConnectorTestFile
{
    /**
     * Makes a @Code{DatabaseConnector} object and
     * runs the @Code{connect} function.
     */
    public static void main(String[] args)
    {
        //private DatabaseConnector dbConnector = new DatabaseConnector();
        DatabaseConnector c1 = new DatabaseConnector();

        c1.close();
    }
}
