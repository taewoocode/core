package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextSameBeanFindTest {

    //ApplicationContext는 스프링의 컨테이너를 말한다.
    //Spring의 컨테이너로 빈(Bean)의 생성,관리,주입을 담당한다.

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이 있으면, 중복오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        ac.getBean( DiscountPolicy.class )
    }

}
