package com.practice.springboot.Service;

import com.practice.springboot.entity.Book;
import com.practice.springboot.exception.BookNotFoundException;
import com.practice.springboot.exception.IdNotFoundException;

import java.util.List;

public interface BookService {

    Book getBookById(int bookId) throws IdNotFoundException;
    List<Book> getBookByAuthor(String author) throws BookNotFoundException;
    List<Book> getBookByCategory(String category) throws BookNotFoundException;
    void addBook(Book book);
//    Book updateBookbyId(Book book,int bookId);
//    void  deleteBookById(int bookId);

}
