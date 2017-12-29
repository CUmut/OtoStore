<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Fuel Type</title>
</head>
<body>

	<form:form action="fueltypes" name="input" method="POST"
		modelAttribute="fuelType">
			FUEL TYPE: <form:input type="text" path="fuel" />
		<form:errors path="fuel"></form:errors>
		<br />

		<input type="submit" name="Submit">
	</form:form>


</body>
</html>