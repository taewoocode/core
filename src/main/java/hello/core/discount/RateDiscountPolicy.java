package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) { // cmd + shift + t 테스트 코드 만들기
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100; // %이기 때문에 100을 나눠준다.
        } else {
            return 0;
        }
    }
}
