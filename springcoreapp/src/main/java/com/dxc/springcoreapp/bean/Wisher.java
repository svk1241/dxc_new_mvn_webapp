package com.dxc.springcoreapp.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Wisher implements DisposableBean,InitializingBean
{
	String message;
	public Wisher()
	{
		System.out.println("Wisher object is Created");
	}
	public void setMessage(String message)
	{
		this.message=message;
		
	}
	public String getMessage()
	{
		return message;
	}
	public void initWisher()
	{
		System.out.println("Wisher Init Method");
	}
	public void destroyWisher()
	{
		System.out.println("Wisher Destroy Method");
	}
	public void afterPropertiesSet()
	{
		System.out.println("From After property set");
	}
	public void destroy()
	{
		System.out.println("From Destroy");
	}

}
