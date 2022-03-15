package dxc.web.lib2.service;
import dxc.web.lib2.bean.Transaction;
import dxc.web.lib2.dao.TransactionDAO;
import dxc.web.lib2.bean.Book;
import dxc.web.lib2.dao.BookDAO;
import java.time.LocalDate;
import java.util.ArrayList;
public class TransactionService
{
	TransactionDAO tdao = new TransactionDAO();
	BookDAO bdao = new BookDAO();
	public ArrayList<Book> getBooksBySubject(String subject)
	{
		return bdao.getBooksBySubject(subject);
	}
	public boolean checkIn(int memberId,int bookId)
	{
		Transaction t = new Transaction();
		t.setBookId(bookId);
		t.setMemberId(memberId);
		t.setBookIssueDate(LocalDate.now());
		t.setStatus('i');
		if(tdao.issueBookTransaction(t))
			return bdao.modifyBookAvailCopies((byte)1, bookId);
		throw new RuntimeException("Book Issue Exception");
		
	}
	public boolean checkOut(int memberId,int bookId)
	{
		if(tdao.returnBookTransaction(memberId, bookId))
			return bdao.modifyBookAvailCopies((byte)2, bookId);
		throw new RuntimeException("Book Issue Exception");
		
	//	return tdao.returnBookTransaction(memberId);
		   
	}
	public ArrayList<Object[]> getTransactionByMemberId(int memberId)
	{
		return tdao.getTransactionDetailsByMemberId(memberId);
	}

}
