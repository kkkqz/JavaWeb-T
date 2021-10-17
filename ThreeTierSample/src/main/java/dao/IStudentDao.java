package dao;

import java.util.List;	

import entity.Student;

public interface IStudentDao {
	
	public List<Student> quertAllStudents();
	
	public boolean isExist(int sno);
	
	public boolean addStudent(Student student) ;
	
	public boolean updateStudentBySno(int sno,Student student);
	
	public boolean deleteStudentBySno(int sno) ;
	
	public Student queryStudentBySno(int sno);
	
	public int getTotalCount();
	
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
}
