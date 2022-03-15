package com.dxc.library.ui;

import java.util.*;

import com.dxc.library.dto.Member;
import com.dxc.library.hibdao.MemberDAO;
import com.dxc.library.hibdao.HibernateUtility;

public class MemberUI {
	private static MemberDAO mdao = new MemberDAO(HibernateUtility.getSessionFactory());

	public static String insertMemberDetails(Scanner sc) {
		Member m = new Member();
		System.out.print("Enter member id :- ");
		m.setMemberId(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Member Name :- ");
		m.setName(sc.nextLine());
		System.out.print("Enter member Aadhar number :-");
		m.setAadaharNo(sc.nextLine());
		System.out.print("Enter Member Phone number :-");
		m.setPhone(sc.nextLong());
		sc.nextLine();
		System.out.print("Enter Member Email id :-");
		m.setEmailId(sc.nextLine());
		System.out.println();
		return mdao.insertMemberDetails(m) ? "Member Inserted Sucessfully" : "Member Insertion Failed";

	}

	public static String deleteMemberDetails(Scanner sc) {
		System.out.print("Enter Member Id to delete :-");
		int memberId = sc.nextInt();
		sc.nextLine();
		return mdao.deleteMemberDetails(memberId) ? "Member Deleted Sucessfully" : "Member Deletion Failed";

	}

	public static String modifyMemberDetails(Scanner sc) {
		int id;
		long num;
		String em;
		System.out.print("Enter Member Id to modify :-");
		id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Member new phone number :-");
		num = sc.nextLong();
		sc.nextLine();
		System.out.print("Enter Member new Email id :-");
		em = sc.nextLine();
		return mdao.modifyMemberDetails(id, num, em) ? "Member details modified" : "member details modification failed";
	}

	public static void showMemberDetails(Scanner sc) {
		System.out.print("Enter member id to view details :-");
		int memberId = sc.nextInt();
		sc.nextLine();
		Member m = mdao.getMemberByMemberId(memberId);
		if (m != null)
			System.out.println(m);
		else
			System.out.println("Member with Id " + memberId + " Does not Exist");

	}

	public static void showAllMembersDetails() {
		for (Member m : mdao.getAllMembersDetails())
			System.out.println(m);
	}
}