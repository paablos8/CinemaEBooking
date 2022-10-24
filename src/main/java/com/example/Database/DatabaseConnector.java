package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.CinemaEBooking.entities.Status;
import com.example.CinemaEBooking.entities.User;

/**
 * This is an object that can connect and disconnect from the server.
 */
public class DatabaseConnector
{
    private Connection conn;
    private UserTableConnector utc = null;
    private CardTableConnector ctc = null;
    private AddressTableConnector atc = null;

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
            atc = new AddressTableConnector(conn);
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
    public Status getUserStatus(int userID){return utc.getUserStatus(userID);}
    public boolean createNewUser(String fName, String lName, long pNum,
                                 String email, boolean promoOp, boolean isAdmin,
                                 String password)
    {return utc.createNewUser(fName,lName,pNum,email,promoOp,isAdmin,password);}
    public User createUserObject(int userID){return utc.createUserObject(userID);}
    public boolean changeFirstName(int userID,String fName){return utc.changeFirstName(userID,fName);}
    public boolean changeLastName(int userID,String lName){return utc.changeLastName(userID,lName);}
    public boolean changePhoneNumber(int userID,Long pNum){return utc.changePhoneNumber(userID,pNum);}
    public boolean changePromotionOpinion(int userID,Boolean promoOp){return utc.changePromoOpinion(userID,promoOp);}
    public boolean changePassword(int userID,String password){return utc.changePassword(userID,password);}
    public boolean changeStatus(int userID, Status status){return utc.changeStatus(userID,status);}

    //Card Methods

    //Address Methods
    public String getStreetAddress(int userID){return atc.getStreetAddress(userID);}
    public boolean createNewAddress(int userID,String stAdd,String city,String state,String country,int zip)
    {return atc.createNewAddress(userID,stAdd,city,state,country,zip);}
    public boolean changeStreetAddress(int userID,String stAdd){return atc.changeStreetAddress(userID,stAdd);}
    public boolean changeCityCounty(int userID,String city){return atc.changeCityCounty(userID,city);}
    public boolean changeStateRegion(int userID,String state){return atc.changeStateRegion(userID,state);}
    public boolean changeCountry(int userID,String country){return atc.changeCountry(userID,country);}
    public boolean changeZipCode(int userID,int zip){return atc.changeZipCode(userID,zip);}
}