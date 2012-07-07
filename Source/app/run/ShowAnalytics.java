package app.run;

import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Shows the statistics attributs to the show.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (6/6/2012)
 * @since 1.0.0
 */
public class ShowAnalytics extends JFrame
{
	//Declare GUI components
	private JPanel filler;

	private JPanel statsPanel;
		private JTextField txtRevenue;
		private JTextField txtAvgDistance;
		private JTextField txtAvgTickets;

	private JPanel filler2;

	//Declare variables
	Show show;

    /**
	 * Constructs and shows the ShowAnalytics GUI.
	 *
	 * @since 1.0.0
	 */
	public ShowAnalytics(Show show) throws Exception
	{
		if (Session.loggedIn)
		{
			//Declare and initialize variables
			this.show = show;
			Database db;
			Ticket [] tickets = new Ticket[0];

			try
			{
				db = new Database();
				tickets = db.loadTickets();

			}//End of try
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "An error occured querying the database. Unable to list available tickets.\n\nIf this problem continues, please contact your system administrator", "Database Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);
			}//End of catch

			for (Showing s : show.getShowings())
			{
				for (Ticket t : tickets)
				{
					if (t.getShowing().getID() == s.getID() && t.getShow().getID() == show.getID())
						s.addTicket(t);
				}
			}

			//Initialize the GUI
			this.initializeGUI();

			//Setup the JFrame
			this.setTitle("Analytics | " + Application.NAME);
			this.setSize(400, 400);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			this.setVisible(true);

			//Shows the stats
			showStats();
		}
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to view show analytics.", Application.NAME, JOptionPane.ERROR_MESSAGE);
	}//End of constructor

	/**
	 * Initializes the GUI components and places them on the screen.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the GUI layout manager for the content pane
		this.getContentPane().setLayout(new GridLayout(3, 1, 0, 0));

		this.filler = new JPanel(new GridLayout());
		this.filler.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		this.statsPanel = new JPanel(new GridLayout(3, 2, 0, 0));
		this.statsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		//Intialize all the customer information GUI components
		this.txtRevenue = new JTextField(10);
		this.txtAvgDistance = new JTextField(10);
		this.txtAvgTickets = new JTextField(10);

		txtRevenue.setEditable(false);
		txtAvgDistance.setEditable(false);
		txtAvgTickets.setEditable(false);

		//Add the components to the frame
		statsPanel.add(new JLabel("Total Sales: "));
		statsPanel.add(this.txtRevenue);
		statsPanel.add(new JLabel("Avg. Distance Travelled Per Customer: "));
		statsPanel.add(this.txtAvgDistance);
		statsPanel.add(new JLabel("Avg. No. Tickets Bought Per Customer: "));
		statsPanel.add(this.txtAvgTickets);

		this.filler2 = new JPanel(new GridLayout());
		this.filler2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

		this.add(filler);
		this.add(statsPanel);
		this.add(filler2);
	}//End of initializeGUI method

	/**
	 * Add the stats to the GUI components
	 *
	 * @since 1.0.0
	 */
	private void showStats() throws Exception
	{
		txtRevenue.setText(NumberFormat.getCurrencyInstance().format(show.calculateSales()));
		txtAvgDistance.setText(new DecimalFormat("#.###").format(show.showStat(Statistics.AVG_DISTANCE)) + " km");
		txtAvgTickets.setText(new DecimalFormat("#.##").format(show.showStat(Statistics.AVG_TICKET_PER_CUSTOMER)));
	}//End of showStats method
}//End of class