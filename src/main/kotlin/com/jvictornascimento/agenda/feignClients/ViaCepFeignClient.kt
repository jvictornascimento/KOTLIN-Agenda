package com.jvictornascimento.agenda.feignClients

import com.jvictornascimento.agenda.dtos.ViaCepDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Service
@FeignClient(name = "via-cep", url = "https://viacep.com.br/ws/")
interface ViaCepFeignClient {
    @GetMapping("/{cep}/json")
    fun getCep(@PathVariable cep:Int):ResponseEntity<ViaCepDTO>
}
