<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件</title>
</head>
<body>
	<center>
		<a href="/myschool/resource/uploads.action">批量上传</a>&nbsp; 
		<a href="/myschool/resource/file/upload.action">上传文件</a>&nbsp; 
		 <a
			href="/myschool/resource/img/1<%-- ${class_id} --%>/get.action">班级相册</a>
		&nbsp; <a
			href="/myschool/resource/vedio/1<%-- ${class_id} --%>/get.action">班级视频</a>
		&nbsp; <a
			href="/myschool/resource/file/1<%-- ${class_id} --%>/get.action">班级文件</a>
		<br>
		<c:if test="${ empty resources}">
		没有文件
		</c:if>
		<c:if test="${!empty resources }">
			<table>
				<tr>
					<th>标题</th>
					<th>上传时间</th>
					<!-- <th>用户?</th> -->
					<th></th>
				</tr>
				<c:forEach items="${resources}" var="resource">
					<tr>
						<td><a
							href="/myschool/resource/${resource.id}/download.action">${resource.title}</a></td>
						<td>${resource.time}</td>
						<td>${resource.user_id}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>