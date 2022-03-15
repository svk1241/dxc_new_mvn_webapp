package com.dxc.library.ui;
import java.util.*;
import java.util.ArrayList;
import com.dxc.library.dto.Member;
import com.dxc.library.dao.MemberDAO;
import com.dxc.library.dao.DBConnection;
public class MemberUI
{
	private static MemberDAO mdao = new MemberDAO();
	public  static String insertMemberDetails(Scanner sc)
	{
		Member m=new Member();
		System.out.println("enter member id :-");
		m.setMemberId(sc.nextInt());
		sc.nextLine();
		System.out.println("enter member name");
		m.setName(sc.nextLine());
		System.out.println("enter aadar number");
		m.setAadaharNo(sc.nextLine());
		System.out.println("enter mobile number");
		m.setPhone(sc.nextLong());
		sc.nextLine();
		System.out.println("enter email id ");
		m.setEmailId(sc.nextLine());
		System.out.println();
		return mdao.insertMemberDetails(m) ? " Member Inserted Successfully"  : "Member Insertion Failed";
	}
	public static String deleteMemberDetails(Scanner sc)
	{
		System.out.println("emter member id to delete");
		int memberId =sc.nextInt();
		sc.hasNextLine();
		return mdao.deleteMemberDetails(memberId) ? "Memner deleted succesfully" : "Member deletion Failed";
	}
	public static String modifyMemberDetails( Scanner sc)
	{
		Member m= new Member();
		System.out.println("enter member id to modify");
	    m.setMemberId(sc.nextInt());
		sc.nextLine();
		System.out.println("enter member new phone number ");
		m.setPhone(sc.nextLong());
		sc.nextLine();
		System.out.println("enter member new mail id");
		m.setEmailId(sc.nextLine());
		return mdao.modifyMemberDetails(m) ? "member details modified" : "memeber details failed";
	}
	public static void showMemberDetails(Scanner sc)
	{
		System.out.println(" enter member id to view datails ");
		int memberId =sc.nextInt();
		sc.nextLine();
		Member m = mdao.getMemberDetails(memberId);
		if(m!=null) System.out.println(m);
		else  System.out.println("meber withh id "+memberId+"does number");
	}
	public static void showAllMemberDetails()
	{
		for(Member m : mdao.getAllMemberDetails())
			System.out.println(m);
	
		
		
		
		
		
	}
	

}
