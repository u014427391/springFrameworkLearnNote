package com.example.springframework.dao.impl;

import com.example.springframework.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * <pre>
 *      AccountDaoImpl
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/03/25 15:51  修改内容:
 * </pre>
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void out(String outer, int money) {
        super.getJdbcTemplate().update("update account set money = money - ? where usercode=?",money,outer);
    }

    @Override
    public void in(String inner, int money) {
        super.getJdbcTemplate().update("update account set money = money + ? where usercode = ?",money , inner);
    }
}
