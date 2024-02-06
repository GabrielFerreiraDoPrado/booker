package com.booker.service.book

import com.booker.book.Genre
import com.booker.domain.book.Book
import com.booker.domain.book.BookGenre

import grails.gorm.transactions.Transactional

@Transactional
class BookGenreService {

    public void save (Book book, Genre genre) {
        BookGenre bookGenre = new BookGenre()
        bookGenre.book = book
        bookGenre.genre = genre
        bookGenre.save()
    }
}
