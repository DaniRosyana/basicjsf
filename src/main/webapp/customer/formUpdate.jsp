<%@page import="id.co.skyforce.basicjsf.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Ubah</title>
</head>
<body>
<center>
<h3>Update Customer</h3>
<% Customer c = (Customer) request.getAttribute("customer"); %>
	<form action="save" method="post">
	<input type="hidden" name="id" value="<%out.print(c.getId()) ; %>" />
		<table border="1" width=30%>
			
			<tr align="center">
				<td>First Name</td>
				<td>:</td>
				<td><input type="text" name="firstName" value="<%out.print(c.getFirstName()) ; %>" /></td>
			</tr>
			<tr align="center">
				<td>Last Name</td>
				<td>:</td>
				<td><input type="text" name="lastName" value="<% out.print(c.getLastName()); %>"/></td>
			</tr>
			<tr align="center">
				<td>Birth Date</td>
				<td>:</td>
				<td><input type="text" name="birthDate" placeholder="YYYY-MM-DD" value="<% out.print(c.getBirthDate()); %>"/></td>
			</tr>
			<tr align="center">
				<td>Home Phone</td>
				<td>:</td>
				<td><input type="text" name="homePhone" value="<% out.print(c.getHomePhone()); %>"/></td>
			</tr>
			<tr align="center">
				<td>Mobile Phone</td>
				<td>:</td>
				<td><input type="text" name="mobilePhone" value="<% out.print(c.getMobileNo()); %>"/></td>
			</tr>
			<tr align="center">
				<td>Email</td>
				<td>:</td>
				<td><input type="text" name="email" value="<% out.print(c.getEmail()); %>" /></td>
			</tr>
			<tr align="center">
				<td>Password</td>
				<td>:</td>
				<td><input type="text" name="password" value="<% out.print(c.getPassword()); %>"/></td>
			</tr>
			
			<tr align="center">
				<td>Street</td>
				<td>:</td>
				<td><input type="text" name="street" value="<% out.print(c.getAddress().getStreet()); %>"/></td>
			</tr>
			<tr align="center">
				<td>City</td>
				<td>:</td>
				<td><input type="text" name="city" value="<% out.print(c.getAddress().getCity()); %>"/></td>
			</tr>
			<tr align="center">
				<td>Postal Code</td>
				<td>:</td>
				<td><input type="text" name="postalCode" maxlength="5" value="<% out.print(c.getAddress().getPostalCode()); %>"/></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="update" />
		<button type="submit">Send</button>
		
	</form>
	</center>
</body>
</html>