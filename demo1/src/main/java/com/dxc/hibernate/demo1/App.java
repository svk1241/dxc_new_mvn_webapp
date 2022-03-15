package com.dxc.hibernate.demo1;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dxc.hibernate.demo1.dao.BookDAO;
import com.dxc.hibernate.demo1.entity.Book;
import com.dxc.hibernate.demo1.entity.HourlyEmployee;
import com.dxc.hibernate.demo1.entity.SalariedEmployee;
public class App 
{
    public static void main( String[] args )
    {
    	/*Properties prop=new Properties();
    	prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    	prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/svk");
    	prop.setProperty("hibernate.connection.username", "root");
    	prop.setProperty("hibernate.connection.password", "1999");
    	prop.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQLDialect");
    	prop.setProperty("hibernate.show_sql", "true");*/
    	/*Configuration cfg=new Configuration();
    	cfg.configure();*/
    	StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
    	MetadataSources sources =new MetadataSources(registry);
    	Metadata data =sources.getMetadataBuilder().build();
    	
    	//cfg.addProperties(prop);
    	//cfg.addResource("Book.hbm.xml");
    	//cfg.addAnnotatedClass(Book.class);
        //SessionFactory factory=cfg.buildSessionFactory();
        SessionFactory factory=data.getSessionFactoryBuilder().build();
        Session session= factory.openSession();
        SalariedEmployee se = new SalariedEmployee(103,"Sharma",14000);
        HourlyEmployee he = new HourlyEmployee(104,"ntr",30,25);
        Transaction trans = session.beginTransaction();
        //BookDAO bdao = new BookDAO(factory);
         //bdao.insertBook(new Book(7003,"c complete","xyz","abc",554,"c",10,10));
         /* Book b = bdao.getBookByBookId(2);
          if(b!=null)System.out.println(b.getBookTitle()+" "+b.getAuthor()+" "+b.getPrice());
         // Book b = new Book(1,"java comp","Herbert kyl","Oracle press",999,"java",10,5);
         // bdao.modifyBook(b);
         /* Book b = new Book();
          b.setBookId(7002);
          bdao.deleteBook(b);*/
        /*Session session= factory.openSession();
        Book b =new Book(7001,"java ref","Herbert","Oracle",800,"java",20,10);
        Transaction trans = session.beginTransaction();*/
       /* Book b = new Book(7010,"Python Black","Karanam","Mgcraw","560","Python",10,10);*/
       /* Transaction trans = session.beginTransaction();
        Book b = session.load(Book.class,7001);
        System.out.println(b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher());
    	System.out.println(b.getPrice()+" "+b.getSubject()+" "+b.getTotalCopies());*/
      //  Book b =new Book(7001,"java ref","Herbert","Oracle",800,"java",20,10);
        //session.saveOrUpdate(b);*/
       /* Book b = new Book();
        b.setBookId(7004);
        b.setBookTitle("Mastering C++");
   	    b.setAuthor("Anil Mohan");
   	    b.setPrice(500);
   	    session.update(b);*/
       /* Book b =session.get(Book.class,7004);
        if(b!=null)
        {
        	 b.setBookTitle("Mastering CPP");
        	 b.setAuthor("gopal");
        	 b.setPrice(1000);
        	 session.update(b);
        }
       // b.setBookId(7001);
       /* session.delete(b);*/
        
       // session.save(b);
        session.save(se);
        session.save(he);
        trans.commit();
        session.close();
        factory.close();
       /* Book b=session.get(Book.class,7005);
        if(b!=null)
        {
        	System.out.println(b.getBookTitle()+" "+b.getAuthor()+" "+b.getPublisher());
        	System.out.println(b.getPrice()+" "+b.getSubject()+" "+b.getTotalCopies());
        	
        }
        else System.out.println("book id is not existing");
        session.close();
        factory.close();*/
    }
}