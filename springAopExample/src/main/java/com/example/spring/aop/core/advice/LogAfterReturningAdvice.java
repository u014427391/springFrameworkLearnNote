package com.example.spring.aop.core.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * <pre>
 *      LogAfterReturningAdvice
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/20 17:41  修改内容:
 * </pre>
 */
public class LogAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(String.format("方法返回：%s", returnValue ));
    }
}
