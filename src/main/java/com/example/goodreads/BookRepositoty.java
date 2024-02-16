package com.example.goodreads;

import com.example.goodreads.Book;
import java.util.ArrayList;

public interface BookRepositoty {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int bookId, Book book);

    void deleteBook(int bookId);
}