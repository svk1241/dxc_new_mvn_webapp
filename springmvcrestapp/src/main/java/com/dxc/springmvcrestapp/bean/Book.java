package com.dxc.springmvcrestapp.bean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement(name="books")
public class Book {
	@Id
    int bookId;
    String bookTitle;
    String author;
    String publisher;
    double price;
    String subject;
    int totalCopies;
    int availCopies;
    public Book() { }
	public Book(int bookId, String bookTitle, String author, String publisher, double price, String subject,
			int totalCopies, int availCopies) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.subject = subject;
		this.totalCopies = totalCopies;
		this.availCopies = availCopies;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	public int getAvailCopies() {
		return availCopies;
	}
	public void setAvailCopies(int availCopies) {
		this.availCopies = availCopies;
	}
	
	
}