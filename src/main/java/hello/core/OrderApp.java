package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member( memberId, "memberA", Grade.VIP ); //vip 회원 만들기
        memberService.join( member ); // DB에 넣어두기 -> 그래야 주문해서 찾아서 쓸 수 있다.

        Order order = orderService.createOrder( memberId, "itemA", 10000 );

        System.out.println( "order = " + order.toString() );

    }
}
