package com.example.todolist;

import com.example.todolist.model.ItemList;
import com.example.todolist.repository.ItemListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodolistCommandLineRunner implements CommandLineRunner {

    private final ItemListRepository itemListRepository;
    public TodolistCommandLineRunner(ItemListRepository itemListRepository)
    {
        this.itemListRepository=itemListRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemListRepository.save(new ItemList("Daily"));
        itemListRepository.save(new ItemList("Monthly"));
        itemListRepository.save(new ItemList("Yearly"));
        itemListRepository.save(new ItemList("Uncategorized"));
    }
}
