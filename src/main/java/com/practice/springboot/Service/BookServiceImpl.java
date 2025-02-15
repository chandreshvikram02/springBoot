package com.practice.springboot.Service;

import com.practice.springboot.Repository.BookRepository;
import com.practice.springboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl  implements BookService {

     @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(int bookId) {

        return getBookList().stream().filter((Book->Book.getBookId()==bookId))
              .findAny()
                //.get();
                .orElse(new Book());


    }
    @Override
    public List<Book> getBookByAuthor(String author) {
        return getBookList().stream().filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());

    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> filteredBooks=getBookList().stream().filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        System.out.println("Filtered Books: " + filteredBooks);
        return  filteredBooks;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public Book updateBookbyId(Book book, int bookId) {
        Book existingbook = bookRepository.getById(bookId);
        existingbook.setAuthor(book.getAuthor());
        existingbook.setCategory(book.getCategory());
        bookRepository.save(existingbook);
        return existingbook;

    }


    @Override
    public void deleteBookById(int bookId) {
       bookRepository.deleteById(bookId);

    }



    private  List<Book> getBookList(){
   return Arrays.asList(new Book(1,"Chandresh","java","springboot"),
                        new Book(2,"vikram","hibernate","springboot"),
                        new Book(3,"Chandresh","spring","top"),
                        new Book(4,"kumar","java","level"));

    }




}
