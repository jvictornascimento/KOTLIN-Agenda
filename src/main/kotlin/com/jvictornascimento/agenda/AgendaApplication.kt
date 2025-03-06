package com.jvictornascimento.agenda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AgendaApplication

fun main(args: Array<String>) {
    runApplication<AgendaApplication>(*args)
}
