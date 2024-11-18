package com.v1.ToDoChallenge.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Todo {

    private int id;
    private String title;
    private String priority;
    private LocalDate deadline;
    private boolean done;

    public Todo(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.priority = todo.getPriority();
        this.deadline = todo.getDeadline();
        this.done = todo.isDone();
    }


}
