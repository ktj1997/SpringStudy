package com.study.spring.item.dao;

import com.study.spring.item.Item;

import java.util.HashMap;
import java.util.Map;

public class MemoryItemRepositoryImpl implements ItemRepository{

    private static Map<Long,Item> store = new HashMap<>();

    @Override
    public Item save(Item item) {
       return store.put(item.getId(),item);
    }

    @Override
    public Item findById(Long itemId) {
        return store.get(itemId);
    }
}
