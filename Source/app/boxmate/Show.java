package app.boxmate;

import app.util.*;
import java.util.ArrayList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 * This class represents a show that is being played at certain venue.  Customers can purchase tickets or rate it. Managers can create instances of a show and edit its details.
 *
 * CHANGES:
 *		June 15, 2012 (Zach):
 *			- Added ID field, for the database.
 *
 * @author Jonathan Tan
 * @version 1.0.0 (24/05/2012)
 * @since 1.0.0
 */
public class Show
{
	/**
	 * The ID of the show, as provided by the Database.
	 *
	 * @since 1.0.0
	 */
	private long ID;
	
	/**
	 * The name of the show or production.
	 *
	 * @since 1.0.0
	 */
	private String name;

	/**
	 * A description of the show or production.
	 *
	 * @since 1.0.0
	 */
	private String description;

	/**
	 * The names of all the people involved with the show or production.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<String> productionMembers;

	/**
	 * A list of all the showings that the show has.
	 *
	 * @since 1.0.0
	 */
	private ArrayList<Showing> showings;

	/**
	 * The content rating of the show.
	 *
	 * @since 1.0.0
	 */
	private Rating rating;

	/**
	 * The average of all users’ rankings of the show or production, out of 5.
	 *
	 * @since 1.0.0
	 */
	private double ranking;

	/**
	 * The price for a ticket to this show.
	 *
	 * @since 1.0.0
	 */
	private double price;

	/**
	 * The default constructor for the Show class. It will assign all the values of the attributes to default values.
	 *
	 * @since 1.0.0
	 */
    public Show()
    {
    	this.ID = 0;
    	this.name = "";
    	this.description = "";
    	this.productionMembers = new ArrayList<String>();
    	this.showings = new ArrayList<Showing>();
    	this.rating = Rating.G;
    	this.ranking = 0.0;
    	this.price = 0.0;
    }//End of default constructor

    /**
	 * A constructor for the Show class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param name The name of the show or production.
	 * @param description A description of the show or production.
	 * @param productionMembers The names of all the people involved with the show or production.
	 * @param showings A list of all the showings that the show has..
	 * @param rating The content rating of the show.
	 * @param ranking The average of all users’ rankings of the show or production, out of 5.
	 * @since 1.0.0
	 */
    public Show(String name, String description, ArrayList<String> productionMembers, ArrayList<Showing> showings, Rating rating, double ranking, double price)
    {
    	this.ID = 0;
    	this.name = name;
    	this.description = description;
    	this.productionMembers = productionMembers;
    	this.showings = showings;
    	this.rating = rating;
    	this.ranking = ranking;
    	this.price = price;
    }//End of object constructor

	/**
	 * A constructor for the Show class that requires the user/program to specify all the attributes as parameters.
	 *
	 * @param ID The ID of the show, as provided by the database.
	 * @param name The name of the show or production.
	 * @param description A description of the show or production.
	 * @param productionMembers The names of all the people involved with the show or production.
	 * @param showings A list of all the showings that the show has..
	 * @param rating The content rating of the show.
	 * @param ranking The average of all users’ rankings of the show or production, out of 5.
	 * @since 1.0.0
	 */
    public Show(long ID, String name, String description, ArrayList<String> productionMembers, ArrayList<Showing> showings, Rating rating, double ranking, double price)
    {
    	this.ID = ID;
    	this.name = name;
    	this.description = description;
    	this.productionMembers = productionMembers;
    	this.showings = showings;
    	this.rating = rating;
    	this.ranking = ranking;
    	this.price = price;
    }//End of object constructor

		
	/********************
	 * ACCESSOR METHODS *
	 ********************/
	
	/**
	 * Gets the value of ID.
	 *
	 * @return The value of ID.
	 */
	public long getID()
	{
		return this.ID;
	}//End of getID method
	
	/**
	 * Gets the value of name.
	 *
	 * @return The value of name.
	 */
	public String getName()
	{
		return this.name;
	}//End of getName method
	
	/**
	 * Gets the value of description.
	 *
	 * @return The value of description.
	 */
	public String getDescription()
	{
		return this.description;
	}//End of getDescription method
	
	/**
	 * Gets the value of productionMembers.
	 *
	 * @return The value of productionMembers.
	 */
	public ArrayList<String> getProductionMembers()
	{
		return this.productionMembers;
	}//End of getProductionMembers method
	
	/**
	 * Gets the value of showings.
	 *
	 * @return The value of showings.
	 */
	public ArrayList<Showing> getShowings()
	{
		return this.showings;
	}//End of getShowings method
	
