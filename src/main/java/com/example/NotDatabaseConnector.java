package com.example;

import java.util.ArrayList;

/**
 * This is an object that can simulate connecting and disconnecting from the server.
 */
public class NotDatabaseConnector
{
    ArrayList<Integer> userIDs = new ArrayList<Integer>();
    ArrayList<String> fNames = new ArrayList<String>();
    ArrayList<String> lNames = new ArrayList<String>();
    ArrayList<Long> pNums = new ArrayList<Long>();
    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<Boolean> promoOps = new ArrayList<Boolean>();
    ArrayList<Boolean> isAdmins = new ArrayList<Boolean>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<Integer> statuses = new ArrayList<Integer>();

    /**
     * Creates NotDatabaseConnector object and "connects to server".
     */
    public NotDatabaseConnector()
    {
        userIDs.add(1);
        userIDs.add(2);
        userIDs.add(3);
        userIDs.add(4);
        userIDs.add(5);
        fNames.add("Tor");
        fNames.add("Jacobi");
        fNames.add("Pablo");
        fNames.add("Spencer");
        fNames.add("Dorian");
        lNames.add("Schilke");
        lNames.add("Coleman");
        lNames.add("Muller");
        lNames.add("Skaggs");
        lNames.add("van Hasenbroeck");
        pNums.add(5407505067L);
        pNums.add(4784614615L);
        pNums.add(7065409326L);
        pNums.add(7063083899L);
        pNums.add(7062062700L);
        emails.add("vvs22964@uga.edu");
        emails.add("jc75735@uga.edu");
        emails.add("pablo.muller@uga.edu");
        emails.add("sgs62943@uga.edu");
        emails.add("dorian.vanhasenbroeck@uga.edu");
        promoOps.add(true);
        promoOps.add(true);
        promoOps.add(true);
        promoOps.add(true);
        promoOps.add(true);
        isAdmins.add(true);
        isAdmins.add(true);
        isAdmins.add(true);
        isAdmins.add(true);
        isAdmins.add(true);
        statuses.add(1);
        statuses.add(1);
        statuses.add(1);
        statuses.add(1);
        statuses.add(1);
        passwords.add("TeamC2");
        passwords.add("TeamC2");
        passwords.add("TeamC2");
        passwords.add("TeamC2");
        passwords.add("TeamC2");

        System.out.println("Connected");
    }

    /**
     * Verifies a login using a given email and password.
     * Returns User ID if valid login, -1 if incorrect password,
     * or -2 if invalid email.
     *
     * @param email The user's email.
     * @param password The user's password
     */
    public int verifyLogin(String email, String password)
    {
        if(emails.contains(email))
        {
            if(emails.indexOf(email) == passwords.indexOf(password))
            {
                return emails.indexOf(email);
            }
            else
            {
                return -1;
            }
        }
        return -2;
    }

    /**
     * Returns the user's first name given their ID.
     * @param userID user's ID
     * @return first name
     */
    public String getUserFirstName(int userID)
    {
        String name = "";

        name = fNames.get(userIDs.indexOf(userID));

        return name;
    }

    /**
     * Returns the user's last name given their ID.
     * @param userID user's ID
     * @return last name
     */
    public String getUserLastName(int userID)
    {
        String name = "";

        name = lNames.get(userIDs.indexOf(userID));

        return name;
    }

    /**
     * Returns the user's phone number given their ID.
     * @param userID user's ID
     * @return phone number
     */
    public long getUserPhoneNumber(int userID)
    {
        long phoneNum = 0;

        phoneNum = pNums.get(userIDs.indexOf(userID));

        return phoneNum;
    }

    /**
     * Returns true if the user is an admin, given their ID.
     * @param userID user's ID
     * @return user type, corresponds with the enum
     */
    public boolean getUserType(int userID)
    {
        boolean isAdmin = false;

        isAdmin = isAdmins.get(userIDs.indexOf(userID));

        return isAdmin;
    }

    /**
     * Returns the User's Promotion Opinion given their ID.
     * @param userID user's ID
     * @return user type, corresponds with the enum
     */
    public boolean getPromoOp(int userID)
    {
        boolean opinion = false;

        opinion = promoOps.get(userIDs.indexOf(userID));

        return opinion;
    }

    /**
     * Creates a new user.
     * @param fName new user's first name
     * @param lName new user's last name
     * @param pNum new user's phone number
     * @param email new user's email address
     * @param promoOp new user's promotion opinion, or true if admin
     * @param isAdmin true if admin
     * @param password new user's password
     * @return true if successful
     */
    public boolean createNewUser(String fName, String lName, long pNum,
                                 String email, boolean promoOp, boolean isAdmin,
                                 String password)
    {
        fNames.add(fName);
        lNames.add(lName);
        pNums.add(pNum);
        emails.add(email);
        promoOps.add(promoOp);
        isAdmins.add(isAdmin);
        passwords.add(password);
        statuses.add(1);

        return true;
    }

    /**
     * If the connection is currently open, "closes the connection".
     */
    public void close()
    {
        System.out.println("Connection closed");
    }
}
