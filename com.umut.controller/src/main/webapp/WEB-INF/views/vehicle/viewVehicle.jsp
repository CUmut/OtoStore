<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicles</title>
</head>
<body>

	<h1>Vehicles</h1>
	
	<c:forEach var="item" items="${vehicles}">
		<c:out value="${item.make}"></c:out>
		<c:out value="${item.model}"></c:out>
		<c:out value="${item.year}"></c:out>
		<c:out value="${item.price}"></c:out>
		<c:out value="${item.description}"> </c:out>
		<c:out value="${item.isNew}"></c:out>
		<c:out value="${item.fuel}"></c:out>
		<c:out value="${item.vendorName}"></c:out>
		<br/>
	</c:forEach>

	<div  style="float: right">
		<a href="vehicles?saveVehicle" >Save Vehicle</a>
	</div>	

</body>
</html>