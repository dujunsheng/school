<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ueditor demo</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/inform/release.action" method="post">
			<input type="hidden" value="test dep" name="depName"><%--查询确定部门所在名称 --%>
			<!-- 页面确定部门名字 -->
			标题:<input type="text" name="title"><br>
			 通知等级:<select name="rank">
				<c:forEach begin="1" end="5" var="i">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<!-- 加载编辑器的容器 -->
			<script id="container" name="content" type="text/plain">
			新通知
			</script>
			<!-- 配置文件 -->
			<script type="text/javascript" src="../utf8-jsp/ueditor.config.js"></script>
			<!-- 编辑器源码文件 -->
			<script type="text/javascript" src="../utf8-jsp/ueditor.all.js"></script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var ue = UE.getEditor('container');
			</script>
			<input type="submit" name="submit">
		</form>
	</div>
</body>

</html>