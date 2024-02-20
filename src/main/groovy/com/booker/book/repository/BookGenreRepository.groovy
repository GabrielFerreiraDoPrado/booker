package com.booker.book.repository

import com.booker.domain.book.BookGenre

import grails.gorm.DetachedCriteria

class BookGenreRepository {

    public static DetachedCriteria<BookGenre> query(Map search) {
        DetachedCriteria<BookGenre> query = BookGenre.where {
            if (search.containsKey("bookId")) {
                eq("book.id", Long.valueOf(search.bookId.toString()))
            }
        }

        return query
    }
}
