package app.boxmate;

import java.util.ArrayList;

/**
 * This class is contains a list of all the shows currently playing or which are to be played.  It also contains associated functionality in organizing this list of shows.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class ShowRoster
{
	/**
	 * A list of all the shows that are displayed to the user.  This includes the shows that all managers have put into the program that are with showing or that will be showing.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<Show> shows;

    /**
	 * The default constructor for the ShowRoster class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public ShowRoster()
    {
    	this.shows = new ArrayList<Show>();
    }//End of default constructor

    /**
	 * A constructor for the ShowRoster class that takes an array of Show objects as a parameter.
	 *
	 * @param shows An array of shows to be put into the roster.
	 * @since 1.0.0
	 */
    public ShowRoster(Show [] shows)
    {
    	for (Show x : shows)
    	{
    		this.shows.add(x);
    	}//End of for
    }//End of object constructor

    /**
	 * A constructor for the ShowRoster class that takes an ArrayList of Show objects as a parameter.
	 *
	 * @param shows An ArrayList of shows to be put into the roster.
	 * @since 1.0.0
	 */
    public ShowRoster(ArrayList<Show> shows)
    {
    	this.shows = shows;
    }//End of object constructor

    /**
	 * Adds a new show to the show roster.
	 *
	 * @param shows A show to add to the roster.
	 * @since 1.0.0
	 */
	public void addShow(Show show)
	{
		shows.add(show);
	}//End of addShow method

	/**
	 * Removes a show from the show roster.
	 *
	 * @param shows A show to remove from the roster.
	 * @since 1.0.0
	 */
	public void removeShow(Show show)
	{
		shows.remove(show);
	}//End of removeShow method

	/**
	 * Sorts the show roster based on the criteria passed and returns the sorted roster.
	 *
	 * @param sortType A particular criteria to sort by.
	 * @return The sorted show roster.
	 * @since 1.0.0
	 */
	public ShowRoster sort(SortTypes sortType)
	{
		if (sortType == SortTypes.NAME)
			return sortByName();
		else if (sortType == SortTypes.DESCRIPTION)
			return sortByDescription();
		else if (sortType == SortTypes.NEXT_SHOWING)
			return sortByNextShowing();
		else if (sortType == SortTypes.RATING)
			return sortByRating ();
		else if (sortType == SortTypes.RANKING)
			return sortByRanking();
		else
			return this;
	}//End of sort method

	/**
	 * Sorts the roster by the name of the shows in alphabetical order.
	 *
	 * @return The show roster sorted alphabetically by name.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	private ShowRoster sortByName()
	{
		return this;
	}//End of sortByName method

	/**
	 * Sorts the roster by the description of the shows in alphabetical order.
	 *
	 * @return The show roster sorted alphabetically by description.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	private ShowRoster sortByDescription()
	{
		return this;
	}//End of sortByDescription method

	/**
	 * Sorts the shows by the date of their next showing in chronological order.
	 *
	 * @return The show roster sorted chronologically by the date of their next showing.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	private ShowRoster sortByNextShowing()
	{
		return this;
	}//End of sortByNextShowing method

	/**
	 * Sorts the shows by their rating from G to R.
	 *
	 * @return The show roster with shows sorted by their rating from G to R.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	private ShowRoster sortByRating()
	{
		return this;
	}//End of sortByRating method

	/**
	 * Sorts the shows by their rating, from highest to lowest.
	 *
	 * @return The show roster with shows sorted by their rating, from highest to lowest.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	private ShowRoster sortByRanking()
	{
		return this;
	}//End of sortByRanking method

	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of shows.
	 *
	 * @return The value of shows.
	 */
	public ArrayList<Show> getShows()
	{
		return this.shows;
	}//End of getShows method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of shows.
	 *
	 * @param shows The new value for shows.
	 */
	public void setShows(ArrayList<Show> shows)
	{
		this.shows = shows;
	}//End of setShows method

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

    	for (Show x : shows)
    	{
    		output += shows.toString();
    	}//End of for

    	return output;
    }//End of toString method

    /**
	 * Returns an array with all the shows in the show roster.
	 *
	 * @return An array with all the shows in the show roster.
	 * @since 1.0.0
	 */
    public Show [] toArray()
    {
    	Show [] showArray = new Show[shows.size()];

    	for (int x = 0; x < shows.size(); x++)
    	{
    		showArray[x] = shows.get(x);
    	}//End of for

    	return showArray;
    }//End of toArray method
}//End of class