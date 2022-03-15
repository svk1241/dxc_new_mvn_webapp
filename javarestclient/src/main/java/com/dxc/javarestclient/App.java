package com.dxc.javarestclient;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
public class App 
{
    public static void main( String[] args )
    {
       ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("Beans.xml");
       RestTemplate rTemplate = new RestTemplate();
       String results= rTemplate.getForObject("http://localhost:8089/springmvcrestapp/book/all",String.class);
       System.out.println(results);
    }
}