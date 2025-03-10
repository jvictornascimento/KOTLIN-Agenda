package com.jvictornascimento.agenda.controllers.exceptions

import com.jvictornascimento.agenda.services.exceptions.CepNotFoundException
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ControllerExceptionsHandler {
    @ExceptionHandler(IdNotFoundException::class)
    fun idNotFound(e: IdNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = "Error resource not found"
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(
            Instant.now(),
            status.value(),
            error,
            e.message ?: "No message available",
            request.requestURI
        )
        return ResponseEntity.status(status).body(err)
    }
    @ExceptionHandler(CepNotFoundException::class)
    fun idNotFound(e: CepNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val error = "Error resource not found"
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(
            Instant.now(),
            status.value(),
            error,
            e.message ?: "No message available",
            request.requestURI
        )
        return ResponseEntity.status(status).body(err)
    }
}