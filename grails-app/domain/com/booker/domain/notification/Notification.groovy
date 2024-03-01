package com.booker.domain.notification

import com.booker.domain.book.Book
import com.booker.domain.user.User
import com.booker.notification.repository.NotificationType

class Notification {

    NotificationType type

    String message

    Book book

    Boolean isRead = false

    User user
}
