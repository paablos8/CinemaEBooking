package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTableConnector
{
    private Connection conn;

    public UserTableConnector(Connection conn)
    {
        this.conn = conn;
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
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT Email, Password, [User ID] FROM Users");

            while(rs.next())
            {
                if(email.equals(rs.getString("Email")))
                {
                    if (password.equals(rs.getString("Password")))
                    {
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
         * Returns the user's first name given their ID.
         * @param userID user's ID
         * @return first name
         */
    public String getUserFirstName(int userID)
    {
        String name = "";
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [First Name] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    name = rs.getString("First Name");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

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
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [Last Name] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    name = rs.getString("Last Name");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return name;
    }

    /**
     * Returns the User's phone number given their ID.
     * @param userID user's ID
     * @return phone number
     */
    public long getUserPhoneNumber(int userID)
    {
        long phoneNum = 0;
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [Phone Number] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    phoneNum = rs.getLong("Phone Number");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return phoneNum;
    }

    /**
         * Returns true if the user is an admin, given their ID.
         * @param userID user's ID
         * @return true if the user is an admin
         */
    public boolean getUserType(int userID)
    {
        boolean isAdmin = false;
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [Is Admin] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    isAdmin = rs.getBoolean("Is Admin");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return isAdmin;
    }

    /**
     * Returns the user's promotion opinion given their ID.
     * @param userID user's ID
     * @return true if user wants promotional emails
     */
    public boolean getPromoOp(int userID)
    {
        boolean promoOp = false;
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [Promotion Opinion] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    promoOp = rs.getBoolean("Promotion Opinion");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return promoOp;
    }

    /**
     * Returns the User's Promotion Opinion given their ID.
     * @param userID user's ID
     * @return user status, corresponds with the enum
     */
    public int getUserStatus(int userID)
    {
        int status = 0;
        ResultSet rs = null;

        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT [User ID] , [User Status] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    status = rs.getInt("User Status");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return status;
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
        try(Statement stmt = conn.createStatement();)
        {
            String SQL = "INSERT INTO Users VALUES ('"
                    +fName+"','"+lName+"',"+pNum+",'"+email+"','"+
                    promoOp+"',"+2+",'"+isAdmin+"','"+password+"')";
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
     * Updates the user's first name
     * @param userID user's ID
     * @param fName user's new first name
     * @return true if successful
     */
    public boolean changeFirstName(int userID,String fName)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [First Name] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("First Name", fName);
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
     * Updates the user's last name
     * @param userID user's ID
     * @param lName user's new last name
     * @return true if successful
     */
    public boolean changeLastName(int userID,String lName)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [Last Name] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Last Name", lName);
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
     * Updates the user's phone number
     * @param userID user's ID
     * @param pNum user's new phone number
     * @return true if successful
     */
    public boolean changePhoneNumber(int userID,long pNum)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [Phone Number] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateLong("Phone Number", pNum);
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
     * Updates the user's promotion opinion
     * @param userID user's ID
     * @param promoOp user's new opinion
     * @return true if successful
     */
    public boolean changePromoOpinion(int userID,Boolean promoOp)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [Promotion Opinion] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateBoolean("Promotion Opinion", promoOp);
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
     * Updates the user's password
     * @param userID user's ID
     * @param password user's new password
     * @return true if successful
     */
    public boolean changePassword(int userID,String password)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , Password FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateString("Password", password);
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
     * Updates the user's status
     * @param userID user's ID
     * @param status user's new status id
     * @return true if successful
     */
    public boolean changeStatus(int userID,int status)
    {
        ResultSet rs = null;
        try
        {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT [User ID] , [User Status] FROM Users");

            while(rs.next())
            {
                if(userID == rs.getInt("User ID"))
                {
                    rs.updateInt("User Status", status);
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
}
