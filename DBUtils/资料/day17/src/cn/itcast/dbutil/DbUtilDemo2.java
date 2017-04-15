package cn.itcast.dbutil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.util.DBCPUtil;

//查询练习
public class DbUtilDemo2 {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Test//BeanHandler
	public void test1() throws SQLException{
		Account a = qr.query("select * from account where id=?", new BeanHandler<Account>(Account.class), 1);
		System.out.println(a);
	}
	@Test//BeanListHandler
	public void test2() throws SQLException{
		List<Account> list = qr.query("select * from account", new BeanListHandler<Account>(Account.class));
		for(Account a:list)
			System.out.println(a);
	}
	
	@Test//ArrayHandler：把结果集中的第一行数据转成对象数组。只适合结果集有一条记录的情况
	public void test3() throws SQLException{
		//该数组中每个元素就是记录的每列的值
		Object objs[] = qr.query("select * from account where id=?", new ArrayHandler(),1);
		for(Object o:objs)
			System.out.println(o);
	}
	@Test//ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
	public void test4() throws SQLException{
		//该数组中每个元素就是记录的每列的值
		List<Object[]> list = qr.query("select * from account", new ArrayListHandler());
		for(Object[] objs:list){
			System.out.println("-----------------");
			for(Object o:objs)
				System.out.println(o);
		}
	}
	@Test//ColumnListHandler：将结果集中某一列的数据存放到List中
	public void test5() throws SQLException{
		List<Object> list = qr.query("select * from account", new ColumnListHandler("id"));
		for(Object o:list)
			System.out.println(o);
	}
	@Test//KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map<列名,列值>里，再把这些map再存到一个map里，其key为指定的key。
	public void test6() throws SQLException{
		Map<Object, Map<String,Object>> bmap= qr.query("select * from account", new KeyedHandler("id"));
		for(Map.Entry<Object, Map<String,Object>> bme:bmap.entrySet()){
			System.out.println("-----------------");
			Map<String,Object> lmap = bme.getValue();
			for(Map.Entry<String,Object> lme:lmap.entrySet()){
				System.out.println(lme.getKey()+"="+lme.getValue());
			}
		}
	}
	@Test//MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
	public void test7() throws SQLException{
		Map<String,Object> map= qr.query("select * from account where id=?", new MapHandler(),1);
		for(Map.Entry<String, Object> me:map.entrySet()){
			System.out.println(me.getKey()+"="+me.getValue());
		}
	}
	@Test//MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
	public void test8() throws SQLException{
		List<Map<String,Object>> list= qr.query("select * from account", new MapListHandler());
		for(Map<String,Object> map:list){
			System.out.println("-----------------");
			for(Map.Entry<String, Object> me:map.entrySet()){
				System.out.println(me.getKey()+"="+me.getValue());
			}
		}
	}
	@Test//ScalarHandler 适合取一条一列的记录。比如记录总数
	public void test9() throws SQLException{
		Object obj = qr.query("select count(*) from account", new ScalarHandler(1));
		System.out.println(obj.getClass().getName());
		int num = ((Long)obj).intValue();
		System.out.println(num);
	}
}
