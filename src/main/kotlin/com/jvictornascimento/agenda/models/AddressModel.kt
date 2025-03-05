package com.jvictornascimento.agenda.models

import jakarta.persistence.*

@Entity
@Table(name = "TB_ADDRESS")
data class AddressModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val address:String,
    val number:Int,
    val state:String,
    val city:String,
    val codePostal:Int,
    @ManyToOne
    val person:PersonModel

)
