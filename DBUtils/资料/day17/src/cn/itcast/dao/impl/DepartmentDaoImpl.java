package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Department;
import cn.itcast.domain.Employee;
import cn.itcast.util.DBCPUtil;
/*
create table department(
	id int primary key,
	name varchar(100)
);
create table employee(
	id int primary key,
	name varchar(100),
	salary float(8,2),
	dept_id int,
	constraint dept_id_fk foreign key(dept_id) references department(id)
);*/
public class DepartmentDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addDepartment(Department d) throws SQLException{
		//���沿�ŵĻ�����Ϣ��department����
		qr.update("insert into department (id,name) values(?,?)", d.getId(),d.getName());
		//�ж�d����û��Ա����Ϣ
		List<Employee> emps = d.getEmps();
		if(emps!=null&&emps.size()>0){
			//����б���Ա����Ϣ��employee����
			Object params[][] = new Object[emps.size()][];
			for(int i=0;i<params.length;i++){
				Employee e = emps.get(i);
				params[i] = new Object[]{e.getId(),e.getName(),e.getSalary(),d.getId()};
			}
			qr.batch("insert into employee (id,name,salary,dept_id) values(?,?,?,?)", params);
		}
		
	}
	
	public Department findDepartment(Integer id) throws SQLException{
		//��ѯ���ŵĻ�����Ϣ
		Department d = qr.query("select * from department where id=?", new BeanHandler<Department>(Department.class), id);
		//���Ź�����Ա����ϢҪ��Ҫ����������һ��Ҫ��Ҫ��ѯ������
		if(d!=null){
			List<Employee> emps = qr.query("select * from employee where dept_id=?", new BeanListHandler<Employee>(Employee.class), id);
			d.setEmps(emps);
		}
		return d;
	}
}
