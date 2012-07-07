package app.boxmate;

import java.util.Calendar;

/**
 * Stores a time.
 *
 * UPDATES:
 *		June 13 (Jonathan):
 *			- Implemented compareTo method.
 *		June 19 (Jonathan):
 *			- Implemented parseTime method.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (12/06/2012)
 * @since 1.0.0
 */
public class Time
{
	/**
	 * Stores the hour.
	 *
	 * @since 1.0.0
	 */
	private int hour;

	/**
	 * Stores the minute.
	 *
	 * @since 1.0.0
	 */
	private int minute;

	/**
	 * Constructs a Time object, using the current time.
	 *
	 * @since 1.0.0
	 */
	public Time()
	{
		//Get the current date
		Calendar today = Calendar.getInstance();

		this.hour = today.get(Calendar.HOUR);
		this.minute = today.get(Calendar.MINUTE);
	}//End of constructor method

	/**
	 * Contructs a Time object with the provided time.
	 *
	 * @param year The year.
	 * @param month The month.
	 * @param day The day.
	 *
	 * @since 1.0.0
	 */
	public Time(int hour, int minute)
	{
		this.hour = hour;
		this.minute = minute;
	}//End of constructor method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of hour.
	 *
	 * @return The value of hour.
	 */
	public int getHour()
	{
		return this.hour;
	}//End of getHour method

	/**
	 * Gets the value of minute.
	 *
	 * @return The value of minute.
	 */
	public int getMinute()
	{
		return this.minute;
	}//End of getMinute method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of hour.
	 *
	 * @param hour The new value for hour.
	 */
	public void setHour(int hour)
	{
		this.hour = hour;
	}//End of setHour method

	/**
	 * Sets the value of minute.
	 *
	 * @param minute The new value for minute.
	 */
	public void setMinute(int minute)
	{
		this.minute = minute;
	}//End of setMinute method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/

	/**
	 * Compares this time object to another.
	 *
	 * @since 1.0.0
	 * @todo
	 */
	public int compareTo(Object object)
	{
		if (object instanceof Time)
		{
			Time time = (Time)object;

			if (this.hour > time.getHour())
				return 1;
			else if (this.hour < time.getHour())
				return -1;
			else
			{
				if (this.minute > time.getMinute())
					return 1;
				else if (this.minute < time.getMinute())
					return -1;
				else
					return 0;
			}
		}
		else
			return 0;
	}//End of compareTo method

	/**
	 * Parses the string argument as a <code>Time</code> object.
	 *
	 * @param s The string to be parsed
	 * @return The <code>Time</code> represented by the argument.
	 * @since 1.0.0
	 */
	 public static Time parseTime(String s)
	 {
	 	Time time = new Time();

	 	String [] parts = s.split(":");

	 	time.setHour(Integer.parseInt(parts[0]));
	 	time.setMinute(Integer.parseInt(parts[1]));

	 	return time;
	 }//End of parseTime method

	/**
	 * Returns the Time object expressed as a String.
	 *
	 * @returns A String representation of this time object.
	 * @since 1.0.0
	 */
	public String toString()
	{
		String time = "";
		String minute = String.valueOf(this.minute);

		if (minute.length() < 2)
			minute = "0" + minute;

		time += String.valueOf(this.hour) + ":" + minute;

		return time;
	}//End of toString method
}//End of class