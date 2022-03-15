package pratice;

import java.util.Scanner;

public class SumAvg 
{
	public static void main(String[] args) 
	{
		int n=0,i,sum=0;
		double avg=0;
		System.out.println("enter n values");
		for(i=1;i<=5;i++)
		{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		sum=sum+n;
		}
		System.out.println("The sum of 5 numbers is"+sum);
		avg=sum/5;
		System.out.println("The average of 5 numbers is"+avg);
	}
	}
