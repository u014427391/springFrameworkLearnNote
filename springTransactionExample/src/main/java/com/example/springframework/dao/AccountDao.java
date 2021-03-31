package com.example.springframework.dao;

public interface AccountDao {

    /**
     *  汇款
     * @Param outer 汇款人
     * @Param money 汇款金额
     */
    void out(String outer,int money);

    /**
     *  收款
     * @Param inner 收款人
     * @Param money 收款人
     */
    void in(String inner,int money);

}
