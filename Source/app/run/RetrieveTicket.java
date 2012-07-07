package app.run;

import app.boxmate.*;
import app.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;

/**
 * Shows the GUI required to retrieve a ticket.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (4/6/2012)
 * @since 1.0.0
 */
public class RetrieveTicket extends JFrame implements ActionListener
{
	//Declare and initialize constants
	private final String [] COLUMN_HEADERS = {"Ticket ID", "Customer", "Row", "Seat"};

	//Declare GUI components
	private JPanel ticketPropertyPanel;
		private JTextField txtTicketID;
		private JTextField txtFirstName;
		private JTextField txtLastName;

	private JPanel ticketListPanel;
		private TicketTableModel model;
		private TableRowSorter<TicketTableModel> sorter;
		private JTable table;
		private JScrollPane scrollPane;

	private JPanel buttonsPanel;
		private JButton cmdFilter;
		private JButton cmdLoad;

	//Declare variables
	Ticket [] tickets;

	/**
	 * Creates the GUI.
	 *
	 * @since 1.0.0
	 */
    public RetrieveTicket()
    {
    	if (Session.loggedIn)
		{
			//Setup the GUI
			this.setTitle("Retrieve Ticket | " + Application.NAME);
			this.setSize(800, 450);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setVisible(true);

			this.initializeGUI();
		}
		else
			JOptionPane.showMessageDialog(null, "You must be logged in to retrieve a ticket.", Application.NAME, JOptionPane.ERROR_MESSAGE);
    }

    /**
	 * Initialize the GUI components.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Declare and initialize variables
		Database db;
		tickets = new Ticket[0];

		try
		{
			db = new Database();
			tickets = db.loadTickets();

			this.setVisible(true);
		}//End of try
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "An error occured querying the database. Unable to list available tickets.\n\nIf this problem continues, please contact your system administrator", "Database Error | " + Application.NAME, JOptionPane.ERROR_MESSAGE);

			//Close the frame
			this.dispose();
		}//End of catch

		//Intialize the ticket property panel
		this.ticketPropertyPanel = new JPanel(new GridLayout(2, 4));
		ticketPropertyPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Retrieve Ticket"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Intialize all the customer information GUI components
		this.txtTicketID = new JTextField(15);
		this.txtFirstName = new JTextField(15);
		this.txtLastName = new JTextField(15);

		//Setup the ticket property panel
		ticketPropertyPanel.add(new JLabel("Ticket ID"));
		ticketPropertyPanel.add(new JLabel(""));
		ticketPropertyPanel.add(new JLabel("Customer"));
		ticketPropertyPanel.add(new JLabel(""));

		ticketPropertyPanel.add(this.txtTicketID);
		ticketPropertyPanel.add(new JLabel("or", SwingConstants.CENTER));
		ticketPropertyPanel.add(this.txtFirstName);
		ticketPropertyPanel.add(this.txtLastName);

		//Add DoumentListners to the objects
		txtTicketID.getDocument().addDocumentListener(
			new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e) {
                    newFilter();
                }
            });
        txtFirstName.getDocument().addDocumentListener(
			new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e) {
                    newFilter();
                }
            });
         txtLastName.getDocument().addDocumentListener(
			new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e) {
                    newFilter();
                }
            });

		//Intialize the ticket list panel
		this.ticketListPanel = new JPanel(new GridLayout());
		this.ticketListPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Purchased Tickets"), BorderFactory.createEmptyBorder(5,5,5,5)));

		//Set up JTable
		model = new TicketTableModel();
		table = new JTable(model);
		sorter = new TableRowSorter<TicketTableModel>(model);
		table.setRowSorter(sorter);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.setFillsViewportHeight(true);
		table.setRowHeight(25);

		scrollPane = new JScrollPane(table);

		this.ticketListPanel.add(scrollPane);

		//Buttons Panel
		this.buttonsPanel = new JPanel(new GridLayout(1, 6, 5, 5));

		this.cmdLoad = new JButton("Load");
		this.cmdLoad.addActionListener(this);

		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(new JLabel(""));
		this.buttonsPanel.add(this.cmdLoad);

		//Setup the frame layout manager
		SpringLayout layout = new SpringLayout();

		this.getContentPane().setLayout(layout);

		layout.putConstraint(SpringLayout.NORTH, this.ticketPropertyPanel, 20, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.ticketPropertyPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.ticketPropertyPanel, 20, SpringLayout.WEST, this.getContentPane());

		layout.putConstraint(SpringLayout.NORTH, this.ticketListPanel, 100, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.ticketListPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.ticketListPanel, 20, SpringLayout.WEST, this.getContentPane());

		layout.putConstraint(SpringLayout.NORTH, this.buttonsPanel, 370, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, this.buttonsPanel, -20, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, this.buttonsPanel, 20, SpringLayout.WEST, this.getContentPane());

		//Add the panels to the frame
		this.add(this.ticketPropertyPanel);
		this.add(this.ticketListPanel);
		this.add(this.buttonsPanel);
	}//End of initializeGUI method

	/**
     * Update the row filter regular expression from the expression in the text box.
     *
     * @since 1.0.0
     */
    private void newFilter()
    {
    	String customerName = "";

    	if (txtFirstName.getText().equals(""))
    		customerName = txtLastName.getText();
    	else if (txtLastName.getText().equals(""))
    		customerName = txtFirstName.getText();
    	else
    		customerName = txtFirstName.getText() + " " + txtLastName.getText();

        RowFilter ID = RowFilter.regexFilter(txtTicketID.getText(), 0);
        RowFilter name = RowFilter.regexFilter("(?i)" + customerName, 1);

        ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
        filters.add(ID);
   		filters.add(name);

        RowFilter<Object,Object> mixed = RowFilter.andFilter(filters);
        sorter.setRowFilter(mixed);
    }//End of newFilter method

