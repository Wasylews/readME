package com.genius.wasylews.readme.domain.reader

import com.genius.wasylews.readme.domain.model.Book
import com.genius.wasylews.readme.domain.model.BookPage

class BookReader(private val book: Book) : ListIterator<BookPage> {
    private val page = 0

    override fun hasNext(): Boolean {
        return page < book.pageCount - 1
    }

    override fun next(): BookPage {
        return BookPage(page)
    }

    override fun nextIndex(): Int {
        return page + 1
    }

    override fun hasPrevious(): Boolean {
        return page > 0
    }

    override fun previous(): BookPage {
        return BookPage(page)
    }

    override fun previousIndex(): Int {
        return page - 1
    }
}