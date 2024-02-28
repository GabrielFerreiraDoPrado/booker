package com.booker.controller.notification

import com.booker.controller.base.BaseController

import grails.converters.JSON

import org.springframework.http.HttpStatus

class NotificationController extends BaseController {

    def notificationService

    def listUnreadNotification() {
        List<Map> notificationList = notificationService.buildNotification(getCurrentUser())

        render(notificationList as JSON, status: HttpStatus.OK)
    }
}