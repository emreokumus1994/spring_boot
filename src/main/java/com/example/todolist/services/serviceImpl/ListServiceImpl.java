package com.example.todolist.services.serviceImpl;
import com.example.todolist.helpers.Response;
import com.example.todolist.model.ItemList;
import com.example.todolist.repository.ItemListRepository;
import com.example.todolist.services.serviceInterfaces.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ItemListRepository itemListRepository;

    @Override
    public ResponseEntity<?> getTodoList() {

        List<ItemList> itemLists = itemListRepository.findAll();

        return new ResponseEntity<>(itemLists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> newTodoList(String title) {

        ItemList itemList = new ItemList(title);

        itemListRepository.save(itemList);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteTodoList(Long id) {

        boolean itemList = itemListRepository.findById(id).isPresent();
        if (!itemList) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrorCode(401);
            response.setMessage("List not found.");

            return new ResponseEntity<>(response ,HttpStatus.NOT_FOUND);
        } else {

            itemListRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
