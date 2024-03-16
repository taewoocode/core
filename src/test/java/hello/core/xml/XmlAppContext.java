package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    //GenericXmlApplicationContext한테 Appconfig.xml을 넘긴다.
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext( "appConfig.xml" );

        //빈 조회
        MemberService memberService = ac.getBean( "memberService", MemberService.class );
        assertThat( memberService ).isInstanceOf( MemberService.class );
    }

    // 자바코드가 아닌 것은 다 resources에 두면 된다.
}
