package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class queryAllStudents
 */
public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.deleteStudentBySno(sno);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(result) {
		//	response.getWriter().println("É¾³ý³É¹¦");
			response.sendRedirect("QuertAllStudentsServlet");
		} else {
			response.getWriter().println("É¾³ýÊ§°Ü");
		}
	}

}
