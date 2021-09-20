package ru.rohtuasad.todoapp.service

import org.springframework.stereotype.Service
import ru.rohtuasad.todoapp.dto.Todo
import java.time.LocalDate

@Service
class TodoService {
    private var idCounter = 0L
    private val todos: MutableList<Todo> =
        mutableListOf(
            Todo(++idCounter, "username", "Learn React", LocalDate.now(), false),
            Todo(++idCounter, "username", "Become expert in React", LocalDate.now(), false),
            Todo(++idCounter, "username", "Visit India", LocalDate.now(), false)
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
        if (todo.id == -1L || todo.id == 0L) {
            todo.id = ++idCounter
            todos.add(todo)
        } else {
            deleteById(todo.id)
            todos.add(todo)
        }
        return todo
    }
}
