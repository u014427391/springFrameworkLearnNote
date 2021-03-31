package com.example.springframework.service.impl;

import com.example.springframework.dao.AccountDao;
import com.example.springframework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *      AccountServiceImpl
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/03/25 15:55  修改内容:
 * </pre>
 */
@Service
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outer,String inner,int money){
        accountDao.out(outer , money);
        accountDao.in(inner , money);
    }

}
