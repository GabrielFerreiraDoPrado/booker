package com.booker.notification.repository

import com.booker.domain.notification.Notification

import grails.gorm.DetachedCriteria

class NotificationRepository {

    public static DetachedCriteria<Notification> query(Map search) {
        DetachedCriteria<Notification> query = Notification.where {
            if (!Boolean.valueOf(search.ignoreUser.toString()) && !search.containsKey("user")) {
                throw new RuntimeException("O atributo user é obrigatório para executar a consulta.")
            }

            if (Boolean.valueOf(search.unreadOnly.toString())) {
                eq("isRead", false)
            }

            if (search.containsKey("user")) {
                eq("user", search.user)
            }
        }

        return query
    }
}