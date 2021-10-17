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
 * Servlet implementation class queryStudentBySno
 */
public class UpdateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("sno"));
		
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(name,age,address);
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(result) {
		//	response.getWriter().println("修改成功");
			response.sendRedirect("QuertAllStudentsServlet");
		} else {
			response.getWriter().println("修改失败");
		}
	}

}
