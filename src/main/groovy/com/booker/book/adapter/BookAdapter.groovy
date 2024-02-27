package com.booker.book.adapter

import com.booker.book.Genre
import com.booker.book.Language
import com.booker.book.repository.BookGenreRepository
import com.booker.domain.book.Book
import com.booker.domain.book.BookGenre
import com.booker.domain.file.BookerFile
import com.booker.domain.user.User

import org.springframework.web.multipart.MultipartFile

import utils.filemanager.FileManager
import utils.filemanager.FileManagerResourceName
import utils.filemanager.LocalDiskManager

class BookAdapter {

    Long id

    String title

    String authorName

    Language language

    String publisher

    String description

    List<Genre> genreList

    Integer yearPublished

    String isbn

    MultipartFile bookCover

    String bookCoverBase64

    User owner

    public BookAdapter(Map params, User owner) {
        this.title = params.title
        this.authorName = params.authorName
        this.language = params.language ? Language.valueOf(params.language) : null
        this.publisher = params.publisher
        this.description = params.description
        this.genreList = parseGenreList(params.genreList)
        this.yearPublished = params.yearPublished ? Integer.valueOf(params.yearPublished) : null
        this.isbn = params.isbn
        this.bookCover = params.bookCover
        this.owner = owner
    }

    public BookAdapter(Map params) {
        this.id = Long.valueOf(params.id.toString())
        this.title = params.title
        this.authorName = params.authorName
        this.language = params.language ? Language.valueOf(params.language) : null
        this.publisher = params.publisher
        this.description = params.description
        this.genreList = parseGenreList(params.genreList)
        this.yearPublished = params.yearPublished ? Integer.valueOf(params.yearPublished) : null
        this.isbn = params.isbn
        this.bookCover = params.bookCover
    }

    public BookAdapter(Book book) {
        this.id = book.id
        this.title = book.title
        this.authorName = book.authorName
        this.language = book.language
        this.publisher = book.publisher
        this.description = book.description
        this.genreList = findGenreList(book.id)
        this.yearPublished = book.yearPublished
        this.isbn = book.isbn
        this.owner = book.owner
        this.bookCoverBase64 = encodeBookCover(book.bookCover)
    }

    private List<Genre> parseGenreList(Object genreGroup) {
        List<Genre> parsedGenreList = []

        if (genreGroup instanceof String) {
            parsedGenreList.add(Genre.valueOf(genreGroup))

            return parsedGenreList
        }

        for (String genre : genreGroup) {
            parsedGenreList.add(Genre.valueOf(genre))
        }

        return parsedGenreList
    }

    private List<Genre> findGenreList(Long bookId) {
        List<BookGenre> genreList = BookGenreRepository.query([bookId: bookId]).list()

        return genreList.collect { it.genre }
    }

    private String encodeBookCover(BookerFile bookCover) {
        FileManager manager = new LocalDiskManager(FileManagerResourceName.BOOK_COVER)
        InputStream bookCoverInputStream = manager.read(bookCover.name)

        return Base64.getEncoder().encodeToString(bookCoverInputStream.bytes)
    }
}
