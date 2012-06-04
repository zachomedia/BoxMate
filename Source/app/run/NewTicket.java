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
	
	//Declare GUI components.
	private JPanel customerInformationPanel;
		private JTextField txtFirstName;
		private JTextField txtLastName;
		private JTextField txtAddressHouseNumber;
		private JTextField txtAddresStreet;
		private JTextField txtAddressStreetSufix;
		private JTextField txtAddressCity;
		private JTextField txtAddressProvince;
		private JTextField txtAddressPostalCode;
	
	/**
	 * Creates the GUI.
	 * 
	 * @since 1.0.0
	 */
	public NewTicket()
	{
		//Setup the GUI
		this.setTitle("New Ticket | " + Application.NAME);
		this.setSize(600, 400);
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
		this.customerInformationPanel = new JPanel(new FlowLayout());
		this.customerInformationPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Customer"), BorderFactory.createEmptyBorder(PADDING_SIZE,PADDING_SIZE,PADDING_SIZE,PADDING_SIZE)));
		
		this.add(this.customerInformationPanel);
		
	}//End of initializeGUI method
}//End of class