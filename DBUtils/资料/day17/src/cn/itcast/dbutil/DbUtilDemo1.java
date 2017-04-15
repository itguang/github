package cn.itcast.dbutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.util.DBCPUtil;
/*
create database day17;
use day17;
create table t1(
	id int primary key,
	name varchar(100),
	birthday date
);
 */
//QueryRunner的基本使用
public class DbUtilDemo1 {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Test
	public void testAdd() throws Exception{
		qr.update("insert into t1 (id,name,birthday) values(?,?,?)", 1,"gfy",new Date());
	}
	@Test//MySQL
	public void testAdd1() throws Exception{
		qr.update("insert into t1 (id,name,birthday) values(?,?,?)", 2,"zql","1992-09-08");
	}
	@Test
	public void testUpdate() throws Exception{
		qr.update("update t1 set birthday=? where id=?", "1991-02-28",2);
	}
	@Test
	public void testDel() throws Exception{
		qr.update("delete from t1 where id=?", 1);
	}
	@Test
	public void testBatch()throws Exception{
		Object params[][] = new Object[10][];//第一维：记录的条数。第二维：每条中需要的参数。此处插入10条记录
		for(int i=0;i<10;i++){
			params[i] = new Object[]{i+1,"aaa"+(i+1),new Date()};//对第二维中的元素进行初始化
		}
		qr.batch("insert into t1 (id,name,birthday) values(?,?,?)", params);
	}
	/*
	create table t2(
		id int primary key,
		content longtext
	);
	 */
	@Test//不建议使用。对于大的文本，内存可能溢出
	public void testClob()throws Exception{
		File file = new File("src/jpm.txt");
		Reader r = new FileReader(file);
		char ch[] = new char[(int)file.length()];//文本的长度
		r.read(ch);
		r.close();//把数据写到数组中
		
		Clob clob = new SerialClob(ch);
		qr.update("insert into t2(id,content) values(?,?)", 1,clob);
	}
	
	/*
	create table t3(
		id int primary key,
		content longblob
	);
	 */
	@Test//不建议使用。
	public void testBlob()throws Exception{
		InputStream in = new FileInputStream("src/8.jpg");
		byte b[] = new byte[in.available()];
		in.read(b);
		in.close();
		Blob blob = new SerialBlob(b);
		qr.update("insert into t3(id,content) values(?,?)", 1,blob);
	}
}
