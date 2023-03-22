package com.nd.dao;

import com.nd.entity.BookCategory;
import com.nd.entity.BookSortCount;

import java.util.List;

public interface BookCategoryDao {

    List<BookCategory> countBook();
    List<BookSortCount> sortBook();
}
