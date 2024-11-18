package com.v1.ToDoChallenge;


import com.v1.ToDoChallenge.Models.Todo;
import com.v1.ToDoChallenge.Services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TodoTests {

    @InjectMocks
    private TodoService todoService;


    @Test
    public void getTodosTest(){
        List<Todo> todos = todoService.getTodos();
        assertThat(todos).isNotNull();
        assertThat(todos.size()).isEqualTo(4);
    }

    @Test
    public void deleteTodoTest(){
        String delete = todoService.deleteTodo(1);
        assertThat(todoService.getTodos()).hasSize(3);
        assertThat(delete).isEqualTo("OK");
    }

    @Test
    public void addTodoTest(){

        int beforeAdd = todoService.getTodos().size();
        Todo todo = todoService.addTodo(new Todo(99,"Test", "High", LocalDate.now(), false));
        int afterAdd = todoService.getTodos().size();
        assertThat(todo).isEqualTo(new Todo(99,"Test", "High", LocalDate.now(), false));
        assertThat(afterAdd).isGreaterThan(beforeAdd);
    }


    @Test
    public void updateTodoTest(){

        Todo beforeUpdate = todoService.getTodoById(1);
        Todo todo = todoService.updateTodo(new Todo(1, "Update Test", "High", LocalDate.now(), true));
        Todo afterUpdate = todoService.getTodoById(1);
        assertThat(todo).isEqualTo(new Todo(1, "Update Test", "High", LocalDate.now(), true));
        //I Cannot get this last part of the test to work, I am unsure why, they should not be the same
        assertThat(beforeUpdate).isNotEqualTo(afterUpdate);

    }
}
