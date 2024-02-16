package com.example.goodreads;

import com.example.goodreads.BookRepositoty;
import com.example.goodreads.Book;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;

public class BookService implements BookRepositoty {

    private HashMap<Integer, Book> hmap = new HashMap<>();
    int uniqueId = 3;

    public BookService() {
        Book b1 = new Book(1, "HarryPotter", "harry_potter.jpg");
        Book b2 = new Book(2, "Rise", "rise.jpg");

        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);

    }

    @Override
    public ArrayList<Book> getBooks() {

        Collection<Book> booksCollection = hmap.values();
        ArrayList<Book> books = new ArrayList<>(booksCollection);
        return books;

    }

    @Override
    public Book getBookById(int bookId) {

        Book book = hmap.get(bookId);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return book;

    }

    @Override
    public Book addBook(Book book) {
        // TODO Auto-generated method stub
        book.setId(uniqueId);
        hmap.put(uniqueId, book);
        uniqueId++;

        return book;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook = hmap.get(bookId);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getName() != null) {
            existingBook.setName(book.getName());
        }

        if (book.getImageUrl() != null) {
            existingBook.setImageUrl(book.getImageUrl());
        }
        return book;

    }

    @Override
    public void deleteBook(int bookId) {

        Book existingBook = hmap.get(bookId);

        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        hmap.remove(bookId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
