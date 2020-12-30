package com.study.spring.member.service;

import com.study.spring.member.Member;

public interface MemberService {
    void save(Member member);
    Member findMember(Long memberId);

}
