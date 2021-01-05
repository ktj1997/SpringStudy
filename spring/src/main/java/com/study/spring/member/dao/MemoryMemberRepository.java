package com.study.spring.member.dao;

import com.study.spring.member.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository  implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        return store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
