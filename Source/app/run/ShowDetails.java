package app.run;

import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * GUI screen that shows the details of a show.
 *
 * @author Zachary Seguin
 * @since 1.0.0
 * @version 1.0.0
 */
public class ShowDetails extends JFrame implements ActionListener
{
	//Instance variables
	/**
	 * Stores the show that is being show.
	 */
	private Show show;

	//Declare GUI components
	private JLabel lblPoster;

	private JLabel lblShowTitle;
	private JLabel lblShowProducers;
	private JTextArea txtShowDescription;

	private JLabel lblShowRating;
	private JLabel lblShowRanking;

	private JTable tblShowings;

	private JButton cmdAnalytics;

	/**
	 * Constructs the GUI screen, putting in the details of the show.
	 *
	 * @param show The show to display the details about.
	 */
	public ShowDetails(Show show)
	{
		if (Session.loggedIn)
		{
			//Set the instance variable
			this.show = show;

			//Setup the GUI
			this.setTitle(show.getName() + " | " + Application.NAME);
			this.setSize(650, 500);
			this.setResizable(true);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(true);

			this.initializeGUI();

		}//End of if
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to view show details.", Application.NAME, JOptionPane.ERROR_MESSAGE);
	}//End of constructor method

	/**
	 * Initializes the GUI components
	 */
	private void initializeGUI()
	{
		//Setup the GUI layout manager for the content pane
		this.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

		//Initialize the left side
		this.lblPoster = new JLabel(Application.LOGO);
		this.lblPoster.setHorizontalAlignment(JLabel.CENTER);

		this.add(this.lblPoster);

		//Initialize the right side
		JPanel rightSidePanel = new JPanel();
		rightSidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));

		SpringLayout rightSideLayout = new SpringLayout();
		rightSidePanel.setLayout(rightSideLayout);

		//SHOW INFORMATION
		this.lblShowTitle = new JLabel(show.getName());
		this.lblShowTitle.setFont(new Font("sansserif", Font.BOLD, 24));
		rightSidePanel.add(this.lblShowTitle);

		String producers = "";
		for (String producer : show.getProductionMembers())
		{
			if (producers.length() > 0)
				producers += ", ";

			producers += producer;
		}//End of for

		this.lblShowProducers = new JLabel(producers);
		rightSidePanel.add(this.lblShowProducers);

		this.txtShowDescription = new JTextArea(show.getDescription());
		this.txtShowDescription.setLineWrap(true);
		this.txtShowDescription.setWrapStyleWord(true);
		this.txtShowDescription.setFont(new Font("sansserif", Font.PLAIN, 12));
		this.txtShowDescription.setBackground(new Color(0, 0, 0, 0));
		this.txtShowDescription.setEditable(false);
		rightSidePanel.add(this.txtShowDescription);

		JPanel ratingRanking = new JPanel(new GridLayout(1, 5, 5, 5));
		ratingRanking.add(new JLabel("Rating:"));
		ratingRanking.add(new JLabel(show.getRating().toString()));
		ratingRanking.add(new JLabel(""));
		ratingRanking.add(new JLabel("Ranking:"));
		ratingRanking.add(new JLabel(String.valueOf(show.getRanking())));
		rightSidePanel.add(ratingRanking);

		JLabel lblShowingsTitle = new JLabel("Showings");
		lblShowingsTitle.setFont(new Font("sansserif", Font.BOLD, 18));
		rightSidePanel.add(lblShowingsTitle);

		this.tblShowings = new JTable(new DefaultTableModel(new String[0][0], new String[]{"Date", "Time", "Theatre"}));
		JScrollPane scrollPane = new JScrollPane(this.tblShowings);

		DefaultTableModel model = (DefaultTableModel) this.tblShowings.getModel();

		show.sortShowings();
		for (Showing showing : show.getShowings())
			model.addRow(new String[]{showing.getDate().toString(), showing.getTime().toString(), showing.getTheatre().getName()});

		rightSidePanel.add(scrollPane);

		this.cmdAnalytics = new JButton("Analytics");
		this.cmdAnalytics.addActionListener(this);
		rightSidePanel.add(cmdAnalytics);

		rightSideLayout.putConstraint(SpringLayout.NORTH, this.lblShowTitle, 5, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, this.lblShowTitle, 5, SpringLayout.WEST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, this.lblShowProducers, 45, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, this.lblShowProducers, 5, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, this.lblShowProducers, -5, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, this.txtShowDescription, 85, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.SOUTH, this.txtShowDescription, 250, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, this.txtShowDescription, 5, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, this.txtShowDescription, -5, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, ratingRanking, 260, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, ratingRanking, 5, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, ratingRanking, -5, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, lblShowingsTitle, 285, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, lblShowingsTitle, 5, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, lblShowingsTitle, -5, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, scrollPane, 310, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -30, SpringLayout.SOUTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, scrollPane, -5, SpringLayout.EAST, rightSidePanel);

		rightSideLayout.putConstraint(SpringLayout.NORTH, cmdAnalytics, 410, SpringLayout.NORTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, cmdAnalytics, 200, SpringLayout.WEST, rightSidePanel);

		this.add(rightSidePanel);
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

		if (trigerObject == this.cmdAnalytics)
		{
			try
			{
				Session.openWindow(new ShowAnalytics(show));
			}
			catch (Exception e) {}
		}
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method
}//End of class