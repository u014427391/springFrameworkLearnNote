package com.example.spring.aop.core.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <pre>
 *      TestMethodInterceptor
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/23 10:28  修改内容:
 * </pre>
 */
public class TestMethodInterceptor  implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(String.format("方法调用前（before method invoke） ：%s",methodInvocation));
        Object implObj = methodInvocation.proceed();
        System.out.println(String.format("方法调用后（after method invoke） ：%s",implObj));
        return implObj;
    }
}
