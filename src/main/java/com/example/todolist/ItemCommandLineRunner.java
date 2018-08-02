package com.example.todolist;

import com.example.todolist.model.Item;
import com.example.todolist.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ItemCommandLineRunner implements CommandLineRunner {

    private final ItemRepository itemRepository;
    public ItemCommandLineRunner(ItemRepository itemRepository)
    {
        this.itemRepository=itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.save(new Item(new Long(1),"Washing hands","Clean yourself",false,"2018.08.08"));

    }
}
