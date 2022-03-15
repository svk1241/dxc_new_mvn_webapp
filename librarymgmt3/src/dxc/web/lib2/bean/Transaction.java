package dxc.web.lib2.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Transaction 
{
	int memberId;
	int bookId;
	LocalDate bookIssueDate;
	LocalDate bookReturnDate;
	char status;
	public Transaction() { }
	public Transaction(int memberId, int bookId, LocalDate bookIssueDate, LocalDate bookReturnDate, char status) {
		
		this.memberId = memberId;
		this.bookId = bookId;
		this.bookIssueDate = bookIssueDate;
		this.bookReturnDate = bookReturnDate;
		this.status = status;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public LocalDate getBookIssueDate() {
		return bookIssueDate;
	}
	public void setBookIssueDate(LocalDate bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}
	public LocalDate getBookReturnDate() {
		return bookReturnDate;
	}
	public void setBookReturnDate(LocalDate bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	

}
