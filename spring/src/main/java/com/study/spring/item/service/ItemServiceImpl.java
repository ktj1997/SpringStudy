package com.study.spring.item.service;

import com.study.spring.item.Item;
import com.study.spring.item.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{


    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Long itemId) {
        return itemRepository.findById(itemId);
    }
}
