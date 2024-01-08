package com.booker.domain.book

import com.booker.book.Language

import utils.BaseEntity

class Book extends BaseEntity {

    String title

    String authorName

    Language language

    String publisher

    String description

    static constraints = {
        description nullable: true, maxSize: 3000
    }
}