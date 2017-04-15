package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.Account;
import cn.itcast.util.TransactionUtil;
//DAO层不能牵扯任何的业务逻辑
public class AccountDaoImpl {
//	private Connection conn;
//	public AccountDaoImpl(Connection conn){
//		this.conn = conn;
//	}
	private QueryRunner qr = new QueryRunner();
//	public void transfer(String sourceAccountName,String targetAccountName,float money){
//		Connection conn = null;
//		try{
//			conn = DBCPUtil.getConnection();
//			conn.setAutoCommit(false);
//			qr.update(conn,"update account set money=money-? where name=?", money,sourceAccountName);
////			int i = 1/0;
//			qr.update(conn,"update account set money=money+? where name=?", money,targetAccountName);
//		}catch(Exception e){
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			throw new RuntimeException(e);
//		}finally{
//			try {
//				conn.commit();
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public Account findAccount(String accountName){
		try {
			return qr.query(TransactionUtil.getConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), accountName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateAccount(Account account){
		try {
			qr.update(TransactionUtil.getConnection(), "update account set money=? where name=?",account.getMoney(),account.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
