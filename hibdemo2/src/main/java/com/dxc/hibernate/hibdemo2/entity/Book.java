package com.dxc.hibernate.hibdemo2.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@NamedQueries(value = {@NamedQuery(name="getBookBySubject", query="from Book b where b.subject=:sub"),@NamedQuery(name="getAllBooks",query="from Book")})

@Entity
@Table(name="book")
public class Book {
	@SequenceGenerator(allocationSize=1,name="my_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="bookid",columnDefinition="int")
    int bookId;
	@Column(name="booktitle",columnDefinition="varchar(20)")
    String bookTitle;
    @Column(name="author",columnDefinition="varchar(20)")
    String author;
    @Column(name="publisher",columnDefinition="varchar(20)")
    String Publisher;
    @Column(name="price",columnDefinition="decimal")
    double price;
    @Column(name="subject",columnDefinition="varchar(15)")
    String subject;
    @Column(name="totalcopies",columnDefinition="int")
    int totalCopies;
    @Column(name="availcopies",columnDefinition="int")
    int availCopies;
    public Book() { }
	
       public Book(int bookId, String bookTitle, String author, String publisher, double price, String subject,
			int totalCopies, int availCopies) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		Publisher = publisher;
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

