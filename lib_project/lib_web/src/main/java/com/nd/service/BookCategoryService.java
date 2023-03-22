package com.nd.service;

import com.nd.entity.BookCategory;
import com.nd.entity.BookSortCount;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> countBook();
    List<BookSortCount> sortBook();
}
