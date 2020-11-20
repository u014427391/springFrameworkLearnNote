package com.example.spring.aop;


import com.example.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplication {

    public static void testAopProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring_interfaces_config");
        UserService userService = (UserService) ioc.getBean("userServiceProxy");
    }

    public static void main(String[] args) {

    }
}
