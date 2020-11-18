package com.example.springframework.bean;

import org.springframework.beans.factory.InitializingBean;

/**
 * <pre>
 *      SpringBean
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:50  修改内容:
 * </pre>
 */
public class SpringBean implements InitializingBean {

    public SpringBean(){
        System.out.println("SpringBean构造函数");
    }

    @Override
    public  void afterPropertiesSet() throws Exception{
        System.out.println("SpringBean afterPropertiesSet");
    }
}
