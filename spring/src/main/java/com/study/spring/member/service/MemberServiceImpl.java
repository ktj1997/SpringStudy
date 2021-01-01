package com.study.spring.member.service;

import com.study.spring.member.Member;
import com.study.spring.member.dao.MemberRepository;
public class MemberServiceImpl implements MemberService{
    //SingletonTest 를 위한 Getter
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
