package hello.core.member;
import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //test 실행 전 무조건 실행이 된다.
    public void beforeEach() {
        AppConfig appConfig = new AppConfig(); // 만들고
        memberService = appConfig.memberService(); // 할당하고
    }

    @Test
    void join() {

        //given ~ 이런이런 환경이 주어지고
        Member member = new Member( 1L, "MemberA", Grade.VIP );


        //when ~ 이렇게 되었을 때
        memberService.join( member );
        Member findMember = memberService.findMember( 1L );


        //then ~ 이렇게 된다. then에서는 검증의 역할을 한다.
        Assertions.assertThat( member ).isEqualTo( findMember ); // 조인한 것이랑, 찾은 거랑 똑같은지 검증


    }
}