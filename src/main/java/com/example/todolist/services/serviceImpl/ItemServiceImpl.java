package com.example.todolist.services.serviceImpl;

import com.example.todolist.helpers.Response;
import com.example.todolist.model.Item;
import com.example.todolist.repository.ItemListRepository;
import com.example.todolist.repository.ItemRepository;
import com.example.todolist.services.serviceInterfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemListRepository itemListRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ResponseEntity<?> getItem(Long itemId) {

        if (!itemRepository.findById(itemId).isPresent()) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrorCode(401);
            response.setMessage("Todo item not found.");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Item item = itemRepository.findById(itemId).get();

            return new ResponseEntity<>(item, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> getAllItemFromList(Long listId) {

        if (!itemListRepository.findById(listId).isPresent()) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrorCode(401);
            response.setMessage("Todo list not found.");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            List<Item> itemList = itemRepository.findAllByListId(listId);

            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> addItem(Long listId, String title, String description, String deadline) {

        Item item = new Item();
        item.setListId(listId);
        item.setTitle(title);
        item.setDescription(description);
        item.setDeadline(deadline);

        itemRepository.save(item);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteItem(Long itemId) {

        if (!itemRepository.findById(itemId).isPresent()) {
            Response response = new Response();
            response.setSuccess(false);
            response.setErrorCode(401);
            response.setMessage("Todo item not found.");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            itemRepository.deleteById(itemId);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
