package pojo.practice.member.service;

import pojo.practice.member.Member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);


}
