package com.example.springframework.config;

import com.example.springframework.bean.A;
import com.example.springframework.bean.B;
import com.example.springframework.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * <pre>
 *      AppConfiguration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:26  修改内容:
 * </pre>
 */
@Configuration
public class AppConfiguration {

    @Bean
    //@Scope("prototype")
    public A a(){
        return new A();
    }

    @Bean
    @Scope("prototype")
    public B b() {
        return new B();
    }

    @Bean
    @Lazy(value = false)
    public SpringBean springBean() {
        return new SpringBean();
    }

    @Bean
    public CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public CustomBeanPostProcessor customBeanPostProcessor(){
        return new CustomBeanPostProcessor();
    }

}
