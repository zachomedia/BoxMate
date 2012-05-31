package app.boxmate;

/**
 * Stores a municipal address.
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
	private String streetSufix;
	
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
		this.streetSufix = "";
		this.province = "";
		this.country = "";
		this.postalCode = "";
	}//End of constructor method
	
	/**
	 * Constructs a Address number with all the provided information.
	 *
	 * @param houseNumber The house number.
	 * @param streetName The street name.
	 * @param streetSufix The street sufix.
	 * @param province The province.
	 * @param country The country.
	 * @param postalCode The postal code.
	 *
	 * @since 1.0.0
	 */
	public Address(int houseNumber, String streetName, String streetSufix, String province, String country, String postalCode)
	{
		//Intialize all the instance variables.
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.streetSufix = streetSufix;
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
	 * Gets the value of streetSufix.
	 *
	 * @return The value of streetSufix.
	 */
	public String getStreetSufix()
	{
		return this.streetSufix;
	}//End of getStreetSufix method
	
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
	 * Sets the value of streetSufix.
	 *
	 * @param streetSufix The new value for streetSufix.
	 */
	public void setStreetSufix(String streetSufix)
	{
		this.streetSufix = streetSufix;
	}//End of setStreetSufix method
	
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
		address += "STREET SUFIX : '" + this.streetSufix + "', ";
		address += "PROVINCE : '" + this.province + "', ";
		address += "COUNTRY : '" + this.country + "', ";
		address += "POSTAL CODE : '" + this.postalCode + "'";
		
		address += "]";

		//Return the String representation
		return address;
	}//End of toString method
 }//End of class