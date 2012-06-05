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
	private JButton cmdRetreiveTicket;
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
		this.getContentPane().setLayout(new GridLayout(1, 2, 15, 15));

		//Initialize the left side
		this.lblLogo = new JLabel("LOGO GOES HERE");
		this.lblLogo.setHorizontalAlignment(JLabel.CENTER);

		this.add(lblLogo);

		//Initialize the right side
		JPanel rightSidePanel = new JPanel(new GridLayout(3, 1, 15, 15));

		JPanel firstRow = new JPanel(new GridLayout(1, 3, 5, 5));

		this.cmdLogout = new JButton("Logout");

		firstRow.add(new JLabel(""));
		firstRow.add(new JLabel(""));
		firstRow.add(this.cmdLogout);

		rightSidePanel.add(firstRow);

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

	}//End of actionPerformed method
}//End of class