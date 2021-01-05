package com.study.spring.bean;

import com.study.spring.config.AutoAnnotationBeanConfig;
import com.study.spring.member.dao.MemberRepository;
import com.study.spring.member.service.MemberService;
import com.study.spring.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAnnotationBeanTest {
    private final ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAnnotationBeanConfig.class);

    @Test
    @DisplayName("ComponentScan을 통한 Bean 자동등록 테스트")
    void checkBean(){
        MemberService memberService = ac.getBean(MemberService.class);
        Class memberServiceClass = memberService.getClass();
        String className = memberServiceClass.getName();

        Assertions.assertNotNull(memberService);
        Assertions.assertEquals(
                "com.study.spring.member.service.MemberServiceImpl"
                ,className);
    }

    @Test
    @DisplayName("Component Scan + Autowired를 통한 Singleton 확인")
    void checkSingleton()
    {
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        MemberServiceImpl memberServiceImpl = ac.getBean(MemberServiceImpl.class);

        Assertions.assertEquals(memberServiceImpl.getMemberRepository(),memberRepository);
    }
}
