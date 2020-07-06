<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ucmo.restaurant.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>User Details</h2>
<br><br><br>
<form action="UpdateUser" method="post">
Username:<br> 
<input type="text" name="userID" value="${user.userID}" hidden="true"><br>
${user.userName} <br> 
<input type="text" name="username" value="${user.userName}" hidden="true"><br>
First Name:<br>
<input type="text" name="firstname" value="${user.firstName}"> <br>
Last Name:<br> 
<input type="text" name="lastname" value="${user.lastName}"> <br>
Age:<br>
<input type="text" name="age" value="${user.age}"> <br>
Mobile Number:<br>
<input type="text" name="mobileNumber" value="${user.mobileNumber}"> <br>
Address:<br>
<input type="text" name="address" value="${user.address}"> <br>
City:<br>
<input type="text" name="city" value="${user.city}"> <br>

<br><br>
<button type="submit">Edit User</button>

</form>

<form action="UserHome" method="post">
<input type="text" name="userID" value="${user.userID}" hidden="true">
<input type="text" name="username" value="${user.userName}" hidden="true">
<button type="submit">Go To Home</button>
</form><br><br>

<form action="LoginPage" method="post">
<button type="submit">Logout</button>
</form>

</body>
</html>