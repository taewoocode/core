package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        Member member = new Member( 1L, "memberA", Grade.VIP );// 조인, cmd + opt + v
//        memberService.join( member ); // join

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean( "memberService", MemberService.class ); // memberService 객체 조회, 타입

        Member member = new Member( 1L, "memberA", Grade.VIP );
        memberService.join(member);

        Member findMember = memberService.findMember( 1L );
        System.out.println( "member = " + member.getName() ); // new member
        System.out.println( "findMember = " + findMember.getName() ); // soutv
    }
}
