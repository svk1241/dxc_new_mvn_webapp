package com.dxc.demo;
public class Utility2 
{
	public int power(int x,int n)
	{
		int res =1;
		for(;n>0;n--)
			res=res*x;
		return res;
	}

}
