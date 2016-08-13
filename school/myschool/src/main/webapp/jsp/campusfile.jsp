<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校内文件</title>
</head>
<body>
	<center>
		<a href="/myschool/resource/file/campus/get.action">校内文件</a>&nbsp; 
		<a href="/myschool/resource/video/campus/get.action">校内视频</a>&nbsp;
<!-- 		 <a href="/myschool/resource/img/campus/get.action">校内相片</a>&nbsp; -->
	</center>
	<center>
		<table>
			<tr>
				<th></th>
				<th></th>
			</tr>
			<c:if test="${empty resources}">
				没有文件
			</c:if>
			<c:if test="${!empty resources}">
				<c:forEach items="${resources}" var="resource">
					<tr>
						<td><a
							href="/myschool/resource/${resource.id}/download.action">${resource.title}</a></td>
						<td>${resource.time}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</center>
</body>
</html>