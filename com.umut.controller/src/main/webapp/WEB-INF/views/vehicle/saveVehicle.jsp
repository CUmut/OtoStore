<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Vehicle</title>
</head>
<body>

	<form:form action="vehicles" name="input" method="POST"
		modelAttribute="vehicle">
			MAKE:  <form:input type="text" path="make" />
		<form:errors path="make"></form:errors>
		<br />
		    MODEL: <form:input type="text" path="model" />
		<form:errors path="model"></form:errors>
		<br />
		    	   YEAR: <form:input type="text" path="year" />
		<form:errors path="year"></form:errors>
		<br />
		    	   PRICE: <form:input type="text" path="price" />
		<form:errors path="price"></form:errors>
		<br />
		    	   DESCRIPTION: <form:input type="text" path="description" />
		<form:errors path="descriptionl"></form:errors>
		<br />
		    	   ISNEW: <form:input type="text" path="İsNew" />
		<form:errors path="İsNew"></form:errors>
		<br />
		    	   FUEL: <form:select type="text" path="fuel">
		    	   		 <form:option value="" label="--Select--"></form:option>
		    	   		 <form:options items="${fuelTypes} }"/>
		    	   		</form:select>
		<form:errors path="fuel"></form:errors>
		<br />
		<input type="submit" name="Submit"> 

	</form:form>

</body>
</html>