package com.jvictornascimento.agenda.services.exceptions

class CepNotFoundException(cep:Int): RuntimeException("Cep $cep not found!") {
}