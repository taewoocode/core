package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); //appconfig에서 멤버서비스를 요청하면 인터페이스를 제공해준다.
        Member member = new Member( 1L, "memberA", Grade.VIP );// 조인, cmd + opt + v
        memberService.join( member ); // join

        Member findMember = memberService.findMember( 1L );
        System.out.println( "member = " + member.getName() ); // new member
        System.out.println( "findMember = " + findMember.getName() ); // soutv
    }
}
