<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
<div align="center">这是分页测试</div>
<ul>
<c:forEach items="${pb.beanList }" var="department">
	<li>
		<table align="center">
			<tr>
				<td>${department.depName }</td>
			</tr>
		</table>
	</li>
</c:forEach>
</ul>
<div align="center"><a href="<c:url value='/findAll.action?pageNum=${pb.pc+1 }'/>">下一页</a></div>
  </body>
 
</html>