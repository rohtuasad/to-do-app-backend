package ru.rohtuasad.todoapp.dto

import java.time.LocalDate

data class Todo(
    val id: Long,
    val username: String,
    val description: String,
    val targetDate: LocalDate,
    val isDone: Boolean
)
