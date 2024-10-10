/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: In this class it is decrypting and encrypting 
 * cesear cipher and bellaso.
 * Due: 10/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
 *  I have not copied the code from a student or any source. 
 *  I have not given my code to any student.
 *  Print your Name here: Alexia Majano
 */

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i =0 ;i<  plainText.length(); i++) // reads the amount of characters 
		{
			char a = plainText.charAt(i);// Loop through the characters in the strings

			if (a < LOWER_RANGE || a > UPPER_RANGE) //checks if the character is in range
			{

				return false; 
			}
		}
		return true;

	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String encryptedText = "";
		for (int i = 0; i < plainText.length();i++) // Loop through the characters in the strings
		{
			char a = plainText.charAt(i); // gets the character
			a = (char)((a - LOWER_RANGE + key) % RANGE + LOWER_RANGE); // Encrypt the character by the key inputed
			encryptedText += a; // concatenation 
		}
	
		return encryptedText;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String encryptedText="";

		for(int i = 0; i < plainText.length(); i++)
		{
			char a = plainText.charAt(i);
			char belChar = bellasoStr.charAt(i % bellasoStr.length());
			int offset = belChar; //converts the characters to number ASCII to encrypt it 
			a = (char) ((a - LOWER_RANGE + offset) % (UPPER_RANGE - LOWER_RANGE + 1) + LOWER_RANGE);

			encryptedText += a;
		}
		
		return encryptedText;	
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String plainText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char a = encryptedText.charAt(i); 

			if (a >= LOWER_RANGE && a <= UPPER_RANGE) // checks if its a letter
			{
				int decrypy = (a - LOWER_RANGE - key) % RANGE + LOWER_RANGE; // this decrypts the char
				if (decrypy < LOWER_RANGE) {
					decrypy += RANGE;
				}
				plainText += (char)decrypy;

			}
			else {
				plainText += a;
			}
		}
		return plainText;

	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {

		String decyrpted = ""; //initalizes decryption
		int bellasoStrLength=bellasoStr.length();
		for (int i=0;i<encryptedText.length();i++) //loops through encryption to convert back to regular string
		{
			char a =encryptedText.charAt(i);
			int decryptint=((int)a-(int)bellasoStr.charAt(i%bellasoStrLength)); // changes the encryption using the ASCII value

			while (decryptint<LOWER_RANGE) //well make sure if its below range
			{
				decryptint+=RANGE; //then will go back to the upper range
			}
			decyrpted+=(char)decryptint; // decrypt the character
		}
		return decyrpted;
	}

}
