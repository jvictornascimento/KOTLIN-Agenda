package com.jvictornascimento.agenda.models

import com.fasterxml.jackson.annotation.JsonManagedReference
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
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    @JsonManagedReference
    val addresses:List<AddressModel>,
    @OneToMany(mappedBy = "person", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    @JsonManagedReference
    val contacts:List<ContactModel>
    )
