package com.dxc.library.ui;
import java.time.LocalDate;
import java.util.Scanner;
import com.dxc.library.hibdao.BookDAO;
import com.dxc.library.hibdao.BookStatusDAO;
import com.dxc.library.hibdao.MemberDAO;
import com.dxc.library.hibdao.TransactionDAO;
import com.dxc.library.dto.Book;
import com.dxc.library.dto.Member;
import com.dxc.library.dto.Transaction;
import com.dxc.library.hibdao.HibernateUtility;
public class TransactionUI 
{
	private static BookStatusDAO bsDao = new BookStatusDAO(HibernateUtility.getSessionFactory());
	private static TransactionDAO tDao = new TransactionDAO(HibernateUtility.getSessionFactory());
	private static MemberDAO mDao = new MemberDAO(HibernateUtility.getSessionFactory());
	private static BookDAO bDao = new BookDAO(HibernateUtility.getSessionFactory());
    public static String issueBookTransaction(Scanner sc)
    {
    	Transaction t = new Transaction();
    	System.out.println("Enter Member Id:- ");
    	t.setMemberId(sc.nextInt());
    	sc.nextLine();
    	Member m = mDao.getMemberByMemberId(t.getMemberId());
    	/*if(m!=null)
    	{
    		System.out.print("Enter Book Title :-");
    		String title = sc.next();
    		//Book b = bDao.getBookDetailsByTitle(title);
    		if(b!=null)
    		{
    			t.setBookId(b.getBookId());
    			t.setBookIssueDate(LocalDate.now());
    			t.setBookReturnDate(null);
    			t.setStatus('i');
    			bsDao.modifyBookStatus('i',b.getBookId());
    			return tDao.issueBookTransaction(t) ? " Transaction Entered Successfully" : " Transaction failed" ;
    		}
    		else
    			return "Invalid Book Title";*/
    	if(m!=null)
    	{
    		System.out.print("Enter Book Id :-");
    		int Id = sc.nextInt();
    		//Book b = bDao.getBookDetailsByTitle(title);
    		Book b = bDao.getBookDetailsByBookId(Id);
    		if(b!=null)
    		{
    			t.setBookId(b.getBookId());
    			t.setBookIssueDate(LocalDate.now());
    			t.setBookReturnDate(null);
    			t.setStatus('i');
    			bsDao.modifyBookStatus('i',b.getBookId());
    			return tDao.issueBookTransaction(t) ? " Transaction Entered Successfully" : " Transaction failed" ;
    		}
    		else
    			return "Invalid Book Id";
    	}
    	else
    		return "Enetered Invalid Member Id";
     }
    public static String returnBookTransaction(Scanner sc)
    {
    	System.out.print("Enter Member Id :-");
    	int memberId = sc.nextInt();
    	sc.nextLine();
    	System.out.print("Enter Book Id :-");
    	int bookId = sc.nextInt();
    	sc.nextLine();
    	if(tDao.returnBookTransaction(memberId))
    	{
    		return bsDao.modifyBookStatus('r', bookId) ? "Book returned successfully ": "Book returned failed ";
    	}
    	return "Book Return Transaction cannot Updated";
    }
}