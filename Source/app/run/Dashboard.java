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
	/**
	 * Constructs and shows the Dashboard GUI.
	 * 
	 * @since 1.0.0
	 */
	public Dashboard()
	{
		//Setup the JFrame
		this.setTitle(Application.NAME);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setDefaultLocation(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}//End of constructor
	
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