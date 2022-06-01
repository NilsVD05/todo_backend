package com.axa.ch.its.todoo_api.repository;

import com.axa.ch.its.todoo_api.model.Todo;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;


@Data
@Repository
public class TodosRepository {
    private List<Todo> todos;

    public TodosRepository() {
        todos = new ArrayList<>();

        todos.add(new Todo(1, 1, "delectus aut autem", false));
        todos.add(new Todo(2, 1, "quis ut nam facilis et officia qui", false));
        todos.add(new Todo(3, 1, "fugiat veniam minus", false));
    }

    public ResponseEntity<List<Todo>> findAll() {
        return status(HttpStatus.OK)
                .body(todos);
    }

    public Todo findByID(long id) {
            return todos.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public Todo save(Todo updateTodo, long id) {
        Todo todo = null;
        try {
            todo = todos
                    .stream()
                    .filter(t -> id == t.getId())
                    .findFirst()
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        todo.setUserId(updateTodo.getUserId());
        todo.setTitle(updateTodo.getTitle());
        todo.setCompleted(updateTodo.isCompleted());


        return updateTodo;
    }

    public void delete(long id) {
        todos.remove(findByID(id));
        System.out.println("Löschen");
    }
}
