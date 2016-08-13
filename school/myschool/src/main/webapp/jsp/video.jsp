<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="net.sf.json.JSONArray"%>
<%@ page import="java.util.List"%>
<%@ page import="com.school.po.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
</head>
<body>
	<center>
		<a
			href="${pageContext.request.contextPath}/resource/img/1<%-- 从session中的user的class_id获取--%>/get.action">班级相册</a>
		&nbsp; <a
			href="${pageContext.request.contextPath}/resource/vedio/1<%-- 从session中的user的class_id获取--%>/get.action">班级视频</a>
		&nbsp; <a
			href="${pageContext.request.contextPath}/resource/file/1/get.action">班级文件</a>
		&nbsp;
		<a href="/myschool/resource/uploads.action">批量上传</a>&nbsp; <a
			href="/myschool/resource/img/upload.action">上传视频</a>
	</center>
	<center>
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
	</center>
</body>
</html>