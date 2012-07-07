package app.run;

import app.boxmate.*;
import app.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows the GUI required to edit customer information.
 *
 * CHANGES:
 *		June 19, 2012 (Jonathan):
 *			- Made the city field save properly.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (4/6/2012)
 * @since 1.0.0
 */
public class NewCustomer extends JFrame implements ActionListener
{
	//Declare and initialize constants
	private final String [] PROVINCES = {"Ontario", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};

	//Declare GUI components
	private JPanel customerInformationPanel;
		private JTextField txtFirstName;
		private JTextField txtLastName;
		private JTextField txtAddressHouseNumber;
		private JTextField txtAddressStreet;
		private JTextField txtAddressStreetSuffix;
		private JTextField txtAddressCity;
		private JComboBox cboAddressProvince;
		private JTextField txtAddressPostalCode;
		private JTextField txtPhoneAreaCode;
		private JTextField txtPhonePrefix;
		private JTextField txtPhoneLine;
		private JTextField txtEmailAddress;
		private JTextField txtEmailAddressDomain;
		private JTextField txtEmailAddressTLD;

	private JPanel buttonsPanel;
		private JButton cmdDone;
		private JButton cmdCancel;

	/**
	 * Creates the GUI.
	 *
	 * @since 1.0.0
	 */
    public NewCustomer()
    {
    	if (Session.loggedIn)
		{
			//Initialize the GUI
			this.initializeGUI();

			//Setup the JFrame
			this.setTitle("New Customer | " + Application.NAME);
			this.setSize(800, 340);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			this.setVisible(true);
		}//End of if
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to create a new customer.", Application.NAME, JOptionPane.ERROR_MESSAGE);
    }//End of constructor

