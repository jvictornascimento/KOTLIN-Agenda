package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.services.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(private val service: PersonService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<PersonDTO>> {
        return ResponseEntity.ok(service.getAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CompletePersonDTO> {
        return ResponseEntity.ok(service.getById(id))
    }
}