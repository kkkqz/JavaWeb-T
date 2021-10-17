package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(no,name,age,address);
		
		IStudentService studentservice = new StudentServiceImpl();
		boolean result = studentservice.addStudent(student);
		
		//设置响应编码，一定要在out生成之前设置
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
/*		if(result) {
			out.println("新增成功");
		} else {
			out.println("新增失败");
		}*/
		if(!result) {
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "noaddError");
		}
		request.getRequestDispatcher("QuertAllStudentsServlet").forward(request, response);
	}
}
