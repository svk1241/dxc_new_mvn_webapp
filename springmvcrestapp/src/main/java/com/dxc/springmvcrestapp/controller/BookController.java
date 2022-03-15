package com.dxc.springmvcrestapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxc.springmvcrestapp.bean.Book;
import com.dxc.springmvcrestapp.bean.Books;
import com.dxc.springmvcrestapp.dao.HibBookDAO;
@CrossOrigin(origins= {"http://localhost:8089/ajaxrestclient","http://localhost:8089/javarestclient"})
/*@Controller
@ResponseBody*/
@RestController
@RequestMapping("/book")
public class BookController
{
	@Autowired
	HibBookDAO hibBookDAO;
	public void sethibBookDAO(HibBookDAO hibBookDAO) {this.hibBookDAO=hibBookDAO;}
	
	@GetMapping(value="/{bookId}",produces={"application/json","application/xml"})
	public ResponseEntity<Book> getbookById(@PathVariable int bookId)
	{
		Book b= hibBookDAO.getBookById(bookId);
		if(b!=null) return new ResponseEntity<Book>(b,HttpStatus.OK);
		throw new RuntimeException("Book with id "+bookId+" Does not Exist");
	}
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@ExceptionHandler(RuntimeException.class)
	public void getExceptionMessage()
	{
		//System.out.println("This is from a method");
		//return ex.getLocalizedMessage();
		//return new ResponseEntity<String> (ex.getMessage(),HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/all",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Books getALLBooks()
	{
		Books books = new Books();
		books.setBooks(hibBookDAO.getAllBooks());
		return books;
	}
	
	@PostMapping(consumes="application/json")
	public void addBookDetails(@RequestBody Book book)
	{
			hibBookDAO.insertBook(book);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBookDetails(@PathVariable int bookId)
	{
			hibBookDAO.deleteBook(bookId);
	}
	
	@PutMapping(consumes="application/json")
	public void modifyBookDetails(@RequestBody Book book)
	{
		hibBookDAO.modifyBook(book);
	}
}












/* ArrayList<Book> blist=new ArrayList<Book>();
public BookController()
{
blist.add(new Book(7001,"java c ref","herbert","Oracle press",750,"java",10,10));
blist.add(new Book(7002,"c++","stroutup","person",650,"cpp",10,10));
blist.add(new Book(7003,"Python Black Book","NagarawarRao","Dee",450,"python",10,10));
blist.add(new Book(7004,"spring","venu","Deew",350,"java",10,10));
}*/





/*@Autowired
HibBookDAO hibBookDAO;*/

//@GetMapping(value="/username/{username}",produces=MediaType.TEXT_HTML_VALUE)
/*@GetMapping(value="/username/{username}",produces=MediaType.TEXT_XML_VALUE)
@ResponseBody
public String wishUser(@PathVariable String username)
{
return "<Username>" +username+"</Username>";
}
@GetMapping(value="/book/{bookId}",produces=MediaType.TEXT_XML_VALUE)
//@ResponseBody
public String getBookById(@PathVariable int bookId)

{
String book ="<Book><bookId>7991</bookId><bookTitle>Java</bookTitle><author>john</author></Book>";
//return hibBookDAO.getBookById(bookId);
return book;*/