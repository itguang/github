package cn.itcast.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
void saveOrUpdate(Department d){
	//看看d的id在数据库中是否已经存在。
	//存在就是更新操作

}

Department d = new Department();  // int id;  默认是0.Integer id，默认是null
saveOrUpdate(d);
 */
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
);
 */
public class Department implements Serializable {
	private Integer id;
	private String name;
	private List<Employee> emps = new ArrayList<Employee>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}
