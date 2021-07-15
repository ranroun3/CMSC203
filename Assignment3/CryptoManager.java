/*
 * CMSC 203
 * Rony Stephan
 * Assignment 3
 * Eclipse IDE, Java Version 15
 */

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean isInBounds = true;
		for(int i=0; i<plainText.length(); i++) {
			if(plainText.charAt(i)>UPPER_BOUND || plainText.charAt(i)<LOWER_BOUND) {
				isInBounds=false;
				
			}
		}
		return isInBounds;
		//throw new RuntimeException("method not implemented");
	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		if(stringInBounds(plainText)) {
		String newString="";
		char tempChar;
		while(key>UPPER_BOUND) {
			key-=RANGE;
		}
		for(int i=0; i<plainText.length(); i++) {
			tempChar=plainText.charAt(i);
			int charToAscii = (int) tempChar;
			int asciiPlusKey=charToAscii+key;
			if(asciiPlusKey>UPPER_BOUND) {
				asciiPlusKey -=RANGE;
			}
			newString+=((char)asciiPlusKey);
		}
		return newString;

		//	throw new RuntimeException("method not implemented");
	}
		else {
			return "String is not in bounds";
		}
	}
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String key = equalizeBellasoAndPlain(plainText, bellasoStr);
		String newString = "";
		if(stringInBounds(plainText)) {
		for(int i=0; i<plainText.length(); i++) {
			char plainChar=plainText.charAt(i);
			int plainCharToAscii = (int) plainChar;
			char bellasoChar = key.charAt(i);
			int bellasoCharToAscii = (int) bellasoChar;
			int charSum =plainCharToAscii + bellasoCharToAscii;
			while(charSum>UPPER_BOUND) {
				charSum-=RANGE;
			}
			newString+=((char)charSum);
		}
		return newString;
	}
		else {
			return "String is not in bounds";
		}
	}
	public static String equalizeBellasoAndPlain(String plainText, String bellasoStr) {
		char tempChar;
		int plainLength = plainText.length();
		int bellasoLength= bellasoStr.length();
		String newKey = "";
		if(bellasoLength<plainLength) {
			int count=0;
			for(int i=0; i<plainLength; i++) {
				newKey+=bellasoStr.charAt(count);
				count++;
				if(count==bellasoLength) {
					count=0;
				}
			}
		}
		else if(bellasoLength>plainLength) {
			for(int i=0; i<plainLength; i++) {
				newKey += bellasoStr.charAt(i);
			}
		}
		else if(bellasoLength==plainLength) {
			newKey=bellasoStr;
		}


		for(int i=0; i<plainText.length(); i++) {
			tempChar=plainText.charAt(i);
			int charToAscii = (int) tempChar;
		}
		return newKey;
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String newString="";
		char tempChar;
		while(key>UPPER_BOUND) {
			key-=RANGE;
		}
		if(stringInBounds(encryptedText)) {

		for(int i=0; i<encryptedText.length(); i++) {
			tempChar=encryptedText.charAt(i);
			int charToAscii = (int) tempChar;
			int asciiMinusKey=charToAscii-key;
			if(asciiMinusKey<LOWER_BOUND) {
				asciiMinusKey+=RANGE;
			}
			newString+=((char)asciiMinusKey);
		}
		return newString;

	}
		else {
			return "String not in bounds";
		}
	}
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String key = equalizeBellasoAndPlain(encryptedText, bellasoStr);
		String decryptedString= "";
		if(stringInBounds(encryptedText)) {
		for(int i=0; i<encryptedText.length(); i++) {
			char encryptedChar = encryptedText.charAt(i);
			int encryptedCharToAscii = (int) encryptedChar;
			char bellasoChar = key.charAt(i);
			int bellasoCharToAscii = (int) bellasoChar;

			int charDiff = encryptedCharToAscii -bellasoCharToAscii;
			while(charDiff<LOWER_BOUND) {
				charDiff+=RANGE;
			}
			decryptedString+=((char)charDiff);
		}
		return decryptedString;
	}
		else {
			return "String not in bounds";
		}
	}
	
}