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
        System.out.println(c1.getAllTitles()[1]);
        c1.close();

/*
        Encryptor enc = new Encryptor();
        String temp= enc.encrypt(1234123412341234L);
        System.out.println(temp);
        System.out.println(enc.decrypt(temp));*/
    }
}
