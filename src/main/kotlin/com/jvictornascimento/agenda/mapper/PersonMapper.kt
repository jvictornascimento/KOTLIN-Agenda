package com.jvictornascimento.agenda.mapper

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.models.PersonModel

    fun PersonModel.toPersonDto(): PersonDTO {
        return PersonDTO(id = if (id == 0L) null else id,
            name,age)
    }
    fun PersonModel.toCompletePersonDTO(): CompletePersonDTO {
    return CompletePersonDTO(id = if (id == 0L) null else id,
        name,age,email,addresses,contacts)
    }
    fun CompletePersonDTO.toPersonModel(): PersonModel {
        return PersonModel(
            id = id,
            name = name,
            age = age ?: 0,
            email = email ?: "",
            addresses = addresses ?: emptyList(),
            contacts = contacts ?: emptyList()
        )
    }
        fun PersonDTO.toPersonModel(): PersonModel {
            return PersonModel(
                id = if (id == 0L) null else id,
                name = name,
                age = age ?: 0,
                email =  "",
                addresses = emptyList(),
                contacts =  emptyList()
            )
        }
