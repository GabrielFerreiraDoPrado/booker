package com.booker.user.adapter

import com.booker.domain.user.User

class UserAdapter {

    Long id

    String username

    String password

    String confirmPassword

    public UserAdapter(Map params) {
        this.username = params.username
        this.password = params.password
        this.confirmPassword = params.confirmPassword
    }

    public UserAdapter(User user) {
        this.id = user.id
        this.username = user.username
    }
}
