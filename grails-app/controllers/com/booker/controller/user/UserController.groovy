package com.booker.controller.user

import com.booker.controller.base.BaseController
import com.booker.user.adapter.UserAdapter

import utils.flashmessage.FlashMessageType

class UserController extends BaseController {

    def userService

    def login() {
        return [:]
    }

    def signUp() {
        return [:]
    }

    def save() {
        try {
            UserAdapter adapter = new UserAdapter(params)
            userService.save(adapter)

            flash.message = "Conta criada com sucesso."
            flash.type = FlashMessageType.SUCCESS

            redirect(action: "login")
        } catch (Exception exception) {
            exceptionHandler(exception)

            redirect(action: "signUp")
        }
    }
}
