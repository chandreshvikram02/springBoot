package com.practice.springboot.controller;

import com.practice.springboot.Service.BookService;
import com.practice.springboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-rest-api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        String message = "welcome to book Application";
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "online book application");
        return new ResponseEntity<String>(message, header, HttpStatus.OK);
    }

    @PostMapping("/book")
    private ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("description", "adding new book");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }
    @GetMapping("/Book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int bookid) {
        Book book = bookService.getBookById(bookid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "get book by id");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(book);
    }

    @GetMapping("/books-by-author/{BookByAuthor}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String BookByAuthor) {
        List<Book> listOfBook = bookService.getBookByAuthor(BookByAuthor);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "get book by Author");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(listOfBook);
    }

    @GetMapping("/books-by-Category")
    public ResponseEntity<List<Book>> getBookByCategory(@RequestParam("category") String bookByCategory) {

        List<Book> listOfBook = bookService.getBookByCategory(bookByCategory);
        HttpHeaders header = new HttpHeaders();
        header.add("description1", "get book by category1");
        header.add("description2", "get book by category2");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(listOfBook);
    }

//    @PutMapping("/UpdateBook-by-id/{id}")
//    public ResponseEntity<Book> UpdateBookById(@RequestBody Book book,@PathVariable("id") int bookid) {
//
//      Book updatedBook =bookService.updateBookbyId(book,bookid);
//      HttpHeaders header = new HttpHeaders();
//        header.add("desc", " book got updated  by id");
//        return ResponseEntity.status(HttpStatus.OK).headers(header).body(updatedBook);
//    }
//
//
//    @DeleteMapping("/Book-by-id/{id}")
//    public ResponseEntity<Void> deleteBookById(@PathVariable("id") int bookid) {
//        bookService.deleteBookById(bookid);
//        HttpHeaders header = new HttpHeaders();
//        header.add("desc", "delete book by id");
//        return ResponseEntity.status(HttpStatus.OK).headers(header).build();
//    }
}
