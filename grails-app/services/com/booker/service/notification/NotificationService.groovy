package com.booker.service.notification

import com.booker.domain.notification.Notification
import com.booker.domain.user.User
import com.booker.notification.repository.NotificationRepository

import grails.gorm.transactions.Transactional

@Transactional
class NotificationService {

    public List<Map> buildNotification(User user) {
        List<Notification> notificationList = NotificationRepository.query([user: user, unreadOnly: true]).list()
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
}