	/**
	 * Gets the value of rating.
	 *
	 * @return The value of rating.
	 */
	public Rating getRating()
	{
		return this.rating;
	}//End of getRating method
	
	/**
	 * Gets the value of ranking.
	 *
	 * @return The value of ranking.
	 */
	public double getRanking()
	{
		return this.ranking;
	}//End of getRanking method
	
	/**
	 * Gets the value of price.
	 *
	 * @return The value of price.
	 */
	public double getPrice()
	{
		return this.price;
	}//End of getPrice method
	
	/***************************
	 * END OF ACCESSOR METHODS *
	 ***************************/

		
	/*******************
	 * MUTATOR METHODS *
	 *******************/
	
	/**
	 * Sets the value of ID.
	 *
	 * @param ID The new value for ID.
	 */
	public void setID(long ID)
	{
		this.ID = ID;
	}//End of setID method
	
	/**
	 * Sets the value of name.
	 *
	 * @param name The new value for name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}//End of setName method
	
	/**
	 * Sets the value of description.
	 *
	 * @param description The new value for description.
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}//End of setDescription method
	
	/**
	 * Sets the value of productionMembers.
	 *
	 * @param productionMembers The new value for productionMembers.
	 */
	public void setProductionMembers(ArrayList<String> productionMembers)
	{
		this.productionMembers = productionMembers;
	}//End of setProductionMembers method
	
	/**
	 * Sets the value of showings.
	 *
	 * @param showings The new value for showings.
	 */
	public void setShowings(ArrayList<Showing> showings)
	{
		this.showings = showings;
	}//End of setShowings method
	
	/**
	 * Sets the value of rating.
	 *
	 * @param rating The new value for rating.
	 */
	public void setRating(Rating rating)
	{
		this.rating = rating;
	}//End of setRating method
	
	/**
	 * Sets the value of ranking.
	 *
	 * @param ranking The new value for ranking.
	 */
	public void setRanking(double ranking)
	{
		this.ranking = ranking;
	}//End of setRanking method
	
	/**
	 * Sets the value of price.
	 *
	 * @param price The new value for price.
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}//End of setPrice method
	
	/**************************
	 * END OF MUTATOR METHODS *
	 **************************/


	/*
	 * Sorts an <code>ArrayList</code> of <code>Showing</code> objects in chronological order. This method
	 * should be called every time a changes is made to the <code>Showing</code> list.
	 *
	 * @since 1.0.0
	 */
	public void sortShowings()
	{
		Showing [] sorted = new Showing[showings.size()];

	 	for (int x = 0; x < sorted.length; x++)
	 	{
	 		sorted[x] = showings.get(x);
	 	}

	 	for (int index = 1; index < sorted.length; index++)
		{
			Showing key = sorted[index];
			int position = index;

			while (position > 0)
			{
				int equalityA = sorted[position-1].getDate().compareTo(key.getDate());

				if (equalityA == 0)
				{
					int equalityB = sorted[position-1].getTime().compareTo(key.getTime());
					if (equalityB > 0)
					{
							sorted[position] = sorted[position-1];
							position--;
					}
					else
					{
						break;
					}
				}
				else if (equalityA > 0)
				{
					sorted[position] = sorted[position-1];
					position--;
				}
				else
				{
					break;
				}
			}
			sorted[position] = key;
		}

		showings.clear();
		for (Showing s : sorted)
		{
			showings.add(s);
		}
	}//End of sortShowings method

	/**
	 * Returns the total sales from this show or production.
	 *
	 * @return The total amount of sales from the production.
	 * @since 1.0.0
	 */
	public double calculateSales()
	{
		double revenue = 0.0;

		for (Showing s : showings)
		{
			revenue += price * s.getTickets().size();
		}

		return revenue;
	}//End of calculateSales method

    /**
	 * Shows a certain statistic related to the show.
	 *
	 * @param statType The statistic to display.
	 * @return The desired statistic.
	 * @since 1.0.0
	 * @todo Implement.
	 */
	public double showStat(Statistics statType) throws Exception
	{
		switch(statType)
		{
			case AVG_DISTANCE:				return avgDistancePerCustomer();
			case AVG_TICKET_PER_CUSTOMER:	return avgTicketPerCustomer();
			default:						return 0.0;
		}
	}//End of showStat method

