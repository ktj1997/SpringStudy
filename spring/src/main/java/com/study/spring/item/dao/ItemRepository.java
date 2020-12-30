package com.study.spring.item.dao;

import com.study.spring.item.Item;

public interface ItemRepository {
    Item save(Item item);
    Item findById(Long itemId);
}
