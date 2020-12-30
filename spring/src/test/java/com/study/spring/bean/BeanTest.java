package com.study.spring.bean;

import com.study.spring.config.AppConfig;
import com.study.spring.order.service.OrderService;
import com.study.spring.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    private static ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void beanDiTest(){
       String[] names =  ac.getBeanDefinitionNames();
       for(String name : names)
            Assertions.assertThat(ac.getBean(name)).isNotNull();
    }

    @Test
    void findBeanByNameTest()
    {
       Object bean = ac.getBean(OrderService.class);
        Assertions.assertThat(bean).isInstanceOfAny(OrderServiceImpl.class);
    }
}
