package com.jvictornascimento.agenda.dtos

data class ViaCepDTO(

    val cep: String?,
    val logradouro: String?,
    val complemento: String?,
    val unidade: String?,
    val bairro: String?,
    val localidade: String?,
    val uf:String?,
    val estado: String?,
    val regiao: String?,
    val ibge: Int?,
    val gia: Int?,
    val ddd: Int?,
    val siafi: Int?

)
