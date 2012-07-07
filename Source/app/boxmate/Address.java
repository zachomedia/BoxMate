package app.boxmate;

/**
 * Stores a municipal address.
 *
 * CHANGES:
 *		June 19, 2012 (Jonathan):
 *			- Added a parseAddress method.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class Address
 {
	/**
	 * The house number.
	 *
	 * @since 1.0.0
	 */
	private int houseNumber;

	/**
	 * The street name.
	 *
	 * @since 1.0.0
	 */
	private String streetName;

	/**
	 * The street sufix (Ex. Street).
	 *
	 * @since 1.0.0
	 */
	private String streetSuffix;

	/**
	 * The city.
	 *
	 * @since 1.0.0
	 */
	private String city;

	/**
	 * The province.
	 *
	 * @since 1.0.0
	 */
	private String province;

	/**
	 * The country.
	 *
	 * @since 1.0.0
	 */
	private String country;

	/**
	 * The postal code (or ZIP Code if you are in the United States).
	 *
	 * @since 1.0.0
	 */
	private String postalCode;

	/**
	 * Default constructor for an Address object.
	 *
	 * @since 1.0.0
	 */
	public Address()
	{
		//Intialize all the instance variables.
		this.houseNumber = 0;
		this.streetName = "";
		this.streetSuffix = "";
		this.city = "";
		this.province = "";
		this.country = "";
		this.postalCode = "";
	}//End of constructor method

	/**
	 * Constructs a Address number with all the provided information.
	 *
	 * @param houseNumber The house number.
	 * @param streetName The street name.
	 * @param streetSuffix The street suffix.
	 * @param city The city.
	 * @param province The province.
	 * @param country The country.
	 * @param postalCode The postal code.
	 *
	 * @since 1.0.0
	 */
	public Address(int houseNumber, String streetName, String streetSuffix, String city, String province, String country, String postalCode)
	{
		//Intialize all the instance variables.
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.streetSuffix = streetSuffix;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
	}//End of constructor method


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of houseNumber.
	 *
	 * @return The value of houseNumber.
	 */
	public int getHouseNumber()
	{
		return this.houseNumber;
	}//End of getHouseNumber method

	/**
	 * Gets the value of streetName.
	 *
	 * @return The value of streetName.
	 */
	public String getStreetName()
	{
		return this.streetName;
	}//End of getStreetName method

	/**
	 * Gets the value of streetSuffix.
	 *
	 * @return The value of streetSuffix.
	 */
	public String getStreetSuffix()
	{
		return this.streetSuffix;
	}//End of getStreetSufix method

	/**
	 * Gets the value of city.
	 *
	 * @return The value of city.
	 */
	public String getCity()
	{
		return this.city;
	}//End of getCity method

	/**
	 * Gets the value of province.
	 *
	 * @return The value of province.
	 */
	public String getProvince()
	{
		return this.province;
	}//End of getProvince method

	/**
	 * Gets the value of country.
	 *
	 * @return The value of country.
	 */
	public String getCountry()
	{
		return this.country;
	}//End of getCountry method

	/**
	 * Gets the value of postalCode.
	 *
	 * @return The value of postalCode.
	 */
	public String getPostalCode()
	{
		return this.postalCode;
	}//End of getPostalCode method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of houseNumber.
	 *
	 * @param houseNumber The new value for houseNumber.
	 */
	public void setHouseNumber(int houseNumber)
	{
		this.houseNumber = houseNumber;
	}//End of setHouseNumber method

	/**
	 * Sets the value of streetName.
	 *
	 * @param streetName The new value for streetName.
	 */
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}//End of setStreetName method

	/**
	 * Sets the value of streetSuffix.
	 *
	 * @param streetSufix The new value for streetSuffix.
	 */
	public void setStreetSuffix(String streetSuffix)
	{
		this.streetSuffix = streetSuffix;
	}//End of setStreetSuffix method

	/**
	 * Sets the value of city.
	 *
	 * @param city The new value for city.
	 */
	public void setCity(String city)
	{
		this.city = city;
	}//End of setCity method

	/**
	 * Sets the value of province.
	 *
	 * @param province The new value for province.
	 */
	public void setProvince(String province)
	{
		this.province = province;
	}//End of setProvince method

	/**
	 * Sets the value of country.
	 *
	 * @param country The new value for country.
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}//End of setCountry method

	/**
	 * Sets the value of postalCode.
	 *
	 * @param postalCode The new value for postalCode.
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}//End of setPostalCode method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/

	/**
	 * Parses the string argument as an <code>Address</code> object.
	 *
	 * @param s The string to be parsed
	 * @return The <code>Address</code> represented by the argument.
	 * @since 1.0.0
	 */
	 public static Address parseAddress(String s)
	 {
	 	Address address = new Address();

    	String [] splitAddress = s.split("'");

		address.setHouseNumber(Integer.parseInt(splitAddress[1]));
		address.setStreetName(splitAddress[3]);
		address.setStreetSuffix(splitAddress[5]);
		address.setCity(splitAddress[7]);
		address.setProvince(splitAddress[9]);
		address.setCountry(splitAddress[11]);
		address.setPostalCode(splitAddress[13]);

	 	return address;
	 }//End of parseAddress method

	/**
	 * Returns the address in standard notation
	 *
	 * @return The normalized address.
	 *
	 * @since 1.0.0
	 */
	public String normalize()
	{
		//Declare and intialize a variable
		String address = "";

		//Create the String representation
		address += this.houseNumber + " " + this.streetName + " " + this.streetSuffix + ", ";
		address += this.city + ", " + this.province + ", " + this.country + " ";
		address += this.postalCode;

		//Return the String representation
		return address;
	}//End of normalize method

	/**
	 * Returns a String representation of the address.
	 *
	 * @return The Address object respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String address = "";

		//Create the String representation
		address += "[";

		address += "HOUSE NUMBER : '" + this.houseNumber + "', ";
		address += "STREET NAME : '" + this.streetName + "', ";
		address += "STREET SUFFIX : '" + this.streetSuffix + "', ";
		address += "CITY : '" + this.city + "', ";
		address += "PROVINCE : '" + this.province + "', ";
		address += "COUNTRY : '" + this.country + "', ";
		address += "POSTAL CODE : '" + this.postalCode + "'";

		address += "]";

		//Return the String representation
		return address;
	}//End of toString method
 }//End of class