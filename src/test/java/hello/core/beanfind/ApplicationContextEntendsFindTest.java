package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextEntendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상이 있으면 중복오류가 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows( NoUniqueBeanDefinitionException.class,
                () -> ac.getBean( DiscountPolicy.class ) );
    }

    @Test
    @DisplayName( "부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정해준다." )
    void findBeanByParentTypeBeanName() {
        //타입은 DiscountPolicy지만 실제 구현객체는 rateDiscountPolicy가 나온다.
        DiscountPolicy rateDiscountPolicy = ac.getBean( "rateDiscountPolicy", DiscountPolicy.class );
        assertThat( rateDiscountPolicy ).isInstanceOf( RateDiscountPolicy.class );
    }

    @Test
    @DisplayName("부모타입으로 전부다 조회")
    void findByAllBeanByParent() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType( DiscountPolicy.class );
        assertThat(beansOfType.size() ).isEqualTo( 2 ); // 사이즈가 2개면 성공
        for (String key : beansOfType.keySet()) {
            System.out.println( "key = " + key + "value = " + beansOfType.get( key ) );
        }
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBySubType() {
        RateDiscountPolicy bean = ac.getBean( RateDiscountPolicy.class );
        assertThat( bean ).isInstanceOf( RateDiscountPolicy.class );
    }

    @Test
    @DisplayName("부모타입으로 모두 조회하기 - object")
    void findAllBeanOfType() {
        Map<String, Object> beansOfType = ac.getBeansOfType( Object.class );
        for (String key : beansOfType.keySet()) {
            System.out.println( "key = " + key + "value = " + beansOfType.get( key ) );

        }
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
