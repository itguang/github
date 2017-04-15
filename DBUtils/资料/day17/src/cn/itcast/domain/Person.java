package cn.itcast.domain;

import java.io.Serializable;
/*
create table person(
	id int primary key,
	name varchar(100)
);
create table idcard(
	id int primary key,
	num varchar(20),
	constraint person_id_fk foreign key(id) references person(id)
);
 */
public class Person implements Serializable {
	private Integer id;
	private String name;
	private IdCard idcard;
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
	public IdCard getIdcard() {
		return idcard;
	}
	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}
	
}
