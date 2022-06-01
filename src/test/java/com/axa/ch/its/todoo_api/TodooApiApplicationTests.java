package com.axa.ch.its.todoo_api;

import com.axa.ch.its.todoo_api.controller.TodosRESTController;
import com.axa.ch.its.todoo_api.model.Todo;
import com.axa.ch.its.todoo_api.repository.TodosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class TodooApiApplicationTests {
    Todo toto = new Todo(2, 1, "quis ut nam facilis et officia qui", false);

    @Test
    public void test() {
        TodosRepository todosRepository = new TodosRepository();
        TodosRESTController todosRESTController = new TodosRESTController(todosRepository);
        assertEquals(HttpStatus.NO_CONTENT,todosRESTController.updateTodo(toto, toto.getId()));
    }

    @Test
    public void test1() {
        TodosRepository todosRepository = new TodosRepository();
        TodosRESTController todosRESTController = new TodosRESTController(todosRepository);
        assertEquals(HttpStatus.CREATED,todosRESTController.updateTodo(toto, toto.getId()));
    }

    @Test
    public void test2() {
        TodosRepository todosRepository = new TodosRepository();
        TodosRESTController todosRESTController = new TodosRESTController(todosRepository);
        assertEquals(HttpStatus.NOT_FOUND, todosRESTController.updateTodo(toto, toto.getId()));
    }

}