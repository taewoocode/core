package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext( AppConfig.class );

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈 정의된 이름 꺼내기
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean( beanDefinitionName );
            System.out.println( "bean = " + beanDefinitionName + "obeject" + bean );
        }


    }
}
