package com.dxc.jenkinsdemo.bussiness;

public class Calculator 
{
	int x=10;
	public int sum(int x, int y)
	{
		return x+y;
		
	}
	public int square(int x)
	{
		return x*x;
		
	}
	public int power(int x,int n)
	{
		int res =1;
		for(;n>0;n--)
			 res =res*x;
		return res;
		
	}
	public int divide(int x,int y)
	{
		int res=0;
		try
		{
			res=x/y;
			
		}
		catch(ArithmeticException ex) {
			
		}
		  return res;
	}
      
}
