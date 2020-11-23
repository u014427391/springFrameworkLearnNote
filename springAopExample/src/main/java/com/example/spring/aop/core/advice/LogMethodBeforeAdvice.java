package com.example.spring.aop.core.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <pre>
 *      LogMethodBeforeAdvice
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/20 17:38  修改内容:
 * </pre>
 */
public class LogMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(String.format("执行方法：%s，参数列表：%s", method.getName(), Arrays.toString(args) ));
    }
}
