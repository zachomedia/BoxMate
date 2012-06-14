package app.boxmate;

import java.util.Calendar;

/**
 * Stores a date.
 *
 * UPDATES:
 *		June 13:
 *			- Implemented compareTo method.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (12/06/2012)
 * @since 1.0.0
 */
public class Date implements Comparable
{
	/**
	 * Stores the potential values for month.
	 *
	 * @since 1.0.0
	 */
	public enum Month
	{
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	};//End of enumeration

	/**
	 * Stores the year.
	 *
	 * @since 1.0.0
	 */
	private int year;

	/**
	 * Stores the month.
	 *
	 * @since 1.0.0
	 */
	private Month month;

	/**
	 * Stores the day.
	 *
	 * @since 1.0.0
	 */
	private int day;

	/**
	 * Constructs a Date object, using the current date.
	 *
	 * @since 1.0.0
	 */
	public Date()
	{
		//Get the current date
		Calendar today = Calendar.getInstance();

		this.year = today.get(Calendar.YEAR);

		switch(today.get(Calendar.MONTH))
		{
			case 0:		this.month = Month.JANUARY;
						break;

			case 1:		this.month = Month.FEBRUARY;
						break;

			case 2:		this.month = Month.MARCH;
						break;

			case 3:		this.month = Month.APRIL;
						break;

			case 4:		this.month = Month.MAY;
						break;

			case 5:		this.month = Month.JUNE;
						break;

			case 6:		this.month = Month.JULY;
						break;

			case 7:		this.month = Month.AUGUST;
						break;

			case 8:		this.month = Month.SEPTEMBER;
						break;

			case 9:		this.month = Month.OCTOBER;
						break;

			case 10:	this.month = Month.NOVEMBER;
						break;

			case 11:	this.month = Month.DECEMBER;
						break;

			default:	this.month = Month.JANUARY;
		}//End of switch

		this.day = today.get(Calendar.DAY_OF_MONTH);
	}//End of constructor method

	/**
	 * Contructs a Date object with the provided date.
	 *
	 * @param year The year.
	 * @param month The month.
	 * @param day The day.
	 *
	 * @since 1.0.0
	 */
	public Date(int year, Month month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}//End of constructor method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of year.
	 *
	 * @return The value of year.
	 */
	public int getYear()
	{
		return this.year;
	}//End of getYear method

	/**
	 * Gets the value of month.
	 *
	 * @return The value of month.
	 */
	public Month getMonth()
	{
		return this.month;
	}//End of getMonth method

	/**
	 * Gets the value of day.
	 *
	 * @return The value of day.
	 */
	public int getDay()
	{
		return this.day;
	}//End of getDay method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of year.
	 *
	 * @param year The new value for year.
	 */
	public void setYear(int year)
	{
		this.year = year;
	}//End of setYear method

	/**
	 * Sets the value of month.
	 *
	 * @param month The new value for month.
	 */
	public void setMonth(Month month)
	{
		this.month = month;
	}//End of setMonth method

	/**
	 * Sets the value of day.
	 *
	 * @param day The new value for day.
	 */
	public void setDay(int day)
	{
		this.day = day;
	}//End of setDay method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/

	/**
	 * Compares this date object to another.
	 *
	 * @since 1.0.0
	 * @todo
	 */
	public int compareTo(Object object)
	{
		if (object instanceof Date)
		{
			Date date = (Date)object;

			if (this.year > date.getYear())
				return 1;
			else if (this.year < date.getYear())
				return -1;
			else
			{
				if (this.month.ordinal() > date.getMonth().ordinal())
					return 1;
				else if (this.month.ordinal() < date.getMonth().ordinal())
					return -1;
				else
				{
					if (this.day > date.getDay())
						return 1;
					else if (this.day < date.getDay())
						return -1;
					else
						return 0;
				}
			}
		}
		else
			return 0;
	}//End of compareTo method

	/**
	 * Returns the Date object expressed as a String.
	 *
	 * @returns A String representation of this date object.
	 * @since 1.0.0
	 */
	public String toString()
	{
		String date = "";

		//Get the month, capitalizing only the first letter
		date += String.valueOf(this.month.toString().charAt(0));
		date += this.month.toString().substring(1).toLowerCase();

		date += " " + String.valueOf(this.day) + ", " + String.valueOf(this.year);

		return date;
	}//End of toString method
}//End of class