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
		public final static String ID = "id";
		public final static String NAME = "name";
		public final static String DESCRIPTION = "description";
		public final static String PRODUCTION_MEMBERS = "productionMembers";
		public final static String RATING = "rating";
		public final static String RANKING = "ranking";
	}//End of inner class

	/**
	 * Database column names for information of a user.
	 */
	public class Users
	{
		public final static String ID = "id";
		public final static String USERNAME = "username";
		public final static String PASSWORD = "password";
		public final static String FIRST_NAME = "firstName";
		public final static String LAST_NAME = "lastName";
		public final static String ACCOUNT_LEVEL = "accountLevel";
		public final static String ADDRESS = "address";
		public final static String PHONE_NUMBER = "phoneNumber";
		public final static String EMAIL_ADDRESS = "emailAddress";
		public final static String CREDIT_CARD = "creditCard";
		public final static String EMPLOYEE_ID = "employeeID";
		public final static String COMPANY = "company";
		public final static String POSITION = "position";
	}//End of inner class
	
	/**
	 * Database column names for information of a ticket.
	 */
	public class Tickets
	{
		public final static String ID = "ID";
		public final static String CUSTOMER_ID = "customerID";
		public final static String SHOW_ID = "showID";
		public final static String SHOWING_ID = "showingID";
		public final static String ROW = "row";
		public final static String SEAT = "seat";
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

				show.setID(rsShows.getLong(Shows.ID));
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
		//If ID is 0, then the show is new AND it doesn't exist in the database
		if (show.getID() == 0 && loadShow(show.getID()) == null)
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
		}//End of if
		else
		{
			//UPDATE SHOW
			throw new UnsupportedOperationException("Updating is not yet available.");
		}//End of else
	}//End of writeShow method

	/**
	 * Writes a user database.
	 *
	 * @param show The show to add to the database.
	 *
	 * @since 1.0.0
	 */
	public void writeUser(User user) throws Exception
	{
		if (!usernameExists(user.getUsername()))
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("INSERT INTO users (username, password, accountLevel, firstName, lastName, address, emailAddress, phoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			query.setString(1, user.getUsername());
			query.setBytes(2, user.getPassword());
			query.setInt(3, user.getAccountLevel());
			query.setString(4, user.getFirstName());
			query.setString(5, user.getLastName());
			query.setString(6, user.getAddress().toString());
			query.setString(7, user.getEmailAddress());
			query.setString(8, user.getPhoneNumber().toString());
	
			//Execute the update
			query.executeUpdate();
		}//End of if
		else
		{
			//UPDATE USER
			throw new UnsupportedOperationException("Updating is not yet available.");
		}//End of else	
	}//End of writeShow method
	
	/**
	 * Load a specific show from the database.
	 *
	 * @param ID The ID of the show to load.
	 * @retrun The show object.
	 */
	public Show loadShow(long ID) throws Exception
	{	
		//Load all the shows from the database
		Show [] shows = loadShows();
		
		//Loop through the shows, looking for a match
		for (Show show : shows)
		{
			//See if the show matches the ID
			if (show.getID() == ID)
				return show;
		}//End of for
		
		//If no show was loaded, return null
		return null;
	}//End of loadShow
	
	/**
	 * Load a specific show from the database.
	 *
	 * @param name The name of the show to load.
	 * @retrun The show object.
	 */
	public Show loadShow(String name) throws Exception
	{	
		//Load all the shows from the database
		Show [] shows = loadShows();
		
		//Loop through the shows, looking for a match
		for (Show show : shows)
		{
			//See if the show matches the name
			if (show.getName().equals(name))
				return show;
		}//End of for
		
		//If no show was loaded, return null
		return null;
	}//End of loadShow

	/**
	 * Sees if a username exists in the database.
	 *
	 * @param username The username to check for existance.
	 * @return Wheter a username exists in the database.
	 *
	 * @since 1.0.0
	 */
	public boolean usernameExists(String username) throws Exception
	{
		PreparedStatement query = database.getPreparedStatement("SELECT username FROM users WHERE username=?");
		query.setString(1, username);

		ResultSet results = query.executeQuery();

		if (results.first())
			return true;
		else
			return false;
	}//End of usernameExists method

	/**
	 * Returns a user object with the user.
	 *
	 * @param username The username to get.
	 * @return The user.
	 *
	 * @since 1.0.0
	 */
	public User loadUser(String username) throws Exception
	{
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM users WHERE username=?");
		query.setString(1, username);

		ResultSet results = query.executeQuery();

		//If a result exists, then a user was returned from the database.
		if (results.first())
		{
			User user = new Customer();

			user.setID(results.getLong(Users.ID));
			user.setUsername(results.getString(Users.USERNAME));
			user.setPassword(results.getBytes(Users.PASSWORD));
			user.setFirstName(results.getString(Users.FIRST_NAME));
			user.setLastName(results.getString(Users.LAST_NAME));
			user.setAccountLevel(results.getInt(Users.ACCOUNT_LEVEL));
			user.setAddress(new Address()); // NEED PARSE ADDRESS
			user.setPhoneNumber(new PhoneNumber()); // NEED PARSE PHONE NUMBER
			user.setEmailAddress(results.getString(Users.EMAIL_ADDRESS));

			return user;
		}//End of if
		else
			return null;
	}//End of usernameExists method
	
	/**
	 * Writes a user database.
	 *
	 * @param show The show to add to the database.
	 *
	 * @since 1.0.0
	 */
	public void writeTicket(Ticket ticket) throws Exception
	{
		if (ticket.getID() == 0)
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("INSERT INTO tickets (customerID, showID, showingID, row, seat) VALUES (?, ?, ?, ?, ?)");
			query.setLong(1, ticket.getCustomer().getID());
			query.setLong(2, ticket.getShow().getID());
			query.setLong(3, ticket.getShowing().getID());
			query.setLong(4, ticket.getRow());
			query.setLong(5, ticket.getSeat());
	
			//Execute the update
			query.executeUpdate();
		}//End of if
		else
		{
			//UPDATE USER
			throw new UnsupportedOperationException("Updating is not yet available.");
		}//End of else	
	}//End of writeTicket method
	
	//TEST HARNEST
	public static void main (String [] args) throws Exception
	{
		Database db = new Database();
		
		Theatre theatre = new Theatre(
    		"Sir Wilfrid Laurier Secondary School - Auditorium",
    		new Address(450, "Millbank", "Drive", "London", "Ontario", "Canada", "N6C 4W7"),
    		new PhoneNumber(519, 452, 2840),
    		"laurier@tvdsb.on.ca",
    		"http://www.tvdsb.ca/SirWilfridLaurier.cfm",
    		1,
    		new int[]{1}
    	);
		
		Ticket ticket = new Ticket(
			(Customer) db.loadUser("boxmate.user"),
			db.loadShow("The Boyfriend"),
			new Showing(
				new Date(2012, Date.Month.JUNE, 14),
				new Time(19, 30),
				new Time(19, 00),
				155,
				154,
				theatre,
				new ArrayList<Ticket>()
	    	),
			1,
			1
		);
		
		db.writeTicket(ticket);
	}
}//End of class
