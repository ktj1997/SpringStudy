package com.study.spring.order.dao;

import com.study.spring.order.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryOrderRepositoryImpl implements OrderRepository {
    private static Map<Long, Order> store = new HashMap<>();
    private static Long auto_increment = 1L;


    @Override
    public Order save(Order order) {
        order.setId(auto_increment++);
        return store.put(auto_increment, order);
    }

    @Override
    public Order findById(Long orderId) {
        return store.get(orderId);
    }
}
