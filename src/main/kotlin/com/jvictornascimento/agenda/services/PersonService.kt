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

            return repository.save(updateData(data,person.toPersonModel())).toCompletePersonDTO()
        }
       return repository.save(person.toPersonModel()).toCompletePersonDTO()
    }
    fun deletePerson(id:Long){
        if (!repository.existsById(id)){
            throw IdNotFoundException(id)
        }
        repository.deleteById(id)
    }
    fun updateData(data: PersonModel, person: PersonModel): PersonModel {
        return data.copy(
            name = if(person.name?.isNotBlank() == true) person.name else data.name,
            age = if (person.age == 0) data.age else person.age,
            email = if (person.email?.isNotBlank() == true) person.email else data.email,
            addresses = if (!person.addresses.isNullOrEmpty()) person.addresses else data.addresses,
            contacts = if (!person.contacts.isNullOrEmpty()) person.contacts else data.contacts

        )
    }

}