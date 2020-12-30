package com.study.spring.item.service;

import com.study.spring.item.Item;

public interface ItemService {

    Item save(Item item);

    Item findById(Long itemId);
}
