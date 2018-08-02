package com.example.todolist.services.serviceInterfaces;

import org.springframework.http.ResponseEntity;

public interface ListService {

    ResponseEntity<?> getTodoList();
    ResponseEntity<?> newTodoList(String title);
    ResponseEntity<?> deleteTodoList(Long id);
}