	/**
	 * Find the average distance travelled to get to the show per customer.
	 *
	 * @return The average distance.
	 *
	 * @since 1.0.0
	 */
	private double avgDistancePerCustomer()
	{
		try
		{
			ArrayList<Customer> checked = new ArrayList<Customer>();
			double [] coordsA;
			double [] coordsB;

			double avgDistance = 0.0;

			for (Showing s : showings)
			{
				coordsA = findEarthCoords(s.getTheatre().getAddress().normalize());

				for (Ticket t : s.getTickets())
				{
					if (checked.indexOf(t.getCustomer()) < 0)
					{
						checked.add(t.getCustomer());
						coordsB = findEarthCoords(t.getCustomer().getAddress().normalize());
						avgDistance += calcDistance(coordsA[0], coordsA[1], coordsB[0], coordsB[1]);
					}
				}
			}

			avgDistance /= checked.size();

			return avgDistance;
		}
		catch (Exception e)
		{
			return Double.NaN;
		}
	}

	/**
	 * Return the latitude and longitude of a location.
	 *
	 * @param address The address in question.
	 * @return The latitude and longitude. (index 0 = latitude, index 1 = longitude)
	 *
	 * @since 1.0.0
	 */
	private double [] findEarthCoords(String address) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
 		final String GEOCODER_REQUEST_PREFIX_FOR_XML = "http://maps.google.com/maps/api/geocode/xml";

    	double [] coords = {Double.NaN, Double.NaN};

    	//Query address
 		URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=false");

 		//Prepare an HTTP connection to the geocoder
 		HttpURLConnection conn = (HttpURLConnection)url.openConnection();

 		Document geocoderResultDocument = null;
    	try
    	{
    		//Open the connection and get results as InputSource.
    		conn.connect();
    		InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());

    		//Read result and parse into XML Document
    		geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);
    	}
    	finally
    	{
      		conn.disconnect();
      	}

		//Prepare XPath
      	XPath xpath = XPathFactory.newInstance().newXPath();

      	//Extract the result
      	NodeList resultNodeList = null;

      	//Extract the coordinates of the first result
    	resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/*", geocoderResultDocument, XPathConstants.NODESET);

    	for(int i = 0; i < resultNodeList.getLength(); i++)
    	{
    		Node node = resultNodeList.item(i);

    		if("lat".equals(node.getNodeName()))
    			coords[0] = Double.parseDouble(node.getTextContent());

    		if("lng".equals(node.getNodeName()))
    			coords[1] = Double.parseDouble(node.getTextContent());
    	}

    	return coords;
	}//End of findEarthCoords method

	/**
	 * Return the distance between two points on the globe.
	 *
	 * @param latA The latitude of the first address.
	 * @param longA The longitude of the first address.
	 * @param latB The latitude of the second address.
	 * @param longB The longitude of the second address.
	 * @return The distance between both points.
	 *
	 * @since 1.0.0
	 */
	private double calcDistance(double latA, double longA, double latB, double longB)
	{
		double distance = 0.0;

		distance = (Math.sin(Math.toRadians(latA)) * Math.sin(Math.toRadians(latB)) + Math.cos(Math.toRadians(latA)) * Math.cos(Math.toRadians(latB)) * Math.cos(Math.toRadians(longA - longB)));
		distance = (Math.toDegrees(Math.acos(distance))) * 111.189577;

		return distance;
	}//End of calcDistance method

	/**
	 * Find the average amount of tickets bought per customer.
	 *
	 * @return The average amount of tickets bought per customer.
	 *
	 * @since 1.0.0
	 */
	private double avgTicketPerCustomer()
	{
		ArrayList<Customer> checked = new ArrayList<Customer>();
		int customerCount = 0;
		int ticketCount = 0;

		for (Showing s : showings)
		{
			for (Ticket t : s.getTickets())
			{
				ticketCount++;

				if (checked.indexOf(t.getCustomer()) < 0)
					checked.add(t.getCustomer());
			}
		}

		return ticketCount / checked.size();
	}//End of avgTicketPerCustomer method

    /**
	 * Returns a string representation of the object.
	 *
	 * @return A string representation of the object
	 *
	 * @since 1.0.0
	 */
	public String toString()
	{
		String output = "";

		output += "--------------------------------\n";
		output += name;
		output += "\n--------------------------------\n";
		output += description + "\n";

		output += "\nPRODUCTION MEMBERS:\n";
		for (String member : productionMembers)
			output += member + "\n";

		output += "\nSHOWINGS:\n";
		for (Showing x : showings)
			output += x.toString();

		output += "Rated " + rating + "\n";
		output += "Avg. Rank: " + ranking;
		output += "\n--------------------------------\n";

		return output;
	}//End of toString method
}//End of class