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
    public static void main(String[] args) {

        //private DatabaseConnector dbConnector = new DatabaseConnector();
        DatabaseConnector c1 = new DatabaseConnector();
        System.out.println(c1.createNewShowtime("The Hobbit",3,"2022-11-20 16:20"));
        c1.close();


/*
        Encryptor enc = new Encryptor();
        String temp= enc.encryptLong(1234123412341234L);
        System.out.println(temp);
        System.out.println(enc.decryptLong(temp));
    }

 */
    }
}
