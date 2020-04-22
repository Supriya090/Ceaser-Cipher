package coursera;

public class WordPlay {
	public static boolean isVowel(char ch)
	{
		char UpperCasech = Character.toUpperCase(ch);
		if (UpperCasech == 'A' || UpperCasech == 'E'||UpperCasech == 'I'||UpperCasech == 'O'||UpperCasech == 'U')
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String replace(String phrase, char ch)
	{
		StringBuilder newString = new StringBuilder(phrase);
		for(int i=0; i<newString.length(); i++)
		{
			char phraseChar = newString.charAt(i);
			if(isVowel(phraseChar))
			{
				newString.setCharAt(i,ch);
			}
		}
		return newString.toString();
		
	}
	
	public static String emphasize(String phrase, char ch)
	{
		StringBuilder newStringBuilder = new StringBuilder(phrase);
		for(int i =0; i<newStringBuilder.length(); i++)
		{
			char eachCharacter = newStringBuilder.charAt(i);
			int index = i + 1;
			if(Character.toLowerCase(eachCharacter) == ch)
			{
				if(index%2 == 0)
				{
					newStringBuilder.setCharAt(i, '+');
				}
				else {
					newStringBuilder.setCharAt(i, '*');
				}
			}
		}
		return newStringBuilder.toString();
	}
	
	public static void main(String[] args)
	{
		String newString = "Mary Bella Abracadabra";
		System.out.println(replace(newString, '*'));
		System.out.println(emphasize(newString, 'a'));
	}
}
