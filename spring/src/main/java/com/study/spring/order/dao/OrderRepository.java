package com.study.spring.order.dao;

import com.study.spring.order.Order;

public interface OrderRepository {
    Order save(Order order);
    Order findById(Long orderId);
}
