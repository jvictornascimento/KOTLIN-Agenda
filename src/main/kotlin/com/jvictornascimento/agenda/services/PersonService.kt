package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val repository:PersonRepository) {
    fun getById(id:Long):PersonModel{
        return repository.findById(id).get();
    }
    fun getAll(id:Long):List<PersonModel>{
        return repository.findAll();
    }

}