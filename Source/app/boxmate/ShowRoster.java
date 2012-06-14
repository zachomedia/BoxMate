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
    	this.shows = new ArrayList<Show>();

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
		switch (sortType)
		{
			case NAME:			return sortByName();

			case DESCRIPTION:	return sortByDescription();

			case NEXT_SHOWING:	return sortByNextShowing();

			case RATING:		return sortByRating();

			case RANKING:		return sortByRanking();

			default:			return this;
		}
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
		Show [] sorted = this.toArray();

		for (int index = 1; index < sorted.length; index++)
		{
			Show key = sorted[index];
			int position = index;

			while (position > 0 && sorted[position-1].getName().compareTo(key.getName()) > 0)
			{
				sorted[position] = sorted[position-1];
				position--;
			}
			sorted[position] = key;
		}

		return new ShowRoster(sorted);
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
		Show [] sorted = this.toArray();

		for (int index = 1; index < sorted.length; index++)
		{
			Show key = sorted[index];
			int position = index;

			while (position > 0 && sorted[position-1].getDescription().compareTo(key.getDescription()) > 0)
			{
				sorted[position] = sorted[position-1];
				position--;
			}
			sorted[position] = key;
		}

		return new ShowRoster(sorted);
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
		Show [] sorted = this.toArray();

		for (int index = 1; index < sorted.length; index++)
		{
			Show key = sorted[index];
			int position = index;

			while (position > 0)
			{
				int equalityA = sorted[position-1].getShowings().get(0).getDate().compareTo(key.getShowings().get(0).getDate());

				if (equalityA == 0)
				{
					int equalityB = sorted[position-1].getShowings().get(0).getTime().compareTo(key.getShowings().get(0).getTime());
					if (equalityB > 0)
					{
							sorted[position] = sorted[position-1];
							position--;
					}
					else
					{
						break;
					}
				}
				else if (equalityA > 0)
				{
					sorted[position] = sorted[position-1];
					position--;
				}
				else
				{
					break;
				}
			}
			sorted[position] = key;
		}

		return new ShowRoster(sorted);
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
		Show [] sorted = this.toArray();

		for (int index = 1; index < sorted.length; index++)
		{
			Show key = sorted[index];
			int position = index;

			while (position > 0 && sorted[position-1].getRating().compareTo(key.getRating()) > 0)
			{
				sorted[position] = sorted[position-1];
				position--;
			}
			sorted[position] = key;
		}

		return new ShowRoster(sorted);
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
		Show [] sorted = this.toArray();

		for (int index = 1; index < sorted.length; index++)
		{
			Show key = sorted[index];
			int position = index;

			while (position > 0 && sorted[position-1].getRanking() < key.getRanking())
			{
				sorted[position] = sorted[position-1];
				position--;
			}
			sorted[position] = key;
		}

		return new ShowRoster(sorted);
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
    		output += x.toString() + "\n";
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

    //Test harness
    public static void main(String [] args) {
 /*   	CHANGE TO USE NEW DATE/TIME CLASSES

  		ArrayList<Showing> testShowing = new ArrayList<Showing>();
    	Showing testee = new Showing();
    	testee.setDate(new Date(8000000));
    	testee.setTime(new Time(10000));
    	testShowing.add(testee);

    	ArrayList<Showing> testShowing2 = new ArrayList<Showing>();
    	Showing testee2 = new Showing();
    	testee2.setDate(new Date(6000000));
    	testee2.setTime(new Time(5000));
    	testShowing2.add(testee2);

    	ArrayList<String> prods = new ArrayList<String>();
    	prods.add("Director: Stephen Harper");
    	Show showA = new Show("Sweeny Todd", "The demon barber of Fleet Street.", prods, testShowing2, Rating.A14, 4.6);
    	Show showB = new Show("Beauty and the Beast", "A Disney fairy tale.", prods, testShowing, Rating.PG, 4.7);

    	ShowRoster test = new ShowRoster();

    	test.addShow(showA);
    	test.addShow(showB);

    	Show showC = new Show("Alice in Wonderland", "Lewis Carroll's beloved story.", prods, testShowing, Rating.G, 4.3);
    	showC.sortShowings();

    	test.addShow(showC);

    	test = test.sort(SortTypes.RATING);

    	System.out.println(test.toString());*/
    }//End of main method
}//End of class