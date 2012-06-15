package app.boxmate;

import java.util.Arrays;

/**
 * This class represents a venue for a showing.
 *
 * CHANGES:
 *		June 15, 2012 (Zach):
 *			- Added ID field, for Database
 *
 * @author Jonathan Tan and Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class Theatre
{
	/**
	 * The ID of the theatre, as provided by the database.
	 *
	 * @since 1.0.0
	 */
	private long ID;
	
	/**
	 * The name of the theatre.
	 *
	 * @since 1.0.0
	 */
	private String name;

	/**
	 * The address of the theatre.
	 *
	 * @since 1.0.0
	 */
	private Address address;

	/**
	 * The address of the theatre.
	 *
	 * @since 1.0.0
	 */
	private PhoneNumber phoneNumber;

	/**
	 * An email address to contact the theatre.
	 *
	 * @since 1.0.0
	 */
	private String emailAddress;

	/**
	 * The theatre's website.
	 *
	 * @since 1.0.0
	 */
	private String website;

	/**
	 * The number of rows in the theatre.
	 *
	 * @since 1.0.0
	 */
	private int rows;

	/**
	 * The number of seats per row.
	 *
	 * @since 1.0.0
	 */
	private int [] seatsPerRow;

    /**
	 * The default constructor for the Theatre class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public Theatre()
    {
    	this.ID = 0;
    	this.name = "Generic Theatre";
    	this.address = new Address();
    	this.phoneNumber = new PhoneNumber();
    	this.emailAddress = "";
    	this.website = "";
    	this.rows = 0;
    	this.seatsPerRow = new int[rows];
    }//End of default constructor
   
    /**
	 * A constructor for the Theatre class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param name The name of the theatre.
	 * @param address The address of the theatre.
	 * @param phoneNumber The phone number to contact the theatre.
	 * @param emailAddress The email address to contact the theatre.
	 * @param website The theatre's website.
	 * @param rows The number of rows in the theatre.
	 * @param seatsPerRow The number of seats per row.
	 * @since 1.0.0
	 */
    public Theatre(String name, Address address, PhoneNumber phoneNumber, String emailAddress, String website, int rows, int [] seatsPerRow)
    {
    	this.ID = 0;
    	this.name = name;
    	this.address = address;
    	this.phoneNumber = phoneNumber;
    	this.emailAddress = emailAddress;
    	this.website = website;
    	this.rows = rows;
    	this.seatsPerRow = seatsPerRow;
    }//End of object constructor
    
    /**
	 * A constructor for the Theatre class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param ID The theatre ID, as provided by the database.
	 * @param name The name of the theatre.
	 * @param address The address of the theatre.
	 * @param phoneNumber The phone number to contact the theatre.
	 * @param emailAddress The email address to contact the theatre.
	 * @param website The theatre's website.
	 * @param rows The number of rows in the theatre.
	 * @param seatsPerRow The number of seats per row.
	 * @since 1.0.0
	 */
    public Theatre(long ID, String name, Address address, PhoneNumber phoneNumber, String emailAddress, String website, int rows, int [] seatsPerRow)
    {
    	this.ID = ID;
    	this.name = name;
    	this.address = address;
    	this.phoneNumber = phoneNumber;
    	this.emailAddress = emailAddress;
    	this.website = website;
    	this.rows = rows;
    	this.seatsPerRow = seatsPerRow;
    }//End of object constructor

		
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
	 * Gets the value of name.
	 *
	 * @return The value of name.
	 */
	public String getName()
	{
		return this.name;
	}//End of getName method
	
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
	 * Gets the value of phoneNumber.
	 *
	 * @return The value of phoneNumber.
	 */
	public PhoneNumber getPhoneNumber()
	{
		return this.phoneNumber;
	}//End of getPhoneNumber method
	
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
	 * Gets the value of website.
	 *
	 * @return The value of website.
	 */
	public String getWebsite()
	{
		return this.website;
	}//End of getWebsite method
	
	/**
	 * Gets the value of rows.
	 *
	 * @return The value of rows.
	 */
	public int getRows()
	{
		return this.rows;
	}//End of getRows method
	
	/**
	 * Gets the value of seatsPerRow.
	 *
	 * @return The value of seatsPerRow.
	 */
	public int [] getSeatsPerRow()
	{
		return this.seatsPerRow;
	}//End of getSeatsPerRow method
	
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
	 * Sets the value of name.
	 *
	 * @param name The new value for name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}//End of setName method
	
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
	 * Sets the value of phoneNumber.
	 *
	 * @param phoneNumber The new value for phoneNumber.
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}//End of setPhoneNumber method
	
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
	 * Sets the value of website.
	 *
	 * @param website The new value for website.
	 */
	public void setWebsite(String website)
	{
		this.website = website;
	}//End of setWebsite method
	
	/**
	 * Sets the value of rows.
	 *
	 * @param rows The new value for rows.
	 */
	public void setRows(int rows)
	{
		this.rows = rows;
	}//End of setRows method
	
	/**
	 * Sets the value of seatsPerRow.
	 *
	 * @param seatsPerRow []  The new value for seatsPerRow.
	 */
	public void setSeatsPerRow(int [] seatsPerRow)
	{
		this.seatsPerRow = seatsPerRow;
	}//End of setSeatsPerRow method
	
	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/

	
	/**
	 * Returns a string representation of the object.
	 *
	 * @return A string representation of the object.
	 * @since 1.0.0
	 */
    public String toString()
    {
    	String output = "";

    	output += "[";
    	output += "Name: " + name + ", ";
    	output += "Address: " + address + ", ";
    	output += "Phone Number: " + phoneNumber.toString() + ", ";
    	output += "Email Address: " + emailAddress + ", ";
    	output += "Website: " + website + ", ";
    	output += "# Rows: " + rows + ", ";
    	output += "# Seats Per Row: " + Arrays.toString(seatsPerRow);
    	output += "]";

    	return output;
    }//End of toString method
}//End of class