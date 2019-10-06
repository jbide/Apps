package fr.jyb.app.rest.v1.controller;

import fr.jyb.app.rest.dtos.TodoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class WelcomeRestController {

    @GetMapping(value = "/todos")
    @ResponseBody
    public ResponseEntity<?> loadTodoList() {
        log.info("load list");
        TodoDTO todo = new TodoDTO();
        todo.setId(1);
        todo.setName("Dupont");
        todo.setDescription("tintin");

        List<TodoDTO> todos = new ArrayList<>();
        todos.add(todo);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping(value = "/home")
    @ResponseBody
        public ResponseEntity<?> getMessage() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
