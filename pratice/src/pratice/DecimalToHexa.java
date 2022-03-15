package pratice;

import java.util.Scanner;

public class DecimalToHexa 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter decimal number");
		int d= sc.nextInt();
		System.out.println("Hexadecimal number is:"+Integer.toHexString(d));
	}

}
