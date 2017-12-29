<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Register</title>
</head>
<body>

	<form:form action="customers" name="input" method="POST"
		modelAttribute="customer">
			USERNAME: <form:input type="text" path="profileName" />
		<form:errors path="profileName"></form:errors>
		<br />
			PASSWORD: <form:input type="text" path="password" />
		<form:errors path="password"></form:errors>
		<br />
		   EMAIL:     <form:input type="text" path="email" />
		<form:errors path="email"></form:errors>
		<br />
		  FIRST NAME: <form:input type="text" path="firstName" />
		<form:errors path="firstName"></form:errors>
		<br />
		
		LAST NAME: <form:input type="text" path="lastName" />
		<form:errors path="lastName"></form:errors>
		<br />
		PHONE:	   <form:input type="text" path="phone" />
		<form:errors path="phone"></form:errors>
		<br />
		
		<input type="submit" name="Submit">
	</form:form>

</body>
</html>