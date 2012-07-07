package app.util;

/**
 * Exception thrown when the query is malformed.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (29/05/2012)
 * @since 1.0.0
 */
public class MalformedQueryException extends Exception
{
    public MalformedQueryException()
    {
        super();
    }//End of constructor

    public MalformedQueryException(String msg)
    {
        super(msg);
    }//End of constructor
}// end of class