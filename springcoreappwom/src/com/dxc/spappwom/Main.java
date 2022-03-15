package com.dxc.spappwom;

import com.dxc.spappwom.bean.Wisher;

public class Main
{
	public static void main( String[] args )
    {
       ApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       Wisher w = (Wisher)container.getBean("w1");
       System.out.println(w.getMessage());
    }

}
