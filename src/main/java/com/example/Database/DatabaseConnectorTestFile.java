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

        DatabaseConnector c1 = null;
        c1 = c1.getInstance();
        System.out.println(c1.verifyLogin("email.com","oawen"));
        c1.close();

        /*
        Encryptor enc = new Encryptor();
        System.out.println(enc.decryptLong("fhfhfhfhfhfhfhfh"));
         */
    }
}
