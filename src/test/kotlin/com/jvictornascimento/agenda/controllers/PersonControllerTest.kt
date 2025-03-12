package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel
import com.jvictornascimento.agenda.services.PersonService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    val address = AddressModel(
        1L,
        "Rua dos lirios",
        85,
        "Sp",
        "Pedreira",
        13923214)
    val contact = ContactModel(
        1L,
        19996686866)
    val person = CompletePersonDTO(
        1L,
        "João Victor Santos do Nascimento",
        27,
        "joao@gmail.com",
        listOf(address),
        listOf(contact)
    )
    @Test
    fun findAll() {
    }

    @Test
    fun findById() {
    }

    @Test
    fun testCreatePersonSuccess() {
        webTestClient
            .post()
            .uri("/person")
            .bodyValue(person)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CompletePersonDTO::class.java)
            .consumeWith { response ->
                val responseBody = response.responseBody
                assert(responseBody!!.name == person.name)
                assert(responseBody.age == person.age)
                assert(responseBody.email == person.email)
                assert(responseBody.addresses == person.addresses)
                assert(responseBody.contacts == person.contacts)
            }
    }
    @Test
    fun testCreatePersonFailure() {
        webTestClient
            .post()
            .uri("/person")
            .bodyValue(
                CompletePersonDTO(
                    null,
                    null,
                    27,
                    null,
                    listOf(address),
                    listOf(contact)
                )
            )
            .exchange()
            .expectStatus().isBadRequest
    }

    @Test
    fun updatePerson() {
    }

    @Test
    fun deletePerson() {
    }
}