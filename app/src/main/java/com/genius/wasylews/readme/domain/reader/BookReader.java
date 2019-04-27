package com.genius.wasylews.readme.domain.reader;

import com.genius.wasylews.readme.domain.model.Book;
import com.genius.wasylews.readme.domain.model.BookPage;

import java.util.Iterator;

public class BookReader implements Iterator<BookPage> {

    private Book book;
    private int page = 0;

    public BookReader(Book book) {
        this.book = book;
    }

    @Override
    public boolean hasNext() {
        return page < book.getPageCount() - 1;
    }

    @Override
    public BookPage next() {
        return new BookPage(page);
    }
}
