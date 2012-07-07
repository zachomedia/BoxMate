package app.util;

import app.boxmate.*;
import java.util.ArrayList;

public class UserCreator
{
	public static void main (String [] args) throws Exception
	{
		Customer customer = new Customer(
			"boxmate.user",
			PasswordEncryption.hashPassword("boxmate.user", "AwesomePassword"),
			10,
			"Boxmate",
			"User",
			new Address(450, "Millbank", "Drive", "London", "Ontario", "Canada", "N6C 4W7"),
			"boxmate.software@gmail.com",
			new PhoneNumber(519, 452, 2840),
			new CreditCard(),
			new ArrayList<Ticket>()
		);
		
		Database db = new Database();
		db.writeUser(customer);		
		
	}
}