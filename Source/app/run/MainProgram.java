package app.run;

import app.boxmate.*;

class MainProgram
{
	public static void main (String [] args) throws Exception
	{
		Database db = new Database();

		Show [] shows = db.loadShows();

		for (Show show : shows)
			System.out.println(show.getName());
	}//End of main method
}//End of class