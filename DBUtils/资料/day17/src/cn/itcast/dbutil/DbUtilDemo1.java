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
//QueryRunner�Ļ���ʹ��
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
		Object params[][] = new Object[10][];//��һά����¼���������ڶ�ά��ÿ������Ҫ�Ĳ������˴�����10����¼
		for(int i=0;i<10;i++){
			params[i] = new Object[]{i+1,"aaa"+(i+1),new Date()};//�Եڶ�ά�е�Ԫ�ؽ��г�ʼ��
		}
		qr.batch("insert into t1 (id,name,birthday) values(?,?,?)", params);
	}
	/*
	create table t2(
		id int primary key,
		content longtext
	);
	 */
	@Test//������ʹ�á����ڴ���ı����ڴ�������
	public void testClob()throws Exception{
		File file = new File("src/jpm.txt");
		Reader r = new FileReader(file);
		char ch[] = new char[(int)file.length()];//�ı��ĳ���
		r.read(ch);
		r.close();//������д��������
		
		Clob clob = new SerialClob(ch);
		qr.update("insert into t2(id,content) values(?,?)", 1,clob);
	}
	
	/*
	create table t3(
		id int primary key,
		content longblob
	);
	 */
	@Test//������ʹ�á�
	public void testBlob()throws Exception{
		InputStream in = new FileInputStream("src/8.jpg");
		byte b[] = new byte[in.available()];
		in.read(b);
		in.close();
		Blob blob = new SerialBlob(b);
		qr.update("insert into t3(id,content) values(?,?)", 1,blob);
	}
}
