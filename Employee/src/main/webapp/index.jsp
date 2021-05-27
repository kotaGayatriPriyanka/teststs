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
<form action="addEmployee" method="get">
<table>
		<tr><td>Enter Id:</td><td><input type="text" name="id" placeholder="Enter Id"/></td></tr>
		<tr><td>Enter Name:</td><td><input type="text" name="firstname" placeholder="Enter name"/></td></tr>
		<tr><td>Enter Address:</td><td><input type="text" name="address" placeholder="Enter Address"/></td></tr>
		<tr><td><button type="submit" class="form">Register</button></td></tr>
</table>
		</form>
		
	
	
    
   <form action="searchEmployeeDetails" method="get">
   <table>
		<tr><td>Enter Id:</td><td><input type="text" name="id" placeholder="Enter Id"/></td></tr>
        <tr><td><button type="submit">Search</button> </td></tr>
        </table>  
    </form>
    
    
    <form action="displayEmployeeDetails" method="get">
    </br></br>
        <button type="submit">Display</button>   
    </form> 
    <%if(request.getAttribute("list")!=null){ %>
		<%List<Employee> l = (ArrayList<Employee>)request.getAttribute("list"); %> 
 <table border="2" cellspacing="0" cellpadding="10">
<tr>
<th>Id</th>
<th>Name</th>
<th>Department</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%for(Employee emp : l){%>
<tr><td><%=emp.getEmp_id() %></td>
<td><%=emp.getEmp_name() %></td>
<td><%=emp.getEmp_address() %></td> 
<td><a href="update.jsp"><button type="submit">Update </button></td>
<td><a href="deleteEmployeeDetails?id=<%=+emp.getEmp_id()%>"><button>Delete</button></a></td>
</tr>
<%} %>
</table>
<%} %>
<% if(request.getAttribute("message")!=null){ %>
<%=request.getAttribute("message") %>
<%} %>
</body>
</html>