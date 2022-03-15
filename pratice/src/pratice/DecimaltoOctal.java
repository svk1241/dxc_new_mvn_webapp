package pratice;

import java.util.Scanner;

public class DecimaltoOctal
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the decimal number");
		int d=sc.nextInt();
		System.out.println("Octal number is:"+Integer.toOctalString(d));
	}

}
