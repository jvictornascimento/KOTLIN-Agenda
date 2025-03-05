package com.jvictornascimento.agenda.models

import jakarta.persistence.*

@Entity
@Table(name = "TB_PERSON")
data class PersonModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name:String,
    val age: Int,
    val email:String,
    @OneToMany(mappedBy = "person")
    val addresses:List<AddressModel>,
    @OneToMany(mappedBy = "person")
    val contacts:List<ContactModel>
    )
