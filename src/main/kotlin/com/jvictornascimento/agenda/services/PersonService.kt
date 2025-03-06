package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonDto
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.springframework.stereotype.Service

@Service
class PersonService(private val repository:PersonRepository) {
    fun getById(id:Long):CompletePersonDTO{
        return repository.findById(id).map { it.toCompletePersonDTO() }.orElseThrow{IdNotFoundException(id)}
        }
    fun getAll():List<PersonDTO>{
        return repository.findAll().map { it.toPersonDto() }
    }

}