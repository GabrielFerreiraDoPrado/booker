package com.booker.notification.repository

enum NotificationType {

    BOOK_REQUESTED("Livro solicitado"),
    BOOK_RETURNED("Livro devolvido")

    String name

    NotificationType(String name) {
        this.name = name
    }
}