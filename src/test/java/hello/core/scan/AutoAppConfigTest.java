package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AutoAppConfig.class );

        //1.조회
        MemberService memberService = ac.getBean( MemberService.class );
        //2.검증
        assertThat( memberService ).isInstanceOf( MemberService.class );
    }
}
