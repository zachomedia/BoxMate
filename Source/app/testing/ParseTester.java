/**
 * @(#)ParseTester.java
 *
 *
 * @author
 * @version 1.00 2012/6/19
 */
import app.boxmate.*;

public class ParseTester {
    public static void main(String [] args) {
    	String address = "[HOUSE NUMBER : '209', STREET NAME : 'Oldham', STREET SUFFIX : 'Street', CITY : 'London', PROVINCE : 'Ontario', COUNTRY : '', POSTAL CODE : 'N5Z 5E2']";
    	String [] splitAddress = address.split("'");

    		Address newOne = new Address();
    		newOne.setHouseNumber(Integer.parseInt(splitAddress[1]));
    		newOne.setStreetName(splitAddress[3]);
    		newOne.setStreetSuffix(splitAddress[5]);
    		newOne.setCity(splitAddress[7]);
    		newOne.setProvince(splitAddress[9]);
    		newOne.setCountry(splitAddress[11]);
    		newOne.setPostalCode(splitAddress[13]);

    		System.out.println(newOne.toString());
    }

}