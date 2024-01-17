package com.booker.user.repository

import com.booker.domain.user.User

import grails.gorm.DetachedCriteria

class UserRepository {

    public static DetachedCriteria<User> query(Map search) {
        DetachedCriteria<User> query = User.where {
            if (search.containsKey("username")) {
                eq("username", search.username)
            }

            if (search.containsKey("id")) {
                eq("id", Long.valueOf(search.id.toString()))
            }

            if (search.containsKey("id[ne]")) {
                ne("id", search.get("id[ne]"))
            }
        }

        return query
    }
}
