package app.boxmate;

/**
 * Stores information relevant to the application.
 * All information stored here is Static, and must be changed in the source code.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public final class Application
 {
	/**
	 * The name of the application.
	 *
	 * @since 1.0.0
	 */
	public final static String NAME = "BoxMate";

	/**
	 * The description of the application.
	 *
	 * @since 1.0.0
	 */
	public final static String DESCRIPTION = "";

	/**
	 * The author(s) of the application.
	 *
	 * @since 1.0.0
	 */
	public final static String AUTHOR = "Zachary Seguin and Jonathan Tan";

	/**
	 * The version of the application.
	 *
	 * @since 1.0.0
	 */
	public final static Version VERSION = new Version(1, 0, 0);

	/**
	 * The copyright text of the application.
	 *
	 * @since 1.0.0
	 */
	public final static String COPYRIGHT = "Copyright 2012 - " + AUTHOR;

	/**
	 * Returns the Application class as a String.
	 *
	 * @return The Applicaion class respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String application = "";

		//Create the String representation
		application += "[";

		application += "NAME : '" + NAME + "', ";
		application += "DESCRIPTION : '" + DESCRIPTION + "', ";
		application += "AUTHOR : '" + AUTHOR + "', ";
		application += "VERSION : '" + VERSION.toString() + "', ";
		application += "COPYRIGHT : '" + COPYRIGHT + "'";

		application += "]";

		//Return the String representation
		return application;
	}//End of toString method
 }//End of class