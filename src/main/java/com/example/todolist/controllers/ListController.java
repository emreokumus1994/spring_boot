package com.example.todolist.controllers;
import com.example.todolist.services.serviceImpl.ListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ListServiceImpl listService;

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseEntity<?> callGetTodoList() {

        return listService.getTodoList();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> callNewTodoList(@RequestParam(value = "listTitle") String listTitle) {

        return listService.newTodoList(listTitle);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> callDeleteTodoList(@PathVariable Long id) {

        return listService.deleteTodoList(id);
    }
}
