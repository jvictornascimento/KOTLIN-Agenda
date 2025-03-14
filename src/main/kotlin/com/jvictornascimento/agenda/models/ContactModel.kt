package com.jvictornascimento.agenda.models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "TB_CONTACT")
data class ContactModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,
    val numberPhone:Long,
    @ManyToOne
    @JsonBackReference
    val person:PersonModel? =null
)
