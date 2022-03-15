package com.dxc.library.ui;
import java.util.Scanner;
import com.dxc.library.dto.Book;
import com.dxc.library.dto.BookStatus;
import com.dxc.library.dao.BookDAO;
import com.dxc.library.dao.BookStatusDAO;

public class BookUI
{
	static BookDAO Bdao = new BookDAO();
	static BookStatusDAO bsDao = new BookStatusDAO();
	public static String addbookDetails(Scanner sc)
	{
		Book b = new Book();
		BookStatus bs =new BookStatus();
		System.out.println("Enter Book Id        :-");
		b.setBookId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter Book Title     :-");
		b.setBookTitle(sc.nextLine());
		System.out.println("Enter Book Author    :-");
		b.setAuthor(sc.nextLine());
		System.out.println("Enter Book Publisher :-");
		b.setPublisher(sc.nextLine());
		System.out.println("Enter Book Price     :-");
		b.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.println("Enter Number of Copies");
		bs.setAvailableCopies(sc.nextInt());
		sc.hasNextLine();
		System.out.println();
		bs.setBookId(b.getBookId());
		bs.setTotalCopies(bs.getAvailableCopies());
		bsDao.insertBookStatus(bs);
		return Bdao.insertBookDetails(b)? "Book Added Succesfully" : "Book Cannot be Added";
	}
	public static String deleteBook(Scanner sc)
	{
		System.out.print("Enter Book Id to Delete :-");
		int bookId = sc.nextInt();
		sc.nextLine();
		return Bdao.deleteBook(bookId)? "Book Deleted Succesfully" : "Book Deletion Failed";
	}
	public static String modifyBook(Scanner sc)
	{
		Book b = new Book();
		System.out.print("Enter Bookid to Modify :- ");
		b.setBookId(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Book Publisher to Modify :-");
		b.setPublisher(sc.nextLine());
		System.out.print("Enter Book new Price :-");
		b.setPrice(sc.nextDouble());
		sc.nextLine();
		System.out.println();
		return Bdao.modifyBook(b) ? "Book Details Modified Successfully" : "Book Modification Failed";
	}
	public static void showbookDetails(Scanner sc)
	{ 
		System.out.println("Enter Book Id to get Details :- ");
		int bookId = sc.nextInt();
		sc.nextLine();
		Book b = Bdao.getBookDetails(bookId);
		if(b!=null)
			System.out.println(b);
		else
			System.out.println("Book with Id "+bookId+"Book does not Exists");
	}
	public static void showAllBooks()
	{
		for(Book b : Bdao.getAllookDetails())
			System.out.println(b);
	}
}

