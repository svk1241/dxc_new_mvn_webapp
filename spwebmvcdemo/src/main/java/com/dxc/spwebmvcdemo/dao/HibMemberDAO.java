package com.dxc.spwebmvcdemo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.spwebmvcdemo.bean.Book;
import com.dxc.spwebmvcdemo.bean.Member;

@Repository
public class HibMemberDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public List<Member>getAllMembers()
	{
		Session session =sessionFactory.openSession();
		TypedQuery<Member> qry =session.createNamedQuery("from Member");
		return qry.getResultList();
		
	}
	public Member getMemberid(int memberId)
	{
		Session session=null;
		Member m = null;
		try
		{
			session=sessionFactory.openSession();
			m=session.get(Member.class, memberId);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
		return m;
	}
	public void insertMember(Member m)
	{
		Session session = null;
		Transaction trans =null;
		try
		{
			session = sessionFactory.openSession();
			trans =session.beginTransaction();
			session.save(m);
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
	public void modifyMember(Member m)
	{
		Session session = null;
		Transaction trans =null;
		try
		{
			session = sessionFactory.openSession();
			trans =session.beginTransaction();
			session.update(m);
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
	public boolean deleteMember(int MemberId)
	{
		Session session = sessionFactory.openSession();
		 Transaction trans = session.beginTransaction();
		TypedQuery<Book> qry = session.createQuery("delete from Member where MemberId=?1");
		qry.setParameter(1, MemberId);
		int count = qry.executeUpdate();
		trans.commit();
		return count ==1;
	}
	}


