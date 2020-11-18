package com.example.springframework.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *      B class
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/16 14:03  修改内容:
 * </pre>
 */
@Component
public class B {

    @Autowired
    A a;

    public B() {
        //a = new A();
        System.out.println("B class is create");
    }
}
