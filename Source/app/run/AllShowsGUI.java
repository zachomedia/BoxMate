package app.run;

import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * A GUI screen that displays all the show.
 *
 * @author Zachary Seguin
 * @version 1.0.0
 * @since 1.0.0
 */
public class AllShowsGUI extends JFrame implements ActionListener
{
	//Declare and initialize constants
	private final static String [] COLUMN_HEADERS = {"ID", "Name", "Description"};
	private final static int [] COLUMN_WIDTHS = { 10, 90, 300 };

	//Declare instance variables
	ShowRoster showRoster;

	//Declare all GUI components
	private JTable tblShows;

	private JComboBox cboSortType;
	private JButton cmdLoadShow;

	private SpringLayout layout;

	/**
	 * Constructs the GUI.
	 */
	public AllShowsGUI()
	{
		if (Session.loggedIn)
		{
			//Initialize
			try
			{
				Database db = new Database();
				showRoster = new ShowRoster(db.loadShows());
				showRoster = showRoster.sort(SortTypes.NAME);
			}//End of try
			catch (Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "An error occured querying the database.\n\nIf this problem continues, contact your system administrator.", Application.NAME, JOptionPane.ERROR_MESSAGE);

				return;
			}//End of catch

			//Setup the GUI
			this.setTitle("Shows | " + Application.NAME);
			this.setSize(800, 400);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(true);

			this.initializeGUI();

		}//End of if
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to view all shows.", Application.NAME, JOptionPane.ERROR_MESSAGE);
	}//End of constructor method

	/**
	 * Initializes the GUI components
	 */
	private void initializeGUI()
	{
		//HEADER LABLE
		JLabel lblTitle = new JLabel("All Shows");
		lblTitle.setFont(new Font("sansserif", Font.BOLD, 24));

		this.add(lblTitle);

		//THE SEARCH PANE
		JPanel searchPane = new JPanel(new GridLayout(1, 6, 5, 5));

		this.cboSortType = new JComboBox(new String[]{"Name", "Description", "Rating", "Ranking"});
		this.cboSortType.addActionListener(this);

		searchPane.add(new JLabel("Sort By:"));
		searchPane.add(this.cboSortType);
		searchPane.add(new JLabel(""));
		searchPane.add(new JLabel(""));
		searchPane.add(new JLabel(""));
		searchPane.add(new JLabel(""));

		this.add(searchPane);

		//THE TABLE
		this.tblShows = new JTable(new DefaultTableModel(new Object[0][0], COLUMN_HEADERS));
		this.tblShows.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(this.tblShows);

		for (int x = 0; x < COLUMN_WIDTHS.length; x++)
			this.tblShows.getColumnModel().getColumn(x).setPreferredWidth(COLUMN_WIDTHS[x]);

		addShowsToTable();

		//LOAD BUTTON
		this.cmdLoadShow = new JButton("Load Show");
		this.cmdLoadShow.addActionListener(this);

		this.add(this.cmdLoadShow);

		//LAYOUT
		this.layout = new SpringLayout();
		this.getContentPane().setLayout(this.layout);

		this.layout.putConstraint(SpringLayout.NORTH, lblTitle, 15, SpringLayout.NORTH, this.getContentPane());
		this.layout.putConstraint(SpringLayout.WEST, lblTitle, 15, SpringLayout.WEST, this.getContentPane());

		this.layout.putConstraint(SpringLayout.NORTH, searchPane, 55, SpringLayout.NORTH, this.getContentPane());
		this.layout.putConstraint(SpringLayout.EAST, searchPane, -15, SpringLayout.EAST, this.getContentPane());
		this.layout.putConstraint(SpringLayout.WEST, searchPane, 15, SpringLayout.WEST, this.getContentPane());

		this.layout.putConstraint(SpringLayout.NORTH, scrollPane, 90, SpringLayout.NORTH, this.getContentPane());
		this.layout.putConstraint(SpringLayout.SOUTH, scrollPane, -50, SpringLayout.SOUTH, this.getContentPane());
		this.layout.putConstraint(SpringLayout.EAST, scrollPane, -15, SpringLayout.EAST, this.getContentPane());
		this.layout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, this.getContentPane());

		this.layout.putConstraint(SpringLayout.SOUTH, this.cmdLoadShow, -15, SpringLayout.SOUTH, this.getContentPane());
		this.layout.putConstraint(SpringLayout.EAST, this.cmdLoadShow, -15, SpringLayout.EAST, this.getContentPane());

		this.add(scrollPane);
	}//End of initializeGUI method

	/**
	 * Adds the shows to the table
	 */
	private void addShowsToTable()
	{
		DefaultTableModel model = (DefaultTableModel) this.tblShows.getModel();

		while (model.getRowCount() > 0)
			model.removeRow(0);

		//Sort the shows
		SortTypes sortType;

		switch (this.cboSortType.getSelectedIndex())
		{
			case 1:		sortType = SortTypes.DESCRIPTION;
						break;

			case 2:		sortType = SortTypes.RATING;
						break;

			case 3:		sortType = SortTypes.RANKING;
						break;

			case 0:
			default:	sortType = SortTypes.NAME;
		}//End of switch

		showRoster = showRoster.sort(sortType);

		for (Show show : showRoster.getShows())
			model.addRow(new String[]{String.valueOf(show.getID()), show.getName(), show.getDescription()});
	}//end of addShowsToTable method

	public void actionPerformed(ActionEvent e)
	{
		Object triggerObject = e.getSource();

		if (triggerObject == this.cboSortType)
			addShowsToTable();
		else if (triggerObject == this.cmdLoadShow)
			loadShow();
	}//End of actionPerformed method

	private void loadShow()
	{
		int [] indexes = this.tblShows.getSelectedRows();

		if (indexes.length == 0)
		{
			JOptionPane.showMessageDialog(this, "No show was selected.", Application.NAME, JOptionPane.WARNING_MESSAGE);
			return;
		}//End of if

		for (int index : indexes)
		{
			Show show = showRoster.getShows().get(index);

			Session.openWindow(new ShowDetails(show));
		}//End of for

		//Close this window
		this.dispose();
	}//End of loadShow method
}//End of class