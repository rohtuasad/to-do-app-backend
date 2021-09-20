package ru.rohtuasad.todoapp.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rohtuasad.todoapp.dto.Todo
import ru.rohtuasad.todoapp.service.TodoService

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class TodoController(val todoService: TodoService) {

    @GetMapping("/users/{username}/todos")
    fun getAllTodos(@PathVariable username: String): List<Todo> {
        return todoService.findAll()
    }

    @GetMapping("/users/{username}/todos/{id}")
    fun getTodo(@PathVariable username: String, @PathVariable id: Long): Todo? {
        return todoService.findById(id)
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    fun deleteTodo(@PathVariable username: String, @PathVariable id: Long) : ResponseEntity<Void> {
        val todo = todoService.deleteById(id)
        return if (todo != null) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }


}
