package com.jvictornascimento.agenda.services


import com.jvictornascimento.agenda.dtos.CompletePersonDTO
import com.jvictornascimento.agenda.dtos.PersonCreateDTO
import com.jvictornascimento.agenda.mapper.toCompletePersonDTO
import com.jvictornascimento.agenda.mapper.toPersonModel
import com.jvictornascimento.agenda.models.AddressModel
import com.jvictornascimento.agenda.models.ContactModel
import com.jvictornascimento.agenda.models.PersonModel
import com.jvictornascimento.agenda.repositories.PersonRepository
import com.jvictornascimento.agenda.services.exceptions.IdNotFoundException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
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
        val pageable: Pageable = PageRequest.of(0, 10)
        val page: Page<PersonModel> = PageImpl(listOf(person.toPersonModel()), pageable, 1L)

        `when`(repository.findAll(pageable)).thenReturn(page)

        val result = service.getAll(pageable)

        assertEquals(1, result.content.size)
        assertEquals(person.id, result.content[0].id)
        assertEquals(person.name, result.content[0].name)
        assertEquals(person.age, result.content[0].age)


    }

    @Test
    fun testUpdatePersonSuccess() {
        val updatedPerson = CompletePersonDTO(null,"joao",25,null, listOf(address), listOf(contact))

        `when`(repository.findById(1L)).thenReturn(Optional.of(person.toPersonModel()))

        `when`(repository.save(any(PersonModel::class.java))).thenReturn(updatedPerson.toPersonModel())

        val result = service.updatePerson(1L, updatedPerson)

        assertEquals(updatedPerson.name, result.name)
        assertEquals(updatedPerson.age, result.age)


    }
    @Test
    fun testUpdatePersonFailure() {
        `when`(repository.findById(person.id!!)).thenReturn(Optional.empty())

        val messagem = "Id 1 not found!"

        val exception = assertThrows<IdNotFoundException> {service.updatePerson(person.id!!,person.toPersonModel().toCompletePersonDTO())}

        assertEquals(messagem,exception.message)
        verify(repository, never()).save(person.toPersonModel())
    }

    @Test
    fun testCreatePersonSuccess() {
        `when`(repository.save(person.toPersonModel())).thenReturn(person.toPersonModel())

        val result = service.createPerson(person)

        assertEquals(person.name, result.name)
        assertEquals(person.age, result.age)
        assertEquals(person.email, result.email)
        assertEquals(person.addresses, result.addresses)
        assertEquals(person.contacts, result.contacts)
    }
    @Test
    fun testDeletePersonSuccess() {
        `when`(repository.existsById(person.id!!)).thenReturn(true)
        doNothing(). `when`(repository).deleteById(person.id!!)

        service.deletePerson(person.id!!)

        verify(repository, times(1)).deleteById(person.id!!)

        assertDoesNotThrow {
            service.deletePerson(person.id!!)
        }
    }
    @Test
    fun testDeletePersonFailure() {
        `when`(repository.existsById(person.id!!)).thenReturn(false)

        val messagem = "Id 1 not found!"

        val exception = assertThrows<IdNotFoundException> {service.deletePerson(person.id!!)}

        assertEquals(messagem,exception.message)
        verify(repository, never()).deleteById(person.id!!)
    }
}