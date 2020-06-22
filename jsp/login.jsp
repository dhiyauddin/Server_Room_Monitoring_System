<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/login.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="logo"></div>
	<div class="login-block">
		<h1>Login</h1>
		<form:form id="loginForm" modelAttribute="login" action="loginProcess"
			method="post">
			<table align="center">
				<tr>
					<td><form:label path="username">Username: </form:label></td>
					<td><form:input path="username" name="username" id="username" />
					</td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="left"><form:button id="login" name="login">Login</form:button>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td>New User ? <a href="register">Register</a>
					</td>
				</tr>
			</table>
		</form:form>
		<table align="center">
			<tr>
				<td style="font-style: italic; color: red;">${message}</td>
			</tr>
		</table>
	</div>
</body>
</html>


