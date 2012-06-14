package app.run;

import java.util.ArrayList;
import javax.swing.JFrame;
import app.boxmate.*;

/**
 * Manages a users session.
 *
 * @author Zachary Seguin
 * @since 1.0.0
 * @version 1.0.0 (12/6/2012)
 */
public class Session
{
	/**
	 * Is a user logged in?
	 */
	public static boolean loggedIn = false;

	/**
	 * The user that is currently logged in. Null if no user is logged in.
	 */
	public static User user = null;

	/**
	 * Stores the windows the user currently has opened. This windows will be closed when the user logs out.
	 */
	public static ArrayList<JFrame> openWindows = new ArrayList<JFrame>();

	/**
	 * Update the session to be in the logged in state.
	 *
	 * @param user The user to login.
	 *
	 * @since 1.0.0
	 */
	public static void login(User user)
	{
		Session.loggedIn = true;
		Session.user = user;
	}//End of login method

	/**
	 * Update the session to be in the logged out state.
	 *
	 * @since 1.0.0
	 */
	public static void logout()
	{
		//Update the class variables
		Session.loggedIn = false;
		Session.user = null;

		//Close all the open windows, as the user is now logged out
		for (JFrame window : Session.openWindows)
			window.dispose();

		Session.openWindows.clear();
	}//End of logout method

	/**
	 * Adds the window to the list of open windows. These windows will be closed when the user logs out.
	 *
	 * @param window The window to add.
	 *
	 * @since 1.0.0
	 */
	public static void openWindow(JFrame window)
	{
		Session.openWindows.add(window);
	}//End of openWindow method
}//End of class