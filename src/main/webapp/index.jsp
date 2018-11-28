<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="add.html" method="post" enctype="multipart/form-data">
  	<input type="text" name="name">
  	<input type="file" name ="file"> 
  	<input type="submit" value="提交">
  	</form>
  
  
    <c:forEach var="list" items="${list}">
    ${list.fileName},${list.name}
    </c:forEach>
  </body>
  
  <script type="text/javascript" src="/js/jquery.min.js"></script>
  <script type="text/javascript">
  $.get("poi.json",function(data){
  	if(data.message=='true'){
  	alert("导出成功！")
  	}else{
  	alert("导出失败！")
  	}
  });
  </script>
</html>
