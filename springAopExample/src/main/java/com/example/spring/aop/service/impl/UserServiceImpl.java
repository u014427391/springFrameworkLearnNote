package com.example.spring.aop.service.impl;

import com.example.spring.aop.bean.User;
import com.example.spring.aop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/20 17:57  修改内容:
 * </pre>
 */
@Service
public class UserServiceImpl implements UserService {

    private static User user = null;

    @Override
    public User addUser(User userDto) {
        user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }

    @Override
    public User getUser() {
        return user;
    }
}
