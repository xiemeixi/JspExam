<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除成功提示页面</title>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}

#message{
	text-align: center;
}
</style>
</head>
<body>

<div id="message">
删除成功.<br/>
<a href="<%=request.getContextPath() %>/02/show_table.jsp">返回页面</a>

</div>

</body>
</html>