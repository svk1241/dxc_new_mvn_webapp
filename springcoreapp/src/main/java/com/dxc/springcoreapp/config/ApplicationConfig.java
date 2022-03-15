package com.dxc.springcoreapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dxc.springcoreapp.bean.Address;
import com.dxc.springcoreapp.bean.Person;
import com.dxc.springcoreapp.bean.Wisher;

//@Configuration
public class ApplicationConfig          
{
	/*@Bean(initMethod="initWisher",destroyMethod="destroyWisher")
	public Wisher wisher()
	{
		Wisher w = new Wisher();
		w.setMessage("JAVA Configuration");
		return w;
	}*/
	
	
	
	/*@Bean(name="add1")
	public Address address()     //<bean>
	{
		Address add1= new Address();
		add1.setHno("1-125");
		add1.setStreetName("Mg Road");
        add1.setCity("Vijayawada");
        add1.setState("Andhra pradesh");
        return add1;
	}*/
	/*@Bean(name="add2")
	public Address address2()     //<bean>
	{
		Address add1= new Address();
		add1.setHno("1-124");
		add1.setStreetName("ST Road");
        add1.setCity("Vij");
        add1.setState("Uttar pradesh");
        return add1;
	}*/
	
	/*@Bean
	public Person person()     //<bean>
	{
		Person p1 = new Person(7011,"Dinesh",address2());
		/*p1.setSsn(7001);
		p1.setName("Ajay");
		p1.setAddress(address());
		return p1;
	}*/

}
