package com.dxc.spwebmvcdemo.exception;

public class MySpringWebMvcException extends RuntimeException
{
	String message;
	public MySpringWebMvcException(String message) { this.message=message;}
	public String toString()
	{
		return message;
	}

}
