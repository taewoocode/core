package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext( TestConfig.class );
        StateFulService stateFulService1 = ac.getBean( StateFulService.class ); //꺼내서 Service1에 할당
        StateFulService stateFulService2 = ac.getBean( StateFulService.class ); //꺼내서 Service2에 할당

        //지역변수이기 때문에 사용자 A와 사용자 B의 값이 다르다.
        //Thread A사용자 10000원 주문
        int userAPrice = stateFulService1.order( "userA", 10000 );
        //Thread B사용자 20000원 주문
        int userBPrice = stateFulService1.order( "userB", 20000 );

        //ThreadA: 사용자A 주문 금액 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userAPrice);
        System.out.println("price = " + userBPrice);

//        org.assertj.core.api.Assertions.assertThat( stateFulService1.getPrice() ).isEqualTo( 20000 );
    }

    static class TestConfig {

        @Bean
        public StateFulService stateFulService() {
            return new StateFulService();
        }
    }
}