package com.booker.service.book

import com.booker.book.Genre
import com.booker.book.adapter.BookAdapter
import com.booker.book.repository.BookRepository
import com.booker.domain.book.Book
import com.booker.domain.user.User
import com.booker.exception.BusinessException

import grails.gorm.transactions.Transactional

@Transactional
class BookService {

    def bookerFileService
    def bookGenreService
    def notificationService

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

    public List<BookAdapter> list(Map search) {
        List<Book> bookList = BookRepository.query(search).order("id", "desc").list()

        return bookList.collect { new BookAdapter(it) }
    }

    public BookAdapter find(Long id) {
        Book book = BookRepository.query(id: id).get()

        return new BookAdapter(book)
    }

    public void update(BookAdapter adapter, User currentUser) {
        if (currentUser != adapter.owner) throw new BusinessException("Você não tem permissão para editar este livro")

        Book book = BookRepository.query(id: adapter.id).get()
        if (!book) throw new BusinessException("Livro não encontrado")

        book.title = adapter.title ?: book.title
        book.authorName = adapter.authorName ?: book.authorName
        book.language = adapter.language ?: book.language
        book.publisher = adapter.publisher ?: book.publisher
        book.description = adapter.description ?: book.description
        book.yearPublished = adapter.yearPublished ?: book.yearPublished
        book.isbn = adapter.isbn ?: book.isbn
        book.bookCover = adapter.bookCover.isEmpty() ? book.bookCover : bookerFileService.update(book.bookCover, adapter.bookCover)
        book.save(failOnError: true)

        bookGenreService.updateGenreList(book, adapter.genreList)
    }

    public void request(Long bookId, User currentUser) {
        Book book = BookRepository.query(id: bookId).get()
        validateRequest(book, currentUser)

        book.currentReader = currentUser
        book.save(failOnError: true)

        notificationService.confirmBookRequest(book, currentUser)
    }

    private void validateRequest(Book book, User currentUser) {
        if (!book) throw new BusinessException("Livro não encontrado")

        if (currentUser == book.owner) throw new BusinessException("Você não pode solicitar um livro próprio")

        if (book.currentReader) throw new BusinessException("Livro já está emprestado")
    }

    public void returnBook(Long bookId, User currentUser) {
        Book book = BookRepository.query(id: bookId).get()
        validateReturn(book, currentUser)

        book.currentReader = null
        book.save(failOnError: true)

        notificationService.confirmBookReturn(book, currentUser)
    }

    private void validateReturn(Book book, User currentUser) {
        if (!book) throw new BusinessException("Livro não encontrado")

        if (currentUser != book.currentReader) throw new BusinessException("Você não pode devolver um livro que não está com você")
    }
}
