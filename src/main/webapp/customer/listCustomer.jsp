<%@page import="id.co.skyforce.basicjsf.domain.Customer"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="id.co.skyforce.basicjsf.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customer</title>
</head>
<body>
	<center>
		<font face="stencil" size="4" color="blue">List Data Customer</font><br/>
		
		<table border="1" width="50%%" cellspacing="3px" cellpadding="3px">
			<tr align ="center">
				<td><b>id Customer</b></td>
				<td><b>Name</b></td>
				<td><b>Birth Date</b></td>
				<td colspan="2"><b>Action</b></td>
			</tr>
			
			<%
				List<Customer> LC = (List<Customer>) request.getAttribute("listCustomer");
				for(Customer c : LC){
			%><tr align="center">
					<td> <% out.print(c.getId()); %></td>
					<td> <% out.print(c.getFirstName()+" "+c.getLastName()); %></td>
					<td> <% out.print(c.getBirthDate()); %></td>
					<% out.print("<td><a href=\"http://localhost:8080/basicjsf/customer/listCustomer?parameter=update&idCustomer="+c.getId()+"\">Edit</a>"+"</td>"); %>
					<% out.print("<td><a href=\"http://localhost:8080/basicjsf/customer/listCustomer?parameter=delete&idCustomer="+c.getId()+"\">Delete</a>"+"</td>"); %>
			</tr><% 
			}
			%>
			
			<tr align="left">
				<td colspan="6"><a href="formInsert.jsp">New customer</a></td>
			</tr>
		</table>
		
	</center>
</body>
</html>