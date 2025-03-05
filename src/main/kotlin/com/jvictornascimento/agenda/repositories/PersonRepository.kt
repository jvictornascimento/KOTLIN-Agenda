package com.jvictornascimento.agenda.repositories

import com.jvictornascimento.agenda.models.PersonModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository:JpaRepository<PersonModel,Long>{
}