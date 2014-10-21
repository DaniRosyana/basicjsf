<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tambah Customer</title>
</head>
<body>
<center>
	<h3>Data Customer</h3>
	<form action="save" method="post">
		<table border="1" width=30%>
			<tr align="center">
				<td>First Name</td>
				<td>:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr align="center">
				<td>Last Name</td>
				<td>:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr align="center">
				<td>Birth Date</td>
				<td>:</td>
				<td><input type="text" name="birthDate" placeholder="YYYY-MM-DD"/></td>
			</tr>
			<tr align="center">
				<td>Home Phone</td>
				<td>:</td>
				<td><input type="text" name="homePhone" /></td>
			</tr>
			<tr align="center">
				<td>Mobile Phone</td>
				<td>:</td>
				<td><input type="text" name="mobilePhone" /></td>
			</tr>
			<tr align="center">
				<td>Email</td>
				<td>:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr align="center">
				<td>Password</td>
				<td>:</td>
				<td><input type="text" name="password" /></td>
			</tr>
			
			<tr align="center">
				<td>Street</td>
				<td>:</td>
				<td><input type="text" name="street" /></td>
			</tr>
			<tr align="center">
				<td>City</td>
				<td>:</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr align="center">
				<td>Postal Code</td>
				<td>:</td>
				<td><input type="text" name="postalCode" /></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="create" />
		<button type="submit">Send</button>
	</form>
	</center>
</body>
</html>