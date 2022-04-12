package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import com.spring.util.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            List<Account> ac = accountDao.findAllAccount();
            // 3、提交事务
            txManager.commit();
            // 4、返回结果
            return ac;
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally{
            // 6、释放连接
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            Account ac = accountDao.findAccountById(accountId);
            // 3、提交事务
            txManager.commit();
            // 4、返回结果
            return ac;
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally{
            // 6、释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.saveAccount(account);
            // 3、提交事务
            txManager.commit();
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
        }finally{
            // 6、释放连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.updateAccount(account);
            // 3、提交事务
            txManager.commit();
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
        }finally{
            // 6、释放连接
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.deleteAccount(accountId);
            // 3、提交事务
            txManager.commit();
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
        }finally{
            // 6、释放连接
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, float money) {
        try{
            // 1、开启事务
            txManager.beginTransaction();
            // 2、执行操作
            //1、根据名称查找转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2、根据名称查找转入账户
            Account target = accountDao.findAccountByName(targetName);
            //3、转出账户少钱
            source.setMoney(source.getMoney() - money);
            //4、转入账户加钱
            target.setMoney(target.getMoney() + money);
            //5、更新转出账户
            accountDao.updateAccount(source);
            //6、更新转出账户
            accountDao.updateAccount(target);
            // 3、提交事务
            txManager.commit();
        }catch(Exception e){
            // 5、回滚事务
            txManager.rollback();
            e.printStackTrace();
        }finally{
            // 6、释放连接
            txManager.release();
        }
    }
}
