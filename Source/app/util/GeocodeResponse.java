package app.util;

/*
 * This class is written by manshreck from: http://code.google.com/p/gmaps-samples/source/browse/trunk/geocoder/java/?r=2476
 */

import org.xml.sax.InputSource;
import org.w3c.dom.*;
import javax.xml.xpath.*;
import java.io.*;
import java.io.*;

public class GeocodeResponse {

  // Note: The default XPath expression "/" selects
  // all text within the XML.

  private static String xPathString = "/";

  public static void main(String[] args) throws IOException {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    String inputXPath = null;

    // For testing purposes, allow user input for the XPath expression.
    // If no input is entered, use the default expression defined above.
    System.out.println("Enter the XPath expression to evaluate the response: ");
    inputXPath = input.readLine();
    if (inputXPath.equals("")) {
      inputXPath = xPathString;
    }

	processResponse(inputXPath);

  }

  private static void processResponse(String xpathString) {

	XPathFactory factory = XPathFactory.newInstance();

    XPath xpath = factory.newXPath();

    try {
      System.out.print("Geocode Parser 1.0\n");
      File xmlFile = new File("reverseresponse.xml");
	  InputSource inputXml = new InputSource(new FileInputStream(xmlFile));
      NodeList nodes = (NodeList) xpath.evaluate(xpathString, inputXml, XPathConstants.NODESET);
      for (int i = 0, n = nodes.getLength(); i < n; i++) {
        String nodeString = nodes.item(i).getTextContent();
        System.out.print(nodeString);
        System.out.print("\n");
      }
    } catch (XPathExpressionException ex) {
	  System.out.print("XPath Error");
    } catch (FileNotFoundException ex) {
      System.out.print("File Error");
    }
  }
}