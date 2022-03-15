package com.dxc.studentdemo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxc.studentdemo.bean.Student;
@Repository
public class HibStudentDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	public void insertStudent(Student s)
	{
		Session session=null;
		Transaction trans= null;
		try
		{
			session= sessionFactory.openSession();
			trans = session.beginTransaction();
			session.save(s);
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
	public Student getStudentById(int srNo)
	{
		Session session = null;
		Student s = null;
		try
		{
			session= sessionFactory.openSession();
			s = session.get(Student.class, srNo);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
		}
		return s;
	}

}
