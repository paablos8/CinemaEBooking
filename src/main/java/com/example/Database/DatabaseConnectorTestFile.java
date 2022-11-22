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
        /*
        DatabaseConnector c1 = new DatabaseConnector();
        System.out.println(c1.createDraftPromotion("2022-11-26 14:00","2022-11-27 16:00",20,"code"));
        c1.close();
*/



        Encryptor enc = new Encryptor();
        //String temp= enc.encrypt("password");
        //System.out.println(temp);
        //System.out.println(enc.decryptLong(temp));


        System.out.println(enc.decrypt("password"));


    }
}
