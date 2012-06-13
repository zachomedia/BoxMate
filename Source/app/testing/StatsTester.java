package app.testing;

import app.boxmate.*;
import app.util.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class StatsTester
{
    public static void main(String [] args) throws Exception
    {
    	Address jonsAddress = new Address(209, "Oldham", "Street", "London", "ON", "Canada", "N5Z5E2");
    	Address laurier = new Address(450, "Millbank", "Drive", "London", "ON", "Canada", "");

    	Customer jon = new Customer("tanjo3", "123@ABC", 0, "Jonathan", "Tan", jonsAddress, "jontan_@hotmail.com", new PhoneNumber(519, 680, 2590), new CreditCard(), new ArrayList<Ticket>());

    	int [] theatreSeating = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    	Theatre theatre = new Theatre("Laurier", laurier, 10, theatreSeating);

    	ArrayList<Showing> testShowing = new ArrayList<Showing>();
    	Showing showing = new Showing(new Date(6000000), new Time(5000), new Time(5000), 100, 0, theatre, new ArrayList<Ticket>());
    	testShowing.add(showing);

    	ArrayList<String> prods = new ArrayList<String>();
    	prods.add("Director: Steven Spielberg");

    	Show show = new Show("Alice in Wonderland", "Lewis Carroll's beloved story.", prods, testShowing, Rating.G, 4.3, 25.50);
    	Ticket ticket = new Ticket(123456, jon, show, showing, 4, 3);
    	jon.addTicket(ticket);
    	showing.addTicket(ticket);

    	System.out.println(show.calculateSales());
    	System.out.println(show.showStat(Statistics.AVG_DISTANCE));
    	System.out.println(show.showStat(Statistics.AVG_TICKET_PER_CUSTOMER));
    }//End of main method
}//End of class