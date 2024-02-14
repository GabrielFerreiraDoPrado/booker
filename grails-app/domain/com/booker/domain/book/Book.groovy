package com.booker.domain.book

import com.booker.book.Language
import com.booker.domain.file.BookerFile
import com.booker.domain.user.User
import utils.BaseEntity

class Book extends BaseEntity {

    String title

    String authorName

    Language language

    String publisher

    String description

    Integer yearPublished

    String isbn

    BookerFile bookCover

    User owner

    static constraints = {
        description nullable: true, maxSize: 3000
    }
}