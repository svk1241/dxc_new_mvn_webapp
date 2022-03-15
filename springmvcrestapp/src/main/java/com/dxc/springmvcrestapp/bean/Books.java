package com.dxc.springmvcrestapp.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Books")
public class Books 
{
   List<Book> books;
   public void setBooks(List<Book> books)
   {
	   this.books=books;
   }
   public List<Book> getBooks()
   {
	   return books;
   }
}
