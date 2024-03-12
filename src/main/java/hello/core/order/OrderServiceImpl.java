package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy; // 이렇게 코드를 변
   // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
   // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByid( memberId ); // memberRepository에서 id 찾음
        int discountPrice = discountPolicy.discount( member, itemPrice ); // cmd + opt + v discountpolicy에서 member와 item찾음

        return new Order( memberId, itemName, itemPrice, discountPrice ); // 괄호안에 있는 것들 반환
    }

    /*
    주문 요청이 오면 회원정보를 먼저 조회를 하고, 할인 정책에다가 회원정보를 넘긴다. 그리고 최종 생성된 주문을 반환해준다.
     */
}