package cn.itcast.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.IdCard;
import cn.itcast.domain.Person;
import cn.itcast.util.DBCPUtil;

public class PersonDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addPerson(Person p) throws SQLException{
		//�����˵Ļ�����Ϣ
		qr.update("insert into person (id,name) values(?,?)", p.getId(),p.getName());
		//��������֤���������֤�Ļ�����Ϣ
		IdCard card = p.getIdcard();
		if(card!=null){
			qr.update("insert into idcard (id,num) values(?,?)", p.getId(),card.getNum());
		}
	}
	//Ҫ��Ҫ��IdCard�����ݡ���Ҫ��飬��ΪIdcard���ٵ�һ����
	public Person findPerson(Integer id) throws SQLException{
		Person p = qr.query("select * from person where id=?", new BeanHandler<Person>(Person.class), id);
		if(p!=null){
			IdCard idcard = qr.query("select * from idcard where id=?", new BeanHandler<IdCard>(IdCard.class), id);
			p.setIdcard(idcard);
		}
		return p;
	}
}
