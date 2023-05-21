package pojo.practice.member.repository;

import pojo.practice.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
