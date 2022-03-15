package com.dxc.springcoreapp.bean;

public class Book
{
    int bookId; 
    String bookTitle;
   // private Book() { };
   /* public static Book getBookObject()
    {
       return new Book();
    }*/
    public Book() { };
    
    public int getBookId() { return bookId; }
    public String getBookTitle() { return bookTitle; }
    public void setBookId(int bookId) { this.bookId = bookId;}
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
}