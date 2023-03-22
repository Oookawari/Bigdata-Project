package com.nd.service.impl;

import com.nd.dao.BookClassifyDao;
import com.nd.entity.Book;
import com.nd.service.BookClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Group-16
 * @date: 2022-07-21 16:09
 */
@Service
public class BookClassifyServiceImpl implements BookClassifyService {
    @Autowired
    private BookClassifyDao bookClassifyDao;

    @Override
    public List<Book> BookClassify(String cate) {
        List<Book> books = bookClassifyDao.classify(cate);
        return books;
    }
}