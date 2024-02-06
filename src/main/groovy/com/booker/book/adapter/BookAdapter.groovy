package com.booker.book.adapter

import com.booker.book.Genre
import com.booker.book.Language

class BookAdapter {

    String title

    String authorName

    Language language

    String publisher

    String description

    List<Genre> genreList

    Integer yearPublished

    String isbn

    public BookAdapter(Map params) {
        this.title = params.title
        this.authorName = params.authorName
        this.language = params.language ? Language.valueOf(params.language) : null
        this.publisher = params.publisher
        this.description = params.description
        this.genreList = params.genreList.collect { Genre.valueOf(it) }
        this.yearPublished = params.yearPublished ? Integer.valueOf(params.yearPublished) : null
        this.isbn = params.isbn
    }
}
