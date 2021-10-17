package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentBySnoServlet
 */
public class QueryStudentBySnoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService service = new StudentServiceImpl();
		Student student = service.queryStudnentBySno(no);
	
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}
}
