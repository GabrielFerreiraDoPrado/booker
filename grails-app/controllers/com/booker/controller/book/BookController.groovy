package com.booker.controller.book

import com.booker.book.adapter.BookAdapter
import com.booker.controller.base.BaseController
import com.booker.exception.BusinessException
import com.booker.user.adapter.UserAdapter

import utils.flashmessage.FlashMessageType

class BookController extends BaseController {

    def bookService

    def index() {
        List<BookAdapter> bookAdapterList = bookService.list()

        return [bookAdapterList: bookAdapterList]
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

    def show() {
        Long bookId = Long.valueOf(params.id.toString())
        BookAdapter bookAdapter = bookService.find(bookId)

        return [bookAdapter: bookAdapter,
                currentUserAdapter: new UserAdapter(getCurrentUser())]
    }

    def edit() {
        Long bookId = Long.valueOf(params.id.toString())
        BookAdapter bookAdapter = bookService.find(bookId)

        return [bookAdapter: bookAdapter,
                currentUserAdapter: new UserAdapter(getCurrentUser())]
    }

    def update() {
        try {
            BookAdapter adapter = new BookAdapter(params)
            bookService.update(adapter, getCurrentUser())

            flash.message = "Livro alterado com sucesso"
            flash.type = FlashMessageType.SUCCESS
        } catch (BusinessException businessException) {
            flash.message = businessException.getMessage()
            flash.type = FlashMessageType.ERROR
        } catch (Exception exception) {
            flash.message = "Erro inesperado, tente novamente mais tarde"
            flash.type = FlashMessageType.ERROR
        } finally {
            redirect(controller: "book", action: "show", id: params.id)
        }
    }
}
