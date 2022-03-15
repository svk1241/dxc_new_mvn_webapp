package com.dxc.library.hibdao;

import com.dxc.library.dao.DBConnection;

import com.dxc.library.dto.Member;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class MemberDAO {
	SessionFactory factory;

	public MemberDAO(SessionFactory factory) {
		this.factory = factory;
	}

	public boolean insertMemberDetails(Member b) {
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

	public boolean deleteMemberDetails(int MemberId) {
		Session session = null;
		try {
			Member b = new Member();
			b.setMemberId(MemberId);
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

	public boolean modifyMemberDetails(int id, long num, String em) {
		Session session = null;
		try {
			Member m = new Member();
			session = factory.openSession();
			m = session.get(Member.class, id);
			m.setPhone(num);
			m.setEmailId(em);
			session.update(m);
			session.beginTransaction().commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return true;
	}

	public Member getMemberByMemberId(int MemberId) {
		Session session = null;
		Member b = null;
		try {
			session = factory.openSession();
			b = session.get(Member.class, MemberId);
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}

	public Member getMemberDetailsByTitle(String title) {
		Session session = null;
		Member b = null;
		try {
			session = factory.openSession();
			b = session.get(Member.class, title);
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public List<Member> getAllMembersDetails()
	{
		List<Member> blist = new ArrayList<>();
		Session session = null;
		try {
			session = factory.openSession();
			blist = session.createCriteria(Member.class).list();			
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return blist;
		
	}

}
