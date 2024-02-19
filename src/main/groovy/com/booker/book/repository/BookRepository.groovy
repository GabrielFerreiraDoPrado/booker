package com.booker.book.repository

import com.booker.domain.book.Book

import grails.gorm.DetachedCriteria

class BookRepository {

    public static DetachedCriteria<Book> query(Map search) {
        DetachedCriteria<Book> query = Book.where {
            if (Boolean.valueOf(search.deletedOnly.toString())) {
                eq("deleted", true)
            } else if (!Boolean.valueOf(search.includeDeleted.toString())) {
                eq("deleted", false)
            }
        }

        return query
    }
}
