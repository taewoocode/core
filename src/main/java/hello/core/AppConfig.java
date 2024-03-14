package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    Appconfig에서 모든 역할들을 담아냈다.
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl( memberRepository() ); //생성자 주입
        //appConfig객체는 memoryMemberRepository객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
    }
    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
