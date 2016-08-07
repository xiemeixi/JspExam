<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>增加数据页面</title>

<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}
</style>


</head>

<body>
	<form action="<%= request.getContextPath() %>/InServlet" method="post" name="LoginForm">

		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">增加数据</td>
			</tr>
			
			<tr>
				<td>title：</td>
				<td><input type="text" name="tl" /></td>
			</tr>
			<tr>
				<td>description：</td>
				<td><input type="text" name="ds" /></td>
			</tr>
			<tr>
			<td>language：</td>
			<td>
			<select name=language>  
				      <option value="1">English</option>  
				      <option value="2">Italian</option>  
				      <option value="3">Japanese</option>  
				      <option value="4">Mandarin</option>
				      <option value="5">French</option>  
				      <option value="6">German</option>    
               </select>  
			 </td> 
			 </tr>  
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" value="增加"/>
					<input type="reset" name="reset" value="重置"/>
				</td>
			</tr>
			 <tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8"><a href="<%=request.getContextPath()%>/05/index.jsp">返回</a></td>
			</tr>
		</table>

	</form>
</body>
</html>