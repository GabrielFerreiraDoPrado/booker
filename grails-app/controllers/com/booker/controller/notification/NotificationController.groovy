package com.booker.controller.notification

import com.booker.controller.base.BaseController
import com.booker.domain.notification.Notification

import grails.converters.JSON

import org.springframework.http.HttpStatus

class NotificationController extends BaseController {

    def notificationService

    def listUnreadNotification() {
        List<Map> notificationList = notificationService.buildNotification(getCurrentUser())

        render(notificationList as JSON, status: HttpStatus.OK)
    }

    def read() {
        Long notificationId = Long.valueOf(params.id.toString())
        Notification notification = notificationService.read(notificationId)

        redirect(controller: "book", action: "show", id: notification.book.id)
    }
}