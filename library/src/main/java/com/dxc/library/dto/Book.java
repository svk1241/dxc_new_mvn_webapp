package com.dxc.library.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book2")
public class Book {
	@Id
    int bookId;
    String bookTitle;
    String author;
    String Publisher;
    double price;
    public Book() { }
	public Book(int bookId, String bookTitle, String author, String publisher, double price) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		Publisher = publisher;
		this.price = price;
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
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
       public  String toString()
        {
    	return "Book Id"+bookId+"\nBook Title :-"+bookTitle+"\nBook Author :-"+author+"\n Book Publisher :-"+Publisher+"\nBook Price :-"+price;
        }
}
