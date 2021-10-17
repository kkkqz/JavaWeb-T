package service;

import java.util.List;

import entity.Student;

public interface IStudentService {
		//��
		public boolean addStudent(Student student) ;
		//ɾ
		public boolean deleteStudentBySno(int sno) ;
		//��
		public boolean updateStudentBySno(int sno,Student student);
		//��
		public Student queryStudnentBySno(int sno);
		
		public List<Student> queryAllStudents();
		
		public int getTotalCount();
		
		public List<Student> queryStudentByPage(int currentPage,int pageSize);
}
