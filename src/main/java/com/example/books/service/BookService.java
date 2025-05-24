package com.example.books.service;

import com.example.books.entity.Book;
import com.example.books.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookByName(String name) {
        return bookRepository.findBookByBookTitle(name);
    }

    public void deleteBook(Integer id) {
       bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public void updateBookById(Integer id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));

        existingBook.setBookAuthor(updatedBook.getBookAuthor());
        existingBook.setBookTitle(updatedBook.getBookTitle());
        existingBook.setBookGenre(updatedBook.getBookGenre());

        bookRepository.save(updatedBook);
    }
}
