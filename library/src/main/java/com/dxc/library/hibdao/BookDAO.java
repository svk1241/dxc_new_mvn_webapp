package com.dxc.library.hibdao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.dxc.library.dto.Book;
public class BookDAO {
	SessionFactory factory;

	public BookDAO(SessionFactory factory) {
		this.factory = factory;
	}

	public boolean insertBookDetails(Book b) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(b);
			session.beginTransaction().commit();
		} catch (HibernateException ex) {

			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return true;
	}

	public boolean deleteBook(int bookId) {
		Session session = null;
		try {
			Book b = new Book();
			b.setBookId(bookId);
			session = factory.openSession();
			session.delete(b);
			session.beginTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return true;
	}

	public boolean modifyBook(int id,String pub,double pri ) {
		Session session = null;
		try {
			Book b = new Book();
			session = factory.openSession();
			b = session.get(Book.class, id);
			b.setPublisher(pub);
			b.setPrice(pri);
			session.update(b);
			session.beginTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return true;
	}

	public Book getBookByBookId(int bookId) {
		Session session = null;
		Book b = null;
		try {
			session = factory.openSession();
			b = session.get(Book.class, bookId);
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}

	/*public Book getBookDetailsByTitle(String title) 
	{
		Session session = null;
		TypedQuery<Book> qry = null;
		Book b = null;
		try {
			session = factory.openSession();
			qry = session.createQuery("from Book b where bookTitle=?1");
			qry.setParameter(1, title);
			b = qry.getSingleResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;*/
	public Book getBookDetailsByBookId(int id) 
	{
		Session session = null;
		TypedQuery<Book> qry = null;
		Book b = null;
		try {
			session = factory.openSession();
			qry = session.createQuery("from Book b where bookid=?1");
			qry.setParameter(1, id);
			b = qry.getSingleResult();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public List<Book> getAllBooksDetails()
	{
		List<Book> blist = new ArrayList<>();
		Session session = null;
		try {
			session = factory.openSession();
			blist = session.createCriteria(Book.class).list();			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return blist;
		
	}

}