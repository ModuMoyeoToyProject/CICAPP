package pojo.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.practice.member.Grade;
import pojo.practice.member.Member;
import pojo.practice.member.service.MemberService;
import pojo.practice.member.service.MemberServiceImpl;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();


    @Test
    void join(){
        //given
        Member member = new Member(1L, "Ihyeon", Grade.MASTER);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
