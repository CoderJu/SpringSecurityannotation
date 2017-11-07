package com.eleven.config.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by User on 2017/11/2.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.eleven.*"})
@Import({SecurityConfig.class})
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/page/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}

/*
spring-mvc.xml
<context:component-scan base-package="com.yiibai.web.*" />

<bean
class="org.springframework.web.servlet.view.InternalResourceViewResolver">
<property name="prefix">
<value>/WEB-INF/pages/</value>
</property>
<property name="suffix">
<value>.jsp</value>
</property>
</bean>
*/
