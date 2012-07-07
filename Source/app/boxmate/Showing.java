package app.boxmate;

import java.util.ArrayList;

/**
 * This class represents a showing of a show (i.e. if the show is being played more than once).
 *
 * UPDATES:
 *		June 12 (Jonathan):
 *			- Now using custom date/time classes.
 *		June 13 (Jonathan):
 *			- Threw in implementation of organizeSeating method
 *		June 15, 2012 (Zach):
 *			- Added ID field, for the database.
 *
 * @author Jonathan Tan and Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class Showing
{
	/**
	 * The ID of the showing, as provided by the Database.
	 *
	 * @since 1.0.0
	 */
	private long ID;
	
	/**
	 * The number of seats per row.
	 *
	 * @since 1.0.0
	 */
	private Date date;

	/**
	 * The time that the show begins.
	 *
	 * @since 1.0.0
	 */
	private Time time;

	/**
	 * The time the doors open for the show.
	 *
	 * @since 1.0.0
	 */
	private Time doorsOpen;

	/**
	 * The maximum number of seats that can be sold.
	 *
	 * @since 1.0.0
	 */
	private int seatsMax;

	/**
	 * The number of seats left for sale.
	 *
	 * @since 1.0.0
	 */
	private int seatsLeft;

	/**
	 * The venue for the showing.
	 *
	 * @since 1.0.0
	 */
	private Theatre theatre;

	/**
	 * A list of all tickets that are for this showing.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<Ticket> tickets;

    /**
	 * The default constructor for the Showing class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public Showing()
    {
    	this.ID = 0;
    	this.date = new Date();
    	this.time = new Time();
    	this.doorsOpen = new Time();
    	this.seatsMax = 0;
    	this.seatsLeft = 0;
    	this.theatre = new Theatre();
    	this.tickets = new ArrayList<Ticket>();
    }//End of default constructor

	/**
	 * A constructor for the Showing class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param date The date of this showing.
	 * @param time The time that the show begins.
	 * @param doorsOpen The time the doors open for the show.
	 * @param seatsMax The maximum number of seats that can be sold.
	 * @param seatsLeft The number of seats left for sale.
	 * @param theatre The venue for the showing.
	 * @param tickets A list of all tickets that are for this showing.
	 * @since 1.0.0
	 */
    public Showing(Date date, Time time, Time doorsOpen, int seatsMax, int seatsLeft, Theatre theatre, ArrayList<Ticket> tickets)
    {
    	this.ID = 0;
    	this.date = date;
    	this.time = time;
    	this.doorsOpen = doorsOpen;
    	this.seatsMax = seatsMax;
    	this.seatsLeft = seatsLeft;
    	this.theatre = theatre;
    	this.tickets = tickets;
    }//End of object constructor
    
    /**
	 * A constructor for the Showing class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param ID The ID of the database, as provided by the database.
	 * @param date The date of this showing.
	 * @param time The time that the show begins.
	 * @param doorsOpen The time the doors open for the show.
	 * @param seatsMax The maximum number of seats that can be sold.
	 * @param seatsLeft The number of seats left for sale.
	 * @param theatre The venue for the showing.
	 * @param tickets A list of all tickets that are for this showing.
	 * @since 1.0.0
	 */
    public Showing(long ID, Date date, Time time, Time doorsOpen, int seatsMax, int seatsLeft, Theatre theatre, ArrayList<Ticket> tickets)
    {
    	this.ID = ID;
    	this.date = date;
    	this.time = time;
    	this.doorsOpen = doorsOpen;
    	this.seatsMax = seatsMax;
    	this.seatsLeft = seatsLeft;
    	this.theatre = theatre;
    	this.tickets = tickets;
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
	 * Gets the value of date.
	 *
	 * @return The value of date.
	 */
	public Date getDate()
	{
		return this.date;
	}//End of getDate method
	
	/**
	 * Gets the value of time.
	 *
	 * @return The value of time.
	 */
	public Time getTime()
	{
		return this.time;
	}//End of getTime method
	
	/**
	 * Gets the value of doorsOpen.
	 *
	 * @return The value of doorsOpen.
	 */
	public Time getDoorsOpen()
	{
		return this.doorsOpen;
	}//End of getDoorsOpen method
	
	/**
	 * Gets the value of seatsMax.
	 *
	 * @return The value of seatsMax.
	 */
	public int getSeatsMax()
	{
		return this.seatsMax;
	}//End of getSeatsMax method
	
	/**
	 * Gets the value of seatsLeft.
	 *
	 * @return The value of seatsLeft.
	 */
	public int getSeatsLeft()
	{
		return this.seatsLeft;
	}//End of getSeatsLeft method
	
	/**
	 * Gets the value of theatre.
	 *
	 * @return The value of theatre.
	 */
	public Theatre getTheatre()
	{
		return this.theatre;
	}//End of getTheatre method
	
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
	 * Sets the value of ID.
	 *
	 * @param ID The new value for ID.
	 */
	public void setID(long ID)
	{
		this.ID = ID;
	}//End of setID method
	
	/**
	 * Sets the value of date.
	 *
	 * @param date The new value for date.
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}//End of setDate method
	
	/**
	 * Sets the value of time.
	 *
	 * @param time The new value for time.
	 */
	public void setTime(Time time)
	{
		this.time = time;
	}//End of setTime method
	
	/**
	 * Sets the value of doorsOpen.
	 *
	 * @param doorsOpen The new value for doorsOpen.
	 */
	public void setDoorsOpen(Time doorsOpen)
	{
		this.doorsOpen = doorsOpen;
	}//End of setDoorsOpen method
	
	/**
	 * Sets the value of seatsMax.
	 *
	 * @param seatsMax The new value for seatsMax.
	 */
	public void setSeatsMax(int seatsMax)
	{
		this.seatsMax = seatsMax;
	}//End of setSeatsMax method
	
	/**
	 * Sets the value of seatsLeft.
	 *
	 * @param seatsLeft The new value for seatsLeft.
	 */
	public void setSeatsLeft(int seatsLeft)
	{
		this.seatsLeft = seatsLeft;
	}//End of setSeatsLeft method
	
	/**
	 * Sets the value of theatre.
	 *
	 * @param theatre The new value for theatre.
	 */
	public void setTheatre(Theatre theatre)
	{
		this.theatre = theatre;
	}//End of setTheatre method
	
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
	 * Adds a ticket to the showing.
	 *
	 * @param ticket The ticket to be added.
	 * @since 1.0.0
	 */
	 public void addTicket(Ticket ticket)
	 {
	 	tickets.add(ticket);
	 }//End of addTicket method

	 /**
	 * Removes a ticket from the showing.
	 *
	 * @param ticket The ticket to be removed.
	 * @since 1.0.0
	 */
	 public void removeTicket(Ticket ticket)
	 {
	 	tickets.remove(ticket);
	 }//End of removeTicket method

	/**
	 * Returns a 2D array of the seating plan for the showing.
	 *
	 * @param rows The number of rows in the seating plan.
	 * @param seatsPerRow The number of seats per row in the seating plan.
	 * @since 1.0.0
	 */
	 public Ticket[][] organizeSeating(int rows, int [] seatsPerRow)
	 {
	 	Ticket [][] seating = new Ticket[rows][];

	 	for (int x = 0; x < seating.length; x++)
	 		seating[x] = new Ticket[seatsPerRow[x]];

	 	for (Ticket t : tickets)
	 	{
	 		if (seating[t.getRow()][t.getSeat()] == null)
	 			System.out.println("Error: Ticket #" + t.getID());
	 		else
	 			seating[t.getRow()][t.getSeat()] = t;
	 	}//End of for

	 	return seating;
	 }//End of organizeSeating method

	/**
	 * Returns a string representation of the object.
	 *
	 * @return A string representation of the object
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		String output = "";

		output += "--------------------------------\n";
		output += theatre.toString() + "\n";
		output += date.toString() + ": " + time.toString() + "\n";
		output += "--------------------------------\n";
		output += "Doors Open: " + doorsOpen.toString() + "\n";
		output += "Seats Left: " + seatsLeft + "/" + seatsMax + "\n";

		output += "Tickets:\n";
		for (Ticket x : tickets)
			output += x.getID() + " ";

		output += "\n--------------------------------\n";

		return output;
	}//End of toString method
}//End of class