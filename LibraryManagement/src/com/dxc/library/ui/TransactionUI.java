package com.dxc.library.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.dxc.library.dao.BookDAO;
import com.dxc.library.dao.BookStatusDAO;
import com.dxc.library.dao.MemberDAO;
import com.dxc.library.dao.TransactionDAO;
import com.dxc.library.dto.Book;
import com.dxc.library.dto.Member;
import com.dxc.library.dto.Transaction;

public class TransactionUI 
{
	private static BookStatusDAO bsDao =new BookStatusDAO();
	private static TransactionDAO tDao = new TransactionDAO();
	private static MemberDAO mDao = new MemberDAO();
	private static BookDAO bDao =new BookDAO();
	public static String issueBook(Scanner sc)
	{
		Transaction t = new Transaction();
		System.out.println("Enter Member Id :-");
		t.setMemberId(sc.nextInt());
		sc.nextLine();
		Member m = mDao.getMemberDetails(t.getMemberId());
		if(m!=null)
		{
			System.out.println("Enter Book Title");
			String title = sc.nextLine();
			Book b=bDao.getBookDetailsByTitle(title);
			if(b!=null)
			{
				t.setBookId(b.getBookId());
				t.setBookIssueDate(LocalDate.now());
				t.setBookReturnDate(null);
				t.setStatus('i');
				bsDao.modifyBookStatus('i', b.getBookId());
				return tDao.issueBookTransaction(t) ? "Transaction Entered Succesfulluy" : "Transaction Failed";
			}
			else 
				return "Invalid Book Title";
		}
		else 
			return  " Enter Invalid Member Id" ;
	}
	public static String returnBook(Scanner sc)
	{
		System.out.println("Enter Member Id :-");
		int memberId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Id :-");
		int bookId = sc.nextInt();
		sc.nextLine();
		if(tDao.returnBookTransaction(memberId))
		{
			return bsDao.modifyBookStatus('r', bookId) ? "Book Returned Succesfully" : "Book Return Failed";
			
		}
		return " Book Return Transaction Cannot Updated";
		
		
	}

}
