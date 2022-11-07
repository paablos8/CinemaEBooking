package com.example.Database;

import java.sql.*;

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
    private MovieTableConnector mtc = null;

    /**
     * Creates DatabaseConnector object and connects to server.
     */
    public DatabaseConnector()
    {
        String serverName = "8.tcp.ngrok.io:18810";
        String loginCredentials = ";user=sa;password=Team_C2;";
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
            mtc = new MovieTableConnector(conn);
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
    public boolean createNewUser(String fName, String lName, long pNum,
                                 String email, boolean promoOp, boolean isAdmin,
                                 String password)
    {return utc.createNewUser(fName,lName,pNum,email,promoOp,isAdmin,password);}
    public int verifyLogin(String email, String password){return utc.verifyLogin(email,password);}
    public String getUserFirstName(int userID){return utc.getUserFirstName(userID);}
    public String getUserLastName(int userID){return utc.getUserLastName(userID);}
    public long getUserPhoneNumber(int userID){return  utc.getUserPhoneNumber(userID);}
    public boolean getUserType(int userID){return utc.getUserType(userID);}
    public boolean getPromoOp(int userID){return utc.getPromoOp(userID);}
    public Status getUserStatus(int userID){return utc.getUserStatus(userID);}
    public String getUserEmail(int userID){return utc.getUserEmail(userID);}
    public String getUserPassword(int userID){return utc.getUserPassword(userID);}
    public User createUserObject(int userID){return utc.createUserObject(userID);}
    public boolean resetPassword(String email,String password){return utc.resetPassword(email,password);}
    public boolean changeFirstName(int userID,String fName){return utc.changeFirstName(userID,fName);}
    public boolean changeLastName(int userID,String lName){return utc.changeLastName(userID,lName);}
    public boolean changePhoneNumber(int userID,Long pNum){return utc.changePhoneNumber(userID,pNum);}
    public boolean changePromotionOpinion(int userID,Boolean promoOp){return utc.changePromoOpinion(userID,promoOp);}
    public boolean changePassword(int userID,String password){return utc.changePassword(userID,password);}
    public boolean changeStatus(int userID, Status status){return utc.changeStatus(userID,status);}

    //Card Methods
    public boolean createNewCard(String date, int cvv, long cardNum, String nameOnCard, int userID,
                                 String streetAddress, String cityCounty, String stateRegion, String country, int zip)
    {return ctc.createNewCard(date,cvv,cardNum,nameOnCard,userID,streetAddress,cityCounty,stateRegion,country,zip);}
    public boolean deleteCard(long cardNum){return ctc.deleteCard(cardNum);}
    public long[] getCardNumbers(int userID){return ctc.getCardNumbers(userID);}
    public String[] getCardExpDates(int userID){return  ctc.getCardExpDates(userID);}
    public String[] getCardNames(int userID){return  ctc.getCardNames(userID);}
    public int[] getCardZips(int userID){return  ctc.getCardZips(userID);}
    public boolean changeCardNumber(long oldCardNum, long newCardNum)
    {return ctc.changeCardNumber(oldCardNum,newCardNum);}
    public boolean changeCardExpDate(long cardNum, String newDate){return ctc.changeCardExpDate(cardNum,newDate);}
    public boolean changeCardName(long cardNum, String name){return ctc.changeCardName(cardNum,name);}
    public boolean changeCardCVV(long cardNum, int zip){return ctc.changeCardCVV(cardNum,zip);}
    public boolean changeStreetAddress(long cardNum, String streetAddress)
    {return ctc.changeCardStreetAddress(cardNum,streetAddress);}
    public boolean changeCityCounty(long cardNum, String cityCounty)
    {return ctc.changeCardCityCounty(cardNum,cityCounty);}
    public boolean changeStateRegion(long cardNum, String stateRegion)
    {return ctc.changeCardStateRegion(cardNum,stateRegion);}
    public boolean changeCountry(long cardNum, String country)
    {return ctc.changeCardCountry(cardNum,country);}
    public boolean changeZipCode(long cardNum, int zipCode)
    {return ctc.changeCardZipCode(cardNum,zipCode);}

    //Address Methods
    public int createNewAddress(int userID,String stAdd,String city,String state,String country,int zip)
    {return atc.createNewAddress(userID,stAdd,city,state,zip);}
    public String getStreetAddress(int userID){return atc.getStreetAddress(userID);}
    public String getCityCounty(int userID){return atc.getCityCounty(userID);}
    public String getStateRegion(int userID){return atc.getStateRegion(userID);}
    public String getCountry(int userID){return atc.getCountry(userID);}
    public int getZipCode(int userID){return atc.getZipCode(userID);}
    public boolean changeStreetAddress(int userID,String stAdd){return atc.changeUserStreetAddress(userID,stAdd);}
    public boolean changeCityCounty(int userID,String city){return atc.changeUserCityCounty(userID,city);}
    public boolean changeStateRegion(int userID,String state){return atc.changeUserStateRegion(userID,state);}
    public boolean changeCountry(int userID,String country){return atc.changeUserCountry(userID,country);}
    public boolean changeZipCode(int userID,int zip){return atc.changeUserZipCode(userID,zip);}

    //Movie Methods
    public boolean createNewMovie(String title,String ageRating,int yearRelease,String producer,String director,
                                  String cast,int IMDBRating,int RTRating,String trailerURL,String posterURL,
                                  String category, String synopsis,int durationMin)
    {
        return mtc.createNewMovie(title,ageRating,yearRelease,producer,director,cast,IMDBRating,RTRating,trailerURL
        ,posterURL,category,synopsis,durationMin);
    }
    String [] getTitlesInCategory(String category){return mtc.getTitlesInCategory(category);}
    String [] getAllTitles(){return mtc.getAllTitles();}
    String getAgeRating(String title){return mtc.getAgeRating(title);}
    int getYearRelease(String title){return mtc.getYearRelease(title);}
    String getProducer(String title){return mtc.getProducer(title);}
    String getCast(String title){return mtc.getCast(title);}
    String getDirector(String title){return mtc.getDirector(title);}
    int getIMDBRating(String title){return mtc.getIMDBRating(title);}
    int getRTRating(String title){return mtc.getRTRating(title);}
    String getTrailerURL(String title){return mtc.getTrailerURL(title);}
    String getPosterURL(String title){return mtc.getPosterURL(title);}
    String getCategory(String title){return mtc.getCategory(title);}
    String getSynopsis(String title){return mtc.getSynopsis(title);}
    int getDuration(String title){return mtc.getDuration(title);}
    boolean changeAgeRating(String title,String ageRate){return mtc.changeAgeRating(title,ageRate);}
    boolean changeYearRelease(String title,int yearRelease){return mtc.changeYearRelease(title,yearRelease);}
    boolean changeProducer(String title,String producer){return mtc.changeProducer(title,producer);}
    boolean changeCast(String title,String cast){return mtc.changeCast(title,cast);}
    boolean changeDirector(String title,String director){return mtc.changeDirector(title,director);}
    boolean changeIMDBRating(String title,int IMDBRating){return mtc.changeIMDBRating(title,IMDBRating);}
    boolean changeRTRating(String title,int RTRating){return mtc.changeRTRating(title,RTRating);}
    boolean changeTrailerURL(String title,String trailerURL){return mtc.changeTrailerURL(title,trailerURL);}
    boolean changePosterURL(String title,String posterURL){return mtc.changePosterURL(title,posterURL);}
    boolean changeCategory(String title,String category){return mtc.changeCategory(title,category);}
    boolean changeSynopsis(String title,String synopsis){return mtc.changeSynopsis(title,synopsis);}
    boolean changeDuration(String title,int duration){return mtc.changeDuration(title,duration);}
}