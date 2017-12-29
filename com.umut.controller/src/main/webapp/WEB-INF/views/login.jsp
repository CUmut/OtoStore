<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login</title>
</head>
<body>
	<div class="container">
		${loginError}
		<div class="form-group form">
			<form action="login" method="post">
				<div>
					<label>User Name</label> <input type="text" id="vendorName"
						name="vendorName" placeholder="vendor name" class="form-control" />
				</div>
				<div>
					<label>Password</label> <input type="password" id="password"
						name="password" placeholder="password" class="form-control" />
				</div>
				<button id="loginButton" class="form-control">Login</button>
			</form>
		</div>
	</div>
</body>
</html>