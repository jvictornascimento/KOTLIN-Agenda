package com.jvictornascimento.agenda.models

import jakarta.persistence.*
import kotlin.jvm.internal.Ref.LongRef

@Entity
@Table(name = "TB_CONTACT")
data class ContactModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val numberPhone:Int,
    @ManyToOne
    val person:PersonModel
)
