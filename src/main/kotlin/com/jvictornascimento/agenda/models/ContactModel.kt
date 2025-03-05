package com.jvictornascimento.agenda.models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import kotlin.jvm.internal.Ref.LongRef

@Entity
@Table(name = "TB_CONTACT")
data class ContactModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val numberPhone:Long,
    @ManyToOne
    @JsonBackReference
    val person:PersonModel
)
