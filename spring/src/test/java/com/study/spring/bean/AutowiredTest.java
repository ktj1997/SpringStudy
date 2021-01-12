package com.study.spring.bean;

import com.study.spring.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    private ApplicationContext ac;

    @Test
    void applicationContextTest()
    {
        ac = new AnnotationConfigApplicationContext(AutowiredBean.class);
    }


    static class AutowiredBean {
        /**
         * required 옵션을 false로주면
         * IOC컨테이너가 관리하는 Bean이 아닐 떄, 메소드 자체가 실행되지않는다.
         */
        @Autowired(required = false)
        public void setNoBean(Member member) {
            System.out.println(member);
        }

        /**
         * @Nullable 에노테이션을 넣어주면
         * IOC 컨테이너가 관리하는 Bean이 아닐시에 NULL이 주입된다.
         */
        @Autowired
        public void setNullableBean(@Nullable Member member) {
            System.out.println(member);
        }

        /**
         * Optional 로 인자를 주면,
         * IOC컨테이너가 관리하는 Bean이 아닐시에 Optinal.empty()가 들어간다.
         */
        @Autowired
        public void setOptionalBean(Optional<Member> member){
            System.out.println(member);
        }
    }
}
