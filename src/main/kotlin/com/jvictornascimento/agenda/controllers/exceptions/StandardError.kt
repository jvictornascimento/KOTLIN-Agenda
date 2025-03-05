package com.jvictornascimento.agenda.controllers.exceptions

import java.time.Instant

data class StandardError(
    val timestamp: Instant,
    val status: Int,
    val error: String,
    val message: String,
    val path: String)
