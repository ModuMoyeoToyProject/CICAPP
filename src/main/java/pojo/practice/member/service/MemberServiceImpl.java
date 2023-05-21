package pojo.practice.member.service;

import pojo.practice.member.Member;
import pojo.practice.member.repository.MemberRepository;
import pojo.practice.member.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemberRepositoryImpl();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
