<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知详情</title>
</head>
<body>
	<center><h2>${inform.title}</h2>
	<br>
	${inform.text}
	
	发布时间:${inform.publishTime} &nbsp;&nbsp;&nbsp;发布部门:${inform.depName}
	</center>
</body>
</html>