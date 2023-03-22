package com.nd.dao;

import com.nd.entity.Book;

import java.util.List;

public interface BookClassifyDao {
    List<Book> classify(String cate);
}
