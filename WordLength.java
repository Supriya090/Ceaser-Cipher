package coursera;

import java.util.Arrays;

public class WordLength {
	public static int[] countLength(String str)
	{
		int[] lengthCounter = new int[18];
		Arrays.fill(lengthCounter, 0);
		
		int counter = 0;
		for(int i =0; i<str.length(); i++)
		{
			char ch = Character.toLowerCase(str.charAt(i));
			//System.out.print(ch+" ");
			if(ch>=97 && ch<=122)
			{
				counter++;
				//System.out.print(counter+" ");
			}
			else
			{
				if(lengthCounter[counter] != 0)
				{
					lengthCounter[counter]++;
					counter = 0;
				}
				else
				{
					lengthCounter[counter] = 1;
					counter = 0;
				}
			}
		}
		if(lengthCounter[counter] != 0)
		{
			lengthCounter[counter]++;
			counter = 0;
		}
		else
		{
			lengthCounter[counter] = 1;
			counter = 0;
		}
		return lengthCounter;
	}
	
	public static void main(String[] args)
	{
		String testString = "THE TRAGEDY OF ROMEO AND JULIET\r\n" + 
				"\r\n" + 
				"by William Shakespeare.";
		int[] count  = countLength(testString);
		// Initialize maximum element 
        int max = count[1], maxIndex =0; 
        
        // Traverse array elements from second and 
        // compare every element with current max   
        for (int i = 1; i < count.length; i++) 
        {   
        	System.out.println("Counter["+i+"] = "+count[i]);
        	if (count[i] > max)
        	{
                max = count[i];
                maxIndex = i;
        	}
               
        }	
        System.out.print(maxIndex+" ");

	}
}
