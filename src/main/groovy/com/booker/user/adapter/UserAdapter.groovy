package com.booker.user.adapter

class UserAdapter {

    String username

    String password

    String confirmPassword

    UserAdapter(Map params) {
        this.username = params.username
        this.password = params.password
        this.confirmPassword = params.confirmPassword
    }
}
