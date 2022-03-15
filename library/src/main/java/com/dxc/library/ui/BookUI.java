package com.dxc.library.ui;

import java.util.Scanner;
import com.dxc.library.dto.Book;
import com.dxc.library.hibdao.BookDAO;
import com.dxc.library.hibdao.BookStatusDAO;
import com.dxc.library.hibdao.HibernateUtility;
import com.dxc.library.dto.BookStatus;

public class BookUI {
	static BookDAO bdao = new BookDAO(HibernateUtility.getSessionFactory());
	static BookStatusDAO bsDao = new BookStatusDAO(HibernateUtility.getSessionFactory());

	public static String addBookDetails(Scanner sc) {
		Book b = new Book();
		BookStatus bs = new BookStatus();
		System.out.print("Enter Book Id :-");
		b.setBookId(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Book Title :-");
		b.setBookTitle(sc.nextLine());
		System.out.print("Enter Book Author :- ");
		b.setAuthor(sc.nextLine());
		System.out.println("Enter Book Publisher :-");
		b.setPublisher(sc.nextLine());
		System.out.print("Enter Book price :-");
		b.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.print("Enter number of copies ");
		bs.setAvailableCopies(sc.nextInt());
		sc.nextLine();
		System.out.println();
		bs.setBookId(b.getBookId());
		bs.setTotalCopies(bs.getAvailableCopies());
		bsDao.insertBookStatus(bs);
		return bdao.insertBookDetails(b) ? "Book Added Successfully" : "Book Cannot be Added";
	}

	public static String deleteBook(Scanner sc) {
		System.out.print("Enter Book Id to Delete :- ");
		;
		int bookId = sc.nextInt();
		sc.nextLine();
		return bdao.deleteBook(bookId) ? "Book Deleted successfully" : "Book Deletion failed";

	}

	public static String modifyBook(Scanner sc)
	{
		int id;
		String pub;
		double pri ;
		System.out.print("Enter Bookid to Modify :-");
		id=sc.nextInt();
		sc.nextLine();
		System.out.print("enter Book new Publisher :-");
		pub=sc.nextLine();
		System.out.print("Enter Book new Price :-");
		pri=sc.nextDouble();
		sc.nextLine();
		System.out.println();
		return bdao.modifyBook(id,pub,pri) ? "Book Details Modified successfully" : "Book Modification Failed";
	}

	public static void showBookDetails(Scanner sc) {
		System.out.print("Enter Book Id to get Details :-");
		int bookId = sc.nextInt();
		sc.nextLine();
		Book b = bdao.getBookByBookId(bookId);
		if (b != null)
			System.out.println(b);
		else
			System.out.println("Book with Id" + bookId + "Does not Exist");

	}
	public static void showAllBooks()
	  {
		  for(Book b : bdao.getAllBooksDetails())
			  System.out.println(b);
	  }
}