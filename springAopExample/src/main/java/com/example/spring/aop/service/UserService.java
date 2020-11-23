package com.example.spring.aop.service;

import com.example.spring.aop.bean.User;

/**
 * <pre>
 *      UserService
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/20 18:02  修改内容:
 * </pre>
 */
public interface UserService {

    User addUser(User user);

    User getUser();

    String findUserNameById(Long id);
}
