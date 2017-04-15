package cn.itcast.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.dao.impl.PersonDaoImpl;
import cn.itcast.domain.IdCard;
import cn.itcast.domain.Person;

public class PersonDaoImplTest {
	private PersonDaoImpl dao = new PersonDaoImpl();
	@Test
	public void testAddPerson() throws SQLException {
		Person p = new Person();
		p.setId(1);
		p.setName("zql");
		
		IdCard idcard = new IdCard();
		idcard.setNum("110");
		
		p.setIdcard(idcard);
		dao.addPerson(p);
	}

	@Test
	public void testFindPerson() throws SQLException {
		Person p = dao.findPerson(1);
		System.out.println(p.getName());
		IdCard idcard = p.getIdcard();
		System.out.println(idcard.getNum());
	}

}
