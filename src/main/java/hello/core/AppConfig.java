package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl( memberRepository() ); //생성자 주입
        //appConfig객체는 memoryMemberRepository객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl( memberRepository(), discountPolicy()); //생성자 주입

    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
