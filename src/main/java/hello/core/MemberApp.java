package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member( 1L, "memberA", Grade.VIP );// 조인, cmd + opt + v
        memberService.join( member ); // join

        Member findMember = memberService.findMember( 1L );
        System.out.println( "member = " + member.getName() ); // new member
        System.out.println( "findMember = " + findMember.getName() ); // soutv
    }
}
