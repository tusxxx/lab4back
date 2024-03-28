package com.example.lab4back.ui

import com.example.lab4back.data.TodoRepository
import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class TodoController {

    @Autowired lateinit var todoRepository: TodoRepository
    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("todos", todoRepository.findAll())
        return "index"
    }

    @GetMapping("/switchState/{todoId}")
    fun switchState(model: Model, @PathVariable todoId: Int): String {
        val todoItem = todoRepository.getReferenceById(todoId.toLong())
        val newTodoItem = todoItem.copy(state = !todoItem.state)
        todoRepository.delete(todoItem)
        todoRepository.save(newTodoItem)
        model.addAttribute("todos", todoRepository.findAll())
        return "index"
    }
}