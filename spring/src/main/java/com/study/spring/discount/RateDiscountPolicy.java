package com.study.spring.discount;

import com.study.spring.member.Grade;
import com.study.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountRate/100;
        else
            return 0;
    }
}
