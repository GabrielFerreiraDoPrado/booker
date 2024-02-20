package com.booker.book

enum Genre {

    ACTION_ADVENTURE("Ação e Aventura"),
    ART_PHOTOGRAPHY("Arte e Fotografia"),
    BIOGRAPHY("Biografia"),
    CHILDREN("Infantil"),
    COMEDY("Comédia"),
    DYSTOPIAN("Distópico"),
    FAIRY_TALE("Conto de Fadas"),
    FANTASY("Fantasia"),
    FICTION("Ficção"),
    HISTORICAL_FICTION("Ficção Histórica"),
    HISTORY("História"),
    HORROR("Terror"),
    MYSTERY("Mistério"),
    RELIGION("Religião"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Ficção Científica"),
    SCIENCE_TECHNOLOGY("Ciência e Tecnologia"),
    SELF_HELP("Autoajuda"),
    SOCIAL_SCIENCE("Ciências Sociais"),
    THRILLER("Suspense"),
    TRAVEL("Viagem")

    String name

    Genre(String name) {
        this.name = name
    }
}