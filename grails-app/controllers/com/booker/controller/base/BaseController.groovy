package com.booker.controller.base

import com.booker.exception.BusinessException

import utils.flashmessage.FlashMessageType

abstract class BaseController {

    def exceptionHandler(Exception exception) {
        if (exception instanceof BusinessException) {
            flash.message = exception.getMessage()
            flash.type = FlashMessageType.ERROR
            return
        }

        if (exception instanceof Exception) {
            flash.message = "Erro inesperado, tente novamente mais tarde"
            flash.type = FlashMessageType.ERROR
        }
    }
}
