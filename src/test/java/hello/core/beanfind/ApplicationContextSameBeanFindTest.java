package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    //ApplicationContext는 스프링의 컨테이너를 말한다.
    //Spring의 컨테이너로 빈(Bean)의 생성,관리,주입을 담당한다.

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이 있으면, 중복오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows( NoUniqueBeanDefinitionException.class,
                () -> ac.getBean( MemberRepository.class ) ); // 람다 -> Java8

    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이 있으면, 빈 이름을 지정하면된다.")
    void BeanFindByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class );
        assertThat( memberRepository ).isInstanceOf( MemberRepository.class );

    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType( MemberRepository.class );
        for (String key : beansOfType.keySet()) {
            System.out.println( "key = " + key + "value = " + beansOfType.get( key ) );
            assertThat( beansOfType.size() ).isEqualTo( 2 ); // 검증
        }
    }


    @Configuration //Spring이 관리하는데 필요한 구성임을 명시함.
    static class SameBeanConfig {


        //MemoryMemberRepository 타입의 빈을 생성해서 반환한다.
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();

        }

        //MemoryMemberRepository 타입의 빈을 생성해서 반환한다.
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();

        }
    }
}
