package com.study.spring.member.dao;

import com.study.spring.member.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long memberId);
}
