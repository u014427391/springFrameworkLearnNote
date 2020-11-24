package com.example.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SchemaBasedAspect {

    private ThreadLocal<SimpleDateFormat> simpleDateFormat =new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            //return super.initialValue();
            return new SimpleDateFormat("[yyyy-mm-dd hh:mm:ss:SSS]");
        }
    };

    public void beforeAdvice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(String.format("前置通知：beforeAdvice，参数是：%s", Arrays.toString(args)));
        System.out.println(simpleDateFormat.get().format(new Date()) + methodName);
    }

    public void afterReturningAdvice(Object returnVal){
        System.out.println(String.format("后置通知：afterReturningAdvice，返回参数是：%s", returnVal));
    }

    public void afterThrowingAdvice(Throwable e) {
        System.out.println(String.format("异常通知：afterThrowingAdvice，异常信息：%s", e));
    }

    public void afterAdvice() {
        System.out.println(String.format("最后通知：afterAdvice"));
    }

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object rtValue = null;
        try {
            System.out.println("aroundAdvice前置通知!");
            // 获取参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 执行切入点方法
            rtValue = proceedingJoinPoint.proceed(args);

            System.out.println("aroundAdvice后置通知!");
        } catch (Throwable e) {
            System.out.println("aroundAdvice异常通知!");
            e.printStackTrace();
        } finally {
            System.out.println("aroundAdvice最后通知!");
        }
        return rtValue;
    }
}