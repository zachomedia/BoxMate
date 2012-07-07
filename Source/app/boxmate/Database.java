<<<<<<< HEAD
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
=======
package app.boxmate;

import app.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * A helper class to easily get data for BoxMate from the database.
 *
 * CHANGES:
 *		June 19, 2012 (Jonathan):
 *			- Implemented parseAddress, parseDate and parseTime methods.
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
	 * Database column names for information of a showing.
	 */
	public class Showings
	{
		public final static String ID = "id";
		public final static String DATE = "date";
		public final static String TIME = "time";
		public final static String DOORS_OPEN = "doorsOpen";
		public final static String THEATRE_ID = "theatreID";
		public final static String SHOW_ID = "showID";
	}//End of inner class

	/**
	 * Database column names for information of a theatre.
	 */
	public class Theatres
	{
		public final static String ID = "ID";
		public final static String NAME = "name";
		public final static String ADDRESS = "address";
		public final static String PHONE_NUMBER = "phoneNumber";
		public final static String EMAIL = "email";
		public final static String WEBSITE = "website";
		public final static String ROWS = "rows";
		public final static String SEATS_PER_ROW = "seatsPerRow";
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

		database.connect("localhost", "BoxMate", "root", "root");
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

				//Load the showings for the show
				ArrayList<Showing> showings = new ArrayList<Showing>();

				for (Showing showing : loadShowings(show.getID()))
					showings.add(showing);

				show.setShowings(showings);

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
	public Show writeShow(Show show) throws Exception
	{
		//If ID is 0, then the show is new AND it doesn't exist in the database
		if (show.getID() == 0 && loadShow(show.getID()) == null)
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("INSERT INTO shows (" + Shows.NAME + ", " + Shows.DESCRIPTION + ", " + Shows.PRODUCTION_MEMBERS + ", " + Shows.RATING + ", " + Shows.RANKING + ") VALUES (?, ?, ?, ?, ?)");
			query.setString(1, show.getName());
			query.setString(2, show.getDescription());
			query.setString(3, show.getProductionMembers().toString());
			query.setString(4, show.getRating().toString());
			query.setDouble(5, show.getRanking());

			//Execute the update
			query.executeUpdate();

			//Return the show written to the database because it now contains the ID
			return loadShow(show.getName());
		}//End of if
		else
		{
			//UPDATE SHOW
			return loadShow(show.getName());
		}//End of else
	}//End of writeShow method

	/**
	 * Writes a user database.
	 *
	 * @param user The user to add to the database.
	 *
	 * @since 1.0.0
	 */
	public User writeUser(User user) throws Exception
	{
		if (!usernameExists(user.getUsername()))
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("INSERT INTO users (" + Users.USERNAME + ", " + Users.PASSWORD + ", " + Users.ACCOUNT_LEVEL + ", " + Users.FIRST_NAME + ", " + Users.LAST_NAME + ", " + Users.ADDRESS + ", " + Users.EMAIL_ADDRESS + ", " + Users.PHONE_NUMBER + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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

			//Return the user that was written to the database (includes the User ID)
			return loadUser(user.getUsername());
		}//End of if
		else
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("UPDATE users SET " + Users.USERNAME + "=?, " + Users.PASSWORD + "=?, " + Users.ACCOUNT_LEVEL + "=?, " + Users.FIRST_NAME + "=?, " + Users.LAST_NAME + "=?, " + Users.ADDRESS + "=?, " + Users.EMAIL_ADDRESS + "=?," + Users.PHONE_NUMBER + "=? WHERE " + Users.ID + "=?");
			query.setString(1, user.getUsername());
			query.setBytes(2, user.getPassword());
			query.setInt(3, user.getAccountLevel());
			query.setString(4, user.getFirstName());
			query.setString(5, user.getLastName());
			query.setString(6, user.getAddress().toString());
			query.setString(7, user.getEmailAddress());
			query.setString(8, user.getPhoneNumber().toString());
			query.setLong(9, user.getID());

			//Execute the update
			query.executeUpdate();

			//Return the user that was written to the database (includes the User ID)
			return loadUser(user.getUsername());
		}//End of else
	}//End of writeUser method

	/**
	 * Deletes a user from database.
	 *
	 * @param user The user to delete from the database.
	 *
	 * @since 1.0.0
	 */
	public void deleteUser(User user) throws Exception
	{
		if (usernameExists(user.getUsername()))
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("DELETE FROM users WHERE " + Users.USERNAME + "=?");
			query.setString(1, user.getUsername());

			//Execute the update
			query.executeUpdate();
		}//End of if
	}//End of writeUser method

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
		PreparedStatement query = database.getPreparedStatement("SELECT " + Users.USERNAME + " FROM users WHERE " + Users.USERNAME + "=?");
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
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM users WHERE " + Users.USERNAME + "=?");
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
			user.setAddress(Address.parseAddress(results.getString(Users.ADDRESS)));
			user.setPhoneNumber(PhoneNumber.parsePhoneNumber(results.getString(Users.PHONE_NUMBER)));
			user.setEmailAddress(results.getString(Users.EMAIL_ADDRESS));

			return user;
		}//End of if
		else
			return null;
	}//End of usernameExists method

	/**
	 * Returns a user object with the user.
	 *
	 * @param username The username to get.
	 * @return The user.
	 *
	 * @since 1.0.0
	 */
	public User loadUser(long userID) throws Exception
	{
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM users WHERE " + Users.ID + "=?");
		query.setLong(1, userID);

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
			user.setAddress(Address.parseAddress(results.getString(Users.ADDRESS)));
			user.setPhoneNumber(PhoneNumber.parsePhoneNumber(results.getString(Users.PHONE_NUMBER)));
			user.setEmailAddress(results.getString(Users.EMAIL_ADDRESS));

			return user;
		}//End of if
		else
			return null;
	}//End of loadUser method

	/**
	 * Writes a user database.
	 *
	 * @param show The show to add to the database.
	 *
	 * @return The ticket that was written to the database (with the ID).
	 *
	 * @since 1.0.0
	 */
	public Ticket writeTicket(Ticket ticket) throws Exception
	{
		if (ticket.getID() == 0)
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("INSERT INTO tickets (" + Tickets.CUSTOMER_ID + ", " + Tickets.SHOW_ID + ", " + Tickets.SHOWING_ID + ", " + Tickets.ROW + ", " + Tickets.SEAT + ") VALUES (?, ?, ?, ?, ?)");
			query.setLong(1, ticket.getCustomer().getID());
			query.setLong(2, ticket.getShow().getID());
			query.setLong(3, ticket.getShowing().getID());
			query.setInt(4, ticket.getRow());
			query.setInt(5, ticket.getSeat());

			//Execute the update
			query.executeUpdate();

			//Return the last ticket written (the one just created)
			Ticket [] tickets = loadTickets();
			return tickets[tickets.length - 1];
		}//End of if
		else
		{
			//Prepare the query
			PreparedStatement query = database.getPreparedStatement("UPDATE tickets SET " + Tickets.CUSTOMER_ID + "=?, " + Tickets.SHOW_ID + "=?, " + Tickets.SHOWING_ID + "=?, " + Tickets.ROW + "=?, " +Tickets.SEAT + "=? WHERE " + Tickets.ID + "=?");
			query.setLong(1, ticket.getCustomer().getID());
			query.setLong(2, ticket.getShow().getID());
			query.setLong(3, ticket.getShowing().getID());
			query.setInt(4, ticket.getRow());
			query.setInt(5, ticket.getSeat());
			query.setLong(6, ticket.getID());

			//Execute the update
			query.executeUpdate();

			//Return the ticket that was written to the database (includes the ID)
			return loadTicket(ticket.getID());
		}//End of else
	}//End of writeTicket method

	/**
	 * Load all the tickets from the database.
	 *
	 * @return The tickets from the database.
	 * @since 1.0.0
	 */
	public Ticket [] loadTickets() throws Exception
	{
		//Declare and initialize variables
		int numRows = 0;
		int index = 0;
		Ticket [] tickets;

		//Query the database for the tickets
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM tickets");
		ResultSet results = query.executeQuery();

		if (results.last())
		{
			//Get the number of results
			numRows = results.getRow();

			//Initialize the tickets array
			tickets = new Ticket[numRows];

			results.beforeFirst();

			//Iterate through the results, creating a ticket for each row
			while (results.next())
			{
				//Create a new ticket
				Ticket ticket = new Ticket();

				//Load the additional information required information from the database
				Customer customer = (Customer) loadUser(results.getLong(Tickets.CUSTOMER_ID));
				Show show = loadShow(results.getLong(Tickets.SHOW_ID));
				Showing showing = loadShowing(results.getLong(Tickets.SHOWING_ID));

				if (customer == null || show == null || showing == null)
					continue;

				//Set the instance variables of the ticket
				ticket.setID(results.getLong(Tickets.ID));
				ticket.setCustomer(customer);
				ticket.setShow(show);
				ticket.setShowing(showing);
				ticket.setRow(results.getInt(Tickets.ROW));
				ticket.setSeat(results.getInt(Tickets.SEAT));

				//Set the ticket in the array
				tickets[index] = ticket;

				//Increment index
				index++;
			}//End of while

			Ticket [] returnTickets = new Ticket[index];

			for (int x = 0; x < returnTickets.length; x++)
				returnTickets[x] = tickets[x];

			return returnTickets;
		}//End of if
		else
			return new Ticket[0];
	}//End of loadTickets method

	/**
	 * Deletes a ticket from the database.
	 *
	 * @param Ticket The ticket to delete.
	 */
	public void deleteTicket(Ticket ticket) throws Exception
	{
		PreparedStatement query = database.getPreparedStatement("DELETE FROM tickets WHERE id=?");
		query.setLong(1, ticket.getID());

		query.executeUpdate();
	}//End of deleteTicket method

	/**
	 * Loads a specific ticket from the database.
	 *
	 * @param ID The ID for the ticket to load from the database.
	 * @return The ticket loaded from the database.
	 * @since 1.0.0
	 */
	public Ticket loadTicket(long ID) throws Exception
	{
		//Get all the tickets from the database
		Ticket [] tickets = loadTickets();

		//Search for the ticket
		for (Ticket ticket : tickets)
		{
			if (ticket.getID() == ID)
				return ticket;
		}//End of for

		//Return null if nothing was found
		return null;
	}//End of loadTicket method

	/**
	 * Writes a showing to the database.
	 *
	 * @param Showing The showing to write to the database.
	 *
	 * @return The showing that was written to the database, because it now contains the ID.
	 */
	public Showing writeShowing(Showing showing) throws Exception
	{
		if (showing.getID() == 0 && loadShowing(showing.getID()) == null)
		{
			PreparedStatement query = database.getPreparedStatement("INSERT INTO showings (" + Showings.DATE + ", " + Showings.TIME + ", " + Showings.DOORS_OPEN + ", " + Showings.THEATRE_ID + ") VALUES(?, ?, ?, ?)");
			query.setString(1, showing.getDate().toString());
			query.setString(2, showing.getTime().toString());
			query.setString(3, showing.getDoorsOpen().toString());
			query.setLong(4, showing.getTheatre().getID());

			query.executeUpdate();

			//Return the newly created showing with the ID set
			return loadShowing(showing.getID());
		}//End of if
		else
		{
			//UPDATE SHOWING
			return loadShowing(showing.getID());
		}//End of else
	}//End of writeShowing method

	/**
	 * Load all showings from the database.
	 *
	 * @return All the showings from the database.
	 */
	public Showing [] loadShowings() throws Exception
	{
		//Declare and initialize variables
		Showing [] showings;
		int numRows = 0;
		int index = 0;

		//Get the prepared statement for the query.
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM showings");

		//Execute and gather the results from the database.
		ResultSet results = query.executeQuery();

		if (results.last())
		{
			//Get the number of results
			numRows = results.getRow();

			//Initialize the array
			showings = new Showing[numRows];

			results.beforeFirst();

			//Loop trough each result
			while (results.next())
			{
				//Declare and initializ a new showing
				Showing showing = new Showing();

				//Gather the required additional information
				Theatre theatre = loadTheatre(results.getLong(Showings.THEATRE_ID));

				//Set the instance variables
				showing.setID(results.getLong(Showings.ID));
				showing.setDate(Date.parseDate(results.getString(Showings.DATE)));
				showing.setTime(Time.parseTime(results.getString(Showings.TIME)));
				showing.setDoorsOpen(Time.parseTime(results.getString(Showings.DOORS_OPEN)));
				showing.setTheatre(theatre);

				//Add it to the array
				showings[index] = showing;

				index++;
			}//End of while

			return showings;
		}//End of if
		else
			return new Showing[0];
	}//End of loadShowings method

	/**
	 * Loads all the showings for a given show ID.
	 *
	 * @param showID The show ID of showings to return
	 *
	 * @return The showings related to that show ID.
	 */
	public Showing [] loadShowings(long showID) throws Exception
	{
		//Declare and initialize variables
		ArrayList<Showing> matchedShowings = new ArrayList<Showing>();

		//Get the prepared statement for the query.
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM showings");

		//Execute and gather the results from the database.
		ResultSet results = query.executeQuery();

		if (results.first())
		{
			results.beforeFirst();

			//Loop trough each result
			while (results.next())
			{
				//Declare and initializ a new showing
				Showing showing = new Showing();

				//Gather the required additional information
				Theatre theatre = loadTheatre(results.getLong(Showings.THEATRE_ID));

				//Set the instance variables
				showing.setID(results.getLong(Showings.ID));
				showing.setDate(Date.parseDate(results.getString(Showings.DATE)));
				showing.setTime(Time.parseTime(results.getString(Showings.TIME)));
				showing.setDoorsOpen(Time.parseTime(results.getString(Showings.DOORS_OPEN)));
				showing.setTheatre(theatre);

				//Add it to the array
				if (results.getLong(Showings.SHOW_ID) == showID)
					matchedShowings.add(showing);
			}//End of while
		}//End of if

		return matchedShowings.toArray(new Showing[matchedShowings.size()]);
	}//End of loadShowings method

	/**
	 * Loads a specific showing from the database.
	 *
	 * @param ID The ID of the showing to load.
	 *
	 * @return The showing from the database.
	 */
	public Showing loadShowing(long ID) throws Exception
	{
		//Load all the showings
		Showing [] showings = loadShowings();

		for (Showing showing : showings)
		{
			if (showing.getID() == ID)
				return showing;
		}//End of for

		//Loop through the results
		return null;
	}//End of loadShowing method

	/**
	 * Writes a theatre to the database.
	 *
	 * @param theatre The theatre to write to the database.
	 * @return The theatre object written to the database - now containin an ID.
	 */
	public Theatre writeTheatre(Theatre theatre) throws Exception
	{
		if (theatre.getID() == 0)
		{
			PreparedStatement query = database.getPreparedStatement("INSERT INTO theatres (" + Theatres.NAME + ", " + Theatres.ADDRESS + ", " + Theatres.PHONE_NUMBER + ", " + Theatres.EMAIL + ", " + Theatres.WEBSITE + ", " + Theatres.ROWS + ", " + Theatres.SEATS_PER_ROW + ") VALUES(?, ?, ?, ?, ?, ?, ?)");
			query.setString(1, theatre.getName());
			query.setString(2, theatre.getAddress().toString());
			query.setString(3, theatre.getPhoneNumber().toString());
			query.setString(4, theatre.getEmailAddress());
			query.setString(5, theatre.getWebsite());
			query.setInt(6, theatre.getRows());

			String seatsPerRow = "";

			for (int seats : theatre.getSeatsPerRow())
			{
				if (seatsPerRow.length() > 0)
					seatsPerRow += ", " + seats;
				else
					seatsPerRow += String.valueOf(seats);
			}//End of for

			query.setString(7, seatsPerRow);

			query.executeUpdate();

			//Return the newly created theatre with the ID set
			return loadTheatre(theatre.getName());
		}//End of if
		else
		{
			//UPDATE SHOWING
			return theatre;
		}//End of else
	}//End of writeTheatre method

	/**
	 * Load all theatres from the database.
	 *
	 * @return All the theatres from the database.
	 */
	public Theatre [] loadTheatres() throws Exception
	{
		//Declare and initialize variables
		Theatre [] theatres;
		int numRows = 0;
		int index = 0;

		//Get the prepared statement for the query.
		PreparedStatement query = database.getPreparedStatement("SELECT * FROM theatres");

		//Execute and gather the results from the database.
		ResultSet results = query.executeQuery();

		if (results.last())
		{
			//Get the number of results
			numRows = results.getRow();

			//Initialize the array
			theatres = new Theatre[numRows];

			results.beforeFirst();

			//Loop trough each result
			while (results.next())
			{
				//Declare and initializ a new theatre
				Theatre theatre = new Theatre();

				//Set the instance variables
				theatre.setID(results.getLong(Theatres.ID));
				theatre.setName(results.getString(Theatres.NAME));
				theatre.setAddress(Address.parseAddress(results.getString(Theatres.ADDRESS)));
				theatre.setPhoneNumber(PhoneNumber.parsePhoneNumber(results.getString(Theatres.PHONE_NUMBER)));
				theatre.setEmailAddress(results.getString(Theatres.EMAIL));
				theatre.setWebsite(results.getString(Theatres.WEBSITE));
				theatre.setRows(results.getInt(Theatres.ROWS));

				String [] seatsPerRow = results.getString(Theatres.SEATS_PER_ROW).split(", ");
				int [] seats = new int[seatsPerRow.length];

				for (int x = 0; x < seats.length; x++)
					seats[x] = Integer.parseInt(seatsPerRow[x]);

				theatre.setSeatsPerRow(seats);

				//Add it to the array
				theatres[index] = theatre;

				index++;
			}//End of while

			return theatres;
		}//End of if
		else
			return new Theatre[0];
	}//End of loadTheatres method

	/**
	 * Loads a specific theatre from the database.
	 *
	 * @param name The name of the theatre to load.
	 *
	 * @return The theatre from the database.
	 */
	public Theatre loadTheatre(String name) throws Exception
	{
		//Load all the theatres
		Theatre [] theatres = loadTheatres();

		for (Theatre theatre : theatres)
		{
			if (theatre.getName().equals(name))
				return theatre;
		}//End of for

		//Loop through the results
		return null;
	}//End of loadTheatre method

	/**
	 * Loads a specific theatre from the database.
	 *
	 * @param ID The ID of the theatre to load.
	 *
	 * @return The theatre from the database.
	 */
	public Theatre loadTheatre(long ID) throws Exception
	{
		//Load all the theatres
		Theatre [] theatres = loadTheatres();

		for (Theatre theatre : theatres)
		{
			if (theatre.getID() == ID)
				return theatre;
		}//End of for

		//Loop through the results
		return null;
	}//End of loadTheatre method

	public static void main (String [] args) throws Exception
	{
		Database db = new Database();

		Theatre theatre = db.loadTheatre(6);

		System.out.println(theatre.getRows());

		for (int seats : theatre.getSeatsPerRow())
			System.out.print(seats + " " );
	}
}//End of class
>>>>>>> More updates. Also, the database class has been updated with credentials for Mamp on Mac OS X Lion.
