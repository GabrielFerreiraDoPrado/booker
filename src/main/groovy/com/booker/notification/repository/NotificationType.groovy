package com.booker.notification.repository

enum NotificationType {

    BOOK_REQUESTED("Livro solicitado")

    String name

    NotificationType(String name) {
        this.name = name
    }
}