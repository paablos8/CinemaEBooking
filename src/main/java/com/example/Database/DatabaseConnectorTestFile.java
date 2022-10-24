package Database;

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
        //private DatabaseConnector dbConnector = new DatabaseConnector();
        DatabaseConnector c1 = new DatabaseConnector();

        System.out.println(c1.getUserFirstName(3));
        c1.changeFirstName(1,"Tori");

        c1.close();
    }
}
