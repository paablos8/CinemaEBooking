package com.example.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.CinemaEBooking.entities.Status;
import com.example.CinemaEBooking.entities.User;

/**
 * These are the functions to access the User Table
 */
class UserTableConnector extends SQL_GetSet
{
    private Connection conn;

    /**
     * Creates UserTable Connector with given connection.
     * Connection should be linked to server prior to creating this object.
     * @param conn Valid connection
     */
    UserTableConnector(Connection conn){super(conn); this.conn = conn;}

    /**
     * Verifies a login using a given email and password.
     * Returns User ID if valid login, -1 if incorrect password,
     * or -2 if invalid email. Returns -3 if user is inactive.
     *
     * @param email The user's email.
     * @param password The user's password
     */
    int verifyLogin(String email, String password)
    {
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT Email, Password, [User ID], [User Status] FROM Users");

            while(rs.next())
            {
                if(email.equals(rs.getString("Email")))
                {/*
                    if (password.equals(decrypt(rs.getString("Password"))))
                    {
                        if(rs.getInt("User Status") != 2)
                        {
                            return -3;
                        }
                        return rs.getInt("User ID");
                    }
                    else
                    {
                        return -1;
                    }*/
                    if (password.equals(rs.getString("Password")))
                    {
                        if(rs.getInt("User Status") != 2)
                        {
                            return -3;
                        }
                        return rs.getInt("User ID");
                    }
                    else
                    {
                        return -1;
                    }
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return -2;
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
    boolean createNewUser(String fName, String lName, long pNum,
                          String email, boolean promoOp, boolean isAdmin,
                          String password)
    {
        if(!(verifyEmail(email)&&verifyPhoneNum(pNum)&&verifyString(fName)&&verifyString(lName)&&verifyString(password)))
        {
            return false;
        }

        //String encPass = encrypt(password);
        String encPass = password;
        try(Statement stmt = conn.createStatement())
        {
            String SQL = "INSERT INTO Users VALUES ('"
                    +fName+"','"+lName+"',"+pNum+",'"+email+"','"+
                    promoOp+"',"+2+",'"+isAdmin+"','"+encPass+"')";
            stmt.executeUpdate(SQL);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Creates a User Object based on a given ID
     * @param userID user's id
     * @return user object
     */
    User createUserObject(int userID)
    {
        User user = new User();

        user.setUserId(userID);
        user.setEmail(getUserEmail(userID));
        user.setPassword(getUserPassword(userID));
        user.setStatus(getUserStatus(userID));

        return user;
    }

    boolean resetPassword(String email,String password)
    {
        if(!verifyEmail(email)||!verifyString(password))return false;
        ResultSet rs;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [Email] ,[Password] FROM Users");

            while(rs.next())
            {
                if((email.equals(rs.getString("Email"))))
                {
                    //String encPass = encrypt(password);
                    String encPass = password;
                    rs.updateString("Password", encPass);
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

    /**
     * Gets user's first name from database given their id
     * @param userID user's id
     * @return user's first name
     */
    String getUserFirstName(int userID){return get(userID,"Users","User ID","First Name");}

    /**
     * Gets user's last name from database given their id
     * @param userID user's id
     * @return user's last name
     */
    String getUserLastName(int userID){return get(userID,"Users","User ID","Last Name");}

    /**
     * Gets user's phone number from database given their id
     * @param userID user's ID
     * @return phone number
     */
    long getUserPhoneNumber(int userID){return get(userID,"Users","User ID","Phone Number");}

    /**
     * Gets user's email address from database given their id
     * @param userID user's id
     * @return user's email address
     */
    String getUserEmail(int userID){return get(userID,"Users","User ID","Email");}

    /**
     * Gets user's promotion opinion from database given their id
     * @param userID user's ID
     * @return true if user wants promotional emails
     */
    boolean getPromoOp(int userID){return get(userID,"Users","User ID","Promotion Opinion");}

    /**
     * Gets user's status from database given their id
     * @param userID user's id
     * @return user status
     */
    Status getUserStatus(int userID)
    {
        int status = get(userID,"Users","User ID","User Status");

        switch (status)
        {
            case(1):return Status.ACTIVE;
            case(2):return Status.INACTIVE;
            default:return Status.SUSPENDED;
        }
    }

    /**
     * Gets user's type from database given their id
     * @param userID user's ID
     * @return true if the user is an admin
     */
    boolean getUserType(int userID){return get(userID,"Users","User ID","User Type");}

    /**
     * Gets user's password from database given their ID.
     * @param userID user's id
     * @return password
     */
    String getUserPassword(int userID)
    {
        String encPass =  get(userID,"Users","User ID","Password");
        //return decrypt(encPass);
        return encPass;
    }

    /**
     * Updates the user's first name
     * @param userID user's ID
     * @param fName user's new first name
     * @return true if successful
     */
    boolean changeFirstName(int userID,String fName)
    {if(verifyString(fName))return false;return update(userID,"Users","User ID","First Name",fName);}

    /**
     * Updates the user's last name
     * @param userID user's ID
     * @param lName user's new last name
     * @return true if successful
     */
    boolean changeLastName(int userID,String lName)
    {if(verifyString(lName))return false;return update(userID,"Users","User ID","Last Name",lName);}

    /**
     * Updates the user's phone number
     * @param userID user's ID
     * @param pNum user's new phone number
     * @return true if successful
     */
    boolean changePhoneNumber(int userID,long pNum)
    {
        if(verifyPhoneNum(pNum))return false;
        return update(userID,"Users","User ID","Phone Number",pNum);
    }

    /**
     * Updates the user's promotion opinion
     * @param userID user's ID
     * @param promoOp user's new opinion
     * @return true if successful
     */
    boolean changePromoOpinion(int userID,Boolean promoOp)
    {return update(userID,"Users","User ID","Promotion Opinion",promoOp);}

    /**
     * Updates the user's status
     * @param userID user's ID
     * @param status user's new status id
     * @return true if successful
     */
    boolean changeStatus(int userID,Status status)
    {
        if(status == null) return false;
        int stat;
        switch(status)
        {
            case ACTIVE:stat = 1;
                break;
            case INACTIVE:stat = 2;
                break;
            default: stat = 3;
        }

        return update(userID,"Users","User ID","User Status",stat);
    }

    /**
     * Updates the user's password
     * @param userID user's ID
     * @param password user's new password
     * @return true if successful
     */
    boolean changePassword(int userID,String password)
    {
        if(verifyString(password))
            return false;
        //String encPass = encrypt(password);
        String encPass = password;
        return update(userID,"Users","User ID","Password",encPass);
    }

    boolean verifyEmail(String email)
    {
        if(!verifyString(email))
        {System.out.println("String fail"); return false;}
        int at = email.indexOf('@');
        return at >= 1 && at != email.length() - 1;
    }

    private boolean verifyPhoneNum(long pNum){return pNum >= 1000000000;}
}
