package app.boxmate;

/**
 * Stores information about a credit card.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class CreditCard
 {
	/**
	 * The credit card number.
	 *
	 * @since 1.0.0
	 */
	private long number;

	/**
	 * The security code number. (Usually located on the rear of a credit card).
	 *
	 * @since 1.0.0
	 */
	private int securityCode;

	/**
	 * Default constructor for a CreditCard object.
	 *
	 * @since 1.0.0
	 */
	public CreditCard()
	{
		//Intialize all the instance variables.
		this.number = 0;
		this.securityCode = 0;
	}//End of constructor method

	/**
	 * Constructs a CreditCard object with all the provided information.
	 *
	 * @param number The number of the credit card.
	 * @param securityCode The security code of the credit card.
	 *
	 * @since 1.0.0
	 */
	public CreditCard(long number, int securityCode)
	{
		//Intialize all the instance variables.
		this.number = number;
		this.securityCode = securityCode;
	}//End of constructor method


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of number.
	 *
	 * @param number The new value for number.
	 */
	public void setNumber(long number)
	{
		this.number = number;
	}//End of setNumber method

	/**
	 * Sets the value of securityCode.
	 *
	 * @param securityCode The new value for securityCode.
	 */
	public void setSecurityCode(int securityCode)
	{
		this.securityCode = securityCode;
	}//End of setSecurityCode method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of number.
	 *
	 * @return The value of number.
	 */
	public long getNumber()
	{
		return this.number;
	}//End of getNumber method

	/**
	 * Gets the value of securityCode.
	 *
	 * @return The value of securityCode.
	 */
	public int getSecurityCode()
	{
		return this.securityCode;
	}//End of getSecurityCode method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/**
	 * Returns a String representation of the credit card.
	 *
	 * @return The credit card respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String creditCard = "";

		//Create the String representation
		creditCard += "[";

		creditCard += "number : '" + String.valueOf(this.number) + "', ";
		creditCard += "securityCode : '" + String.valueOf(this.securityCode) + "'";

		creditCard += "]";

		//Return the String representation
		return creditCard;
	}//End of toString method
 }//End of class