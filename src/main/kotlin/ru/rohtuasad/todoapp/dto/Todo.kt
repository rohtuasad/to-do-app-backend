package ru.rohtuasad.todoapp.dto

import java.time.LocalDate
import java.util.*

data class Todo(
    var id: UUID?,
    val username: String,
    val description: String,
    val targetDate: LocalDate,
    val isDone: Boolean
)
