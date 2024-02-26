package com.booker.service.book

import com.booker.book.Genre
import com.booker.book.adapter.BookAdapter
import com.booker.book.repository.BookRepository
import com.booker.domain.book.Book
import com.booker.exception.BusinessException

import grails.gorm.transactions.Transactional

@Transactional
class BookService {

    def bookerFileService
    def bookGenreService

    public void save(BookAdapter adapter) {
        validateSave(adapter)

        Book book = new Book()
        book.title = adapter.title
        book.authorName = adapter.authorName
        book.language = adapter.language
        book.publisher = adapter.publisher
        book.description = adapter.description
        book.yearPublished = adapter.yearPublished
        book.isbn = adapter.isbn
        book.bookCover = bookerFileService.save(adapter.bookCover)
        book.owner = adapter.owner
        book.save(failOnError: true)

        for (Genre genre : adapter.genreList) {
            bookGenreService.save(book, genre)
        }
    }

    private void validateSave(BookAdapter adapter) {
        if (!adapter.title) throw new BusinessException("É necessário informar o título")

        if (!adapter.authorName) throw new BusinessException("É necessário informar o nome do autor")

        if (!adapter.language) throw new BusinessException("É necessário informar o idioma")

        if (!adapter.publisher) throw new BusinessException("É necessário informar a editora")

        if (!adapter.description) throw new BusinessException("É necessário informar a descrição")

        if (!adapter.genreList) throw new BusinessException("É necessário informar pelo menos um gênero")

        if (!adapter.yearPublished) throw new BusinessException("É necessário informar o ano de publicação")

        if (!adapter.isbn) throw new BusinessException("É necessário informar o ISBN")

        if (!adapter.bookCover.size) throw new BusinessException("É necessário anexar uma imagem da capa do livro")
    }

    public List<BookAdapter> list() {
        List<Book> bookList = BookRepository.query([:]).list()

        return bookList.collect { new BookAdapter(it) }
    }

    public BookAdapter find(Long id) {
        Book book = BookRepository.query(id: id).get()

        return new BookAdapter(book)
    }
}
