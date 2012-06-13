package app.run;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Manages a users session.
 *
 * @author Zachary Seguin
 * @since 1.0.0
 * @version 1.0.0 (12/6/2012)
 */
public class Session
{
	public static boolean loggedIn = false;
	public static String username = "";

	public static ArrayList<JFrame> openWindows = new ArrayList<JFrame>();


	public static void login(String username)
	{
		Session.loggedIn = true;
		Session.username = username;
	}

	public static void logout()
	{
		Session.loggedIn = false;
		Session.username = "";

		for (JFrame window : Session.openWindows)
			window.dispose();

		Session.openWindows = new ArrayList<JFrame>();
	}
}//End of class