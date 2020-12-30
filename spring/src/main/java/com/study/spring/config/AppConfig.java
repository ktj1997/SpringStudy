package com.study.spring.config;

import com.study.spring.discount.DiscountPolicy;
import com.study.spring.discount.FixDiscountPolicy;
import com.study.spring.discount.RateDiscountPolicy;
import com.study.spring.item.dao.ItemRepository;
import com.study.spring.item.dao.MemoryItemRepositoryImpl;
import com.study.spring.item.service.ItemService;
import com.study.spring.item.service.ItemServiceImpl;
import com.study.spring.member.dao.MemberRepository;
import com.study.spring.member.dao.MemoryMemberRepository;
import com.study.spring.member.service.MemberService;
import com.study.spring.member.service.MemberServiceImpl;
import com.study.spring.order.dao.MemoryOrderRepositoryImpl;
import com.study.spring.order.dao.OrderRepository;
import com.study.spring.order.service.OrderService;
import com.study.spring.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public ItemService itemService(){
        return new ItemServiceImpl(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository(){
        return new MemoryItemRepositoryImpl();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),itemRepository(),discountPolicy(),orderRepository());
    }

    @Bean
    public OrderRepository orderRepository()
    {
        return new MemoryOrderRepositoryImpl();
    }
}
