package com.example.spring.aop.config;

import com.example.spring.aop.core.interceptor.TestMonitoringInterceptor;
import com.example.spring.aop.service.UserService;
import com.example.spring.aop.service.impl.UserServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <pre>
 *      AOP配置类
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本: V1.0.0    修改人：mazq  修改日期: 2020/11/23 14:30  修改内容: 新增配置类
 * </pre>
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Pointcut("within(com.example.spring.aop..*) && execution(public String com.example.spring.aop.service.UserService.findUserNameById(Long, ..))")
    public void monitor(){ }

    @Bean
    public TestMonitoringInterceptor monitoringInterceptor() {
        return new TestMonitoringInterceptor(true);
    }

    @Bean
    public Advisor monitoringAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.example.spring.aop.config.AopConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, monitoringInterceptor());
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

}
