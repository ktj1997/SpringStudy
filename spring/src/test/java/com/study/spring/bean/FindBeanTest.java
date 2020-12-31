package com.study.spring.bean;

import com.study.spring.discount.DiscountPolicy;
import com.study.spring.discount.FixDiscountPolicy;
import com.study.spring.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FindBeanTest {

    private static ApplicationContext ac = new AnnotationConfigApplicationContext(BeanTestConfig.class);


    @Test
    @DisplayName("동일한 타입의 빈이 여러개 있을 때 오류발생")
    void sameTypeBeanErrorTest()
    {
        assertThrows(NoUniqueBeanDefinitionException.class,() -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("동일한 타입의 빈 여러개 꺼내오기")
    void getSameTypeBeansTest()
    {
        Map<String,DiscountPolicy> map  = ac.getBeansOfType(DiscountPolicy.class);

        for(String key :map.keySet())
            assertTrue(map.get(key) instanceof DiscountPolicy);
        assertSame(2,map.size());
    }

    @Test
    @DisplayName("상속에 따른 빈 여러개 꺼내오기")
    void getBeansFromParentTypeTest()
    {
        //모든 Java객체는 Object를 상속
        Map<String,Object> map =ac.getBeansOfType(Object.class);

        //부모객체 타입으로 꺼내오면, 부모를 상속하는 자식 Bean들도 다 딸려온다.
        for(String key:map.keySet()){
            Assertions.assertTrue(map.get(key) instanceof Object);
        }
    }


    @Configuration
    static class BeanTestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy()
        {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy()
        {
            return new FixDiscountPolicy();
        }

    }
}
