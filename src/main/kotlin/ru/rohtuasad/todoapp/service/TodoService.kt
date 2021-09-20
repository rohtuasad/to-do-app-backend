package ru.rohtuasad.todoapp.service

import org.springframework.stereotype.Service
import ru.rohtuasad.todoapp.dto.Todo
import java.time.LocalDate

@Service
class TodoService {
    private var idCounter = 3L
    private val todos: MutableList<Todo> =
        mutableListOf(
            Todo(1, "username", "Learn React", LocalDate.now(), false),
            Todo(2, "username", "Become expert in React", LocalDate.now(), false),
            Todo(3, "username", "Visit India", LocalDate.now(), false)
        )

    fun findAll(): List<Todo> {
        return todos
    }

    fun deleteById(id: Long): Todo? {
        val todo = findById(id)
        return if (todos.remove(todo)) {
            todo
        } else {
            null
        }
    }

    fun findById(id: Long): Todo? {
        return todos.find { todo -> todo.id == id }
    }

    fun saveTodo(todo: Todo): Todo {
        if (todo.id == -1L) {
            todo.id = ++idCounter
            todos.add(todo)
        } else {
            deleteById(todo.id)
            todos.add(todo)
        }
        return todo
    }
}
