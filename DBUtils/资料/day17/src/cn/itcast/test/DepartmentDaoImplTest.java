package cn.itcast.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.dao.impl.DepartmentDaoImpl;
import cn.itcast.domain.Department;
import cn.itcast.domain.Employee;

public class DepartmentDaoImplTest {
	private DepartmentDaoImpl dao = new DepartmentDaoImpl();
	@Test
	public void testAddDepartment() throws SQLException {
		Department d = new Department();
		d.setId(1);
		d.setName("开发部");
		
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("葛付以");
		e1.setSalary(8000);
		
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("王翔云");
		e2.setSalary(8000);
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);//建立关系
		
		dao.addDepartment(d);
	}

	@Test
	public void testFindDepartment() throws SQLException {
		Department d = dao.findDepartment(1);
		System.out.println(d.getName());
		List<Employee> emps = d.getEmps();
		for(Employee e:emps)
			System.out.println(e.getName());
	}

}
