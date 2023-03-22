package com.nd.service.impl;

import com.nd.dao.BookDao;
import com.nd.entity.Book;
import com.nd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-20 14:09
 */
@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findBook(String book) {
        List<Book> books = bookDao.findBook(book);
        return books;
    }
}