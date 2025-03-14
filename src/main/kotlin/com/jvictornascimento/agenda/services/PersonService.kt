package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonCreateDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonDto
import com.jvictornascimento.agenda.mapper.toPersonModel
import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PersonService(private val repository:PersonRepository) {
    fun getById(id:Long): CompletePersonDTO {
        return repository.findById(id).map { it.toCompletePersonDTO() }.orElseThrow{ IdNotFoundException(id) }
        }
   
    fun getAll(pageable: Pageable): Page<PersonDTO> {
        val persons = repository.findAll(pageable)
        return persons.map { person -> person.toPersonDto() }
    }
    fun updatePerson(id: Long ,person:CompletePersonDTO):CompletePersonDTO{
        val data = repository.findById(id).orElseThrow {
                IdNotFoundException(id)
        }
        return repository.save(updateData(data,person.toPersonModel())).toCompletePersonDTO()

    }
    fun createPerson(person: PersonCreateDTO):CompletePersonDTO{
        return repository.save(person.toPersonModel()).toCompletePersonDTO()
    }
    fun deletePerson(id:Long){
        if (!repository.existsById(id)){
            throw IdNotFoundException(id)
        }
        repository.deleteById(id)
    }
    private fun updateData(data: PersonModel, person: PersonModel): PersonModel {
        return data.copy(
            name = if(person.name?.isNotBlank() == true) person.name else data.name,
            age = if (person.age == 0) data.age else person.age,
            email = if (person.email?.isNotBlank() == true) person.email else data.email,
            addresses = if (!person.addresses.isNullOrEmpty()) person.addresses else data.addresses,
            contacts = if (!person.contacts.isNullOrEmpty()) person.contacts else data.contacts

        )
    }

}