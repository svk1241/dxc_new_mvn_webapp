package com.dxc.library.hibdao;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.library.dto.Book;
import com.dxc.library.dto.BookStatus;

public class BookStatusDAO 
{
	SessionFactory factory;
	public BookStatusDAO(SessionFactory factory)
	{
		this.factory=factory;
	}
	public void insertBookStatus(BookStatus b)
	{
		Session session = null;
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
			if(session!=null)
				session.close();
		}
	}
	public void modifyBookStatus(BookStatus b)
	{
		Session session = null;
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
			if(session!=null)
				session.close();
		}
	}
	public Book getAvailableCopies(int bookId)
	{
		Session session = null;
		Book b = null;
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
			if(session!=null)
				session.close();
		}
		  return b;
	}
	public boolean modifyBookStatus(char c, int bookId)
	{
		Session session = null;
		Book b = null;
		try
		{
			session=factory.openSession();
			b=session.get(Book.class,bookId);
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return true;
	}	
}