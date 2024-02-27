package com.booker.service.book

import com.booker.book.Genre
import com.booker.book.repository.BookGenreRepository
import com.booker.domain.book.Book
import com.booker.domain.book.BookGenre

import grails.gorm.transactions.Transactional

@Transactional
class BookGenreService {

    public void save(Book book, Genre genre) {
        BookGenre bookGenre = new BookGenre()
        bookGenre.book = book
        bookGenre.genre = genre
        bookGenre.save(failOnError: true)
    }

    public void updateGenreList(Book book, List<Genre> genreList) {
        if (!genreList) return

        deleteByBookId(book.id)

        for (Genre genre : genreList) {
            save(book, genre)
        }
    }

    private void deleteByBookId(Long bookId) {
        List<BookGenre> bookGenreList = BookGenreRepository.query(bookId: bookId).list()
        for (BookGenre bookGenre : bookGenreList) {
            bookGenre.delete(failOnError: true)
        }
    }
}
