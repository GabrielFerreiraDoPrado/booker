package com.booker.controller.book

import com.booker.book.adapter.BookAdapter
import com.booker.controller.base.BaseController
import com.booker.exception.BusinessException

import utils.flashmessage.FlashMessageType

class BookController extends BaseController {

    def bookService

    def index() {
        return [:]
    }

    def create() {
        return [:]
    }

    def save() {
        try {
            BookAdapter adapter = new BookAdapter(params, getCurrentUser())
            bookService.save(adapter)

            flash.message = "Livro criado com sucesso"
            flash.type = FlashMessageType.SUCCESS
        } catch (BusinessException businessException) {
            flash.message = businessException.getMessage()
            flash.type = FlashMessageType.ERROR
        } catch (Exception exception) {
            flash.message = "Erro inesperado, tente novamente mais tarde"
            flash.type = FlashMessageType.ERROR
        } finally {
            redirect(controller: "book", action: "create")
        }
    }
}
