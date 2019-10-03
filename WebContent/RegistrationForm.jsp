<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body align="center">

<form action="RegistrationServlet" method="post">

<table>
<tr>
<td>Enter Name : </td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>Enter UserID : </td>
<td><input type="text" name="uid"/></td>
</tr>
<tr>
<td>Enter Password : </td>
<td><input type="password" name="password"/></td>
</tr>
<!-- <tr>
<td>Retype Password : </td>
<td><input type="password" name="password1"/></td>
</tr> -->
<tr>
<td colspan="2"><input type="submit" value="REGISTER"/></td>
</tr>
</table>

</form>

</body>
</html>