package com.study.spring.order.service;

import com.study.spring.discount.DiscountPolicy;
import com.study.spring.item.Item;
import com.study.spring.item.dao.ItemRepository;
import com.study.spring.member.Member;
import com.study.spring.member.dao.MemberRepository;
import com.study.spring.order.Order;
import com.study.spring.order.dao.OrderRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final DiscountPolicy discountPolicy;
    private final OrderRepository orderRepository;

    //SpringContainer의 Singleton 확인을 위한 Getter
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, Long itemId) {
        Member member = memberRepository.findById(memberId);
        Item item = itemRepository.findById(itemId);

        int discountPrice = discountPolicy.discount(member,item.getPrice());
        int totalPrice = item.getPrice() - discountPrice;
        Order order = new Order(member.getId(),item.getId(),totalPrice);

        return orderRepository.save(order);
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public OrderServiceImpl(MemberRepository memberRepository, ItemRepository itemRepository, DiscountPolicy discountPolicy, OrderRepository orderRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.discountPolicy = discountPolicy;
        this.orderRepository = orderRepository;
    }
}