    /**
	 * The TableModel for the JTable.
	 *
	 * @author Jonathan Tan
	 * @version 1.0.0 (4/6/2012)
	 * @since 1.0.0
	 */
    class TicketTableModel extends AbstractTableModel
    {
	    private String [] columnNames = COLUMN_HEADERS;
	    private String [][] data = populateTable(tickets);

	    public int getColumnCount()
	    {
	        return columnNames.length;
	    }//End of getColumnCount method

	    public int getRowCount()
	    {
	        return data.length;
	    }//End of getRowCount method

	    public String getColumnName(int col)
	    {
	        return columnNames[col];
	    }//End of getColumnName method

	    public String getValueAt(int row, int col)
	    {
	        return data[row][col];
	    }//End of getValueAt method

	    public void setValueAt(String value, int row, int col)
	    {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }//End of setValueAt method
	}//End of inner class

    /**
	 * Invoked when an action occurs.
	 *
	 * @param evt The event which occured.
	 * @since 1.0.0
	 */
	public void actionPerformed(ActionEvent evt)
	{
		try
		{
			Database db = new Database();
			Object trigerObject = evt.getSource();

			if (trigerObject == this.cmdLoad)
			{
				Session.openWindow(new TicketGUI(db.loadTicket(Long.parseLong((String)table.getModel().getValueAt(table.getSelectedRow(), 0)))));
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(this, "No ticket was selected.", Application.NAME, JOptionPane.WARNING_MESSAGE);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}//End of actionPerformed method

	/**
	 * Populate the table with all the tickets in the database.
	 *
	 * @return the 2D array of ticket data
	 * @since 1.0.0
	 */
	 private String [][] populateTable(Ticket [] tickets)
	 {
	 	String [][] rowData = new String [tickets.length][4];

	 	for (int x = 0; x < tickets.length; x++)
	 	{
	 		rowData[x][0] = String.valueOf(tickets[x].getID());
	 		rowData[x][1] = tickets[x].getCustomer().getFirstName() + " " + tickets[x].getCustomer().getLastName();
	 		rowData[x][2] = String.valueOf(tickets[x].getSeat());
	 		rowData[x][3] = String.valueOf(tickets[x].getSeat());
	 	}//End of for

	 	return rowData;
	 }//End of populateTable method
}//End of class