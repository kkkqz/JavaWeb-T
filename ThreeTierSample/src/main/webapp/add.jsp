<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script>
	function check(){
		var sno = $("sno").val();
		var sname = $("sname").val();
		var sage = $("sage").val();
		var saddress = $("saddress").val();
		if(!(sno>0 && sno<101)){
			alert("学号必须是1-100")
			return false;
		}
		if(!(sname.length>1 && sname.length<5)){
			alert("姓名长度有误")
			return false;
		}
		return true;
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "AddStudentServlet" method="post" onsubmit="return check()">
		学号:<input type = "text" name = "sno" id="sno"><br/>
		姓名:<input type = "text" name = "sname" id="sname"><br/>
		年龄:<input type = "text" name = "sage" id="sage"><br/>
		地址:<input type = "text" name = "saddress" id="saddress"><br/>
		<input type = "submit" value = "新增学生">
	</form>
</body>
</html>