<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Start Chat</h3>

<form action="/startChat" method="get"">
    <input type="text" name="phone" placeholder="Enter receiver phone"/>
    <button type="submit">Start</button>
</form>

<p style="color:red">${error}</p>
</body>
</html>