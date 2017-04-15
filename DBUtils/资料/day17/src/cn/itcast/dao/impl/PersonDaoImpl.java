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
		//保存人的基本信息
		qr.update("insert into person (id,name) values(?,?)", p.getId(),p.getName());
		//如果有身份证，保存身份证的基本信息
		IdCard card = p.getIdcard();
		if(card!=null){
			qr.update("insert into idcard (id,num) values(?,?)", p.getId(),card.getNum());
		}
	}
	//要不要查IdCard的内容。都要求查，因为Idcard是少的一方的
	public Person findPerson(Integer id) throws SQLException{
		Person p = qr.query("select * from person where id=?", new BeanHandler<Person>(Person.class), id);
		if(p!=null){
			IdCard idcard = qr.query("select * from idcard where id=?", new BeanHandler<IdCard>(IdCard.class), id);
			p.setIdcard(idcard);
		}
		return p;
	}
}
