<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级资源</title>
</head>
<body>
	<center>
		<a href="/myschool/resource/img/1<%-- ${user.class_id } --%>/get.action">班级相册</a>
		&nbsp; 
		<a href="/myschool/resource/vedio/1<%-- ${user.class_id } --%>/get.action">班级视频</a>
		&nbsp;
		<a href="/myschool/resource/file/1<%-- ${user.class_id } --%>/get.action">班级文件</a>
		&nbsp;
		<a href="/myschool/resource/campus/get.action">校内资源</a>
	</center>
</body>
</html>