package com.study.spring.bean;

import com.study.spring.discount.DiscountPolicy;
import com.study.spring.discount.RateDiscountPolicy;
import com.study.spring.member.service.MemberService;
import com.study.spring.member.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

public class XmlBeanTest {

    private static ApplicationContext ac = new GenericXmlApplicationContext("XmlBeanConfig.xml");

    @Test
    @DisplayName("정상적인 Bean 로딩 테스트")
    void findBeanTest()
    {
        MemberService memberService = ac.getBean(MemberService.class);
        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);

        assertAll(
                () -> assertTrue(memberService instanceof  MemberServiceImpl),
                () -> assertTrue(discountPolicy instanceof  RateDiscountPolicy)
        );
    }

}
