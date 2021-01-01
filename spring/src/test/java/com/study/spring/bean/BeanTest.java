package com.study.spring.bean;

import com.study.spring.config.AnnotationBeanConfig;
import com.study.spring.discount.DiscountPolicy;
import com.study.spring.discount.RateDiscountPolicy;
import com.study.spring.member.service.MemberService;
import com.study.spring.member.service.MemberServiceImpl;
import com.study.spring.order.service.OrderService;
import com.study.spring.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanTest {
    private static ApplicationContext aac = new AnnotationConfigApplicationContext(AnnotationBeanConfig.class);
    private static ApplicationContext xac = new GenericXmlApplicationContext("XmlBeanConfig.xml");

    @Test
    void beanDiTest(){
       String[] names =  aac.getBeanDefinitionNames();
       for(String name : names)
            Assertions.assertThat(aac.getBean(name)).isNotNull();
    }

    @Test
    void findBeanByNameTest()
    {
       Object bean = aac.getBean(OrderService.class);
        Assertions.assertThat(bean).isInstanceOfAny(OrderServiceImpl.class);
    }

    @Test
    @DisplayName("정상적인 Bean 로딩 테스트")
    void findBeanTest()
    {
        MemberService memberService = xac.getBean(MemberService.class);
        DiscountPolicy discountPolicy = xac.getBean(DiscountPolicy.class);

        assertAll(
                () -> assertTrue(memberService instanceof MemberServiceImpl),
                () -> assertTrue(discountPolicy instanceof RateDiscountPolicy)
        );
    }
}
