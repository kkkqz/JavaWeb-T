package servlet;

import java.io.IOException;	
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QuertAllStudentsServlet
 */
public class QuertAllStudentsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.queryAllStudents();

		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