    /**
	 * Initialize the GUI components.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the customer information panel
		this.customerInformationPanel = new JPanel(new GridLayout(3, 1));
		this.customerInformationPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Customer"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Intialize all the customer information GUI components
		this.txtFirstName = new JTextField(15);
		this.txtLastName = new JTextField(15);
		this.txtAddressHouseNumber = new JTextField(5);
		this.txtAddressStreet = new JTextField(15);
		this.txtAddressStreetSuffix = new JTextField(5);
		this.txtAddressCity = new JTextField(15);
		this.cboAddressProvince = new JComboBox(PROVINCES);
		this.txtAddressPostalCode = new JTextField(8);
		this.txtPhoneAreaCode = new JTextField(3);
		this.txtPhonePrefix = new JTextField(3);
		this.txtPhoneLine = new JTextField(4);
		this.txtEmailAddress = new JTextField(13);
		this.txtEmailAddressDomain = new JTextField(13);
		this.txtEmailAddressTLD = new JTextField(6);

		//Add all the customer information GUI components and their labels to the custome information panel
		JPanel firstRow = new JPanel(new GridLayout(2, 2, 5, 5));
		firstRow.add(new JLabel("First Name"));
		firstRow.add(new JLabel("Last Name"));
		firstRow.add(this.txtFirstName);
		firstRow.add(this.txtLastName);

		this.customerInformationPanel.add(firstRow);

		JPanel secondRow = new JPanel(new GridLayout(2, 3, 5, 5));
		secondRow.add(new JLabel("Address"));
		secondRow.add(new JLabel("City, Province"));
		secondRow.add(new JLabel("Postal Code"));

		JPanel addressFields = new JPanel(new BorderLayout());
		addressFields.add(this.txtAddressHouseNumber, BorderLayout.WEST);
		addressFields.add(this.txtAddressStreet, BorderLayout.CENTER);
		addressFields.add(this.txtAddressStreetSuffix, BorderLayout.EAST);

		secondRow.add(addressFields);

		JPanel cityProvinceFields = new JPanel(new GridLayout(1, 2, 5, 5));
		cityProvinceFields.add(this.txtAddressCity);
		cityProvinceFields.add(this.cboAddressProvince);

		secondRow.add(cityProvinceFields);

		secondRow.add(this.txtAddressPostalCode);

		this.customerInformationPanel.add(secondRow);

		JPanel thirdRow = new JPanel(new GridLayout(2, 2, 5, 5));

		thirdRow.add(new JLabel("Phone Number"));
		thirdRow.add(new JLabel("Email Address"));

		JPanel phoneNumberFields = new JPanel(new FlowLayout());

		phoneNumberFields.add(new JLabel("("));
		phoneNumberFields.add(this.txtPhoneAreaCode);
		phoneNumberFields.add(new JLabel(") "));
		phoneNumberFields.add(this.txtPhonePrefix);
		phoneNumberFields.add(new JLabel("-"));
		phoneNumberFields.add(this.txtPhoneLine);

		thirdRow.add(phoneNumberFields);

		JPanel emailFields = new JPanel(new FlowLayout());

		emailFields.add(this.txtEmailAddress);
		emailFields.add(new JLabel("@"));
		emailFields.add(this.txtEmailAddressDomain);
		emailFields.add(new JLabel("."));
		emailFields.add(this.txtEmailAddressTLD);

		thirdRow.add(emailFields);

		this.customerInformationPanel.add(thirdRow);

		//Buttons Panel
		this.buttonsPanel = new JPanel(new GridLayout(1, 6, 5, 5));

		this.cmdDone = new JButton("Done");
		this.cmdDone.addActionListener(this);
		this.cmdCancel = new JButton("Cancel");
		this.cmdCancel.addActionListener(this);

		this.buttonsPanel.add(this.cmdCancel);
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(this.cmdDone);

		//Setup the frame layout manager
		SpringLayout layout = new SpringLayout();

		this.getContentPane().setLayout(layout);

		layout.putConstraint(SpringLayout.NORTH, this.customerInformationPanel, 20, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.customerInformationPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.customerInformationPanel, 20, SpringLayout.WEST, this.getContentPane());

		layout.putConstraint(SpringLayout.NORTH, this.buttonsPanel, 265, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.buttonsPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.buttonsPanel, 20, SpringLayout.WEST, this.getContentPane());

		//Add the panels to the frame
		this.add(this.customerInformationPanel);
		this.add(this.buttonsPanel);
	}//End of initializeGUI method

	/**
	 * Invoked when an action occurs.
	 *
	 * @param evt The event which occured.
	 * @since 1.0.0
	 */
	public void actionPerformed(ActionEvent evt)
	{
		Object trigerObject = evt.getSource();

		if (trigerObject == this.cmdDone)
			createNewUser();
		else if (trigerObject == this.cmdCancel)
			this.dispose();
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method

	/**
	 * Creates a new <code>Customer</code> object to...
	 *
	 * @since 1.0.0
	 */
	private void createNewUser()
	{
		Customer customer = new Customer();
		Address address = new Address();
		PhoneNumber phone = new PhoneNumber();
		String email = "";

		if (txtFirstName.getText().length() != 0)
			customer.setFirstName(txtFirstName.getText());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the customer's first name.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		if (txtLastName.getText().length() != 0)
			customer.setLastName(txtLastName.getText());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the customer's last name.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		try
		{
			if (txtAddressHouseNumber.getText().length() != 0)
				address.setHouseNumber(Integer.parseInt(txtAddressHouseNumber.getText()));
			else
			{
				JOptionPane.showMessageDialog(this, "Please enter the house number.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

				return;
			}//End of else
		}//End of try
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured processing the house number.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of catch

		if (txtAddressStreet.getText().length() != 0)
			address.setStreetName(txtAddressStreet.getText());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the street name.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		if (txtAddressStreetSuffix.getText().length() != 0)
			address.setStreetSuffix(txtAddressStreetSuffix.getText());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the street suffix.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		if (txtAddressCity.getText().length() != 0)
			address.setCity(txtAddressCity.getText());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the city.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		address.setProvince((String)cboAddressProvince.getSelectedItem());

		if (txtAddressPostalCode.getText().length() != 0)
			address.setPostalCode(txtAddressPostalCode.getText().toUpperCase());
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter the postal code.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		if (txtPhoneAreaCode.getText().length() == 3 && txtPhonePrefix.getText().length() == 3 && txtPhoneLine.getText().length() == 4)
		{
			phone.setAreaCode(Integer.parseInt(txtPhoneAreaCode.getText()));
			phone.setPrefix(Integer.parseInt(txtPhonePrefix.getText()));
			phone.setLineNumber(Integer.parseInt(txtPhoneLine.getText()));
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter a valid phone number.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		if (txtEmailAddress.getText().length() != 0 && txtEmailAddressDomain.getText().length() != 0 && txtEmailAddressTLD.getText().length() != 0)
			email = txtEmailAddress.getText() + "@" + txtEmailAddressDomain.getText() + "." + txtEmailAddressTLD.getText();
		else
		{
			JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}//End of else

		customer.setAddress(address);
		customer.setEmailAddress(email);
		customer.setPhoneNumber(phone);

		//Create username and password
		customer.setUsername(customer.getFirstName().toLowerCase() + "." + customer.getLastName().toLowerCase());
		try
		{
			customer.setPassword(PasswordEncryption.hashPassword(customer.getUsername(), "NoPasswordExists"));
		}
		catch (Exception e)
		{
			customer.setPassword(new byte[0]);
		}

		//Temporary output
		System.out.println(customer.toString());

		//Add the user to the database
		try
		{
			Database database = new Database();
			database.writeUser(customer);

			JOptionPane.showMessageDialog(this, "Customer saved properly.",Application.NAME, JOptionPane.PLAIN_MESSAGE);
			this.dispose();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured adding the user. If this problem continues, please contact your system administrator.", "Customer Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}
	}//End of createNewUser method
}//End of class