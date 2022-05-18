package com.connectPostgres.demoPostgres.Service;

import com.connectPostgres.demoPostgres.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book SaveBook(Book book);

    Book GetBookById(Integer id);

    Book EditBook(Book book);

    void deleteBook(Integer id);
}
