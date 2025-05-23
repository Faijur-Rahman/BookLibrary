package com.example.books.controller;

import com.example.books.entity.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addbooks")
    public ResponseEntity<Book> addBook( @RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/getbook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name) {
        Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book name) {
        Book updatedBook = bookService.updateBook(name);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable("bookId") Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
