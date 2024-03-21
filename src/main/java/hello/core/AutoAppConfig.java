package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

//ComponentScan으로 bean을 다 자동등록해주는데 뺄 것을 지정해준다.
@ComponentScan(
        basePackages = "hello.core.member", //member만 ComponentScan의 대상이된다.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
