package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonCreateDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.services.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun createPerson(@RequestBody person: PersonCreateDTO):ResponseEntity<CompletePersonDTO>{
        val data = service.createPerson(person)
        return ResponseEntity(data, HttpStatus.CREATED)
    }
    @PutMapping("/{id}")
    fun updatePerson( @PathVariable id:Long, @RequestBody person: CompletePersonDTO):ResponseEntity<CompletePersonDTO>{
        val data = service.updatePerson(id,person)
        return ResponseEntity(data, HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id:Long):ResponseEntity<Void>{
        service.deletePerson(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}