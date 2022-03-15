package pratice;

import java.util.Scanner;

public class BinarySum 
{
	public static void main(String[] args) 
	{
		long b1,b2;
		int i=0; int carry=0;
		int [] sum = new int[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first binary number");
		b1=sc.nextLong();
		System.out.println("enter the second binary number ");
		b2=sc.nextLong();
		while(b1!=0 || b2!=0)
		{
			sum[i]=(int)((b1%10+b2%10+carry)%2);
			i++;
			carry =(int)((b1%10+b2%10+carry)/2);
					b1=b1/10;
					b2=b2/10;
		}
		if(carry!=0)
		{
			sum[i++]=carry;
		}
		i--;
		System.out.println("sum of two binary numbers is:      ");
		while(i>=0)
		{
			System.out.println(sum[i]);
			i--;
		}
		System.out.print("\n");
			
		
	}

}
