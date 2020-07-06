<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>User Login Page</h2>
<br><br>
<p>${result}</p>
<pre>
<form action="LoginUser" method="post">
Username: <input type="text" name="username">

Password: <input type="password" name="password">


<button type="submit">Login</button></form>

<form action="SignupPage"><button type="submit">Signup</button></form>
</pre>
</div>
</body>
</html>