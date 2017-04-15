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
		//������ʦ�Ļ�����Ϣ
		qr.update("insert into teacher(id,name,money) values(?,?,?)", t.getId(),t.getName(),t.getMoney());
		//�ж�t���Ƿ���ѧ��
		List<Student> stus = t.getStus();
		//��ѧ�����жϸ�ѧ���Ƿ���student���У��ڣ�������ˣ����ڣ���ӽ�ȥ
		if(stus!=null&&stus.size()>0){
			for(Student s:stus){
				Object num =  qr.query("select 1 from student where id=?", new ScalarHandler(1), s.getId());//�ж�ѧ���Ƿ��������ݿ���
				if(num==null){
					//ѧ����Ϣ������
					qr.update("insert into student (id,name,grade) values(?,?,?)", s.getId(),s.getName(),s.getGrade());
				}
				//�ڵ��������н�����ʦ��ѧ���Ĺ�ϵ
				qr.update("insert into teacher_student (t_id,s_id) values(?,?)", t.getId(),s.getId());
			}
		}
		
	}
	
	public Teacher findTeacher(Integer id) throws SQLException{
		//��ѯ��ʦ�Ļ�����Ϣ
		Teacher t = qr.query("select * from teacher where id=?", new BeanHandler<Teacher>(Teacher.class), id);
		if(t!=null){
		//������ʦ��id��ѧ���Ļ�����Ϣ����ʽ����
//			String sql = "select * from student where id in (select s_id from teacher_student where t_id=?)";//�Ӳ�ѯ
//			String sql = "select s.* from student s,teacher_student ts where s.id=ts.s_id and ts.t_id=?";//��ʽ������
			String sql = "select s.* from student s inner join teacher_student ts on s.id=ts.s_id where ts.t_id=?";;//��ʽ������
			List<Student> stus = qr.query(sql, new BeanListHandler<Student>(Student.class), id);
			t.setStus(stus);
		}
		return t;
	}
}
