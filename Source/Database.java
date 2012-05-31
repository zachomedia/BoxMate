package app.boxmate;

import app.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * A helper class to easily get data for BoxMate from the database.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (29/05/2012)
 * @since 1.0.0
 */
public class Database
{
	/**
	 * Database column names for information of a show.
	 */
	public class Shows
	{
		public final static String NAME = "name";
		public final static String DESCRIPTION = "description";
		public final static String PRODUCTION_MEMBERS = "productionMembers";
		public final static String RATING = "rating";
		public final static String RANKING = "ranking";
	}//End of inner class

	/**
	 * Database column names for information of a user
	 */
	public class Users
	{
		public final static String USERNAME = "username";
		public final static String PASSWORD = "password";
		public final static String FIRST_NAME = "firstName";
		public final static String LAST_NAME = "lastName";
		public final static String ACCOUNT_LEVEL = "accountLevel";
		public final static String ADDRESS = "address";
		public final static String PHONE_NUMBER = "phoneNumber";
		public final static String CREDIT_CARD = "creditCard";
		public final static String EMPLOYEE_ID = "employeeID";
		public final static String COMPANY = "company";
		public final static String POSITION = "position";
	}//End of inner class
	
	/**
	 * Stores the MySQLDatabaseManager.
	 */
	private MySQLDatabaseManager database;

	/**
	 * Connects to the database using the default information.
	 * Host: localhost, Database Name: BoxMate, Username: root, Password: (none)
	 */
	public Database() throws Exception
	{
		if (database == null)
			database = MySQLDatabaseManager.getInstance();

		database.connect("localhost", "BoxMate", "root", "");
	}//End of constructor method

	/**
	 * Connects to the database using the provided connection information.
	 *
	 * @param host The host of the computer (either name or IP address)
	 * @param database The database to connect to
	 * @param username The username of the database user.
	 * @param password The password of the database user.
	 */
	public Database(String host, String databaseName, String username, String password) throws 
	Exception
	{
		if (database == null)
			database = MySQLDatabaseManager.getInstance();

		database.connect(host, databaseName, username, password);
	}//End of constructor method

	/**
	 * Get all the shows from the database.
	 *
	 * @return All the shows in the database.
	 *
	 * @since 1.0.0
	 */
	public Show [] loadShows() throws Exception
	{
		//Declare and initaliaze variables
		int numberOfShows = 0;
		Show [] shows;
		Show show;
		
		//Query the database to get all the shows
		ResultSet rsShows = database.query("SELECT * FROM shows");
		
		//Get the number of shows, if there are shows
		if (rsShows.last())
		{
			numberOfShows = rsShows.getRow();
			
			//Create the array
			shows = new Show[numberOfShows];
			
			//Iterate through all the shows, and create a Show object
			rsShows.beforeFirst();
			
			while (rsShows.next())
			{
				ArrayList<String> productionMembers = new ArrayList<String>();
				
				show = new Show();
				
				show.setName(rsShows.getString(Shows.NAME));
				show.setDescription(rsShows.getString(Shows.DESCRIPTION));
				
				productionMembers.add(rsShows.getString(Shows.PRODUCTION_MEMBERS));
				show.setProductionMembers(productionMembers);
				//show.setRating(rsShows.getString(Shows.RATING)); TODO: GET SEARCH
				show.setRating(Rating.PG);
				show.setRanking(rsShows.getDouble(Shows.RANKING));
				
				shows[rsShows.getRow() - 1] = show;
			}//End of while
		}//End of if
		else
			return new Show[0];
			
		return shows;
	}//End of loadShows method
	
	/**
	 * Writes the show to the database.
	 * 
	 * @param show The show to add to the database.
	 *
	 * @since 1.0.0
	 */
	public void writeShow(Show show) throws Exception
	{
		//Prepare the query
		PreparedStatement query = database.getPreparedStatement("INSERT INTO shows (name, description, productionMembers, rating, ranking) VALUES (?, ?, ?, ?, ?)");
		query.setString(1, show.getName());
		query.setString(2, show.getDescription());
		query.setString(3, show.getProductionMembers().toString());
		query.setString(4, show.getRating().toString());
		query.setDouble(5, show.getRanking());
		 
		//Execute the update
		query.executeUpdate();
	}//End of writeShow method
	
	public static void main (String [] args) throws Exception
	{
		Database db = new Database();
		
		Show [] shows = db.loadShows();
		
		/*System.out.println("*************************************");
		System.out.println("*     SHOWS CURRENTLY IN THEATRE    *");
		System.out.println("*************************************");
		
		for (Show show : shows)
			System.out.println(" " + show.getName());*/
	
		Show newShow = new Show("High School Musical", "Insert some really cool awesome description here.", new ArrayList<String>(), new ArrayList<Showing>(), Rating.PG, 8.0);
		//db.writeShow(newShow);
	
		shows = db.loadShows();
		
		System.out.println("*************************************");
		System.out.println("*     SHOWS CURRENTLY IN THEATRE    *");
		System.out.println("*************************************");
		
		for (Show show : shows)
		{
			System.out.println(" " + show.getName());
			System.out.println("       " + show.getDescription());
		}//End of for
	}//End of class
}//End of class
