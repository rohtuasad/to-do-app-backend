package ru.rohtuasad.todoapp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
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

    @PutMapping("/users/{username}/todos/{id}")
    fun updateTodo(
        @PathVariable username: String,
        @PathVariable id: Long,
        @RequestBody todo: Todo
    ): ResponseEntity<Todo> {
        return ResponseEntity<Todo>(todoService.saveTodo(todo), HttpStatus.OK)
    }

    @PostMapping("/users/{username}/todos")
    fun updateTodo(
        @PathVariable username: String, @RequestBody todo: Todo
    ): ResponseEntity<Void> {
        val createdTodo = todoService.saveTodo(todo)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(createdTodo.id).toUri()
        return ResponseEntity.created (uri).build()
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    fun deleteTodo(@PathVariable username: String, @PathVariable id: Long): ResponseEntity<Void> {
        val todo = todoService.deleteById(id)
        return if (todo != null) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
