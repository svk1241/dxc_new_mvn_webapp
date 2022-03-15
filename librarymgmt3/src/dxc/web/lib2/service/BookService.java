package dxc.web.lib2.service;
import dxc.web.lib2.bean.Book;
import dxc.web.lib2.dao.BookDAO;
import java.util.ArrayList;
public class BookService
{
   BookDAO bdao = new BookDAO();
   public Book getBook(int bookId)
   {
	   return bdao.getBookDetails(bookId);
   }
   public boolean addBook(Book b)
   {
	   return bdao.insertBookDetails(b);
   }
   public boolean deleteBook(int bookId)
   {
	   return bdao.deleteBook(bookId);
   }
   public boolean modifyBook(Book b)
   {
	   return bdao.modifyBook(b);
   }
   public ArrayList<Book> getAllBooks()
   {
	   return bdao.getAllBookDetails();
   }

    public ArrayList<Book>getBookBySubject(String subject)
    {
	return bdao.getBooksBySubject(subject);
     }
   public boolean modifyBookAvailCopies(byte ttype,int bookId)
   {
	   return bdao.modifyBookAvailCopies(ttype, bookId);
   }
   public String getBookTitleById(int bookId)
   {
	   String bookTitle = bdao.getBookTitleById(bookId);
	   if(bookTitle!=null) return bookTitle;
	   throw new RuntimeException("Book Does Not Exists");
   }
}
