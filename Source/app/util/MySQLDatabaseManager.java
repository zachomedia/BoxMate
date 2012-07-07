package app.util;

import java.sql.*;

/**
 * Manages the connection to a MySQL Database.
 * 
 * @author Zachary Seguin
 * 
 * @since 1.0.0 (29/05/2012)
 * @version 1.0.0
 * 
 */
public class MySQLDatabaseManager
{
    private static MySQLDatabaseManager instance;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL_PREFIX = "jdbc:mysql://";
    private static int MYSQL_DEFAULT_PORT = 3306;
    
    private Connection connection;
    
    /**
     * Private to only allow one instance. Not used by this class.
     */
    private MySQLDatabaseManager()
    {
        // do nothing
    }//End of constructor
    
    /**
     * Connect to a MySQL Database with the provided information.
     * 
     * @param host The host (host name or ip address) of the MySQL Server.
     * @param dbName The database name.
     * @param username The username to connect to the database.
     * @param password The password to connect to the database.
     * @throws DatabaseConnectionException  If the manager is unable to connect the database.
     */
    public void connect(String host, String dbName, String username, String password) throws DatabaseConnectionException
    {
        try
        {
            if (connection != null && !connection.isClosed())
                disconnect();
        }//End of try
        catch (Exception e)
        {
            //do nothing 
        }//End of catch
        
        try
        {
            Class.forName(DRIVER).newInstance();
            
            connection = DriverManager.getConnection(URL_PREFIX + host + ":" + MYSQL_DEFAULT_PORT + "/" + dbName, username, password);
        }//End of try
        catch (Exception e)
        {
            e.printStackTrace();
            throw new DatabaseConnectionException("Unable to connect to database.");
        }//End of catch
    }//End of connect method
    
    /**
     * Disconnect from the database.
     * 
     * @throws DatabaseConnectionException 
     */
    public void disconnect() throws DatabaseConnectionException
    {
        try
        {
            connection.close();
        }//End of try
        catch (Exception e)
        {
            throw new DatabaseConnectionException("Unable to close connection to the database.");
        }//End of catch
    }//End of diconnect method
    
    /**
     * Query the database.
	 *
	 * FOR SECURITY PURPOSES, IT IS PREFERRED THAT YOU USE THE PREPARED STATEMENT.
     * 
     * @param query The query to execute.
     * @return The result set the query returned.
     *
     * @throws MalformedQueryException A malformed query has been provided.
     * @throws Exception  Any other exception thrown by the database.
     */
    public ResultSet query(String query) throws MalformedQueryException, Exception
    {
        try
        {
            return query(connection.prepareStatement(query));
        }//End of try
        catch (Exception e)
        {
            throw e;
        }//End of catch
    }//End of query method
	
	/**
     * Query the database.
     * 
     * @param ps The prepared statement to execute.
     * @return The result set the query returned.
     *
     * @throws MalformedQueryException A malformed query has been provided.
     * @throws Exception  Any other exception thrown by the database.
     */
    public ResultSet query(PreparedStatement ps) throws MalformedQueryException, Exception
    {
        try
        {
            return ps.executeQuery();
        }//End of try
        catch (Exception e)
        {
            throw e;
        }//End of catch
    }//End of query method
    
    /**
     * Query the database, which a query that will manipulate data.
     * Examples include: INSERT, DELETE, MODIFY
	 *
	 * IF YOU ARE MANIPULATING DATA, IT IS RECOMMENDED YOU USE A PREPARED STATEMENT.
     * 
     * @param query The query to execute.
     * 
     * @throws MalformedQueryException A malformed query has been provided.
     * @throws Exception  Any other exception thrown by the database.
     */
    public void manipulationQuery(String query) throws MalformedQueryException, Exception
    {
        try
        {
            manipulationQuery(connection.prepareStatement(query));
        }//End of try
        catch (Exception e)
        {
            throw e;
        }//End of catch
    }//End of manipulationQuery method
    
    /**
     * Query the database, which a query that will manipulate data.
     * Examples include: INSERT, DELETE, MODIFY
     * 
     * @param query The query to execute.
     * 
     * @throws MalformedQueryException A malformed query has been provided.
     * @throws Exception  Any other exception thrown by the database.
     */
    public void manipulationQuery(PreparedStatement ps) throws MalformedQueryException, Exception
    {
        try
        {
            ps.executeUpdate();
        }//End of try
        catch (Exception e)
        {
            throw e;
        }//End of catch
    }//End of manipulationQuery method
    
    /**
     * Get a prepared statement for the provided query.
     * 
     * @param query The query to prepare.
     * 
     * @return The PreparedStatement object.
     */
    public PreparedStatement getPreparedStatement(String query)
    {
        try
        {
            return connection.prepareStatement(query);
        }//End of try
        catch (Exception e)
        {
            return null;
        }//End of catch
    }//End of getPreparedStatement method
    
    /**
     * Get the connection.
     *
     * @return The connection.
     * 
     * @throws MalformedQueryException A malformed query has been provided.
     * @throws Exception  Any other exception thrown by the database.
     */
    public Connection getConnection()
    {
        return connection;
    }//End of getConnection method
    
    /**
     * Get's the instance of the MySQLDatabaseManager.
     */
    public static synchronized MySQLDatabaseManager getInstance()
    {
        if (instance == null)
            instance = new MySQLDatabaseManager();
        
        return instance;
    }//End of getInstance method
    
    /**
     * Disallows cloning of the MySQLDatabaseManager object.
     * 
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }//End of clone method
}// end of class