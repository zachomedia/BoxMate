package app.boxmate;

/**
 * This enumerated type contains the different criteria to sort shows by.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public enum SortTypes
{
	/**
	 * Sort by the name of the show, alphanumerically.
	 */
	NAME,
	
	/**
	 * Sort by the description of the show, alphanumerically.
	 */
	DESCRIPTION,
	
	/**
	 * Sort by the next showing of the show, chronologically.
	 */
	NEXT_SHOWING,
	
	/**
	 * Sort by the rating of the show, from G to R.
	 */
	RATING,
	
	/**
	 * Sort by the ranking of the show, anumerically.
	 */
	RANKING
}//End of enum