package ru.rohtuasad.todoapp.service

import org.springframework.stereotype.Service
import ru.rohtuasad.todoapp.dto.Todo
import java.time.LocalDate
import java.util.*

@Service
class TodoService {
    private var idCounter = 0L
    private val todos: MutableList<Todo> =
        mutableListOf(
            Todo(UUID.randomUUID(), "username", "Learn React", LocalDate.now(), false),
            Todo(UUID.randomUUID(), "username", "Become expert in React", LocalDate.now(), false),
            Todo(UUID.randomUUID(), "username", "Visit India", LocalDate.now(), false)
        )

    fun findAll(): List<Todo> {
        return todos
    }

    fun deleteById(id: UUID): Todo? {
        val todo = findById(id)
        return if (todos.remove(todo)) {
            todo
        } else {
            null
        }
    }

    fun findById(id: UUID): Todo? {
        return todos.find { todo -> todo.id == id }
    }

    fun saveTodo(todo: Todo): Todo {
        if (todo.id == null) {
            todo.id = UUID.randomUUID()
            todos.add(todo)
        } else {
            deleteById(todo.id!!)
            todos.add(todo)
        }
        return todo
    }
}
