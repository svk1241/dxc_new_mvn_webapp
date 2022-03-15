package com.dxc.springcoreapp.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanPostProcessor2 implements BeanPostProcessor,Ordered
{
	public Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException
	{
		System.out.println("From ppbi 2 method");
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean,String beanName)throws BeansException
	{
		System.out.println("From PPAI method will be executed immediately after bean is initalised");
		return bean;
	}
	public int getOrder()
	{
		return 0;
	}

}
