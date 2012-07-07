package app.util;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

/**
 * Small utility for encrypting password.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (12/6/2012)
 * @since 1.0.0
 */
public class PasswordEncryption
{
	public static byte [] hashPassword(String username, String password) throws Exception
	{
		String passwd = username + password;

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte [] hashed = md.digest(passwd.getBytes("UTF-8"));

		return hashed;
	}//End of encryptPassword method
}//End of class