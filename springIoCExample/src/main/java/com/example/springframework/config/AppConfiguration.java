package com.example.springframework.config;

import com.example.springframework.bean.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:26  修改内容:
 * </pre>
 */
@Configuration
public class AppConfiguration {

    @Bean
    public A a(){
        return new A();
    }

}
