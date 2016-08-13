<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/uploadify.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.uploadify.min.js"></script>
<script>
	$(document).ready(function() {
		$("#file_upload").uploadify({
			'buttonText' : '请选择',
			'height' : 30,
			'swf' : '/myschool/js/uploadify.swf',
			'uploader' : '../resource/img/upload.action',
			'width' : 120,
			'auto' : false,
			'fileObjName' : 'file',
			'onUploadSuccess' : function(file, data, response) {
				
			}
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="file" name="fileName" id="file_upload" />
	<a href="javascript:$('#file_upload').uploadify('upload', '*')">上传文件</a>
	|
	<a href="javascript:$('#file_upload').uploadify('stop')">停止上传!</a>
</body>
</html>