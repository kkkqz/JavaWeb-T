<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>
	<!-- 通过表单展示 -->
	<form action="UpdateStudentServlet" method="post">
		学号：<input type="text" name="sno" value="<%=student.getSno()%>"/><br/>
		姓名：<input type="text" name="sname" value="<%=student.getSname()%>"/><br/>
		年龄：<input type="text" name="sage" value="<%=student.getSage()%>"/><br/>
		地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"/><br/>
		<input type="submit" value="修改"/>
		<a href="QuertAllStudentsServlet">返回</a>
	</form>
</body>
</html>