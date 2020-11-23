package com.example.spring.aop;


import com.example.spring.aop.bean.User;
import com.example.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplication {

    public static void testAopProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring_interfaces_config.xml");
        UserService userService = (UserService) ioc.getBean("userServiceProxy");
        User userDto = new User();
        userDto.setUsername("tom");
        userDto.setPassword("11");
        userService.addUser(userDto);
        System.out.println(String.format("用户数据打印:%s",userService.getUser().toString()));
    }

    public static void testBeanNameAutoProxy() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring_beanNameAutoProxy_config.xml");
        UserService userService = ioc.getBean(UserService.class);
        User userDto = new User();
        userDto.setUsername("tom");
        userDto.setPassword("11");
        userService.addUser(userDto);
        System.out.println(String.format("用户数据打印:%s",userService.getUser().toString()));
    }

    public static void main(String[] args) {
        // ProxyFactoryBean
        testAopProxy();
        // BeanNameAutoProxyCreator
        //testBeanNameAutoProxy();
    }
}
