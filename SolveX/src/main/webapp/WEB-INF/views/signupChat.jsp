<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Signup</h2>

<form action="/signupChat" method="post">
    Name: <input type="text" name="name"/><br/>
    Phone: <input type="text" name="phone"/><br/>
    <button type="submit">Register</button>
</form>
			Already have an account? <a href="loginChat">Login</a>

<p style="color:red">${error}</p>

</body>
</html>