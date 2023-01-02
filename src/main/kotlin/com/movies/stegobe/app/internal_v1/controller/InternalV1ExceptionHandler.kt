package com.movies.stegobe.app.internal_v1.controller

import com.movies.stegobe.domain.exception.FkConstraintViolationException
import com.movies.stegobe.domain.exception.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

/**
 * 内部例外ハンドラ
 */
@RestControllerAdvice
class InternalV1ExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        // エラー発生時は空のボディを返す
        return super.handleExceptionInternal(ex, null, headers, status, request)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: NotFoundException) {
        // NotFoundExceptionがスローされた時、HTTPステータスコード404を返す
    }

    @ExceptionHandler(FkConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFkConstraintViolationException(ex: FkConstraintViolationException) {
        // FkConstraintViolationExceptionがスローされた時、HTTPステータスコード400を返す
    }
}