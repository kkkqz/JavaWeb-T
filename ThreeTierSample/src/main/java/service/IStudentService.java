package service;

import java.util.List;

import entity.Student;

public interface IStudentService {
		//Ôö
		public boolean addStudent(Student student) ;
		//É¾
		public boolean deleteStudentBySno(int sno) ;
		//¸Ä
		public boolean updateStudentBySno(int sno,Student student);
		//²é
		public Student queryStudnentBySno(int sno);
		
		public List<Student> queryAllStudents();
		
		public int getTotalCount();
		
		public List<Student> queryStudentByPage(int currentPage,int pageSize);
}
