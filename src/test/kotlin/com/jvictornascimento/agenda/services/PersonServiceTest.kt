package com.jvictornascimento.agenda.services


import com.jvictornascimento.agenda.dtos.PersonCreateDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonModel
import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertEquals


@ExtendWith(MockitoExtension::class)
class PersonServiceTest {
    @Mock
    private lateinit var repository: PersonRepository

    @InjectMocks
    private lateinit var service: PersonService

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
    fun testGetByIdSuccess() {
        `when`(repository.findById(1L)).thenReturn(Optional.of(person.toPersonModel()))

        val result = service.getById(1L)

        assertEquals(person.name, result.name)
        assertEquals(person.age, result.age)
        assertEquals(person.email, result.email)
        assertEquals(person.addresses, result.addresses)
        assertEquals(person.contacts, result.contacts)

    }
    @Test
    fun testGetByIdFailure() {
        `when`(repository.findById(2L)).thenThrow(IdNotFoundException(2L))
        val messagem = "Id 2 not found!"

        val exception = assertThrows<IdNotFoundException> {service.getById(2L)}

        assertEquals(messagem,exception.message)
    }

    @Test
    fun testGetAllSuccess() {
    }

    @Test
    fun testUpdatePersonSuccess() {
    }
    @Test
    fun testUpdatePersonFailure() {
    }

    @Test
    fun testCreatePersonSuccess() {
    }
    @Test
    fun testCreatePersonFailure() {
    }

    @Test
    fun testDeletePersonSuccess() {
    }
    @Test
    fun testDeletePersonFailure() {
    }
}