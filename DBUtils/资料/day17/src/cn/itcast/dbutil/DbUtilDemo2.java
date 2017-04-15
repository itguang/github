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

//��ѯ��ϰ
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
	
	@Test//ArrayHandler���ѽ�����еĵ�һ������ת�ɶ������顣ֻ�ʺϽ������һ����¼�����
	public void test3() throws SQLException{
		//��������ÿ��Ԫ�ؾ��Ǽ�¼��ÿ�е�ֵ
		Object objs[] = qr.query("select * from account where id=?", new ArrayHandler(),1);
		for(Object o:objs)
			System.out.println(o);
	}
	@Test//ArrayListHandler���ѽ�����е�ÿһ�����ݶ�ת��һ�����飬�ٴ�ŵ�List�С�
	public void test4() throws SQLException{
		//��������ÿ��Ԫ�ؾ��Ǽ�¼��ÿ�е�ֵ
		List<Object[]> list = qr.query("select * from account", new ArrayListHandler());
		for(Object[] objs:list){
			System.out.println("-----------------");
			for(Object o:objs)
				System.out.println(o);
		}
	}
	@Test//ColumnListHandler�����������ĳһ�е����ݴ�ŵ�List��
	public void test5() throws SQLException{
		List<Object> list = qr.query("select * from account", new ColumnListHandler("id"));
		for(Object o:list)
			System.out.println(o);
	}
	@Test//KeyedHandler(name)����������е�ÿһ�����ݶ���װ��һ��Map<����,��ֵ>��ٰ���Щmap�ٴ浽һ��map���keyΪָ����key��
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
	@Test//MapHandler����������еĵ�һ�����ݷ�װ��һ��Map�key��������value���Ƕ�Ӧ��ֵ��
	public void test7() throws SQLException{
		Map<String,Object> map= qr.query("select * from account where id=?", new MapHandler(),1);
		for(Map.Entry<String, Object> me:map.entrySet()){
			System.out.println(me.getKey()+"="+me.getValue());
		}
	}
	@Test//MapListHandler����������е�ÿһ�����ݶ���װ��һ��Map�Ȼ���ٴ�ŵ�List
	public void test8() throws SQLException{
		List<Map<String,Object>> list= qr.query("select * from account", new MapListHandler());
		for(Map<String,Object> map:list){
			System.out.println("-----------------");
			for(Map.Entry<String, Object> me:map.entrySet()){
				System.out.println(me.getKey()+"="+me.getValue());
			}
		}
	}
	@Test//ScalarHandler �ʺ�ȡһ��һ�еļ�¼�������¼����
	public void test9() throws SQLException{
		Object obj = qr.query("select count(*) from account", new ScalarHandler(1));
		System.out.println(obj.getClass().getName());
		int num = ((Long)obj).intValue();
		System.out.println(num);
	}
}
