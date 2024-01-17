package com.booker.role.repository

import com.booker.domain.user.Role
import com.booker.role.RoleAuthority

import grails.gorm.DetachedCriteria

class RoleRepository {

    public static DetachedCriteria<Role> query(Map search) {
        DetachedCriteria<Role> query = Role.where {
            if (search.containsKey("authority")) {
                eq("authority", RoleAuthority.valueOf(search.authority.toString()))
            }
        }

        return query
    }
}
