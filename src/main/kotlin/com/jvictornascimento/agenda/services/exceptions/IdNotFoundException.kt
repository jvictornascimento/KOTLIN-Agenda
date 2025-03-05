package com.jvictornascimento.agenda.services.exceptions

class IdNotFoundException(id:Long): RuntimeException("Id $id not found!") {
}