package app.boxmate;

/**
 * An employee.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
 public class Employee extends User
 {
	/**
	 * The employees's employee ID.
	 *
	 * @since 1.0.0
	 */
	private int employeeID;

	/**
	 * The company the employee works for.
	 *
	 * @since 1.0.0
	 */
	private String company;

	/**
	 * The employees's position.
	 *
	 * @since 1.0.0
	 */
	private String position;

	/**
	 * Default constructor for an Employee object.
	 *
	 * @since 1.0.0
	 */
	public Employee()
	{
		//Call the parent class's constructor.
		super();

		//Intialize all the instance variables.
		this.employeeID = 0;
		this.company = "";
		this.position = "";
	}//End of constructor method

	/**
	 * Constructs an Employee object with all the provided information.
	 *
	 * @param username The employee's username.
	 * @param password The employee's password.
	 * @param accountLevel The employee's accountLevel.
	 * @param firstName The employee's first name.
	 * @param lastName The employee's last name.
	 * @param address The employee's address.
	 * @param emailAddress The employee's email address.
	 * @param phoneNumber The employee's phone number.
	 * @param employeeID The employee's employee ID.
	 * @param company The company the employee works for.
	 * @param position The employee's position.
	 *
	 * @since 1.0.0
	 */
	public Employee(String username, byte [] password, int accountLevel, String firstName, String lastName, Address address, String emailAddress, PhoneNumber phoneNumber, int employeeID, String company, String position)
	{
		//Call the parent class' constructor.
		super(username, password, accountLevel, firstName, lastName, address, emailAddress, phoneNumber);

		//Initialize all the fields
		this.employeeID = employeeID;
		this.company = company;
		this.position = position;
	}//End of constructor


	/********************
	 * ACCESSOR METHODS *
	 ********************/

	/**
	 * Gets the value of employeeID.
	 *
	 * @return The value of employeeID.
	 */
	public int getEmployeeID()
	{
		return this.employeeID;
	}//End of getEmployeeID method

	/**
	 * Gets the value of company.
	 *
	 * @return The value of company.
	 */
	public String getCompany()
	{
		return this.company;
	}//End of getCompany method

	/**
	 * Gets the value of position.
	 *
	 * @return The value of position.
	 */
	public String getPosition()
	{
		return this.position;
	}//End of getPosition method

	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/


	/*******************
	 * MUTATOR METHODS *
	 *******************/

	/**
	 * Sets the value of employeeID.
	 *
	 * @param employeeID The new value for employeeID.
	 */
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}//End of setEmployeeID method

	/**
	 * Sets the value of company.
	 *
	 * @param company The new value for company.
	 */
	public void setCompany(String company)
	{
		this.company = company;
	}//End of setCompany method

	/**
	 * Sets the value of position.
	 *
	 * @param position The new value for position.
	 */
	public void setPosition(String position)
	{
		this.position = position;
	}//End of setPosition method

	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/**
	 * Returns a String representation of the customer.
	 *
	 * @return The customer respresented as a String.
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		//Declare and intialize a variable
		String employee = "";

		//Create the String representation
		employee += "[";

		employee += "username : '" + this.username + "', ";
		employee += "password : '" + this.password + "', ";
		employee += "accountLevel : '" + String.valueOf(this.accountLevel) + "', ";
		employee += "firstName : '" + this.firstName + "', ";
		employee += "lastName : '" + this.lastName + "', ";
		employee += "address : '" + this.address.toString() + "', ";
		employee += "emailAddress : '" + this.emailAddress + "', ";
		employee += "phoneNumber : '" + this.phoneNumber.toString() + "', ";
		employee += "employeeID : '" + String.valueOf(this.employeeID) + "', ";
		employee += "company : '" + this.company + "', ";
		employee += "position : '" + this.position + "'";

		employee += "]";

		//Return the String representation
		return employee;
	}//End of toString method
 }//End of class