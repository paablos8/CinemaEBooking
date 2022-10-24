package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is an object that can connect and disconnect from the server.
 */
public class DatabaseConnector
{
    private Connection conn;
    private UserTableConnector utc = null;
    private CardTableConnector ctc = null;

    /**
     * Creates DatabaseConnector object and connects to server.
     */
    public DatabaseConnector()
    {
        String serverName = "2.tcp.ngrok.io:13938;";
        String loginCredentials = "user=sa;password=Team_C2;";
        String settings = "encrypt=true;trustServerCertificate=true";
        String dbURL = "jdbc:sqlserver://"+serverName+loginCredentials+settings;
        try
        {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        if (conn != null)
        {
            System.out.println("Connected");
            utc = new UserTableConnector(conn);
            ctc = new CardTableConnector(conn);
        }
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
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    //User Methods
    public int verifyLogin(String email, String password){return utc.verifyLogin(email,password);}
    public String getUserFirstName(int userID){return utc.getUserFirstName(userID);}
    public String getUserLastName(int userID){return utc.getUserLastName(userID);}
    public long getUserPhoneNumber(int userID){return  utc.getUserPhoneNumber(userID);}
    public boolean getUserType(int userID){return utc.getUserType(userID);}
    public boolean getPromoOp(int userID){return utc.getPromoOp(userID);}
    public int getUserStatus(int userID){return utc.getUserStatus(userID);}
    public boolean createNewUser(String fName, String lName, long pNum,
                                 String email, boolean promoOp, boolean isAdmin,
                                 String password)
    {return utc.createNewUser(fName,lName,pNum,email,promoOp,isAdmin,password);}
    public boolean changeFirstName(int userID,String fName){return utc.changeFirstName(userID,fName);}
    public boolean changeLastName(int userID,String lName){return utc.changeLastName(userID,lName);}
    public boolean changePhoneNumber(int userID,Long pNum){return utc.changePhoneNumber(userID,pNum);}
    public boolean changePromotionOpinion(int userID,Boolean promoOp){return utc.changePromoOpinion(userID,promoOp);}
    public boolean changePassword(int userID,String password){return utc.changePassword(userID,password);}
    public boolean changeStatus(int userID,int status){return utc.changeStatus(userID,status);}
}
