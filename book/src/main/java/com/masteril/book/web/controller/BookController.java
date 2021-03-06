package com.masteril.book.web.controller;

import com.masteril.book.model.Book;
import com.masteril.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository dao;

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/Books")
    public Iterable<Book> getBooks() {
        return dao.findAll();
    }

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/Books/{id}")
    public Book getBook(@PathVariable int id) {
        return dao.findById(id);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value="/Books/title/{title}")
    public Book getBookTitle(@PathVariable String title) {
        return dao.findByTitle(title);
    }

    @PostMapping(value="/Books")
    public void addBook(@RequestBody Book b) {
        dao.save(b);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping(value="/Books/{id}")
    public void updateBook(@RequestBody Book newBook, @PathVariable int id) {
        Book book = dao.findById(id);
        if (newBook.getTitle() != null) {
            if (!newBook.getTitle().trim().equals(""))
                book.setTitle(newBook.getTitle());
        }
        if (newBook.getAuthor() != null) {
            if (!newBook.getAuthor().trim().equals(""))
                book.setAuthor(newBook.getAuthor());
        }
        if (newBook.getDescription() != null) {
            if (!newBook.getDescription().trim().equals(""))
                book.setDescription(newBook.getDescription());
        }
        if (newBook.getPrice() > 0) {
            book.setPrice(newBook.getPrice());
        }
        dao.save(book);
    }

    @DeleteMapping(value="/Books/{id}")
    public void deleteBook(@PathVariable int id) { dao.deleteById(id); }
}
