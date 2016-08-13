<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知</title>
</head>
<body>
	通知：
	<a href="${pageContext.request.contextPath}/inform/release.action">发布通知</a>
	<a href="${pageContext.request.contextPath}/inform/getallbyrank.action">按等级</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/inform/getall.action">按时间</a>&nbsp;&nbsp;
	<form action="${pageContext.request.contextPath}/inform/search.action">
		<input type="text" name="keyword"><input type="submit"
			value="搜索">
	</form>
	<c:if test="${inform != null}">
		<table>
			<tr>
			<th>标题</th>
			<th>发布时间</th>
			<th>通知等级</th>
			</tr>
			<c:forEach items="${inform}" var="item">
				<tr>
					<td><a href="get.action?informId=${item.informId}">${item.title}
					</a></td>
					<td>${item.publishTime}</td>
					<td>${item.rank}<%--  转成相应文字--%></td>
					<td><a href="delete.action?informId=${item.informId}">删除</a></td>
					<td><a
						href="${pageContext.request.contextPath}/inform/update.action?informId=${item.informId}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>