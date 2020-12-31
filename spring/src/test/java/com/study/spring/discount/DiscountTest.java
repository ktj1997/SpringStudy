package com.study.spring.discount;

import com.study.spring.config.AnnotationBeanConfig;
import com.study.spring.member.Grade;
import com.study.spring.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiscountTest {
    private static ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationBeanConfig.class);
    private final DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);

    @Test
    @DisplayName("VIP회원 10%할인 확인")
    void checkDiscountPolicy()
    {
        int price = 50000;
        Member member = new Member(1L,"memberA", Grade.VIP);
        Assertions.assertEquals(discountPolicy.discount(member,price),price * 10/100);
    }
}
