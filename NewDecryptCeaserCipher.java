package coursera;

public class NewDecryptCeaserCipher {
	public static int[] countElements(String str)
	{
		int[] counter1 = new int[26];
		int[] counter2 = new int[26];
		//Writing down the alphabets
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<str.length(); i++)
		{
			char currChar = str.charAt(i);
			char upperCurrChar = Character.toUpperCase(currChar);
			int index = alphabets.indexOf(upperCurrChar);
			if(index != -1)
			{
				if(i%2 == 0)
				{
					counter1[index]++;
				}
				else {
					counter2[index]++;
				}
				
			}
		}
		
		int[] max = new int[2];
		int[] maxIndex = new int[2];
		max[0] = counter1[0];
		max[1] = counter2[0]; 
        
        // Traverse array elements from second and 
        // compare every element with current max   
        for (int i = 1; i < counter1.length; i++) 
        {   
        	if (counter1[i] > max[0])
        	{
                max[0] = counter1[i];
                maxIndex[0] = i;
        	}
            
        	if(counter2[i]>max[1])
        	{
        		max[1] = counter2[i];
        		maxIndex[1] = i;
        	}
        }	
       
        return maxIndex;
	}
	
	
	public static String decrypt(String str)
	{
		//CeaserCipher ccCeaserCipher = new CeaserCipher();
		int[] maxElements = countElements(str);
		//System.out.println(max+" ");
		int dKey1 = maxElements[0] - 4;
		int dKey2 = maxElements[1] - 4;
		if(maxElements[0]<4)
		{
			dKey1 = 26 - (4-maxElements[0]);
		}
		if(maxElements[1]<4)
		{
			dKey2 = 26 - (4-maxElements[1]);
		}
		int key1 = 26-dKey1, key2 = 26-dKey2;
		System.out.println(key1+" "+ key2);
		return encryptTwoWays(str, key1, key2);
	}
	
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
		String testString = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
		System.out.println(decrypt(testString));
	}
}
