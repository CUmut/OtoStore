<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer Profile</title>
</head>
<body>

	<h1>View Customer Profile</h1>
	<div>PROFILE NAME: ${customer.profileName}</div>
	<div>NAME: ${customer.firstName} ${user.lastNme}</div>
	<div>EMAIL: ${customer.email}</div>
	<div>PHONE: ${customer.phone}</div>

	<a href="${customer.profileName}/edit">Edit Profile</a>
</body>
</html>