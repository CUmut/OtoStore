<%@ page language="java" contentType="text/html; chargset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Customer</title>
</head>
<body>
	<h1>Edit Customer Profile</h1>

	<form:form action="edit" name="input" method="POST"
		modelAttribute="customer">
		<form:input type="hidden" path="id" />

		<div>
			<label>USERNAME:</label>
			<form:input class="form-control" type="text" path="profileName"
				readonly="true" />
		</div>
		<div>
			<label>PASSWORD:</label>
			<form:input class="form-control" type="text" path="password" />
			<form:errors path="password"></form:errors>
		</div>
		<div>
			<label>EMAIL:</label>
			<form:input class="form-control" type="text" path="email" />
			<form:errors path="email"></form:errors>
		</div>
		<div>
			<label>FIRST NAME:</label>
			<form:input class="form-control" type="text" path="firstName" />
			<form:errors path="firstName"></form:errors>
		</div>
		<div>
			<label>LAST NAME</label>
			<form:input class="form-control" type="text" path="lastName" />
			<form:errors path="lastName"></form:errors>
		</div>
		<div>
			<label>PHONE:</label>
			<form:input class="form-control" type="text" path="phone" />
			<form:errors path="phone"></form:errors>
		</div>
		<div>
			<input class="form-control" type="submit" value="submit">
		</div>


	</form:form>


</body>
</html>