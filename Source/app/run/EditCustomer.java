package app.run;

import app.boxmate.*;
import app.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.util.*;
/**
 * Shows the GUI required to edit customer information.
 *
 * CHANGES:
 *		June 18, 2012 (Jonathan):
 *			- Added JTable.  Finishing adding all the GUI components.
 *		June 19, 2012 (Jonathan):
 *			- Fixed an error with city field not appearing correctly.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (4/6/2012)
 * @since 1.0.0
 */
public class EditCustomer extends JFrame implements ActionListener
{
	//Declare and initialize constants
	private final String [] PROVINCES = {"Ontario", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon"};
	private final String [] COLUMN_HEADERS = {"Customer ID", "Show ID", "Showing ID", "Row", "Seat"};

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

	private JPanel purchasedTicketsPanel;
		private JTable table;
		private JScrollPane scrollPane;

	private JPanel buttonsPanel;
		private JButton cmdNewTicket;
		private JButton cmdDone;
		private JButton cmdDelete;
		private JButton cmdCancel;

	//Declare variables
	private Customer customer;

	/**
	 * Creates the GUI.
	 *
	 * @since 1.0.0
	 */
    public EditCustomer(String username)
    {
    	if (Session.loggedIn)
		{
			//Bring in customer data
			try
			{
				Database database = new Database();
				customer = (Customer)database.loadUser(username);
				customer.toString();
			}//End of try
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "The user could not be found. Check the spelling and try again.", Application.NAME, JOptionPane.WARNING_MESSAGE);

				return;
			}//End of catch

			//Initialize the GUI
			this.initializeGUI();

			//Setup the JFrame
			this.setTitle("Edit Customer | " + Application.NAME);
			this.setSize(800, 440);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			this.setVisible(true);
		}//End of if
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to edit customer information.", Application.NAME, JOptionPane.ERROR_MESSAGE);
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
		this.customerInformationPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(customer.getFirstName() + " " + customer.getLastName()), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Seperate email address into its individual parts
		String [] email = customer.getEmailAddress().split("@");
		String [] email2 = email[1].split("\\.");

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

		//Set the text of the fields to match that of the customer
		this.txtFirstName.setText(customer.getFirstName());
		this.txtLastName.setText(customer.getLastName());
		this.txtAddressHouseNumber.setText(Integer.toString(customer.getAddress().getHouseNumber()));
		this.txtAddressStreet.setText(customer.getAddress().getStreetName());
		this.txtAddressStreetSuffix.setText(customer.getAddress().getStreetSuffix());
		this.txtAddressCity.setText(customer.getAddress().getCity());
		this.cboAddressProvince.setSelectedItem(customer.getAddress().getCountry());
		this.txtAddressPostalCode.setText(customer.getAddress().getPostalCode());
		this.txtPhoneAreaCode.setText(Integer.toString(customer.getPhoneNumber().getAreaCode()));
		this.txtPhonePrefix.setText(Integer.toString(customer.getPhoneNumber().getPrefix()));
		this.txtPhoneLine.setText(Integer.toString(customer.getPhoneNumber().getLineNumber()));
		this.txtEmailAddress.setText(email[0]);
		this.txtEmailAddressDomain.setText(email2[0]);
		this.txtEmailAddressTLD.setText(email2[1]);

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

