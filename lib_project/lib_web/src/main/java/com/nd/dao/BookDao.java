package com.nd.dao;

import com.nd.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findBook(String bname);
}
