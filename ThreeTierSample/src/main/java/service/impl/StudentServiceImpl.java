package service.impl;

import java.util.List;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.IStudentService;

//ҵ���߼���
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	//��
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {		//���˲�����
			return studentDao.addStudent(student);
		} else {
			return false; 								//�����Ѵ���
		}
	}
	//ɾ
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)){
			return studentDao.deleteStudentBySno(sno);
		} else {
			return false;
		}
	}
	//��
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		} else {
			return false;
		}
	}
	//��
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
