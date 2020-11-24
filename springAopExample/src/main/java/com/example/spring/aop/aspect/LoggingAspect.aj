package com.example.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * <pre>
 *      LoggingAspect
 * </pre>
 * <pre> Spring5.0.x版本可以支持aspect类型的类，
 *       eg：public aspect LoggingAspect 可以不用 @Aspect
 * </pre>
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/23 15:54  修改内容:
 * </pre>
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    private ThreadLocal<SimpleDateFormat> simpleDateFormat =new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            //return super.initialValue();
            return new SimpleDateFormat("[yyyy-mm-dd hh:mm:ss:SSS]");
        }
    };

    //---------------------------------------------------------------------
    // Types of pointcut
    //---------------------------------------------------------------------

    @Pointcut("within(com.example.spring.aop..*) && execution(public String com.example.spring.aop.service.UserService.*(..))")
    public void regexpExecution(){}

    @Pointcut("within(com.example.spring.aop..*) && execution(* *..find*(Long,..))")
    public void regexpExecutionByMethodName(){}

    @Pointcut("within(com.example.spring.aop..*) && target(com.example.spring.aop.service.UserService)")
    public void targetInterface(){}

    @Pointcut("within(com.example.spring.aop..*) &&@args(com.example.spring.aop.annotation.Entity)")
    public void argsMethod(){}

    @Pointcut("within(com.example.spring.aop..*) &&@args(com.example.spring.aop.annotation.EnableLog)")
    public void annotationMethod(){}

    //---------------------------------------------------------------------
    // Types of advice
    //---------------------------------------------------------------------

    @Before(value = "regexpExecution()")
    public void beforeAdvice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(String.format("前置通知：beforeAdvice，参数是：%s", Arrays.toString(args)));
        System.out.println(simpleDateFormat.get().format(new Date()) + methodName);
    }

    @AfterReturning(value = "regexpExecution()", returning = "returnVal")
    public void afterReturningAdvice(Object returnVal){
        System.out.println(String.format("后置通知：afterReturningAdvice，返回参数是：%s", returnVal));
    }

    @AfterThrowing(value = "regexpExecution()", throwing = "e")
    public void afterThrowingAdvice(Throwable e) {
        System.out.println(String.format("异常通知：afterThrowingAdvice，异常信息：%s", e));
    }

    @After(value = "regexpExecution()")
    public void afterAdvice() {
        System.out.println(String.format("最后通知：afterAdvice"));
    }

    @Around(value = "regexpExecution()")
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
