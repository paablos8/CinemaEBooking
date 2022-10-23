package Database_Test;
import java.util.Scanner;

/**
 * This is used to test the Database Connection.
 */
public class DatabaseConnectorTestFile
{
    public static String getEmail()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert email address");
        return reader.next();
    }

    public static String getPassword()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert Password");
        return reader.next();
    }

    /**
     * Makes a @Code{DatabaseConnector} object and
     * runs the @Code{connect} function.
     */
    public static void main(String[] args)
    {
        //private DatabaseConnector dbConnector = new DatabaseConnector();
        DatabaseConnector c1 = new DatabaseConnector();

        int result = c1.verifyLogin(getEmail(),getPassword());
        switch(result)
        {
            case(0):System.out.println("Login successful");
            break;
            case(-1):System.out.println("Incorrect password");
            break;
            case(-2):System.out.println("Email not found");
            break;
            default:System.out.println("Something went wrong");
        }

        c1.close();
    }
}
