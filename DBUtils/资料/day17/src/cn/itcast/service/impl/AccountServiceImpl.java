package cn.itcast.service.impl;

import cn.itcast.dao.impl.AccountDaoImpl;
import cn.itcast.domain.Account;
import cn.itcast.util.TransactionUtil;

public class AccountServiceImpl {
	private AccountDaoImpl dao = new AccountDaoImpl();
	public void transfer(String sourceAccountName,String targetAccountName,float money){
		try{
			TransactionUtil.startTransaction();
			Account sAccount = dao.findAccount(sourceAccountName);
			Account tAccount = dao.findAccount(targetAccountName);
			sAccount.setMoney(sAccount.getMoney()-money);
			tAccount.setMoney(tAccount.getMoney()+money);
			dao.updateAccount(sAccount);
			int i=1/0;
			dao.updateAccount(tAccount);
		}catch(Exception e){
			TransactionUtil.rollback();
			e.printStackTrace();
		}finally{
			TransactionUtil.commit();
			TransactionUtil.relase();
		}
	}
}
