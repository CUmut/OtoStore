<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Oto Store</h1>

	<c:forEach var="item" items="$(customerList)">
		<c:out value="$(item.firstName)"></c:out>
		<c:out value="$(item.lastName)"></c:out>
		<c:out value="$(item.profileName)"></c:out>
		<br />
	</c:forEach>

	<div style="float: right">
		 <a href="users/customers?registerCustomer">Customer Register</a>
	</div>
</body>
</html>
