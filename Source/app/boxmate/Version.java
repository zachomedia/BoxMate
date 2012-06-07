package app.boxmate;

/**
 * Stores a version number. Stores Major, Minor and Revision.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class Version
 {
	/**
	 * The major number.
	 *
	 * @since 1.0.0
	 */
	private int major;

	/**
	 * The minor number.
	 *
	 * @since 1.0.0
	 */
	private int minor;

	/**
	 * The revision number.
	 *
	 * @since 1.0.0
	 */
	private int revision;

	/**
	 * Constructs a Version number with major 0, minor 0, revision 0.
	 *
	 * @since 1.0.0
	 */
	public Version()
	{
		//Intialize all the instance variables.
		this.major = 0;
		this.minor = 0;
		this.revision = 0;
	}//End of constructor method

	/**
	 * Constructs a Version number with the provided version number.
	 *
	 * @param major The major number.
	 * @param minor The minor number.
	 * @param revision The revision number
	 *
	 * @since 1.0.0
	 */
	public Version(int major, int minor, int revision)
	{
		//Intialize all the instance variables.
		this.major = major;
		this.minor = minor;
		this.revision = revision;
	}//End of constructor method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of major.
	 *
	 * @return The value of major.
	 */
	public int getMajor()
	{
		return this.major;
	}//End of getMajor method

	/**
	 * Gets the value of minor.
	 *
	 * @return The value of minor.
	 */
	public int getMinor()
	{
		return this.minor;
	}//End of getMinor method

	/**
	 * Gets the value of revision.
	 *
	 * @return The value of revision.
	 */
	public int getRevision()
	{
		return this.revision;
	}//End of getRevision method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of major.
	 *
	 * @param major The new value for major.
	 */
	public void setMajor(int major)
	{
		this.major = major;
	}//End of setMajor method

	/**
	 * Sets the value of minor.
	 *
	 * @param minor The new value for minor.
	 */
	public void setMinor(int minor)
	{
		this.minor = minor;
	}//End of setMinor method

	/**
	 * Sets the value of revision.
	 *
	 * @param revision The new value for revision.
	 */
	public void setRevision(int revision)
	{
		this.revision = revision;
	}//End of setRevision method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/**
	 * Returns the version number as a String. Returns in the format of MAJOR.MINOR.REVISION.
	 *
	 * @return The Applicaion class respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String version = "";

		//Create the String representation
		version += String.valueOf(major) + ".";
		version += String.valueOf(minor) + ".";
		version += String.valueOf(revision);

		//Return the String representation
		return version;
	}//End of toString method
 }//End of class