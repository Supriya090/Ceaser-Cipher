package coursera;

public class NewCeaserCipher {
	/*public static String encrypt(String input, int key)
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlphabets = alphabet.substring(key) + alphabet.substring(0,  key);
		StringBuilder newStringB = new StringBuilder(input); 
		for(int i =0; i<newStringB.length(); i++)
		{
			char eachCharacter = newStringB.charAt(i);
			char upperEachCharacter = Character.toUpperCase(eachCharacter);
			int index = alphabet.indexOf(upperEachCharacter);
			if(index != -1)
			{
				char newChar = shiftAlphabets.charAt(index);
				if(Character.isLowerCase(eachCharacter))
				{
					newChar = Character.toLowerCase(newChar);
				}
				newStringB.setCharAt(i, newChar);
			}
		}
		return newStringB.toString();
	}*/
	
	public static String encryptTwoWays(String input, int key1, int key2 )
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftAlphabets1 = alphabet.substring(key1) + alphabet.substring(0,  key1);
		String shiftAlphabets2 = alphabet.substring(key2) + alphabet.substring(0,  key2);
		StringBuilder newStringB = new StringBuilder(input); 
		for(int i =0; i<newStringB.length(); i++)
		{
			char eachCharacter = newStringB.charAt(i);
			char upperEachCharacter = Character.toUpperCase(eachCharacter);
			int index = alphabet.indexOf(upperEachCharacter);
			char newChar;			if(index != -1)
			{
				if(i%2 == 0)
				{
					newChar = shiftAlphabets1.charAt(index);
				}
				else {
					newChar = shiftAlphabets2.charAt(index);
				}
				if(Character.isLowerCase(eachCharacter))
				{
					newChar = Character.toLowerCase(newChar);
				}
				newStringB.setCharAt(i, newChar);
			}
		}
		return newStringB.toString();
	}
	
	public static void main(String[] args)
	{
		String newString = "Top ncmy qkff vi vguv vbg ycpx";
		int key1 = 2, key2 = 20;
		System.out.println(encryptTwoWays(newString, key1, key2));
	}
}
