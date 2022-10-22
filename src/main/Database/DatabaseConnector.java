package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * This is an object that can connect and disconnect from the server.
 */
class DatabaseConnector
{
    Connection conn = null;

    /**
     * Creates DatabaseConnector object and connects to server.
     */
    public DatabaseConnector()
    {
        String dbURL = "jdbc:sqlserver://DESKTOP-LCS9BBJ\\SOFTWAREENGSERVE;user=sa;password=Team_C2;" +
                "encrypt=true;trustServerCertificate=true";
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("Connected");
        }
    }

    /**
     * Verifies a login using a given email and password.
     * Returns 0 if valid login, 1 if incorrect password,
     * or 2 if invalid email.
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
            rs = stmt.executeQuery("SELECT Email , Password FROM Users");

            while(rs.next())
            {
                if(email.equals(rs.getString("Email")))
                {
                    if (password.equals(rs.getString("Password")))
                    {
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 2;
    }

    /**
     * Creates a new User Record.
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param phoneNum The user's phone number
     * @param email The user's email
     * @param userType The user's type, customer or admin
     * @param
     */

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
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
