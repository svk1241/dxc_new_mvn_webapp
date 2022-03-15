package com.dxc.springcoreapp;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.dxc.springcoreapp.bean.Address;
import com.dxc.springcoreapp.bean.Country;
import com.dxc.springcoreapp.bean.Department;
import com.dxc.springcoreapp.bean.Employee;
import com.dxc.springcoreapp.bean.Person;
import com.dxc.springcoreapp.bean.Wisher;
import com.dxc.springcoreapp.config.ApplicationConfig;
import com.dxc.springcoreapp.bean.Book;

import java.util.Map.Entry;

public class App 
{
    public static void main( String[] args )
    {
    	/*ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans2.xml");
    	 //Person p = container.getBean("per1",Person.class);
    	 Person p = container.getBean(Person.class);
         System.out.println(p.getSsn()+" "+p.getName());
         System.out.println(p.getAddress().getHno()+" "+p.getAddress().getStreetName());
         System.out.println(p.getAddress().getCity()+" "+p.getAddress().getState());  */
  
    	ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans2.xml");
         Book b = container.getBean("b1",Book.class);
         System.out.println(b.getBookId()+" "+b.getBookTitle());
       container.close();
    }
}



/*  ApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       //Wisher w = (Wisher)container.getBean("w1");
        Wisher w = container.getBean("w1",Wisher.class);
       System.out.println(w.getMessage());
       Wisher w2 = container.getBean("w1",Wisher.class);
       System.out.println(w2.getMessage());
        w2.setMessage("hello");
       System.out.println(w2.getMessage());  */
  /* ApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       //Wisher w = (Wisher)container.getBean("w1");
        Wisher w = container.getBean("w1",Wisher.class);
        Wisher w2 = container.getBean("w1",Wisher.class);
        w2.setMessage("hello");
        System.out.println(w.getMessage());
       System.out.println(w2.getMessage()); */
/*   ApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       System.out.println("Container is created");
       Wisher w = container.getBean("w1",Wisher.class); */
/*  ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       Wisher w = container.getBean("w1",Wisher.class);
       container.close(); */
/*  ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
       Wisher w = container.getBean("w1",Wisher.class);
       System.out.println(w.getMessage());
       container.close();
      */
/*  ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
      Address  a1 = container.getBean("add1",Address.class);
      System.out.println(a1.getHno());
      System.out.println(a1.getStreetName());
      System.out.println(a1.getCity());
      System.out.println(a1.getState());
       container.close();
       */
/* //FileSystemXmlApplicationContext container = new FileSystemXmlApplicationContext("C:/Users/ssankarshna/OneDrive - DXC Production/Desktop/Beans.xml");
       Person p = container.getBean("per1",Person.class);
       System.out.println(p.getSsn()+" "+p.getName());
       System.out.println(p.getAddress().getHno()+" "+p.getAddress().getStreetName());
       System.out.println(p.getAddress().getCity()+" "+p.getAddress().getState());
      */
/*  ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
    Country c1 = container.getBean("cty1",Country.class);
    System.out.println(c1.getCountryName()+" "+c1.getContinentName());
    System.out.println("States");
    List<String> states =c1.getStates();
    System.out.println(states.getClass().getName());
    for(String s : states)
    	System.out.println(s);
       container.close(); */
/* ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
    Country c1 = container.getBean("cty1",Country.class);
    System.out.println(c1.getCountryName()+" "+c1.getContinentName());
    System.out.println("States");
    Map<String,String> states =c1.getStates();
    System.out.println(states.getClass().getName());
    for(Entry<String,String> ent : states.entrySet())
    	System.out.println(ent.getKey()+" "+ent.getValue());
       container.close(); */
/*    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
      Employee e =container.getBean("emp",Employee.class);
      System.out.println(e.getEmpId()+" "+e.geteName());
      System.out.println(e.getSalary().getHra()+" "+e.getSalary().getdA()+""+e.getSalary().getBasic());
      */
/*Department d = container.getBean("dept1",Department.class);
      System.out.println(d.getDeptNo()+" "+d.getDeptName());
      for(Employee e : d.getEmployees())
    	  System.out.println(e.getEmpId()+" "+e.geteName()+" "+e.getSalary());*/
/*
       ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
    	//XmlBeanFactory container = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
    	//Default
      Employee e = container.getBean("emp1",Employee.class);
      System.out.println(e.getEmpId()+" "+e.geteName()+" "+e.getSalary());
      System.out.println(e.getAddress().getHno()+" "+e.getAddress().getStreetName()+" "+e.getAddress().getCity()+" "+e.getAddress().getState());
      
      
      
       container.close();*/
/* ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("Beans.xml");
    	//XmlBeanFactory container = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
    	/*DefaultListableBeanFactory container = new DefaultListableBeanFactory();
    	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(container);
    	reader.loadBeanDefinitions(new ClassPathResource("Beans.xml"));*/
   /*   Employee e = container.getBean("emp1",Employee.class);
      System.out.println(e.getEmpId()+" "+e.geteName()+" "+e.getSalary());
      System.out.println(e.getAddress().getHno()+" "+e.getAddress().getStreetName()+" "+e.getAddress().getCity()+" "+e.getAddress().getState());*/
      
      
      
      // container.close();*/
/* AnnotationConfigApplicationContext container  = new AnnotationConfigApplicationContext(ApplicationConfig.class);
     Person p = container.getBean(Person.class);
     System.out.println(p.getSsn()+" "+p.getName());
     System.out.println(p.getAddress().getHno()+" "+p.getAddress().getStreetName());
     System.out.println(p.getAddress().getCity()+" "+p.getAddress().getState());
      
       */
