package app.boxmate;

/**
 * Abstract user type.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public abstract class User
 {
 	/**
	 * The user's ID.
	 *
	 * @since 1.0.0
	 */
	protected long ID;
 	
	/**
	 * The user's username.
	 *
	 * @since 1.0.0
	 */
	protected String username;

	/**
	 * The user's password.
	 *
	 * @since 1.0.0
	 */
	protected byte [] password;

	/**
	 * The user's accountLevel.
	 *
	 * @since 1.0.0
	 */
	protected int accountLevel;

	/**
	 * The user's first name.
	 *
	 * @since 1.0.0
	 */
	protected String firstName;

	/**
	 * The user's last name.
	 *
	 * @since 1.0.0
	 */
	protected String lastName;

	/**
	 * The user's address.
	 *
	 * @since 1.0.0
	 */
	protected Address address;

	/**
	 * The user's e-mail address.
	 *
	 * @since 1.0.0
	 */
	protected String emailAddress;

	/**
	 * The user's phone number.
	 *
	 * @since 1.0.0
	 */
	protected PhoneNumber phoneNumber;

	/**
	 * Default constructor for a User object.
	 *
	 * @since 1.0.0
	 */
	public User()
	{
		//Intialize all the instance variables.
		this.ID = 0;
		this.username = "";
		this.password = new byte[0];
		this.accountLevel = 0;
		this.firstName = "";
		this.lastName = "";
		this.address = new Address();
		this.emailAddress = "";
		this.phoneNumber = new PhoneNumber();
	}//End of constructor method

	/**
	 * Constructs a user object with all the provided information.
	 *
	 * @param username The user's username.
	 * @param password The user's password.
	 * @param accountLevel The user's accountLevel.
	 * @param firstName The user's first name.
	 * @param lastName The user's last name.
	 * @param address The user's address.
	 * @param emailAddress The user's email address.
	 * @param phoneNumber The user's phone number.
	 *
	 * @since 1.0.0
	 */
	public User(String username, byte [] password, int accountLevel, String firstName, String lastName, Address address, String emailAddress, PhoneNumber phoneNumber)
	{
		//Intialize all the instance variables.
		this.ID = 0;
		this.username = username;
		this.password = password;
		this.accountLevel = accountLevel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}//End of constructor method
	
	/**
	 * Constructs a user object with all the provided information.
	 *
	 * @param ID The user's ID.
	 * @param username The user's username.
	 * @param password The user's password.
	 * @param accountLevel The user's accountLevel.
	 * @param firstName The user's first name.
	 * @param lastName The user's last name.
	 * @param address The user's address.
	 * @param emailAddress The user's email address.
	 * @param phoneNumber The user's phone number.
	 *
	 * @since 1.0.0
	 */
	public User(long ID, String username, byte [] password, int accountLevel, String firstName, String lastName, Address address, String emailAddress, PhoneNumber phoneNumber)
	{
		//Intialize all the instance variables.
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.accountLevel = accountLevel;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}//End of constructor method

	/**
	 * Delete's the user.
	 *
	 * @todo
	 */
	public void delete()
	{
		//TO DO
	}//End of delete method

		
	/********************
	 * ACCESSOR METHODS *
	 ********************/
	
	/**
	 * Gets the value of ID.
	 *
	 * @return The value of ID.
	 */
	public long getID()
	{
		return this.ID;
	}//End of getID method
	
	/**
	 * Gets the value of username.
	 *
	 * @return The value of username.
	 */
	public String getUsername()
	{
		return this.username;
	}//End of getUsername method
	
	/**
	 * Gets the value of password.
	 *
	 * @return The value of password.
	 */
	public byte [] getPassword()
	{
		return this.password;
	}//End of getPassword method
	
	/**
	 * Gets the value of accountLevel.
	 *
	 * @return The value of accountLevel.
	 */
	public int getAccountLevel()
	{
		return this.accountLevel;
	}//End of getAccountLevel method
	
	/**
	 * Gets the value of firstName.
	 *
	 * @return The value of firstName.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}//End of getFirstName method
	
	/**
	 * Gets the value of lastName.
	 *
	 * @return The value of lastName.
	 */
	public String getLastName()
	{
		return this.lastName;
	}//End of getLastName method
	
	/**
	 * Gets the value of address.
	 *
	 * @return The value of address.
	 */
	public Address getAddress()
	{
		return this.address;
	}//End of getAddress method
	
	/**
	 * Gets the value of emailAddress.
	 *
	 * @return The value of emailAddress.
	 */
	public String getEmailAddress()
	{
		return this.emailAddress;
	}//End of getEmailAddress method
	
	/**
	 * Gets the value of phoneNumber.
	 *
	 * @return The value of phoneNumber.
	 */
	public PhoneNumber getPhoneNumber()
	{
		return this.phoneNumber;
	}//End of getPhoneNumber method
	
	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/

		
	/*******************
	 * MUTATOR METHODS *
	 *******************/
	
	/**
	 * Sets the value of ID.
	 *
	 * @param ID The new value for ID.
	 */
	public void setID(long ID)
	{
		this.ID = ID;
	}//End of setID method
	
	/**
	 * Sets the value of username.
	 *
	 * @param username The new value for username.
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}//End of setUsername method
	
	/**
	 * Sets the value of password.
	 *
	 * @param password []  The new value for password.
	 */
	public void setPassword(byte [] password)
	{
		this.password = password;
	}//End of setPassword method
	
	/**
	 * Sets the value of accountLevel.
	 *
	 * @param accountLevel The new value for accountLevel.
	 */
	public void setAccountLevel(int accountLevel)
	{
		this.accountLevel = accountLevel;
	}//End of setAccountLevel method
	
	/**
	 * Sets the value of firstName.
	 *
	 * @param firstName The new value for firstName.
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}//End of setFirstName method
	
	/**
	 * Sets the value of lastName.
	 *
	 * @param lastName The new value for lastName.
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}//End of setLastName method
	
	/**
	 * Sets the value of address.
	 *
	 * @param address The new value for address.
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}//End of setAddress method
	
	/**
	 * Sets the value of emailAddress.
	 *
	 * @param emailAddress The new value for emailAddress.
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}//End of setEmailAddress method
	
	/**
	 * Sets the value of phoneNumber.
	 *
	 * @param phoneNumber The new value for phoneNumber.
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}//End of setPhoneNumber method
	
	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/**
	 * Returns a String representation of the user.
	 *
	 * @return The user respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String user = "";

		//Create the String representation
		user += "[";

		user += "username : '" + this.username + "', ";
		user += "password : '" + new String(this.password) + "', ";
		user += "accountLevel : '" + String.valueOf(this.accountLevel) + "', ";
		user += "firstName : '" + this.firstName + "', ";
		user += "lastName : '" + this.lastName + "', ";
		user += "address : '" + this.address.toString() + "', ";
		user += "emailAddress : '" + this.emailAddress + "', ";
		user += "phoneNumber : '" + this.phoneNumber.toString() + "'";

		user += "]";

		//Return the String representation
		return user;
	}//End of toString method
 }//End of class