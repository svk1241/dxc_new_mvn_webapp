package com.dxc.library.hibdao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.library.dto.Member;
import com.dxc.library.dto.Transaction;

public class TransactionDAO 
{
	SessionFactory factory;
	public TransactionDAO(SessionFactory factory)
	{
		this.factory=factory;
	}
	public boolean issueBookTransaction(Transaction t)
	{
		Session session = null;
		try
		{
			session=factory.openSession();
			session.save(t);
			session.beginTransaction().commit();
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
	public boolean returnBookTransaction(int memberId)
	{
		Session session = null;
		try
		{
			Member m = new Member();
			session=factory.openSession();
			m = session.get(Member.class, memberId);
			session.update(m);
			session.beginTransaction().commit();
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