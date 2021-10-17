package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Page;
import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentByPage
 */
public class QueryStudentByPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService service = new StudentServiceImpl();
		Page page = new Page();
		
		
		String cPage = request.getParameter("page");
		if(cPage == null) {
			cPage = "1";
		}
		int currentPage = Integer.parseInt(cPage);
		int pageSize = 10;
		int totalCount = service.getTotalCount();
		List<Student> students = service.queryStudentByPage(currentPage, pageSize);
		
		page.setPage(currentPage);
		page.setStudents(students);
		page.setTotalCount(totalCount);
		page.setPageSize(pageSize);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
