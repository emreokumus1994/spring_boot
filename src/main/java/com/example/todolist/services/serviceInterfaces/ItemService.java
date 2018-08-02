package com.example.todolist.services.serviceInterfaces;


import org.springframework.http.ResponseEntity;

public interface ItemService {

    ResponseEntity<?> getItem(Long itemId);
    ResponseEntity<?> getAllItemFromList(Long listId);
    ResponseEntity<?> addItem(Long listId, String title, String description, String deadline);
    ResponseEntity<?> deleteItem(Long itemId);
}
