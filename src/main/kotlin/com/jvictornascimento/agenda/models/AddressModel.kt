package com.jvictornascimento.agenda.models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "TB_ADDRESS")
data class AddressModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val address:String,
    val number:Long,
    val state:String,
    val city:String,
    val codePostal:Long,
    @ManyToOne
    @JsonBackReference
    val person:PersonModel

)
