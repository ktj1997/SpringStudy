package com.study.spring.order.service;

import com.study.spring.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, Long itemId);
    Order findOrder(Long orderId);
}
