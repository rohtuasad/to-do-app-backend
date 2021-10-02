package ru.rohtuasad.todoapp.service

import org.springframework.stereotype.Service
import ru.rohtuasad.todoapp.model.Todo
import java.time.LocalDate
import java.util.*

@Service
class TodoService {
    private val todos: MutableList<Todo> =
        mutableListOf(
            Todo(UUID.randomUUID(),"Learn React", LocalDate.now(), false, "username"),
            Todo(UUID.randomUUID(), "Become expert in React", LocalDate.now(), false, "username"),
            Todo(UUID.randomUUID(), "Visit India", LocalDate.now(), false, "username")
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
            todos.add(todo)
        } else {
            deleteById(todo.id!!)
            todos.add(todo)
        }
        return todo
    }
}
