package com.ttstudios.kalah.rest.web;

import java.util.List;

import com.ttstudios.kalah.persistence.model.Book;
import com.ttstudios.kalah.rest.web.exception.BookIdMismatchException;
import com.ttstudios.kalah.rest.web.exception.BookNotFoundException;
import com.ttstudios.kalah.persistence.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable String id) {
        final Book book = bookRepository.findOne(id);
        if (book == null) {
            throw new BookNotFoundException();
        }
        return book;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        final Book book = bookRepository.findOne(id);
        if (book == null) {
            throw new BookNotFoundException();
        }
        bookRepository.delete(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@Valid @RequestBody Book book, @PathVariable String id) {
        if (!book.getId().equals( id )) {
            throw new BookIdMismatchException();
        }
        final Book old = bookRepository.findOne(id);
        if (old == null) {
            throw new BookNotFoundException();
        }
        return bookRepository.save(book);
    }

}
