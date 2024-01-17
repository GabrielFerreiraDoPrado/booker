package com.booker.service.user

import com.booker.domain.user.Role
import com.booker.domain.user.User
import com.booker.domain.user.UserRole
import com.booker.user.repository.UserRepository

import grails.gorm.transactions.Transactional

@Transactional
class UserRoleService {

    public void saveIfNecessary(User user, Role role) {
        Boolean userRoleExists = UserRepository.query([user: user, role: role]).get().asBoolean()
        if (userRoleExists) return

        UserRole userRole = new UserRole()
        userRole.user = user
        userRole.role = role
        userRole.save(failOnError: true)
    }
}
