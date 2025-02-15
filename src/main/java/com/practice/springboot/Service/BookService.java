package com.practice.springboot.Service;

import com.practice.springboot.entity.Book;

import java.util.List;

public interface BookService {

    Book getBookById(int bookId);
    List<Book> getBookByAuthor(String author);
    List<Book> getBookByCategory(String category);
    void addBook(Book book);
    Book updateBookbyId(Book book,int bookId);
    void  deleteBookById(int bookId);

}
