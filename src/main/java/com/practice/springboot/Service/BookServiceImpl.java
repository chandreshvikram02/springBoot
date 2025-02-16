package com.practice.springboot.Service;

//import com.practice.springboot.Repository.BookRepository;

import com.practice.springboot.entity.Book;
import com.practice.springboot.exception.BookNotFoundException;
import com.practice.springboot.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

//     @Autowired
//    private BookRepository bookRepository;

    @Override
    public Book getBookById(int bookId) {

        if(bookId<=0)
        {
            throw  new RuntimeException("other type of exception");
        }

        return getBookList().stream().filter((Book -> Book.getBookId() == bookId))
                .findAny()
                //.get();
                .orElseThrow(() -> new IdNotFoundException("Book not available for this given id"));


    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> bookList = getBookList().stream().filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());

        if (bookList.isEmpty()) {
            throw new BookNotFoundException("book not found for this author");
        } else {
            return bookList;
        }


    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> filteredBooks = getBookList().stream().filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if (filteredBooks.isEmpty()) {
            throw new BookNotFoundException("book not found for the category");
        } else {
            return filteredBooks;
        }
    }

    @Override
    public void addBook(Book book) {

    }

//    @Override
//    public Book updateBookbyId(Book book, int bookId) {
//        Book existingbook = bookRepository.getById(bookId);
//        existingbook.setAuthor(book.getAuthor());
//        existingbook.setCategory(book.getCategory());
//        bookRepository.save(existingbook);
//        return existingbook;
//
//    }
//
//
//    @Override
//    public void deleteBookById(int bookId) {
//       bookRepository.deleteById(bookId);
//
//    }


    private List<Book> getBookList() {
        return Arrays.asList(new Book(1, "Chandresh", "java", "springboot"),
                new Book(2, "vikram", "hibernate", "springboot"),
                new Book(3, "Chandresh", "spring", "top"),
                new Book(4, "kumar", "java", "level"));

    }


}
