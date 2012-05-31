package app.boxmate;

/**
 * This class represents a virtual ticket with show information and can be used at the actual production.
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
    	return false;
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
    	return false;
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
}//End of class