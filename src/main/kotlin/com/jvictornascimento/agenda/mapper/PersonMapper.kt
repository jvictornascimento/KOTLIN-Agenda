package com.jvictornascimento.agenda.mapper

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.models.PersonModel

    fun PersonModel.toPersonDto(): PersonDTO {
        return PersonDTO(id,name,age)
    }
fun PersonModel.toCompletePersonDTO(): CompletePersonDTO {
    return CompletePersonDTO(id,name,age,email,addresses,contacts)
}