package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean( "memberService", MemberService.class );
        System.out.println( "memberService = " + memberService );
        System.out.println( "memberService.getClass() = " + memberService.getClass() );

         // memberService가 memberService//Impl에 있으면 성공
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class ); //static
    }
    //이름없이 타입으로만 조회
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class );
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class ); //static

    }

    //구체타입으로 조회를 해도 되지만, 권장하는 방식은 아니다. 이유는? 항상 역할과 구현을 구분하고 역할에 의존해야 하기 때문이다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean( "memberService", MemberServiceImpl.class );
        assertThat( memberService ).isInstanceOf( MemberServiceImpl.class ); //static
    }
}
