package coursera;

public class DecryptCeaserCipher {
	public static int[] countElements(String str)
	{
		int[] counter = new int[26];
		//Writing down the alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<str.length(); i++)
		{
			char currChar = str.charAt(i);
			char upperCurrChar = Character.toUpperCase(currChar);
			int index = alphabets.indexOf(upperCurrChar);
			if(index != -1)
			{
				counter[index]++;
			}
		}
		for(int i=0; i<counter.length; i++)
		{
			System.out.print(counter[i]+" ");
		}
		System.out.println();
		return counter;
	}
	
	public static int maxElement(int[] counter)
	{
		// Initialize maximum element 
        int max = counter[0], maxIndex =0; 
        
        // Traverse array elements from second and 
        // compare every element with current max   
        for (int i = 1; i < counter.length; i++) 
        {   if (counter[i] > max)
        	{
                max = counter[i];
                maxIndex = i;
        	}
                System.out.print(maxIndex+" ");
        }	
       
        return maxIndex; 
	}
	
	public static String decrypt(String str)
	{
		//CeaserCipher ccCeaserCipher = new CeaserCipher();
		int[] count = countElements(str);
		int max = maxElement(count);
		System.out.println(max+" ");
		int dKey = max - 4;
		if(max<4)
		{
			dKey = 26 - (4-max);
		}
		System.out.println(dKey);
		return encrypt(str, 26 - dKey);
	}
	
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
		String testString = "Hetrxpa Utpijgth";
		System.out.println(decrypt(testString));
	}
}
