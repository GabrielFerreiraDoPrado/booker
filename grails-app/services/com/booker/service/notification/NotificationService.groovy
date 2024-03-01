package com.booker.service.notification

import com.booker.domain.book.Book
import com.booker.domain.notification.Notification
import com.booker.domain.user.User
import com.booker.notification.repository.NotificationRepository
import com.booker.notification.repository.NotificationType

import grails.gorm.transactions.Transactional

@Transactional
class NotificationService {

    public List<Map> buildNotification(User user) {
        List<Notification> notificationList = NotificationRepository.query([user: user, unreadOnly: true]).order("id", "desc").list()
        List<Map> formattedNotificationList = []

        for (Notification notification : notificationList) {
            Map formattedNotification  = [
                    id: notification.id,
                    bookId: notification.book.id,
                    title: notification.type.name,
                    message: notification.message
            ]

            formattedNotificationList.add(formattedNotification)
        }

        return formattedNotificationList
    }

    public void confirmBookRequest(Book book, User user) {
        Notification notification = new Notification()
        notification.type = NotificationType.BOOK_REQUESTED
        notification.message = "Livro ${book.title} solicitado por ${user.username}"
        notification.book = book
        notification.user = book.owner

        notification.save(failOnError: true)
    }
}
