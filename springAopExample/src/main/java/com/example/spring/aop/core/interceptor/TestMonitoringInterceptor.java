package com.example.spring.aop.core.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

/**
 * <pre>
 *      TestMonitoringInterceptor
 *      Copy form @https://www.baeldung.com/spring-performance-logging
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/23 16:39  修改内容:
 * </pre>
 */
public class TestMonitoringInterceptor extends AbstractMonitoringInterceptor {

    public TestMonitoringInterceptor(){}

    public TestMonitoringInterceptor (boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation methodInvocation, Log log) throws Throwable {
        String name = createInvocationTraceName(methodInvocation);
        long start = System.currentTimeMillis();
        try {
            return methodInvocation.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info(String.format("方法名：%s，执行时间：%s ms",name,time));
            if (time > 10) {
                log.warn(String.format("方法名：%s，执行时间超过10 ms! ",name));
            }
        }
    }
}
