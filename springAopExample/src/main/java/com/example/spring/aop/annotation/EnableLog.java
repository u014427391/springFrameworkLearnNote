package com.example.spring.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 *      EnableLog
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/23 18:27  修改内容:
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
// 作用于方法
@Target(ElementType.METHOD)
public @interface EnableLog {
}
