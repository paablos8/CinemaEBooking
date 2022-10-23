import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * This is an object that can connect and disconnect from the server.
 */
public class DatabaseConnector
{
    private Connection conn = null;

    /**
     * Creates DatabaseConnector object and connects to server.
     */
    public DatabaseConnector()
    {
        String serverName = "2.tcp.ngrok.io:11975;";
        String serverInstance = "instanceSOFTWAREENGSERVE;";
        String loginCredentials = "user=sa;password=Team_C2;";
        String settings = "encrypt=true;trustServerCertificate=true";
        String dbURL = "jdbc:sqlserver://"+serverName+loginCredentials+settings;
        try 
        {
            conn = DriverManager.getConnection(dbURL);
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
        if (conn != null) 
        {
            System.out.println("Connected");
        }
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
            rs = stmt.executeQuery("SELECT Email, Password, User ID FROM Users");

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
            rs = stmt.executeQuery("SELECT User ID , First Name FROM Users");

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
            rs = stmt.executeQuery("SELECT User ID , Last Name FROM Users");

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
            rs = stmt.executeQuery("SELECT User ID , Phone Number FROM Users");

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
            rs = stmt.executeQuery("SELECT User ID , Is Admin FROM Users");

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
            rs = stmt.executeQuery("SELECT User ID , Promotion Opinion FROM Users");

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
     * Returns the user's status given their ID.
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
            rs = stmt.executeQuery("SELECT User ID , User Status FROM Users");

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
     * If the connection is currently open, closes the connection.
     */
    public void close()
    {
        try
        {
            if (conn != null && !conn.isClosed())
            {
                conn.close();
                System.out.println("Connection closed");
            }
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
