<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校内视频</title>
</head>
<body>
	<center>
		<a href="/myschool/resource/file/campus/get.action">校内文件</a>&nbsp; <a
			href="/myschool/resource/video/campus/get.action">校内视频</a>&nbsp;
		<!-- 		<a href="/myschool/resource/img/campus/get.action">校内相片</a>&nbsp; -->
	</center>
	<center>
	<c:if test="${empty resource}">
		没有内容
	</c:if>
	<c:if test="${!empty resource}">
		<table>
			<tr>
				<td><a href="/myschool/resource/vedio/lastest.action">最新</a></td>
			</tr>
			<tr>
				<th>资源</th>
				<th>标题</th>
				<th>时间</th>
			</tr>
			<c:forEach items="${resources}" var="resource">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/resource/${resource.id}/download.action">
							<img alt=""
							src="${pageContext.request.contextPath}/upload${resource.thumb_path }">
					</a></td>
					<td>${resource.title}</td>
					<td>${resource.time}</td>
					<td><a
						href="${pageContext.request.contextPath}/resource/${resource.id}/delete.action">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</center>
</body>
</html>