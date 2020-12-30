package com.study.spring.item.service;

import com.study.spring.item.Item;
import com.study.spring.item.dao.ItemRepository;

public class ItemServiceImpl implements ItemService{


    private final ItemRepository itemRepository;

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
