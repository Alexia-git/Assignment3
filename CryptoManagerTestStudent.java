import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: (Give a brief description for each Class)
 * Due: 10/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alexia Majano
*/


class CryptoManagerTestStudent {

	// Testers

	@Test
    public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("\"WHY SIT SLEEP\""));
		assertFalse(CryptoManager.isStringInBounds("hello kitty"));
		assertFalse(CryptoManager.isStringInBounds("% cat"));
		assertFalse(CryptoManager.isStringInBounds("This is a very long sentence and it should not work test[]"));
    }
	

	@Test // change 
	public void testEncryptCaesar() {
		assertEquals("XLMW$MW$E$PSRK$XVMT", CryptoManager.caesarEncryption("THIS IS A LONG TRIP", 4));
		assertEquals("YJXYNSL%JSHW^UYNTS", CryptoManager.caesarEncryption("TESTING ENCRYPTION", 5));
		assertEquals("NKRRU&QOZZ_", CryptoManager.caesarEncryption("HELLO KITTY", 6));
		assertEquals("\"!43-!25)", CryptoManager.caesarEncryption("BATSMARUI", 864));
	}
		
	
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING ENCRYPTION", CryptoManager.caesarDecryption("YJXYNSL%JSHW^UYNTS", 5));
		assertEquals("THIS IS A LONG TRIP", CryptoManager.caesarDecryption("XLMW$MW$E$PSRK$XVMT", 4));
		assertEquals("HELLO KITTY", CryptoManager.caesarDecryption("NKRRU&QOZZ_", 6));
		assertEquals("BATSMARUI", CryptoManager.caesarDecryption("\"!43-!25)", 864));
		
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("*MYJ\" QQT^3^JI", CryptoManager.bellasoEncryption("WATERMELON RED", "SLEEP"));
		assertEquals("XJJS^ND]O!EPPPUP*DK]STWXKT", CryptoManager.bellasoEncryption("NIGHTMARE BEFORE CHRISTMAS", "JACK"));

	}
	@Test
	public void testDecryptBellaso() {
		assertEquals("WATERMELON RED", CryptoManager.bellasoDecryption("*MYJ\" QQT^3^JI", "SLEEP"));
		assertEquals("NIGHTMARE BEFORE CHRISTMAS", CryptoManager.bellasoDecryption("XJJS^ND]O!EPPPUP*DK]STWXKT", "JACK"));

	}


}