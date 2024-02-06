package com.booker.book

enum Genre {

    FANTASY("Fantasia"),
    MYSTERY("Mistério"),
    SCIENCE_FICTION("Ficção Científica")

    String name

    Genre(String name) {
        this.name = name
    }
}