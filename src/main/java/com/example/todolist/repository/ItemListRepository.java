package com.example.todolist.repository;

import com.example.todolist.model.ItemList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemListRepository extends CrudRepository<ItemList, Long> {

    List<ItemList> findAll();
}
