<%@page import="entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("tr:odd").css("background-color","lightgray")
	});
</script>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<%
		//error 
		String error = (String)request.getAttribute("error");
		if(error!=null){
			if(error.equals("addError")){
				out.print("增加失败!");
			}else if(error.equals("noaddError")){
				out.print("增加成功!");
			}
		}
	%>
	<table border="1px">
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.students }" var="entity">
				<tr>
					<td><a href="QueryStudentBySnoServlet?sno=${entity.sno }">${entity.sno }</a></td>
					<td>${entity.sname }</td>
					<td>${entity.sage }</td>
					<td>${entity.saddress }</td>
					<td><a href="DeleteStudentServlet?sno=${entity.sno }">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add.jsp">新增</a><br/>
	<% 
		Page pages = (Page)request.getAttribute("page");
	//不能取名page，jsp有个内置对象是page
	
		if(pages.getPage()==pages.getTotalPage()){ //尾页
	%>
			<a href="QueryStudentByPage?page=1">首页</a>
			<a href="QueryStudentByPage?page=<%=pages.getPage()-1 %>">上一页</a>
			<a>下一页</a>
			<a>尾页</a>
	<%	
		}
		else if(pages.getPage()==1){//首页
	%>		
			<a>首页</a>
			<a>上一页</a>
			<a href="QueryStudentByPage?page=<%=pages.getPage()+1 %>">下一页</a>
			<a href="QueryStudentByPage?page=<%=pages.getTotalPage() %>">尾页</a>
	<% 		
		}
		else{//中间页
	%>	
			<a href="QueryStudentByPage?page=1">首页</a>
			<a href="QueryStudentByPage?page=<%=pages.getPage()-1 %>">上一页</a>
			<a href="QueryStudentByPage?page=<%=pages.getPage()+1 %>">下一页</a>
			<a href="QueryStudentByPage?page=<%=pages.getTotalPage() %>">尾页</a>
	<% 		
		}
	%>
	
	
		
		
		
		
		
	<%
// 		分页SQL
// 			当前页 page
// 			页面大小 pageSize 固定为10
// 			总数据量 totalCount
// 			总页数 totalPage
// 			当前页的数据集合 list(student)
// 				新建一个Page类来封装这些数据
	%>
</body>
</html>