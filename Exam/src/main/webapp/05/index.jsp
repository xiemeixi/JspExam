<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}
</style>

</head>
<body>
<center>
	首页
	<br />
	<br /> 
	<tr>
	<td>
	<a href="<%=request.getContextPath()%>/02/show_table.jsp">查看和删除电影数据</a>
	</td>
	</tr>
	<br/>
    <tr>
	<td>
	<a href="<%=request.getContextPath()%>/03/insert.jsp">增加电影数据</a>
	</td>
	</tr>
	<br />
	<br />
		</center>

	<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if (obj != null) {
			flag = obj.toString();
		}
		if (flag.equals("login_success")) {
	%>
	<center><a href="<%=request.getContextPath()%>/LoServlet">退出</a></center>
	<%
		} else {
	%>
	<center><a href="<%=request.getContextPath()%>/01/login.jsp">登录</a></center>
	<%
		}
	%>


</body>
</html>