package app.boxmate;

import java.util.ArrayList;

/**
 * This class represents a show that is being played at certain venue.  Customers can purchase tickets or rate it. Managers can create instances of a show and edit its details.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class Show
{
	/**
	 * The name of the show or production.
	 *
	 * @since 1.0.0
	 */
	private String name;

	/**
	 * A description of the show or production.
	 *
	 * @since 1.0.0
	 */
	private String description;

	/**
	 * The names of all the people involved with the show or production.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<String> productionMembers;

	/**
	 * A list of all the showings that the show has.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<Showing> showings;

	/**
	 * The content rating of the show.
	 *
	 * @since 1.0.0
	 */
	private Rating rating;

	/**
	 * The average of all users’ rankings of the show or production, out of 5.
	 *
	 * @since 1.0.0
	 */
	private double ranking;

	/**
	 * The default constructor for the Show class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public Show()
    {
    	this.name = "";
    	this.description = "";
    	this.productionMembers = new ArrayList<String>();
    	this.showings = new ArrayList<Showing>();
    	this.rating = Rating.G;
    	this.ranking = 0.0;
    }//End of default constructor

    /**
	 * A constructor for the Show class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param name The name of the show or production.
	 * @param description A description of the show or production.
	 * @param productionMembers The names of all the people involved with the show or production.
	 * @param showings A list of all the showings that the show has..
	 * @param rating The content rating of the show.
	 * @param ranking The average of all users’ rankings of the show or production, out of 5.
	 * @since 1.0.0
	 */
    public Show(String name, String description, ArrayList<String> productionMembers, ArrayList<Showing> showings, Rating rating, double ranking)
    {
    	this.name = name;
    	this.description = description;
    	this.productionMembers = productionMembers;
    	this.showings = showings;
    	this.rating = rating;
    	this.ranking = ranking;
    }//End of object constructor


	/********************
	 * ACCESSOR METHODS *
	 ********************/

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
	 * Gets the value of description.
	 *
	 * @return The value of description.
	 */
	public String getDescription()
	{
		return this.description;
	}//End of getDescription method

	/**
	 * Gets the value of productionMembers.
	 *
	 * @return The value of productionMembers.
	 */
	public ArrayList<String> getProductionMembers()
	{
		return this.productionMembers;
	}//End of getProductionMembers method

	/**
	 * Gets the value of showings.
	 *
	 * @return The value of showings.
	 */
	public ArrayList<Showing> getShowings()
	{
		return this.showings;
	}//End of getShowings method

	/**
	 * Gets the value of rating.
	 *
	 * @return The value of rating.
	 */
	public Rating getRating()
	{
		return this.rating;
	}//End of getRating method

	/**
	 * Gets the value of ranking.
	 *
	 * @return The value of ranking.
	 */
	public double getRanking()
	{
		return this.ranking;
	}//End of getRanking method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

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
	 * Sets the value of description.
	 *
	 * @param description The new value for description.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}//End of setDescription method

	/**
	 * Sets the value of productionMembers.
	 *
	 * @param productionMembers The new value for productionMembers.
	 */
	public void setProductionMembers(ArrayList<String> productionMembers)
	{
		this.productionMembers = productionMembers;
	}//End of setProductionMembers method

	/**
	 * Sets the value of showings.
	 *
	 * @param showings The new value for showings.
	 */
	public void setShowings(ArrayList<Showing> showings)
	{
		this.showings = showings;
	}//End of setShowings method

	/**
	 * Sets the value of rating.
	 *
	 * @param rating The new value for rating.
	 */
	public void setRating(Rating rating)
	{
		this.rating = rating;
	}//End of setRating method

	/**
	 * Sets the value of ranking.
	 *
	 * @param ranking The new value for ranking.
	 */
	public void setRanking(double ranking)
	{
		this.ranking = ranking;
	}//End of setRanking method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/

	/**
	 * Returns the total sales from this show or production.
	 *
	 * @return The total amount of sales from the production.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	 public double calculateSales()
	 {
	 	return 0.0;
	 }//End of calculateSales method

    /**
	 * Shows a certain statistic related to the show.
	 *
	 * @param statType The statistic to display.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	 public void showStat(Statistics statType)
	 {
	 }//End of showStat method

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
		output += name;
		output += "--------------------------------\n";
		output += description;

		output += "\nPRODUCTION MEMBERS:\n";
		for (String member : productionMembers)
			output += member + "\n";

		output += "SHOWINGS:\n";
		for (Showing x : showings)
			output += x.toString() + "\n";

		output += "Rated " + rating + "\n";
		output += "Avg. Rank: " + ranking;
		output += "\n--------------------------------\n";

		return output;
	}//End of toString method
}//End of class