package com.booker.service.role

import com.booker.domain.user.Role
import com.booker.role.RoleAuthority
import com.booker.role.repository.RoleRepository
import grails.gorm.transactions.Transactional

@Transactional
class RoleService {

    public Role saveIfNecessary(RoleAuthority authority) {
        Role role = RoleRepository.query([authority: authority]).get()
        if (role) return role

        role = new Role()
        role.authority = authority

        return role.save(failOnError: true)
    }
}
