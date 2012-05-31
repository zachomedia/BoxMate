package app.boxmate;

/**
 * Stores a standard phone number.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class PhoneNumber
 {
	/**
	 * The area code.
	 *
	 * @since 1.0.0
	 */
	private int areaCode;

	/**
	 * The prefix number (First 3 digits after area code).
	 *
	 * @since 1.0.0
	 */
	private int prefix;

	/**
	 * The line number (Last 4 digits of phone number).
	 *
	 * @since 1.0.0
	 */
	private int lineNumber;

	/**
	 * Default constructor for a PhoneNumber object.
	 *
	 * @since 1.0.0
	 */
	public PhoneNumber()
	{
		//Intialize all the instance variables.
		this.areaCode = 0;
		this.prefix = 0;
		this.lineNumber = 0;
	}//End of constructor method

	/**
	 * Constructs a PhoneNumber object with all the provided information.
	 *
	 * @param areaCode The area code.
	 * @param prefix The prefix.
	 * @param lineNumber The line number.
	 *
	 * @since 1.0.0
	 */
	public PhoneNumber(int areaCode, int prefix, int lineNumber)
	{
		//Intialize all the instance variables.
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}//End of constructor method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of areaCode.
	 *
	 * @return The value of areaCode.
	 */
	public int getAreaCode()
	{
		return this.areaCode;
	}//End of getAreaCode method

	/**
	 * Gets the value of prefix.
	 *
	 * @return The value of prefix.
	 */
	public int getPrefix()
	{
		return this.prefix;
	}//End of getPrefix method

	/**
	 * Gets the value of lineNumber.
	 *
	 * @return The value of lineNumber.
	 */
	public int getLineNumber()
	{
		return this.lineNumber;
	}//End of getLineNumber method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of areaCode.
	 *
	 * @param areaCode The new value for areaCode.
	 */
	public void setAreaCode(int areaCode)
	{
		this.areaCode = areaCode;
	}//End of setAreaCode method

	/**
	 * Sets the value of prefix.
	 *
	 * @param prefix The new value for prefix.
	 */
	public void setPrefix(int prefix)
	{
		this.prefix = prefix;
	}//End of setPrefix method

	/**
	 * Sets the value of lineNumber.
	 *
	 * @param lineNumber The new value for lineNumber.
	 */
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}//End of setLineNumber method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/**
	 * Returns a String representation of the phone number.
	 *
	 * @return The phone number respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String phoneNumber = "";

		//Create the String representation
		phoneNumber += "(" + String.valueOf(this.areaCode) + ") ";
		phoneNumber += String.valueOf(this.prefix) + "-";
		phoneNumber += String.valueOf(this.lineNumber);

		//Return the String representation
		return phoneNumber;
	}//End of toString method
 }//End of class