package com.jvictornascimento.agenda.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "TB_PERSON")
data class PersonModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name:String? = "",
    val age: Int? = 0,
    var email:String? ="",
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    @JsonManagedReference
    val addresses:List<AddressModel>? = emptyList(),
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    @JsonManagedReference
    val contacts:List<ContactModel>? = emptyList()
    )
