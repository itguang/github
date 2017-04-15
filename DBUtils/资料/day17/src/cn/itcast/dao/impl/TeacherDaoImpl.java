package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Student;
import cn.itcast.domain.Teacher;
import cn.itcast.util.DBCPUtil;

public class TeacherDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addTeacher(Teacher t) throws SQLException{
		//保存老师的基本信息
		qr.update("insert into teacher(id,name,money) values(?,?,?)", t.getId(),t.getName(),t.getMoney());
		//判断t中是否有学生
		List<Student> stus = t.getStus();
		//有学生：判断该学生是否在student表中；在，不添加了；不在，添加进去
		if(stus!=null&&stus.size()>0){
			for(Student s:stus){
				Object num =  qr.query("select 1 from student where id=?", new ScalarHandler(1), s.getId());//判断学生是否已在数据库中
				if(num==null){
					//学生信息不存在
					qr.update("insert into student (id,name,grade) values(?,?,?)", s.getId(),s.getName(),s.getGrade());
				}
				//在第三方表中建立老师和学生的关系
				qr.update("insert into teacher_student (t_id,s_id) values(?,?)", t.getId(),s.getId());
			}
		}
		
	}
	
	public Teacher findTeacher(Integer id) throws SQLException{
		//查询老师的基本信息
		Teacher t = qr.query("select * from teacher where id=?", new BeanHandler<Teacher>(Teacher.class), id);
		if(t!=null){
		//根据老师的id查学生的基本信息：方式三种
//			String sql = "select * from student where id in (select s_id from teacher_student where t_id=?)";//子查询
//			String sql = "select s.* from student s,teacher_student ts where s.id=ts.s_id and ts.t_id=?";//隐式内连接
			String sql = "select s.* from student s inner join teacher_student ts on s.id=ts.s_id where ts.t_id=?";;//显式内连接
			List<Student> stus = qr.query(sql, new BeanListHandler<Student>(Student.class), id);
			t.setStus(stus);
		}
		return t;
	}
}
