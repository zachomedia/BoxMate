package app.run;

import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows the GUI required to create a new ticket.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (4/6/2012)
 * @since 1.0.0
 */
public class NewTicket extends JFrame
{
	//Declare and initialize constants
	private final int PADDING_SIZE = 10;
	private final String [] PROVINCES = {"Ontario", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nortwest Territories", "Nova Scotia", "Nunavut", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};

	//Declare GUI components.
	private JPanel customerInformationPanel;
		private JTextField txtFirstName;
		private JTextField txtLastName;
		private JTextField txtAddressHouseNumber;
		private JTextField txtAddressStreet;
		private JTextField txtAddressStreetSufix;
		private JTextField txtAddressCity;
		private JComboBox cboAddressProvince;
		private JTextField txtAddressPostalCode;
		private JTextField txtPhoneAreaCode;
		private JTextField txtPhonePrefix;
		private JTextField txtPhoneLine;
		private JTextField txtEmailAddress;
		private JTextField txtEmailAddressDomain;
		private JTextField txtEmailAddressTLD;

	/**
	 * Creates the GUI.
	 *
	 * @since 1.0.0
	 */
	public NewTicket()
	{
		//Setup the GUI
		this.setTitle("New Ticket | " + Application.NAME);
		this.setSize(800, 400);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.initializeGUI();

		this.setVisible(true);
	}//End of constructor

	/**
	 * Initialize the GUI components.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the customer information panel
		this.customerInformationPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		this.customerInformationPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Customer"), BorderFactory.createEmptyBorder(PADDING_SIZE,PADDING_SIZE,PADDING_SIZE,PADDING_SIZE)));

		//Intialize all the customer information GUI components
		this.txtFirstName = new JTextField(15);
		this.txtLastName = new JTextField(15);
		this.txtAddressHouseNumber = new JTextField(3);
		this.txtAddressStreet = new JTextField(15);
		this.txtAddressStreetSufix = new JTextField(5);
		this.txtAddressCity = new JTextField(15);
		this.cboAddressProvince = new JComboBox(PROVINCES);
		this.txtAddressPostalCode = new JTextField(8);
		this.txtPhoneAreaCode = new JTextField(3);
		this.txtPhonePrefix = new JTextField(3);
		this.txtPhoneLine = new JTextField(3);
		this.txtEmailAddress = new JTextField(10);
		this.txtEmailAddressDomain = new JTextField(10);
		this.txtEmailAddressTLD = new JTextField(6);

		//Setings for the above GUI components
		this.cboAddressProvince.setEditable(false);

		//Add all the customer information GUI components and their labels to the custome information panel
		JPanel firstRow = new JPanel(new GridLayout(2, 2, 5, 5));
		firstRow.add(new JLabel("First Name"));
		firstRow.add(new JLabel("Last Name"));
		firstRow.add(this.txtFirstName);
		firstRow.add(this.txtLastName);

		this.customerInformationPanel.add(firstRow);

		JPanel secondRow = new JPanel(new GridLayout(2, 3, 5, 2));
		secondRow.add(new JLabel("Address"));
		secondRow.add(new JLabel("City, Province"));
		secondRow.add(new JLabel("Postal Code"));

		JPanel addressFields = new JPanel(new BorderLayout());
		addressFields.add(this.txtAddressHouseNumber, BorderLayout.WEST);
		addressFields.add(this.txtAddressStreet, BorderLayout.CENTER);
		addressFields.add(this.txtAddressStreetSufix, BorderLayout.EAST);

		secondRow.add(addressFields);

		JPanel cityProvinceFields = new JPanel(new GridLayout(1, 2, 1, 1));
		cityProvinceFields.add(this.txtAddressCity);
		cityProvinceFields.add(this.cboAddressProvince);

		secondRow.add(cityProvinceFields);

		secondRow.add(this.txtAddressPostalCode);

		this.customerInformationPanel.add(secondRow);

		JPanel thirdRow = new JPanel(new GridLayout(2, 2, 5, 5));

		thirdRow.add(new JLabel("Phone Number"));
		thirdRow.add(new JLabel("Email Address:"));

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

		//Add the panels to the frame
		this.add(this.customerInformationPanel);

	}//End of initializeGUI method
}//End of class