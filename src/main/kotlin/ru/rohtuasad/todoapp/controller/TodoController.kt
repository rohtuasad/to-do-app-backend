package ru.rohtuasad.todoapp.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.rohtuasad.todoapp.dto.Todo
import ru.rohtuasad.todoapp.service.TodoService

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
class TodoController(val todoService: TodoService) {


    @GetMapping("/users/{username}/todos")
    fun getAllTodos(@PathVariable username: String): List<Todo> {
        return todoService.findAll()
    }
}
