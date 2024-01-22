package com.booker.service.user

import com.booker.domain.user.Role
import com.booker.domain.user.User
import com.booker.role.RoleAuthority
import com.booker.user.adapter.UserAdapter
import com.booker.user.repository.UserRepository
import com.booker.exception.BusinessException

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def roleService
    def springSecurityService
    def userRoleService

    public void save(UserAdapter adapter) {
        validateSave(adapter)

        User user = new User()
        user.username = adapter.username
        user.password = adapter.password
        user.accountExpired = false
        user.accountLocked = false
        user.passwordExpired = false
        user.save(failOnError: true)

        Role role = roleService.saveIfNecessary(RoleAuthority.ROLE_USER)
        userRoleService.saveIfNecessary(user, role)
    }

    public User changePassword(User user, UserAdapter adapter, String currentPassword) {
        validateChangePassword(user, adapter, currentPassword)

        user.password = adapter.password

        return user.save(failOnError: true)
    }

    private void validateSave(UserAdapter adapter) {
        if (!adapter.username) throw new BusinessException("É necessário informar um e-mail")

        if (!adapter.password) throw new BusinessException("É necessário informar uma senha")
        if (adapter.password != adapter.confirmPassword) throw new BusinessException("As senhas informadas precisam ser iguais")

        Boolean userExists = UserRepository.query([username: adapter.username]).get().asBoolean()
        if (userExists) throw new BusinessException("Já existe um usuário com este e-mail")
    }

    private void validateChangePassword(User user, UserAdapter adapter, String currentPassword) {
        if (!adapter.password) throw new BusinessException("É necessário informar uma senha")
        if (adapter.password != adapter.confirmPassword) throw new BusinessException("As senhas informadas precisam ser iguais")

        if (!springSecurityService.passwordEncoder.matches(currentPassword, user.password)) throw new BusinessException("Senha incorreta")
    }
}
