<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Sign Up User Form</h2>
<br><br><br>
<form action="InsertUser" method="post">
Username:<br> 
<input type="text" name="username"> <br> 
First Name:<br>
<input type="text" name="firstname"> <br>
Last Name:<br> 
<input type="text" name="lastname"> <br>
Age:<br>
<input type="text" name="age"> <br>
Mobile Number:<br>
<input type="text" name="mobileNumber"> <br>
Address:<br>
<input type="text" name="address"> <br>
City:<br>
<input type="text" name="city"> <br>
Password:<br>
<input type="password" name="password"><br>
<br><br>
<button type="submit">Signup</button>

</form>
</body>
</html>