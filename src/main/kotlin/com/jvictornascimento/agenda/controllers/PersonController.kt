package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.services.PersonService
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(private val service: PersonService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<PersonDTO>> {
        return ResponseEntity(service.getAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CompletePersonDTO> {
        return ResponseEntity(service.getById(id),HttpStatus.OK)
    }
    @PostMapping
    fun createPerson(@RequestBody person: CompletePersonDTO):ResponseEntity<CompletePersonDTO>{
        val data = service.savePerson(person)
        return ResponseEntity(data, HttpStatus.CREATED)
    }
    @PutMapping()
    fun updatePerson( @RequestBody person: CompletePersonDTO):ResponseEntity<CompletePersonDTO>{
        val data = service.savePerson(person)
        return ResponseEntity(data, HttpStatus.OK)
    }
}