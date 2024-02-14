package com.booker.book.adapter

import com.booker.book.Genre
import com.booker.book.Language
import com.booker.domain.user.User
import org.springframework.web.multipart.MultipartFile

class BookAdapter {

    String title

    String authorName

    Language language

    String publisher

    String description

    List<Genre> genreList

    Integer yearPublished

    String isbn

    MultipartFile bookCover

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
}
