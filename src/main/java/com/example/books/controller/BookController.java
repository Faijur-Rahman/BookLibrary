package com.example.books.controller;

import com.example.books.entity.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBooks")
    public ResponseEntity<Book> addBook( @RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name) {
        Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @GetMapping("/getBooks")
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book name) {
        bookService.updateBook(name);
        return new ResponseEntity<>("Book with name: " + name.getBookTitle() + " Updated successfully !!!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book with id: " +id +" Deleted successfully !!!",HttpStatus.OK);
    }
}
