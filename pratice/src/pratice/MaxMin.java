package pratice;

import java.util.Arrays;

public class MaxMin
{
	public static void main(String[] args)
	{
		int [] a = {25,5,12,34,44,1,4};
		Arrays.sort(a);
		int min=a[0];
		System.out.println(min);
		int max=a[a.length-1];
		System.out.println(max);
		
	}

}
