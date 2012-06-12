package app.boxmate;

import java.util.*;
import java.sql.Time;
import java.io.*;
import javax.mail.*;
import javax.mail.event.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * This class represents a virtual ticket with show information and can be used at the actual production.
 *
 * CHANGES:
 *		June 12, 2012:
 *			- Added email ticket.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class Ticket
{
	/**
	 * The unique identification code for this ticket.
	 *
	 * @since 1.0.0
	 */
	private long ID;

	/**
	 * The customer with which the ticket is associated with.
	 *
	 * @since 1.0.0
	 */
	private Customer customer;

	/**
	 * The show this ticket is for.
	 *
	 * @since 1.0.0
	 */
	private Show show;

	/**
	 * The particular showing that this ticket is for.
	 *
	 * @since 1.0.0
	 */
	private Showing showing;

	/**
	 * The row to which the customer is assigned.
	 *
	 * @since 1.0.0
	 */
	private int row;

	/**
	 * The seat to which the customer is assigned.
	 *
	 * @since 1.0.0
	 */
	private int seat;

	/**
	 * The default constructor for the Ticket class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public Ticket()
    {
    	this.ID = 000000000;
    	this.customer = new Customer();
    	this.show = new Show();
    	this.showing = new Showing();
    	this.row = 0;
    	this.seat = 0;
    }//End of default constructor

    /**
	 * A constructor for the Ticket class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param ID The unique identification code for this ticket.
	 * @param customer The customer with which the ticket is associated with.
	 * @param show The show this ticket is for.
	 * @param showing The particular showing that this ticket is for.
	 * @param row The row to which the customer is assigned.
	 * @param seat The seat to which the customer is assigned.
	 * @since 1.0.0
	 */
    public Ticket(long ID, Customer customer, Show show, Showing showing, int row, int seat)
    {
    	this.ID = ID;
    	this.customer = customer;
    	this.show = show;
    	this.showing = showing;
    	this.row = row;
    	this.seat = seat;
    }//End of object constructor

    /**
	 * Sends the ticket to a printer to print. Returns if the job was successful.
	 *
	 * @return Whether or not the print job was successful.
	 * @since 1.0.0
	 * @todo Implement.
	 */
    public boolean print()
    {
    	return false;
    }//End of print method

    /**
	 * Sends a printable version of the ticket to the e-mail of the Customer object.  Returns if the job was successful.
	 *
	 * @return Whether or not the print job was successful.
	 * @since 1.0.0
	 * @todo Implement.
	 */
    public boolean email()
    {
    	return email(this.customer.getEmailAddress());
    }//End of email method

    /**
	 * Sends a printable version of the ticket to the specified e-mail.  Returns if the job was successful.
	 *
	 * @return Whether or not the print job was successful.
	 * @since 1.0.0
	 * @todo Implement.
	 */
    public boolean email(String emailAddress)
    {
    	try
    	{
    		Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	
			//Setup the session, and authentication
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("boxmate.software@gmail.com", "BoxMate2012Software");
				}
			  });
	
			//Create the message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("boxmate-software@gmail.com", "BoxMate E-Tickets"));
			message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(emailAddress)});
			message.setSubject("Your E-Ticket for " + this.show.getName());
	
	
			String content = "";
	
			content += "<p style='background: #e3e3e3; padding: 8px; border-radius: 4px; -webkit-border-radius: 4px; font-weight: bold; font-size: 16pt;'>E-Ticket: " + this.show.getName() + "</p>";
			content += "<p style='padding: 4px;'>" + this.customer.getFirstName() + ",<br /><br />Thank you for purchasing a ticket to this performance. Please print this ticket and bring it with you to be admitted into the event.</p>";
			
			content += "<div style='padding: 10px 50px;'><h3 style='color: #acacac'>" + this.show.getName() + "</h3>";
			content += "<p style='color: #dcdcdc;'>" + this.show.getDescription() + "</p></div>";
			
			content += "<h3 style='text-decoration: underline; font-weight: bold;'>Ticket Information</h3>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Ticket Number:</b> " + String.valueOf(this.ID) + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Show:</b> " + this.show.getName() + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Date/Time:</b> " + this.showing.getDate() + " at " + this.showing.getTime() + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Doors Open:</b> " + this.showing.getDoorsOpen() + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Row:</b> " + this.row + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Seat:</b> " + this.seat + "</p>";
	
			content += "<h3 style='text-decoration: underline; font-weight: bold;'>Theatre Information</h3>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Name:</b> " + this.showing.getTheatre().getName() + "</p>";
			content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Address:</b> " + this.showing.getTheatre().getAddress().normalize() + "</p>";
			//content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Phone:</b> (519) 452-2840</p>";
			//content += "<p><b style='display: inline-block; width: 100px; text-align: right; padding-right: 10px; padding-left: 10px;'>Website:</b> <a style='color: black;' href='http://www.tvdsb.ca/sirwilfridlaurier.cfm'>http://www.tvdsb.ca/SirWilfridLaurier.cfm</a></p>";
	
	
			content += "<p style='text-style: italic; text-align: center; font-size: 9pt; color: #acacac;'>Email automatically generated by BoxMate.</p>";
	
			message.setContent(content, "text/html");
	
			message.saveChanges();
	
			//Send the message
			Transport.send(message);
			
			return true;
    	}//End of try
    	catch (Exception e)
    	{
    		return false;
    	}//End of catch
    }//End of email method


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
	 * Gets the value of customer.
	 *
	 * @return The value of customer.
	 */
	public Customer getCustomer()
	{
		return this.customer;
	}//End of getCustomer method

	/**
	 * Gets the value of show.
	 *
	 * @return The value of show.
	 */
	public Show getShow()
	{
		return this.show;
	}//End of getShow method

	/**
	 * Gets the value of showing.
	 *
	 * @return The value of showing.
	 */
	public Showing getShowing()
	{
		return this.showing;
	}//End of getShowing method

	/**
	 * Gets the value of row.
	 *
	 * @return The value of row.
	 */
	public int getRow()
	{
		return this.row;
	}//End of getRow method

	/**
	 * Gets the value of seat.
	 *
	 * @return The value of seat.
	 */
	public int getSeat()
	{
		return this.seat;
	}//End of getSeat method

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
	 * Sets the value of customer.
	 *
	 * @param customer The new value for customer.
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}//End of setCustomer method

	/**
	 * Sets the value of show.
	 *
	 * @param show The new value for show.
	 */
	public void setShow(Show show)
	{
		this.show = show;
	}//End of setShow method

	/**
	 * Sets the value of showing.
	 *
	 * @param showing The new value for showing.
	 */
	public void setShowing(Showing showing)
	{
		this.showing = showing;
	}//End of setShowing method

	/**
	 * Sets the value of row.
	 *
	 * @param row The new value for row.
	 */
	public void setRow(int row)
	{
		this.row = row;
	}//End of setRow method

	/**
	 * Sets the value of seat.
	 *
	 * @param seat The new value for seat.
	 */
	public void setSeat(int seat)
	{
		this.seat = seat;
	}//End of setSeat method

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
    	output += "ID #: " + ID + "| ";
    	output += customer.getFirstName() +  " "  + customer.getLastName() +" for " + show.getName() + ": " + showing.getDate();
    	output += "[Row: " + row + ", Seat: " + seat + "]";
    	output += "]";

    	return output;
    }//End of toString method
    
    public static void main (String [] args)
    {
    	Theatre theatre = new Theatre(
    		"Sir Wilfrid Laurier S. S. RamLand Theatre",
    		new Address(450, "Millbank", "Drive", "London", "Ontario", "Canada", "N6C 4W7"),
    		1,
    		new int[]{1}
    	);
    	
    	ArrayList<Showing> showings = new ArrayList<Showing>();
    	showings.add(new Showing(
			new Date(5464564),
			new Time(65645),
			new Time(6000),
			155,
			154,
			theatre,
			new ArrayList<Ticket>()
    	));
    	
    	Customer customer = new Customer(
    		"zachary.seguin",
    		"NoPassword",
    		10,
    		"Zachary",
    		"Seguin",
    		new Address(429, "Cardigan", "Place", "London", "Ontario", "Canada", "N6M 1J6"),
    		"zseguin@me.com",
    		new PhoneNumber(519, 668, 3141),
    		new CreditCard(),
    		new ArrayList<Ticket>()
    	);
    	
    	Show show = new Show(
    		"The Boyfriend",
    		"Some awesome description",
    		new ArrayList<String>(),
    		showings,
    		Rating.G,
    		1.0
    	);
    
    	Ticket ticket = new Ticket(
    		5156165,
    		customer,
    		show,
    		show.getShowings().get(0),
    		1,
    		1
    	);
    	
    	ticket.email();
    }
}//End of class