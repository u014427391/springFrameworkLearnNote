package com.example.springframework.service;

/**
 * <pre>
 *      AccountService
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/03/25 16:00  修改内容:
 * </pre>
 */
public interface AccountService {

    void transfer(String outer,String inner,int money);

}
