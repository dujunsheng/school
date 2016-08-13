<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="${pageContext.request.contextPath}/js/js-global/FancyZoom.js"
	language="JavaScript" type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/js-global/FancyZoomHTML.js"
	language="JavaScript" type="text/javascript"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/cabel-v1.css"
	type="text/css" />
<style type="text/css">
a： {
	text-decoration: none;
}
</style>
<title>相册</title>
</head>
<body>
	<a href="/myschool/resource/img/1<%-- ${class_id} --%>/get.action">班级相册</a>
	&nbsp;
	<a href="/myschool/resource/vedio/1<%-- ${class_id} --%>/get.action">班级视频</a>
	&nbsp;
	<a href="/myschool/resource/file/1<%-- ${class_id} --%>/get.action">班级文件</a>
	&nbsp;
	<a href="/myschool/resource/uploads.action">批量上传</a>&nbsp; <a
			href="/myschool/resource/img/upload.action">上传相片</a>
</body>
<body onLoad="setupZoom();">
	<br>
	<div class="photoblock-many">
		<c:forEach items="${resources}" var="resource">
			<c:if test="${resource != null}">
				<a
					href="${pageContext.request.contextPath}/upload${resource.relative_path}">
					<img
					src="${pageContext.request.contextPath}/upload${resource.thumb_path}"
					width="200" height="150" border="0" alt="" id="img-mwsf-9"
					class="photo" />
				</a>
			</c:if>
		</c:forEach>
	</div>
	<br>
	<div align="center"></div>
</body>
</html>