<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Vendor Profile</title>
</head>
<body>

	 <h1>View Vendor Profile</h1>
	<div>PROFILE NAME: ${vendor.vendorName}</div>
	<div>NAME: ${vendor.firstName} ${vendor.lastName}</div>
	<div>EMAIL: ${vendor.email}</div>
	<div>PHONE: ${vendor.phone}</div>

	<a href="${vendor.vendorName}/edit">Edit Profile</a>

	<div style="float:right">
		<a href="${vendor.vendorName}/vehicles">View Vehicle</a>	
	</div>

	<br> <br>
	<div style="float: right" >
		<a href="${vendor.vendorName}/fueltypes">View Vehicle Fuel Types</a>
	</div>
	
	<br> <br>

</body>
</html>