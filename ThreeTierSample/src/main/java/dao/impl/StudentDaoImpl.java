package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IStudentDao;
import entity.Student;
import util.DBUtil;

//数据访问层，原子性的增删改查
public class StudentDaoImpl implements IStudentDao {

	// 查询全部学生
	public List<Student> quertAllStudents() {
		List<Student> list = new ArrayList<>();
		Student student = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				list.add(student);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (DBUtil.pstmt != null)
					DBUtil.pstmt.close();
				if (DBUtil.conn != null)
					DBUtil.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sno = ?";
			Object[] params = { sno };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 根据姓名查询
	// 根据年龄查询
	// 查询此人是否存在
	public boolean isExist(int sno) {
		return queryStudentBySno(sno) == null ? false : true;
	}

	public boolean addStudent(Student student) {
		String sql = "insert into student values (?,?,?,?)";
		Object[] params = { student.getSno(), student.getSname(), student.getSage(), student.getSaddress() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据sno找人，改成后边的传入的student
	public boolean updateStudentBySno(int sno, Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] params = { student.getSname(), student.getSage(), student.getSaddress(), sno };
		return DBUtil.executeUpdate(sql, params);
	}

	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno = ?";
		Object[] params = { sno };
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student limit ?,?";
		Object[] params = { (currentPage - 1)*pageSize, pageSize };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Student student = new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"),rs.getString("saddress"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (DBUtil.pstmt != null) DBUtil.pstmt.close();
				if (DBUtil.conn != null) DBUtil.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return students;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}
}
