package com.example.springframework.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <pre>
 *      CustomBeanPostProcessor
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:55  修改内容:
 * </pre>
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {


    public CustomBeanPostProcessor() {
        System.out.println("BeanPostProcessor构造函数被调用");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("springBean".equals(beanName)) {
            System.out.println("postProcessBeforeInitialization方法被调用，对应的beanName是springBean");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("springBean".equals(beanName)) {
            System.out.println("postProcessAfterInitialization，对应的beanName是springBean");
        }
        return bean;
    }
}
