<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.hcl.employees.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%List<Employee> l = (ArrayList<Employee>)request.getAttribute("list"); %> 
 <table border="2" cellspacing="0" cellpadding="10">
<tr>
<th>Id</th>
<th>Name</th>
<th>Department</th>
</tr>
<%for(Employee emp : l){%>
<tr><td><%=emp.getEmp_id() %></td>
<td><%=emp.getEmp_name() %></td>
<td><%=emp.getEmp_address() %></td> 
</tr>
<%} %>
</table>
</body>
</html>