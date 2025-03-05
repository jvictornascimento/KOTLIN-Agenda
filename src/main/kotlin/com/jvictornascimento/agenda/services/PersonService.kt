package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.springframework.stereotype.Service

@Service
class PersonService(private val repository:PersonRepository) {
    fun getById(id:Long):PersonModel{
        return repository.findById(id).orElseThrow{IdNotFoundException(id)}
        }
    fun getAll():List<PersonModel>{
        return repository.findAll();
    }

}