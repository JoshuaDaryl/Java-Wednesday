package com.v1.ToDoChallenge.Services;

import com.v1.ToDoChallenge.Models.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class TodoService {

    private List<Todo> todoList = new ArrayList<>();

    public TodoService() {
        todoList.add(new Todo(1, "Create get endpoint", "High", LocalDate.now(), true ));
        todoList.add(new Todo(2, "Create post endpoint", "High", LocalDate.now(), true ));
        todoList.add(new Todo(3, "Create put endpoint", "Medium", LocalDate.now(), true ));
        todoList.add(new Todo(4, "Create delete endpoint", "Low", LocalDate.now(), true ));
    }


    public List<Todo> getTodos(){

        if(todoList.size() > 0) {
            return todoList;
        }else{
            throw new NoSuchElementException("No todos available.");
        }

    }

    public Todo addTodo(Todo todo){
        if (todo == null) {
            throw new IllegalArgumentException("Todo cannot be null");
        }
        todoList.add(todo);
        return todo;
    }

    public String deleteTodo(int id) {
        boolean idExists = todoList.removeIf(todo -> todo.getId() == id);
        if (!idExists) {
            throw new IllegalArgumentException("Cannot fine todo with id: " + id);
        }
        return "OK";
    }


    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoList.stream()
                .filter(t -> t.getId() == todo.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot fine todo with id: " + todo.getId()));

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setPriority(todo.getPriority());
        existingTodo.setDeadline(todo.getDeadline());

        return existingTodo;
    }
    public Todo getTodoById(int id){
        return todoList.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot fine todo with id: " + id));
    }


}
