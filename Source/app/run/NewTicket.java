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
		
		this.setVisible(true);
	}//End of constructor
}//End of class