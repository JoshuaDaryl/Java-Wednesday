package com.v1.ToDoChallenge.Controllers;


import com.v1.ToDoChallenge.Models.Todo;
import com.v1.ToDoChallenge.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        List<Todo>todos = todoService.getTodos();
        System.out.println(ResponseEntity.ok(todos));
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){

        Todo addNewTodo = todoService.addTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(addNewTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Todo deleted.");
    }

    @PutMapping
    public ResponseEntity<String> updateTodo(@RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return ResponseEntity.status(HttpStatus.OK).body("Todo updated.");
    }


}
