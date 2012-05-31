package app.boxmate;

import java.util.ArrayList;

/**
 * A customer.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class Customer extends User
 {
	/**
	 * The customer's credit card.
	 *
	 * @since 1.0.0
	 */
	private CreditCard creditCard;

	/**
	 * The customer's tickets.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<Ticket> tickets;

	/**
	 * Default constructor for a Customer object.
	 *
	 * @since 1.0.0
	 */
	public Customer()
	{
		//Call the parent class's constructor.
		super();

		//Intialize all the instance variables.
		this.creditCard = new CreditCard();
		this.tickets = new ArrayList<Ticket>();
	}//End of constructor method

	/**
	 * Constructs a Customer object with all the provided information.
	 *
	 * @param username The customer's username.
	 * @param password The customer's password.
	 * @param accountLevel The customer's accountLevel.
	 * @param firstName The customer's first name.
	 * @param lastName The customer's last name.
	 * @param address The customer's address.
	 * @param emailAddress The customer's email address.
	 * @param phoneNumber The customer's phone number.
	 * @param creditCard The customer's credit card.
	 * @param tickets The customer's tickets.
	 *
	 * @since 1.0.0
	 */
	public Customer(String username, String password, int accountLevel, String firstName, String lastName, Address address, String emailAddress, PhoneNumber phoneNumber, CreditCard creditCard, ArrayList<Ticket> tickets)
	{
		//Call the parent class' constructor.
		super(username, password, accountLevel, firstName, lastName, address, emailAddress, phoneNumber);

		//Initialize all the fields
		this.creditCard = creditCard;
		this.tickets = tickets;
	}//End of constructor


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of creditCard.
	 *
	 * @return The value of creditCard.
	 */
	public CreditCard getCreditCard()
	{
		return this.creditCard;
	}//End of getCreditCard method

	/**
	 * Gets the value of tickets.
	 *
	 * @return The value of tickets.
	 */
	public ArrayList<Ticket> getTickets()
	{
		return this.tickets;
	}//End of getTickets method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of creditCard.
	 *
	 * @param creditCard The new value for creditCard.
	 */
	public void setCreditCard(CreditCard creditCard)
	{
		this.creditCard = creditCard;
	}//End of setCreditCard method

	/**
	 * Sets the value of tickets.
	 *
	 * @param tickets The new value for tickets.
	 */
	public void setTickets(ArrayList<Ticket> tickets)
	{
		this.tickets = tickets;
	}//End of setTickets method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/**
	 * Returns a String representation of the customer.
	 *
	 * @return The customer respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String customer = "";

		//Create the String representation
		customer += "[";

		customer += "username : '" + this.username + "', ";
		customer += "password : '" + this.password + "', ";
		customer += "accountLevel : '" + String.valueOf(this.accountLevel) + "', ";
		customer += "firstName : '" + this.firstName + "', ";
		customer += "lastName : '" + this.lastName + "', ";
		customer += "address : '" + this.address.toString() + "', ";
		customer += "emailAddress : '" + this.emailAddress + "', ";
		customer += "phoneNumber : '" + this.phoneNumber.toString() + "', ";
		customer += "creditCard : '" + this.creditCard.toString() + "', ";
		customer += "tickets : '" + this.tickets.toString() + "'";

		customer += "]";

		//Return the String representation
		return customer;
	}//End of toString method
 }//End of class