package com.study.spring.bean;

import com.study.spring.config.AnnotationBeanConfig;
import com.study.spring.member.dao.MemberRepository;
import com.study.spring.member.service.MemberServiceImpl;
import com.study.spring.order.service.OrderService;
import com.study.spring.order.service.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;
public class SingletonBeanTest {

    private static ApplicationContext aac = new AnnotationConfigApplicationContext(AnnotationBeanConfig.class);

    @Test
    @DisplayName("스프링 컨테이너 싱글톤 확인")
    void checkSpringContainerSingleton()
    {
        OrderService orderService1 = aac.getBean(OrderService.class);
        OrderService orderService2 = aac.getBean(OrderService.class);

        assertTrue(orderService1 == orderService2);
        assertEquals(orderService1,orderService2);

    }

    @Test
    @DisplayName("순수 DI 컨테이너 확인")
    void checkPureDiContainerSingleton()
    {
        AnnotationBeanConfig pac = new AnnotationBeanConfig();
        OrderService orderService1 = pac.orderService();
        OrderService orderService2 = pac.orderService();

        assertNotEquals(orderService1,orderService2);
        assertFalse(orderService1.equals(orderService2));
    }

    @Test
    @DisplayName("싱글톤패턴 테스트")
    void checkSingleton()
    {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        assertEquals(singleton1,singleton2);
        assertTrue(singleton1.equals(singleton2));
    }

    @Test
    @DisplayName("@Configuration 확인")
    void checkConfigurationAnnotation()
    {
        OrderServiceImpl orderService = aac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = aac.getBean(MemberRepository.class);
        MemberServiceImpl memberService = aac.getBean(MemberServiceImpl.class);
        Class annotationBeanConfig = AnnotationBeanConfig.class;
        Annotation annotation = annotationBeanConfig.getAnnotation(Configuration.class);

        if(annotation != null)
            assertAll(
                    () -> assertTrue(memberRepository == memberService.getMemberRepository()),
                    () -> assertTrue(memberRepository == orderService.getMemberRepository()),
                    () -> assertTrue(memberService.getMemberRepository() == orderService.getMemberRepository())
            );
        else
            assertAll(
                    () -> assertFalse(memberRepository == memberService.getMemberRepository()),
                    () -> assertFalse(memberRepository == orderService.getMemberRepository()),
                    () -> assertFalse(memberService.getMemberRepository() == orderService.getMemberRepository())
            );
    }
}
class Singleton{
    private static Singleton instance = new Singleton();

    //생성자 제한
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
