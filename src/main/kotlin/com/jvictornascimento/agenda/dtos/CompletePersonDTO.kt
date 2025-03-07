package com.jvictornascimento.agenda.dtos

import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel

data class CompletePersonDTO(
    val id: Long? = null,
    val name:String,
    val age: Int?,
    val email:String?,
    val addresses:List<AddressModel>?,
    val contacts:List<ContactModel>?
)
