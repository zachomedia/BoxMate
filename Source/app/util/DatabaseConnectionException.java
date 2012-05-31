package app.util;

/**
 * Exception thrown when unable to connect to the database.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (29/05/2012)
 * @since 1.0.0
 */
public class DatabaseConnectionException extends Exception
{
    public DatabaseConnectionException()
    {
        super();
    }//End of constructor
    
    public DatabaseConnectionException(String message)
    {
        super(message);
    }//End of constructor
}//End of class