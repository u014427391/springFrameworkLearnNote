package com.example.springframework.service.impl;

import com.example.springframework.dao.AccountDao;
import com.example.springframework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
public class AccountServiceImpl extends JdbcDaoSupport implements AccountService {

    AccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED , isolation = Isolation.DEFAULT)
    public void transfer(final String outer,final String inner,final int money){
        accountDao.out(outer , money);
        // exception
        int i = 1 / 0;
        accountDao.in(inner , money);
    }

    /*@Override
    public void transfer(final String outer,final String inner,final int money){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.out(outer , money);
                // exception
                int i = 1 / 0;
                accountDao.in(inner , money);
            }
        });
    }*/

    @Override
    public void transferTrans(String outer, String inner, int money) {
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager();
        // 设置数据源
        dataSourceTransactionManager.setDataSource(super.getJdbcTemplate().getDataSource());
        DefaultTransactionDefinition transDef = new DefaultTransactionDefinition();
        // 设置传播行为属性
        transDef.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = dataSourceTransactionManager.getTransaction(transDef);
        try {
            accountDao.out(outer , money);
            // exception
            //int i = 1 / 0;
            accountDao.in(inner , money);
            //commit
            dataSourceTransactionManager.commit(status);
        } catch (Exception e) {
            // rollback
            dataSourceTransactionManager.rollback(status);
        }
    }


}
