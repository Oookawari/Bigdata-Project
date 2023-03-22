package com.nd.service;

import com.nd.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findBook(String bookname);
}
