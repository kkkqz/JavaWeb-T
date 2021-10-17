package service.impl;

import java.util.List;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.IStudentService;

//业务逻辑层
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//增
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {		//此人不存在
			return studentDao.addStudent(student);
		} else {
			return false; 								//此人已存在
		}
	}
	//删
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)){
			return studentDao.deleteStudentBySno(sno);
		} else {
			return false;
		}
	}
	//改
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		} else {
			return false;
		}
	}
	//查
	public Student queryStudnentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	public List<Student> queryAllStudents() {
		return studentDao.quertAllStudents();
	}
	
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
	
	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentByPage(currentPage, pageSize);
	}
}
