package pojo.practice.member;

import pojo.practice.member.service.MemberService;
import pojo.practice.member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "Ihyeon", Grade.MASTER);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        if (findMember.getName().equals(member.getName())){
            System.out.println("goodJob!");
        }
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());


    }
}
