package com.dxc.hibernate.demo1.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.dxc.hibernate.demo1.entity.Book;
public class BookDAO {
SessionFactory factory;
public BookDAO(SessionFactory factory) {this.factory=factory;}
public void insertBook(Book b)
{
	Session session=null;
	try
	{
	session=factory.openSession();
	session.save(b);
	session.beginTransaction().commit();
	}
	catch(HibernateException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		if(session!=null) session.close();
	}
}
	public void deleteBook(Book b)
	{
		Session session=null;
		try
		{
		session=factory.openSession();
		session.delete(b);
		session.beginTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
	}
	public void modifyBook(Book b)
	{
		Session session=null;
		try
		{
		session=factory.openSession();
		session.update(b);
		session.beginTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
	}
	public Book getBookByBookId(int bookId)
	{
		Session session=null;
		Book b=null;
		try
		{
		session=factory.openSession();
		b=session.get(Book.class,bookId);
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
		return b;
}
}