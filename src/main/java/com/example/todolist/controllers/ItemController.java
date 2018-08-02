package com.example.todolist.controllers;
import com.example.todolist.model.Item;
import com.example.todolist.services.serviceInterfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/get")
    public ResponseEntity<?> callGetItem(@RequestParam(value = "id") Long id) {

        return itemService.getItem(id);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> callGetAllItemFromList(@RequestParam(value = "listId") Long listId) {

        return itemService.getAllItemFromList(listId);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> callAddItem(@Valid @RequestBody Item item) {

        return itemService.addItem(item.getListId().longValue(), item.getTitle(), item.getDescription(), item.getDeadline());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> callDeleteItem(@PathVariable Long id) {

        return itemService.deleteItem(id);
    }
}