		//Tickets Panel
		this.purchasedTicketsPanel = new JPanel(new GridLayout());
		this.purchasedTicketsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Purchased Tickets"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Set up JTable
		Integer [][] data = populateTable();
		table = new JTable(data, COLUMN_HEADERS);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(600, 30));
		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);

		this.purchasedTicketsPanel.add(scrollPane);

		//Populate the table from the database
		populateTable();

		//Buttons Panel
		this.buttonsPanel = new JPanel(new GridLayout(1, 6, 5, 5));

		this.cmdDone = new JButton("Done");
		this.cmdDone.addActionListener(this);
		this.cmdDelete = new JButton("Delete");
		this.cmdDelete.addActionListener(this);
		this.cmdNewTicket = new JButton("New Ticket");
		this.cmdNewTicket.addActionListener(this);
		this.cmdCancel = new JButton("Cancel");
		this.cmdCancel.addActionListener(this);

		this.buttonsPanel.add(this.cmdCancel);
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(this.cmdDelete);
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(this.cmdNewTicket);
		this.buttonsPanel.add(this.cmdDone);

		//Setup the frame layout manager
		SpringLayout layout = new SpringLayout();

		this.getContentPane().setLayout(layout);

		layout.putConstraint(SpringLayout.NORTH, this.customerInformationPanel, 20, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.customerInformationPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.customerInformationPanel, 20, SpringLayout.WEST, this.getContentPane());

		layout.putConstraint(SpringLayout.NORTH, this.purchasedTicketsPanel, 255, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.purchasedTicketsPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.purchasedTicketsPanel, 20, SpringLayout.WEST, this.getContentPane());

		layout.putConstraint(SpringLayout.NORTH, this.buttonsPanel, 365, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.buttonsPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.buttonsPanel, 20, SpringLayout.WEST, this.getContentPane());

		//Add the panels to the frame
		this.add(this.customerInformationPanel);
		this.add(this.purchasedTicketsPanel);
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
			editCustomerInfo();
		else if (trigerObject == this.cmdDelete)
			deleteCustomer();
		else if (trigerObject == this.cmdNewTicket)
			Session.openWindow(new TicketGUI(customer));
		else if (trigerObject == this.cmdCancel)
			this.dispose();
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method

	/**
	 * Deletes the customer
	 */
	private void deleteCustomer()
	{
		try
		{
			Database db = new Database();
			db.deleteUser(customer);
			this.dispose();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured deleting the customer.", Application.NAME, JOptionPane.ERROR_MESSAGE);
		}
	}//End of deleteCustomer

	/**
	 * Creates a new <code>Customer</code> object to replace the old data.
	 *
	 * @since 1.0.0
	 */
	private void editCustomerInfo()
	{
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

		//Add the user to the database
		try
		{
			Database database = new Database();
			customer = (Customer) database.writeUser(customer);

			JOptionPane.showMessageDialog(this, "The customer has been updated.",Application.NAME, JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		catch (UnsupportedOperationException e)
		{
			JOptionPane.showMessageDialog(this, "Updating is not yet available.", "Database Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			return;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured updating the user. If this problem continues, please contact your system administrator.", "Database Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();

			return;
		}
	}//End of editCustomerInfo method

	/**
	 * Populate the table with the tickets the customer has.
	 *
	 * @since 1.0.0
	 */
	 private Integer [][] populateTable()
	 {
	 	Ticket [] tickets = new Ticket[0];
	 	int ticketCount = 0;

		try
		{
			Database db = new Database();
			tickets = db.loadTickets();

			this.setVisible(true);
		}//End of try
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured querying the database. Unable to list available tickets.\n\nIf this problem continues, please contact your system administrator", "Database Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);
		}//End of catch

		for (Ticket t : tickets)
		{
			if (customer.getID() == t.getCustomer().getID())
				ticketCount++;
		}

		Integer [][] rowData = new Integer[ticketCount][5];
		int count = 0;

		for (Ticket t : tickets)
	 	{
	 		if (customer.getID() == t.getCustomer().getID())
	 		{
		 		rowData[count][0] = new Integer((int)customer.getID());
		 		rowData[count][1] = new Integer((int)t.getShow().getID());
		 		rowData[count][2] = new Integer((int)t.getShowing().getID());
		 		rowData[count][3] = new Integer(t.getRow());
		 		rowData[count][4] = new Integer(t.getSeat());

		 		count++;
	 		}//End of if
	 	}//End of for

	 	return rowData;
	 }//End of populateTable method
}//End of class