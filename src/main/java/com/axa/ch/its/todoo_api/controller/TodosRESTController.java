package com.axa.ch.its.todoo_api.controller;

import com.axa.ch.its.todoo_api.model.Todo;
import com.axa.ch.its.todoo_api.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/todos")
public class TodosRESTController {
    TodosRepository todosRepository;

    @Autowired
    public TodosRESTController(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return todosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOneTodo(@PathVariable long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todosRepository.findByID(id));
    }


    @PostMapping
    public HttpStatus addTodo(@RequestBody Todo addTodo) {
        todosRepository.getTodos().add(addTodo);
        return HttpStatus.CREATED;
    }

    @PutMapping("/{id}")
    public HttpStatus updateTodo(@RequestBody Todo updateTodo, @PathVariable long id) {
        todosRepository.save(updateTodo, id);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTodo(@PathVariable long id) {
        todosRepository.delete(id);
        return HttpStatus.OK;
    }

    @PatchMapping("/{id}/{state}")
    public ResponseEntity<String> changeState(@PathVariable long id, @PathVariable String state){
        if ("completed;open".contains(state)) {
            Todo todo = todosRepository.findByID(id);
            todo.setCompleted(state.equals("completed"));
            return new ResponseEntity<>("", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }

}
