package com.dxc.spwebmvcdemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.spwebmvcdemo.bean.Book;
import com.dxc.spwebmvcdemo.dao.BookDAO;
import com.dxc.spwebmvcdemo.dao.HibBookDAO;

@Controller
public class BookController 
{
	@Autowired
	BookDAO bdao;
	@Autowired
	HibBookDAO hbdao;
	public void setBookDAO(BookDAO bdao) {this.bdao=bdao;}
	public void setHibBookDAO(HibBookDAO hbdao) { this.hbdao=hbdao;}
	
	@GetMapping("/bookForm")
	public String getBookForm(Model model)
	{
		model.addAttribute("book",new Book(0,"","","",0.0,"",0,0));
		return "BookDetails";
	}
	@PostMapping("/bookCrud")
	public String bookCrudOperations(@RequestParam("bookSubmit") String bookSubmit,Model model,@RequestParam("bookId") int bookId,@RequestParam String booktitle,
			@RequestParam String author,@RequestParam String publisher,@RequestParam double price,
			@RequestParam String subject,@RequestParam int copies)
	{
		model.addAttribute("book",new Book(0,"","","",0.0,"",0,0));
		switch(bookSubmit)
		{
		case "Add":
			//bdao.insertBookDetails(new Book(bookId,booktitle,author,publisher,price,subject,copies,copies));
			hbdao.insertBook(new Book(bookId,booktitle,author,publisher,price,subject,copies,copies));
			break;
		case "Modify":
			hbdao.modifyBook(new Book(bookId,booktitle,author,publisher,price,subject,copies,copies));
			//bdao.modifyBook(new Book(bookId,booktitle,author,publisher,price,subject,copies,copies));
			break;
		case "Delete":
			hbdao.deleteBook(bookId);
			//bdao.deleteBook(bookId);
			break;
		case "Show":
			//Book b = bdao.getBookDetails(bookId);
			Book b = hbdao.getBookById(bookId);
			model.addAttribute("book",b);
			break;
		case "ShowAll":
			ArrayList<Book> bookList=(ArrayList<Book>)hbdao.getAllBooks(); //bdao.getAllBooksDetails();
			model.addAttribute("bookList", bookList);
		}
		return "BookDetails";
	}
	

}
/*@ExceptionHandler(MySpringWebMvcException.class)
public ModelAndView xyz(MySpringWebMvcException ex)
{
	return new ModelAndView("ExceptionHandler1","exception",ex);
}*/
