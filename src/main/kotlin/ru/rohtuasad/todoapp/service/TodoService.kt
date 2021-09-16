package ru.rohtuasad.todoapp.service

import org.springframework.stereotype.Service
import ru.rohtuasad.todoapp.dto.Todo
import java.time.LocalDate

@Service
class TodoService {
    private val todos: List<Todo> =
        listOf(
            Todo(1, "username", "Learn React", LocalDate.now(), false),
            Todo(2, "username", "Become expert in React", LocalDate.now(), false),
            Todo(3, "username", "Visit India", LocalDate.now(), false)
        )

    fun findAll(): List<Todo> {
        return todos
    }
}
