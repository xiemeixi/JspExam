<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.hand.connection.ConnectionFactory,com.hand.dao.filmimpl.FilmImpl,java.sql.Connection,java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">  
table {  
    border: 2px #CCCCCC solid;  
}  
  
td,th {  
    border: #CCCCCC 1px solid;  
}  
</style>  
</head>  
<body> 
  <%  FilmImpl fl = new FilmImpl();
   	  Connection conn = ConnectionFactory.getInstance().makeConnection();
	  conn.setAutoCommit(false);
	  ResultSet rs = fl.select(conn);
    %>   
    <br>  
    <br>  
    <table align="center">
        <tr>
			<td colspan="2" align="center" bgcolor="#E8E8E8"><a href="<%=request.getContextPath()%>/05/index.jsp">返回</a></td>
		</tr>  
        <tr>  
            <th>  
                <%  
                    out.print("Film_Id");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("Title");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("Description");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("language");  
                %>  
            </th>  
        </tr>  
  
        <%  
            while (rs.next()) {  
        %>  
        <tr>  
            <td>  
                <%  
                    out.print(rs.getInt(1));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(2));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(3));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(4));  
                %>  
            </td> 
            <td>
            <a href="<%= request.getContextPath() %>/DeServlet?id=<%=rs.getInt(1) %>">删除</a>
            </td> 
        </tr>  
        <%  
            }  
        %>  
    </table>  
    <div align="center">  
    </div>  
    <%  
        conn.close();  
    %>  
</body>
<span>
<span style="font-size:24px;color: rgb(255, 0, 0);">  
</span>
</span>    
</html>