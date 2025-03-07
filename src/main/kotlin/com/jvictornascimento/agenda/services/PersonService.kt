package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonDto
import com.jvictornascimento.agenda.mapper.toPersonModel
import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.springframework.stereotype.Service

@Service
class PersonService(private val repository:PersonRepository) {
    fun getById(id:Long): CompletePersonDTO {
        return repository.findById(id).map { it.toCompletePersonDTO() }.orElseThrow{ IdNotFoundException(id) }
        }
    fun getAll():List<PersonDTO>{
        return repository.findAll().map { it.toPersonDto() }
    }
    fun savePerson(person:CompletePersonDTO):CompletePersonDTO{
        if (person.id != null) {
            val data = repository.findById(person.id).orElseThrow {
                IdNotFoundException(person.id)
            }
            val updatedData = updateData(person.toPersonModel(), data)
            return repository.save(updatedData).toCompletePersonDTO()
        }
       return repository.save(person.toPersonModel()).toCompletePersonDTO()
    }

    fun updateData(person:PersonModel,data:PersonModel):PersonModel{
        return person.copy(
            name = data.name.ifBlank { person.name },
            age = data.age ?: person.age,
            email = data.email?.ifBlank { person.email } ?: person.email,
            addresses = if (data.addresses.isNullOrEmpty()) person.addresses else data.addresses,
            contacts = if (data.contacts.isNullOrEmpty()) person.contacts else data.contacts
        )
    }

}