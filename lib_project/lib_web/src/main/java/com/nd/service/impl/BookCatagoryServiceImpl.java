package com.nd.service.impl;

import com.nd.dao.BookCategoryDao;
import com.nd.entity.BookCategory;
import com.nd.entity.BookSortCount;
import com.nd.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-21 11:38
 */
@Service
public class BookCatagoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;
    @Override
    public List<BookCategory> countBook() {
        List<BookCategory> bookCategory = bookCategoryDao.countBook();
        return bookCategory;
    }

    @Override
    public List<BookSortCount> sortBook() {
        List<BookSortCount> bookSortCount = bookCategoryDao.sortBook();
        return bookSortCount;
    }
}