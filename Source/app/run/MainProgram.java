package app.run;

import app.boxmate.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.util.ArrayList;

/**
 * Starts the application.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (31/05/2012)
 * @since 1.0.0
 */
public class MainProgram
{
	/**
	 * The first method that is called in the application (by Java).
	 *
	 * @param args The command line arguments.
	 *
	 * @since 1.0.0
 	 */
	public static void main (String [] args) throws Exception
	{
		// set the look and feel to that of the current OS
        try
        {
            boolean nimbusfound = false;

            //Get system look
            final String SYSTEM_LOOK = UIManager.getSystemLookAndFeelClassName();

            UIManager.setLookAndFeel(SYSTEM_LOOK);
        }//End of try
        catch (Exception e)
        {
            e.printStackTrace();
            //Do nothing, use default java look
        }//End of catch

		new Login();
	}//End of main method
}//End of class