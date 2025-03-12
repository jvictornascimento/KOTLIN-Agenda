package com.jvictornascimento.agenda.controllers

import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonCreateDTO
import com.jvictornascimento.agenda.dtos.PersonDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonDto
import com.jvictornascimento.agenda.mapper.toPersonModel
import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel
import com.jvictornascimento.agenda.services.PersonService
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
    @Autowired
    private lateinit var webTestClient: WebTestClient
    @MockitoBean
    private lateinit var personService:PersonService

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
    val person = PersonCreateDTO(
        1L,
        "João Victor Santos do Nascimento",
        27,
        "joao@gmail.com",
        listOf(address),
        listOf(contact)
    )
    @Test
    fun testFindAllSuccess() {
        val pageable = PageRequest.of(0,10)
        val personPage = PageImpl(listOf(person.toPersonModel().toPersonDto()),pageable,1L)

        `when`(personService.getAll(pageable)).thenReturn(personPage)

        webTestClient
            .get()
            .uri("/person")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.content").isArray
            .jsonPath("$.content.length()").isEqualTo(1)
            .jsonPath("$.content[0].name").isEqualTo(person.name!!)
            .jsonPath("$.content[0].age").isEqualTo(person.age!!)
    }
    @Test
    fun testFindByIdSuccess() {
        `when`(personService.getById(1L)).thenReturn(person.toPersonModel().toCompletePersonDTO())
        webTestClient
            .post()
            .uri("/person")
            .bodyValue(person)
            .exchange()
            .expectStatus().isCreated
        webTestClient
            .get()
            .uri("/person/1")
            .exchange()
            .expectStatus().isOk
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
    fun testFindByIdFailure() {
        `when`(personService.getById(2L)).thenThrow(IdNotFoundException(2L))

        webTestClient
            .get()
            .uri("/person/2")
            .exchange()
            .expectStatus().isNotFound
    }

    @Test
    fun testCreatePersonSuccess() {
        `when`(personService.createPerson(person)).thenReturn(person.toPersonModel().toCompletePersonDTO())
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