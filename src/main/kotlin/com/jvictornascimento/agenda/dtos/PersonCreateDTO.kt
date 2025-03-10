package com.jvictornascimento.agenda.dtos

import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank

data class PersonCreateDTO(

    val id: Long? = null,
    @field:NotBlank(message = "The name cannot be null")
    val name:String,
    val age: Int?,
    val email:String?,
    val addresses:List<AddressModel>?,
    val contacts:List<ContactModel>?
)
