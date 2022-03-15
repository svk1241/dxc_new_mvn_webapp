package com.dxc.library.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bookstatus1")
public class BookStatus 
{
	@Id
	int bookId;
	int totalCopies;
	int availableCopies;
	public BookStatus() {}
	public BookStatus(int bookId, int totalCopies, int availableCopies) {
		super();
		this.bookId = bookId;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	

}
