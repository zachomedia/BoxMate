package app.testing;

import app.boxmate.*;
import app.util.*;

import java.util.ArrayList;

public class SortTester
{
    public static void main(String [] args)
    {
    	ArrayList<Showing> testShowing = new ArrayList<Showing>();
    	Showing testee = new Showing();
    	testee.setDate(new Date(2012, Date.Month.JUNE, 12));
    	testee.setTime(new Time(17, 0));
    	testShowing.add(testee);

    	ArrayList<Showing> testShowing2 = new ArrayList<Showing>();
    	Showing testee2 = new Showing();
    	testee2.setDate(new Date(2012, Date.Month.JULY, 15));
    	testee2.setTime(new Time(20, 30));
    	testShowing2.add(testee2);

    	ArrayList<String> prods = new ArrayList<String>();
    	prods.add("Director: Stephen Harper");
    	Show showA = new Show("Sweeny Todd", "The demon barber of Fleet Street.", prods, testShowing2, Rating.A14, 4.6, 15.20);
    	Show showB = new Show("Beauty and the Beast", "A Disney fairy tale.", prods, testShowing, Rating.PG, 4.7, 8.75);

    	ShowRoster test = new ShowRoster();

    	test.addShow(showA);
    	test.addShow(showB);

    	Show showC = new Show("Alice in Wonderland", "Lewis Carroll's beloved story.", prods, testShowing, Rating.G, 4.3, 10.50);
    	showC.sortShowings();

    	test.addShow(showC);

    	test = test.sort(SortTypes.NEXT_SHOWING);

    	System.out.println(test.toString());
    }//End of main method
}//End of class