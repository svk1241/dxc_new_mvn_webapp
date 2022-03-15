package com.dxc.demo;
public class Utility 
{ 
	public String timeMethod()
	{
		for(long i=1;i<=9999999999999999L;i++);
		return "Done";
	}
	public int sum(int x,int y)
	{
		return x+y;
		
	}
	public int sqr(int x)
	{
		return x*x;
		
	}
	public int division(int x,int y)
	{
		if(y!=0)
			return x/y;
		throw new ArithmeticException();
	}
	

}
