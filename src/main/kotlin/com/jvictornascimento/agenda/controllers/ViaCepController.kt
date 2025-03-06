package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.ViaCepDTO
import com.jvictornascimento.agenda.services.ViaCepService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cep")
class viaCepController(private val service: ViaCepService){
    @GetMapping("/search/{cep}")
    fun findByCep(@PathVariable cep:Int):ResponseEntity<ViaCepDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(service.getCep(cep))
    }
}

