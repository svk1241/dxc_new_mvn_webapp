package com.dxc.spwebmvcdemo.dao;
import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.spwebmvcdemo.bean.Book;

@Repository
public class HibBookDAO 
{
	@Autowired
    SessionFactory sessionFactory;
	public List<Book> getAllBooks()
	{
		Session session =sessionFactory.openSession();
		TypedQuery<Book> qry = session.createQuery("from Book");
		return qry.getResultList();
	}
	public Book getBookById(int bookId)
	{
		Session session = null;
		Book b = null;
		try
		{
			session= sessionFactory.openSession();
			b = session.get(Book.class, bookId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
		return b;
	}
	public void insertBook(Book b)
	{
		Session session=null;
		Transaction trans= null;
		try
		{
			session= sessionFactory.openSession();
			trans = session.beginTransaction();
			session.save(b);
			trans.commit();
			
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
		Transaction trans= null;
		try
		{
			session= sessionFactory.openSession();
			trans = session.beginTransaction();
			session.update(b);
			trans.commit();
			
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
	public boolean deleteBook(int bookId)
	{
		Session session = sessionFactory.openSession();
		 Transaction trans = session.beginTransaction();
		TypedQuery<Book> qry = session.createQuery("delete from Book where bookId=?1");
		qry.setParameter(1, bookId);
		int count = qry.executeUpdate();
		trans.commit();
		return count ==1;
	}
			
		
	}

