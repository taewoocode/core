package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig(); // 만들고
        memberService = appConfig.memberService();// 할당하고
     //   orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member( memberId, "memberA", Grade.VIP );
        memberService.join( member );

        Order order = orderService.createOrder( memberId, "itemA", 1000 );
        Assertions.assertThat( order.getDiscountPrice()).isEqualTo( 1000);

    }
}
