<<<<<<< HEAD
package app.run;

//Import the required packages
import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows the Dashboard GUI to the user of the application.
 * This dashboard is that for a normal employee.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (6/6/2012)
 * @since 1.0.0
 */
public class Dashboard extends JFrame implements ActionListener
{
	//Declare GUI components
	private JLabel lblLogo;

	private JButton cmdLogout;
	private JButton cmdListAllShows;
	private JButton cmdNewTicket;
	private JButton cmdRetrieveTicket;
	private JButton cmdNewCustomer;
	private JButton cmdRetrieveCustomer;

	/**
	 * Constructs and shows the Dashboard GUI.
	 *
	 * @since 1.0.0
	 */
	public Dashboard()
	{
		//Initialize the GUI
		this.initializeGUI();

		//Setup the JFrame
		this.setTitle(Application.NAME);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}//End of constructor

	/**
	 * Initializes the GUI components and places them on the screen.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the GUI layout manager for the content pane
		this.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

		//Initialize the left side
		ImageIcon imgLogo = new ImageIcon("P:/Final Project/Project/BoxMate/Build/app/images/logo.png");

		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setHorizontalAlignment(JLabel.CENTER);

		this.add(lblLogo);

		//Initialize the right side
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));

		SpringLayout rightSideLayout = new SpringLayout();
		rightSidePanel.setLayout(rightSideLayout);

		JPanel firstRow = new JPanel(new GridLayout(1, 3, 5, 5));

		this.cmdLogout = new JButton("Logout");

		this.cmdLogout.addActionListener(this);

		firstRow.add(new JLabel(""));
		firstRow.add(new JLabel(""));
		firstRow.add(this.cmdLogout);

		rightSidePanel.add(firstRow);

		//Initialize the SHOWS row
		JPanel showsPanel = new JPanel(new GridLayout(1, 1, 15, 15));
		showsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Shows"), BorderFactory.createEmptyBorder(5,5,5,5)));

		showsPanel.add(new JLabel("Shows are coming soon!"));

		rightSidePanel.add(showsPanel);

		//Initialize the TICKETS AND CUSTOMERS row
		JPanel ticketsCustomersPanel = new JPanel(new GridLayout(2, 2, 15, 15));
		ticketsCustomersPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Tickets and Customers"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Initialize the GUI objects
		this.cmdNewTicket = new JButton("New Ticket");
		this.cmdRetrieveTicket = new JButton("Retrieve Ticket");
		this.cmdNewCustomer = new JButton("New Customer");
		this.cmdRetrieveCustomer = new JButton("Retrieve Customer");

		//Add the even listeners to the GUI objects
		this.cmdNewTicket.addActionListener(this);
		this.cmdRetrieveTicket.addActionListener(this);
		this.cmdNewCustomer.addActionListener(this);
		this.cmdRetrieveCustomer.addActionListener(this);

		ticketsCustomersPanel.add(this.cmdNewTicket);
		ticketsCustomersPanel.add(this.cmdNewCustomer);
		ticketsCustomersPanel.add(this.cmdRetrieveTicket);
		ticketsCustomersPanel.add(this.cmdRetrieveCustomer);

		rightSidePanel.add(ticketsCustomersPanel);

		//Position the elements on the screen
		rightSideLayout.putConstraint(SpringLayout.NORTH, firstRow, 0, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, firstRow, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, firstRow, 0, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, showsPanel, 30, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, showsPanel, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, showsPanel, 0, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, ticketsCustomersPanel, 220, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, ticketsCustomersPanel, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, ticketsCustomersPanel, 0, SpringLayout.EAST, rightSidePanel);

		this.add(rightSidePanel);
	}//End of initializeGUI method

	/**
	 * Handles user interactions with the GUI components on the screen. This is called automatically by the action listener.
	 *
	 * @param event The event that was generated.
	 *
	 * @since 1.0.0
	 */
	public void actionPerformed(ActionEvent event)
	{
		Object trigerObject = event.getSource();

		if (trigerObject == this.cmdNewTicket)
			new NewTicket();
		else if (trigerObject == this.cmdLogout)
		{
			Session.logout();

			new Login();
			this.dispose();
		}//End of else if
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method
=======
package app.run;

//Import the required packages
import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows the Dashboard GUI to the user of the application.
 * This dashboard is that for a normal employee.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (6/6/2012)
 * @since 1.0.0
 */
public class Dashboard extends JFrame implements ActionListener
{
	//Declare GUI components
	private JLabel lblLogo;

	private JButton cmdLogout;
	private JButton cmdListAllShows;
	private JButton cmdNewTicket;
	private JButton cmdRetrieveTicket;
	private JButton cmdNewCustomer;
	private JButton cmdRetrieveCustomer;

	/**
	 * Constructs and shows the Dashboard GUI.
	 *
	 * @since 1.0.0
	 */
	public Dashboard()
	{
		//Initialize the GUI
		this.initializeGUI();

		//Setup the JFrame
		this.setTitle(Application.NAME);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}//End of constructor

	/**
	 * Initializes the GUI components and places them on the screen.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the GUI layout manager for the content pane
		this.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

		//Initialize the left side
		this.lblLogo = new JLabel(Application.LOGO);
		this.lblLogo.setHorizontalAlignment(JLabel.CENTER);

		this.add(lblLogo);

		//Initialize the right side
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));

		SpringLayout rightSideLayout = new SpringLayout();
		rightSidePanel.setLayout(rightSideLayout);

		JPanel firstRow = new JPanel(new GridLayout(1, 3, 5, 5));

		this.cmdLogout = new JButton("Logout");

		this.cmdLogout.addActionListener(this);

		firstRow.add(new JLabel(""));
		firstRow.add(new JLabel(""));
		firstRow.add(this.cmdLogout);

		rightSidePanel.add(firstRow);

		//Initialize the SHOWS row
		JPanel showsPanel = new JPanel(new GridLayout(1, 1, 15, 15));
		showsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Shows"), BorderFactory.createEmptyBorder(5,5,5,5)));

		this.cmdListAllShows = new JButton("List All Shows");
		this.cmdListAllShows.addActionListener(this);

		showsPanel.add(this.cmdListAllShows);

		rightSidePanel.add(showsPanel);

		//Initialize the TICKETS AND CUSTOMERS row
		JPanel ticketsCustomersPanel = new JPanel(new GridLayout(2, 2, 15, 15));
		ticketsCustomersPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Tickets and Customers"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Initialize the GUI objects
		this.cmdNewTicket = new JButton("New Ticket");
		this.cmdRetrieveTicket = new JButton("Retrieve Ticket");
		this.cmdNewCustomer = new JButton("New Customer");
		this.cmdRetrieveCustomer = new JButton("Retrieve Customer");

		//Add the even listeners to the GUI objects
		this.cmdNewTicket.addActionListener(this);
		this.cmdRetrieveTicket.addActionListener(this);
		this.cmdNewCustomer.addActionListener(this);
		this.cmdRetrieveCustomer.addActionListener(this);

		ticketsCustomersPanel.add(this.cmdNewTicket);
		ticketsCustomersPanel.add(this.cmdNewCustomer);
		ticketsCustomersPanel.add(this.cmdRetrieveTicket);
		ticketsCustomersPanel.add(this.cmdRetrieveCustomer);

		rightSidePanel.add(ticketsCustomersPanel);

		//Position the elements on the screen
		rightSideLayout.putConstraint(SpringLayout.NORTH, firstRow, 0, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, firstRow, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, firstRow, 0, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, showsPanel, 40, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, showsPanel, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, showsPanel, 0, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, ticketsCustomersPanel, 200, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, ticketsCustomersPanel, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, ticketsCustomersPanel, 0, SpringLayout.EAST, rightSidePanel);

		this.add(rightSidePanel);
	}//End of initializeGUI method

	/**
	 * Handles user interactions with the GUI components on the screen. This is called automatically by the action listener.
	 *
	 * @param event The event that was generated.
	 *
	 * @since 1.0.0
	 */
	public void actionPerformed(ActionEvent event)
	{
		Object trigerObject = event.getSource();

		if (trigerObject == this.cmdNewTicket)
			Session.openWindow(new TicketGUI());
		else if (trigerObject == this.cmdRetrieveTicket)
			Session.openWindow(new RetrieveTicket());
		else if (trigerObject == this.cmdNewCustomer)
			Session.openWindow(new NewCustomer());
		else if (trigerObject == this.cmdListAllShows)
			Session.openWindow(new AllShowsGUI());
		else if (trigerObject == this.cmdRetrieveCustomer)
		{
			String username = JOptionPane.showInputDialog(this, "What is the customer's name or username?", Application.NAME, JOptionPane.QUESTION_MESSAGE);

			if (username != null)
			{
				username = username.toLowerCase().replace(' ', '.');

				Session.openWindow(new EditCustomer(username));
			}//End of if
		}//End of else if
		else if (trigerObject == this.cmdLogout)
		{
			Session.logout();

			new Login();
			this.dispose();
		}//End of else if
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method
>>>>>>> More updates. Also, the database class has been updated with credentials for Mamp on Mac OS X Lion.
}//End of class