package coursera;

public class CeaserCipher {
	public static String encrypt(String s, int key)
	{
		//Making a StringBuilder with a message(encrypted)
		StringBuilder encrypted = new StringBuilder(s);
		//Writing down the alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//Compute the shifted alphabet
		String shiftedAlphabets = alphabets.substring(key) + alphabets.substring(0, key);
		for(int i=0; i<encrypted.length(); i++)
		{
			char currChar = encrypted.charAt(i);
			char upperCurrChar = Character.toUpperCase(currChar);
			int index = alphabets.indexOf(upperCurrChar);
			if(index != -1)
			{
				char newChar = shiftedAlphabets.charAt(index);
				if(Character.isLowerCase(currChar))
				{
					newChar = Character.toLowerCase(newChar);
				}
				encrypted.setCharAt(i, newChar);
			}
		}
		return encrypted.toString();
	}
	
	public static void main(String[] args)
	{
		int key = 15;
		String testCaseString  = "Hetrxpa Utpijgth";
		String encrypted = encrypt(testCaseString, key);
		System.out.println(encrypted);
		System.out.println(encrypt(encrypted, 26-key));
	}
}
