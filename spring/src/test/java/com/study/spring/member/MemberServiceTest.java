package com.study.spring.member;

import com.study.spring.config.AnnotationBeanConfig;
import com.study.spring.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
    private static ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationBeanConfig.class);
    private MemberService memberService = ac.getBean(MemberService.class);

    @Test
    void saveAndFindTest()
    {
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.save(member);
        Assertions.assertThat(member).isEqualTo(memberService.findMember(1L));
    }

}
