package com.jvictornascimento.agenda.services

import com.jvictornascimento.agenda.dtos.ViaCepDTO
import com.jvictornascimento.agenda.feignClients.ViaCepFeignClient
import com.jvictornascimento.agenda.services.exceptions.CepNotFoundException
import org.springframework.stereotype.Service

@Service
class ViaCepService(private val viacepfeignclient:ViaCepFeignClient) {

    fun getCep(searchCep:Int): ViaCepDTO? {
        val dataCep = viacepfeignclient.getCep(searchCep).body
            ?: throw CepNotFoundException(searchCep)

        return if (dataCep.cep.isNullOrBlank()) {
            throw CepNotFoundException(searchCep)
        } else {
            dataCep
        }
    }
}